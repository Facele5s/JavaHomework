package edu.hw8;

import edu.hw8.Task1.Client;
import edu.hw8.Task1.Server;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class Task1Test {
    private static final String PHRASE_1 =
        "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами";
    private static final String PHRASE_2 =
        "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.";

    @Test
    @DisplayName("Поиск фразы по ключевому слову")
    public void phraseSearchTest() {
        Server server = new Server();
        Client client = new Client();

        Thread serverThread = new Thread(() -> {
            try {
                server.run();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        serverThread.start();

        assertEquals(PHRASE_1, client.findPhrases("ПрОТиВниКи"));
        assertEquals(PHRASE_2, client.findPhrases("глупый"));
        assertEquals(PHRASE_2, client.findPhrases("БОГ"));
        assertEquals("null", client.findPhrases("awdawdawdwd"));

        serverThread.interrupt();
    }

    @Test
    @DisplayName("Поиск фраз для нескольких клиентов")
    public void phraseSearchTes1t() {
        String phrase1 = "Волк слабее льва и тигра";
        String phrase2 = "Волк не тот, кто волк";

        Server server = new Server(List.of(phrase1, phrase2));
        Client[] clients = new Client[6];
        for (int i = 0; i < clients.length; i++) {
            clients[i] = new Client();
        }

        Thread serverThread = new Thread(() -> {
            try {
                server.run();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        serverThread.start();

        for (Client client : clients) {
            assertEquals(phrase1, client.findPhrases("волк"));
        }

        serverThread.interrupt();
    }

    @Test
    @DisplayName("Проверка на пустую строку")
    public void emptyStringTest() {
        Server server = new Server();
        Client client = new Client();

        Thread serverThread = new Thread(() -> {
            try {
                server.run();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        serverThread.start();

        assertEquals("null", client.findPhrases(""));
        assertEquals("null", client.findPhrases(null));

        serverThread.interrupt();
    }
}
