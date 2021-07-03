package com.gildedrose;

class GildedRose {
    Item[] items;

    static final String CONJURED = "Conjured Mana Cake";
    static final String BACKSTAGE_TICKET = "Backstage passes to a TAFKAL80ETC concert";
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
        } else if (isBackstageTicket(item)) {
            return new BackstageTicketProtocol();
        } else if (isConjured(item)) {
            return new ConjuredProtocol();
        }
        return new UpdateProtocol();
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals(SULFURAS);
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals(AGED_BRIE);
    }

    private boolean isBackstageTicket(Item item) {
        return item.name.equals(BACKSTAGE_TICKET);
    }

    private boolean isConjured(Item item) {
        return item.name.equals(CONJURED);
    }
}
