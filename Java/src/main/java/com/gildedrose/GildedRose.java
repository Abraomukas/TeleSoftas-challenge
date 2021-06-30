package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];

            if (!isAgedBrie(item) && !isBackstageTicket(item)) {
                if (item.quality > 0) {
                    if (!isSulfuras(item)) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (isBackstageTicket(item)) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
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
                        item.quality = item.quality - item.quality;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
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
