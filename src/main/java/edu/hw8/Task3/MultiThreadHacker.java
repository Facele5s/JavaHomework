package edu.hw8.Task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MultiThreadHacker {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        .toCharArray();
    private static final int MAX_PASSWORD_LENGTH = 4;
    private final int encryptedPasswordsCount;
    private final AtomicInteger passwordNumber;

    private final ConcurrentMap<String, String> decryptedPasswords;
    private final ConcurrentMap<String, String> encryptedPasswords;
    private final int numberOfThreads;

    public MultiThreadHacker(ConcurrentMap<String, String> encryptedPasswords, int numberOfThreads) {
        this.decryptedPasswords = new ConcurrentHashMap<>();
        this.encryptedPasswords = encryptedPasswords;
        this.numberOfThreads = numberOfThreads;
        this.encryptedPasswordsCount = encryptedPasswords.size();

        this.passwordNumber = new AtomicInteger(0);
    }

    public Map<String, String> hackPasswords() {
        try (ExecutorService service = Executors.newFixedThreadPool(numberOfThreads)) {
            for (int length = 1; length <= MAX_PASSWORD_LENGTH; length++) {
                long passwordsCount = calculateNumberOfPasswords(length);

                for (int j = 0; j < numberOfThreads; j++) {
                    int finalLength = length;
                    service.submit(() -> {
                        while (passwordNumber.get() < passwordsCount) {
                            String password = handlePassword(finalLength, passwordNumber.getAndIncrement());
                            checkPassword(password);
                        }
                    });
                }
            }

            service.shutdown();
        }

        if (decryptedPasswords.size() < encryptedPasswordsCount) {
            LOGGER.info("Неотгаданные пароли содержали посторонние символы, либо их длина превышает 4 символа");
        }
        return decryptedPasswords;
    }

    private String handlePassword(int passwordLength, long passwordNumber) {
        List<Integer> permutation = new ArrayList<>();
        for (int i = 0; i < passwordLength; i++) {
            permutation.add(0);
        }

        List<Integer> passwordChars = new ArrayList<>();
        long n = passwordNumber;
        while (n != 0) {
            passwordChars.add((int) n % ALPHABET.length);
            n /= ALPHABET.length;
        }

        for (int i = 0; i < passwordChars.size(); i++) {
            permutation.set(i, passwordChars.get(i));
        }

        permutation = permutation.reversed();

        return generatePassword(permutation);
    }

    private String generatePassword(List<Integer> permutation) {
        StringBuilder passwordBuilder = new StringBuilder();

        for (int n : permutation) {
            passwordBuilder.append(ALPHABET[n]);
        }

        return passwordBuilder.toString();
    }

    private void checkPassword(String passwordToCheck) {
        String encryptedPassword = DigestUtils.md5Hex(passwordToCheck);

        if (encryptedPasswords.containsKey(encryptedPassword)) {
            String userName = encryptedPasswords.get(encryptedPassword);
            decryptedPasswords.put(userName, passwordToCheck);
            encryptedPasswords.remove(encryptedPassword);
        }
    }

    private long calculateNumberOfPasswords(int maxLength) {
        long result = 0;

        for (int i = 1; i <= maxLength; i++) {
            result += (long) Math.pow(ALPHABET.length, i);
        }

        return result;
    }
}
