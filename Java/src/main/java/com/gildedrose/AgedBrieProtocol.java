package com.gildedrose;

public class AgedBrieProtocol extends UpdateProtocol {

    public void qualityUpdateFor(Item item) {
        increaseQualityOf(item);
    }

    protected void qualityIncreaseFor(Item item) {
        increaseQualityOf(item);
    }
}
