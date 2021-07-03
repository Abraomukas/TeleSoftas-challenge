package com.gildedrose;

public class ConjuredProtocol extends UpdateProtocol {

    protected void qualityIncreaseFor(Item item) {
        decreaseQualityByOne(item);
        decreaseQualityByOne(item);
    }

    protected void qualityUpdateFor(Item item) {
        decreaseQualityByOne(item);
        decreaseQualityByOne(item);
    }
}
