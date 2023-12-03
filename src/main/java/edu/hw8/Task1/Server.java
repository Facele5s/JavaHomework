package edu.hw8.Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("LineLength")
public class Server {
    private static final String PHRASE_1 = "Не переходи на личности там, где их нет";
    private static final String PHRASE_2 = "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами";
    private static final String PHRASE_3 = "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.";
    private static final String PHRASE_4 = "Чем ниже интеллект, тем громче оскорбления";

    private static final int PORT = 25565;
    private static final int NUMBER_OF_THREADS = 6;
    private static final ConcurrentHashMap<List<String>, String> RESPONSES = new ConcurrentHashMap<>();

    public Server() {
        RESPONSES.put(generateKeywords(PHRASE_1), PHRASE_1);
        RESPONSES.put(generateKeywords(PHRASE_2), PHRASE_2);
        RESPONSES.put(generateKeywords(PHRASE_3), PHRASE_3);
        RESPONSES.put(generateKeywords(PHRASE_4), PHRASE_4);
    }

    public Server(List<String> phrases) {
        phrases.forEach(s -> RESPONSES.put(generateKeywords(s), s));
    }

    public void run() throws IOException {
        try (ExecutorService service = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
             ServerSocket serverSocket = new ServerSocket(PORT)) {
            CompletableFuture.allOf(Stream.generate(() -> CompletableFuture.runAsync(handleClient(serverSocket), service))
                .limit(NUMBER_OF_THREADS)
                .toArray(CompletableFuture[]::new))
                .join();
        }
    }

    private Runnable handleClient(ServerSocket serverSocket) {
        return () -> {
            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

                    String response = findPhraseByKeyword(reader.readLine());
                    writer.println(response);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    private static List<String> generateKeywords(String phrase) {
        String clearPhrase = phrase.chars().mapToObj(c -> (char) c)
            .filter(c -> Character.isLetter(c) || c == ' ')
            .map(Character::toLowerCase)
            .map(Object::toString).collect(Collectors.joining());

        return List.of(clearPhrase.split(" "));
    }

    private static String findPhraseByKeyword(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return null;
        }

        return RESPONSES.entrySet().stream()
            .filter(entry -> entry.getKey().contains(keyword.toLowerCase()))
            .map(Map.Entry::getValue)
            .findFirst().orElse(null);
    }
}
