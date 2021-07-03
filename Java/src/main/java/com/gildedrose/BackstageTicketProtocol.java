package com.gildedrose;

public class BackstageTicketProtocol extends UpdateProtocol {

    protected void qualityIncreaseFor(Item item) {
        increaseQualityOf(item);

        if (item.sellIn < 11) {
            increaseQualityOf(item);
        }
        if (item.sellIn < 6) {
            increaseQualityOf(item);
        }
    }

    protected void qualityUpdateFor(Item item) {
        item.quality = 0;
    }
}
