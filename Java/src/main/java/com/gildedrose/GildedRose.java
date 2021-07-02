package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (isAgedBrie(item) || isBackstageTicket(item)) {
                increaseQualityOf(item);


                if (isBackstageTicket(item)) {
                    if (item.sellIn < 11) {
                        increaseQualityOf(item);
                    }

                    if (item.sellIn < 6) {
                        increaseQualityOf(item);
                    }
                }

            } else {
                if (item.quality > 0) {
                    if (!isSulfuras(item)) {
                        item.quality = item.quality - 1;
                    }
                }
            }

            if (!isSulfuras(item)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!isAgedBrie(item)) {
                    if (!isBackstageTicket(item)) {
                        if (item.quality > 0) {
                            if (!isSulfuras(item)) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    increaseQualityOf(item);
                }
            }
        }
    }

    private void increaseQualityOf(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private boolean isAgedBrie(Item item) {
        final String agedBrie = "Aged Brie";
        return itemMatches(item, agedBrie);
    }

    private boolean isBackstageTicket(Item item) {
        final String backstageTicket = "Backstage passes to a TAFKAL80ETC concert";
        return itemMatches(item, backstageTicket);
    }

    private boolean isSulfuras(Item item) {
        final String sulfuras = "Sulfuras, Hand of Ragnaros";
        return itemMatches(item, sulfuras);
    }

    private boolean itemMatches(Item item, String s) {
        return item.name.equals(s);
    }
}
