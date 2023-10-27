package edu.hw3;

import edu.hw3.Task6.Market;
import edu.hw3.Task6.Stock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6Test {
    @Test
    @DisplayName("Проверка добавления акций")
    public void stockAddTest() {
        Market market = new Market();
        market.add(new Stock("Средняя акция", 25));
        market.add(new Stock("Дешёвая акция", 10));
        market.add(new Stock("Ещё одна средняя акция", 25));
        market.add(new Stock("Дорогая акция", 46));

        String expected = "[Stock: Дорогая акция. Price: 46, Stock: Средняя акция. Price: 25, "
            + "Stock: Ещё одна средняя акция. Price: 25, Stock: Дешёвая акция. Price: 10]";

        assertEquals(expected, market.getStocks().toString());
    }

    @Test
    @DisplayName("Проверка удаления акций")
    public void stockRemoveTest() {
        Market market = new Market();
        Stock stock1 = new Stock("Ещё одна средняя акция", 74);
        Stock stock2 = new Stock("Дешёвая акция", 5);
        market.add(new Stock("Средняя акция", 74));
        market.add(stock2);
        market.add(stock1);
        market.add(new Stock("Дорогая акция", 128));

        String expected = "[Stock: Дорогая акция. Price: 128, Stock: Средняя акция. Price: 74, "
            + "Stock: Ещё одна средняя акция. Price: 74, Stock: Дешёвая акция. Price: 5]";
        assertEquals(expected, market.getStocks().toString());

        //

        market.remove(stock1);
        market.remove(stock2);

        expected = "[Stock: Дорогая акция. Price: 128, Stock: Средняя акция. Price: 74]";
        assertEquals(expected, market.getStocks().toString());
    }

    @Test
    @DisplayName("Получение самой дорогой акции")
    public void mostValuableStockTest() {
        Market market = new Market();
        Stock stock1 = new Stock("Акция 5", 780);
        Stock stock2 = new Stock("Акция 3", 17);
        Stock stock3 = new Stock("Акция 2", 98);

        market.add(new Stock("Акция 1", 1));
        market.add(stock2);
        market.add(stock3);
        market.add(new Stock("Акция 4", 8));
        market.add(stock1);

        assertEquals(stock1, market.mostValuableStock());

        market.remove(stock1);
        assertEquals(stock3, market.mostValuableStock());

        market.remove(stock2);
        assertEquals(stock3, market.mostValuableStock());
    }
}
