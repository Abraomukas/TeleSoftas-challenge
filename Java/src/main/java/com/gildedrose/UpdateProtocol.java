package com.gildedrose;

public class UpdateProtocol {
    static final int MAX_QUALITY = 50;

    public void update(Item item) {
        qualityIncreaseFor(item);

        sellInUpdateFor(item);

        if (item.sellIn < 0) {
            qualityUpdateFor(item);
        }
    }

    protected void qualityIncreaseFor(Item item) {
        decreaseQualityByOne(item);
    }

    protected void sellInUpdateFor(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    protected void qualityUpdateFor(Item item) {
        decreaseQualityByOne(item);
    }

    protected void decreaseQualityByOne(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    protected void increaseQualityOf(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality = item.quality + 1;
        }
    }
}
