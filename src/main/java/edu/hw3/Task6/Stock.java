package edu.hw3.Task6;

import org.jetbrains.annotations.NotNull;

public class Stock implements Comparable {
    private final int price;
    private final String title;

    public Stock(String title, int price) {
        this.price = price;
        this.title = title;
    }

    @Override public String toString() {
        return "Stock: " + title
            + ". Price: " + price;
    }

    @Override
    public int compareTo(@NotNull Object o) {
        Stock stock = (Stock) o;

        // Цены будут сортироваться по убыванию
        return stock.price - this.price;
    }
}
