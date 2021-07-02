package com.example.demo.models;

import com.example.demo.enums.StockTypeEnum;

public class Stock {

    private int quantity;

    private StockTypeEnum stockTypeEnum;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public StockTypeEnum getStockType() {
        return stockTypeEnum;
    }

    public void setStockType(StockTypeEnum stockTypeEnum) {
        this.stockTypeEnum = stockTypeEnum;
    }
}
