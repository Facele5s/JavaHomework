package edu.hw8.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SingleThreadHacker {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        .toCharArray();
    private static final int MAX_PASSWORD_LENGTH = 4;
    private final int encryptedPasswordsCount;

    private final Map<String, String> decryptedPasswords;
    private final Map<String, String> encryptedPasswords;

    public SingleThreadHacker(Map<String, String> encryptedPasswords) {
        this.decryptedPasswords = new HashMap<>();
        this.encryptedPasswords = encryptedPasswords;
        this.encryptedPasswordsCount = encryptedPasswords.size();
    }

    public Map<String, String> hackPasswords() {
        handlePassword(new ArrayList<>());

        if (decryptedPasswords.size() < encryptedPasswordsCount) {
            LOGGER.info("Неотгаданные пароли содержали посторонние символы, либо их длина превышает 4 символа");
        }
        return decryptedPasswords;
    }

    private void handlePassword(List<Integer> passwordChars) {
        if (passwordChars.size() == MAX_PASSWORD_LENGTH) {
            String password = generatePassword(passwordChars);
            checkPassword(password);
            return;
        }

        for (int j = 0; j < ALPHABET.length; j++) {
            passwordChars.add(j);
            handlePassword(passwordChars);
            passwordChars.removeLast();
        }

        if (!passwordChars.isEmpty()) {
            String password = generatePassword(passwordChars);
            checkPassword(password);
        }
    }

    private String generatePassword(List<Integer> permutation) {
        StringBuilder passwordBuilder = new StringBuilder();

        for (int n: permutation) {
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
}
