package edu.hw6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static edu.hw6.HackerNews.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {
    private static final Logger LOGGER = LogManager.getLogger();

    @Test
    @DisplayName("Получение самых обсуждаемых статей")
    public void mostPopularArticlesTest() {
        long[] ids = hackerNewsTopStories();

        assertTrue(ids.length > 0);

        LOGGER.info("Номера самых обсуждаемых статей:");
        Arrays.stream(ids).forEach(LOGGER::info);
    }

    @Test
    @DisplayName("Получение заголовка новости")
    public void getTitleTest() {
        assertEquals(news(38304109), "FCC Is Trying to Stop Discrimination in Broadband Deployment. Telecoms Are Mad");

        assertEquals(news(38279307), "Microsoft aims to tailor everything 'from silicon to service' to meet AI demand");

        assertEquals(news(38293236), "Apple says iPhones will support RCS in 2024");

        assertNull(news(0));

        assertNull(news(-10));
    }

}
