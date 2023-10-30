package edu.hw3.Task6;

import java.util.PriorityQueue;
import java.util.Queue;

public class Market implements StockMarket {
    private final Queue<Stock> stocks = new PriorityQueue<>();

    public Queue<Stock> getStocks() {
        return stocks;
    }

    @Override
    public void add(Stock stock) {
        stocks.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stocks.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stocks.peek();
    }
}
