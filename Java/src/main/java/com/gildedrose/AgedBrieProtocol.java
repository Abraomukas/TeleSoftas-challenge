package com.gildedrose;

public class AgedBrieProtocol extends UpdateProtocol {
    static final String LABEL = "Aged Brie";

    public void qualityUpdateFor(Item item) {
        increaseQualityOf(item);
    }

    protected void qualityIncreaseFor(Item item) {
        increaseQualityOf(item);
    }
}
