package com.gildedrose;

public class BackstageTicketProtocol extends UpdateProtocol {
    static final String LABEL = "Backstage passes to a TAFKAL80ETC concert";
    static final int FIRST_QUALITY_WINDOW = 10;
    static final int SECOND_QUALITY_WINDOW = 5;

    protected void qualityIncreaseFor(Item item) {
        increaseQualityOf(item);

        if (item.sellIn <= FIRST_QUALITY_WINDOW) {
            increaseQualityOf(item);
        }
        if (item.sellIn <= SECOND_QUALITY_WINDOW) {
            increaseQualityOf(item);
        }
    }

    protected void qualityUpdateFor(Item item) {
        item.quality = 0;
    }
}
