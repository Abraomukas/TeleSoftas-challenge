package com.gildedrose;

class GildedRose {
    Item[] items;

    static final String AGED_BRIE = "Aged Brie";
    static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            UpdateProtocol protocol = createProtocolFor(item);
            protocol.update(item);
        }
    }

    private UpdateProtocol createProtocolFor(Item item) {
        if (isSulfuras(item)) {
            return new SulfurasProtocol();
        } else if (isAgedBrie(item)) {
            return new AgedBrieProtocol();
        }

        return new UpdateProtocol();
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals(SULFURAS);
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals(AGED_BRIE);
    }
}
