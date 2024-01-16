package com.example.financetracker;

public class Spinner_Item {
    private String itemName;
    private int itemImageResId;

    public Spinner_Item(String itemName, int itemImageResId) {
        this.itemName = itemName;
        this.itemImageResId = itemImageResId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemImageResId() {
        return itemImageResId;
    }
}
