package com.gildedrose;

public class UpdateProtocol {

    public void update(Item item) {
        qualityIncreaseFor(item);

        sellInUpdateFor(item);

        if (item.sellIn < 0) {
            qualityUpdateFor(item);
        }
    }

    protected void qualityIncreaseFor(Item item) {
        if (isAgedBrie(item)) {
            increaseQualityOf(item);
        } else if (isBackstageTicket(item)) {
            increaseQualityOf(item);
            if (item.sellIn < 11) {
                increaseQualityOf(item);
            }
            if (item.sellIn < 6) {
                increaseQualityOf(item);
            }
        } else if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }


    protected void sellInUpdateFor(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    public void qualityUpdateFor(Item item) {
        if (isAgedBrie(item)) {
            increaseQualityOf(item);
        } else if (isBackstageTicket(item)) {
            item.quality = 0;
        } else if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    void increaseQualityOf(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private boolean isAgedBrie(Item item) {
        final String agedBrie = "Aged Brie";
        return itemNameMatches(item, agedBrie);
    }

    private boolean isBackstageTicket(Item item) {
        final String backstageTicket = "Backstage passes to a TAFKAL80ETC concert";
        return itemNameMatches(item, backstageTicket);
    }

    private boolean itemNameMatches(Item item, String s) {
        return item.name.equals(s);
    }
}
