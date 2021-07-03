package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        //given
        Item item = new Item("foo", 0, 0);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        //when
        app.updateQuality();
        //then
        assertEquals("foo, -1, 0", app.items[0].toString());
    }

    @Test
    void qualityDegradesTwiceAsFastAfterSellInDate() {
        //given
        int quality = 10;
        Item item = new Item("foo", 0, quality);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        //when
        app.updateQuality();
        //then
        assertEquals(quality - 2, app.items[0].quality);
    }

    @Test
    void qualityIsNeverNegative() {
        //given
        Item item = new Item("foo", 1, 2);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        //when
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        //then
        assertEquals("foo, -2, 0", app.items[0].toString());
    }

    @Test
    void agedBrieIncreasesQualityTheOlderItGets() {
        //given
        Item item = new Item("Aged Brie", 1, 2);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        //when
        app.updateQuality();
        //then
        assertEquals("Aged Brie, 0, 3", app.items[0].toString());
    }

    @Test
    void qualityNeverSurpassesFifty() {
        //given
        Item item = new Item("Aged Brie", 1, 50);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        //when
        app.updateQuality();
        //then
        assertEquals("Aged Brie, 0, 50", app.items[0].toString());
    }

    @Test
    void sulfurasNeverLosesQuality() {
        //given
        Item item = new Item("Sulfuras, Hand of Ragnaros", 1, 23);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        //when
        app.updateQuality();
        //then
        assertEquals("Sulfuras, Hand of Ragnaros, 1, 23", app.items[0].toString());
    }

    @Test
    void backstageTicketsQualityIncrease_doubleIncreaseWithTenDaysOrLessLeft() {
        //given
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 7, 10);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        //when
        app.updateQuality();
        //then
        assertEquals("Backstage passes to a TAFKAL80ETC concert, 6, 12", app.items[0].toString());
    }

    @Test
    void backstageTicketsQualityIncrease_tripleIncreaseWithFiveDaysOrLessLeft() {
        //given
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 3, 10);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        //when
        app.updateQuality();
        //then
        assertEquals("Backstage passes to a TAFKAL80ETC concert, 2, 13", app.items[0].toString());
    }

    @Test
    void backstageTicketsQualityIncrease_dropsToZeroAfterTheConcert() {
        //given
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        //when
        app.updateQuality();
        //then
        assertEquals("Backstage passes to a TAFKAL80ETC concert, -1, 0", app.items[0].toString());
    }

    @Test
    void conjuredItemsDegradeTwiceAsFast() {
        //given
        Item item = new Item("Conjured Mana Cake", 3, 7);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        //when
        app.updateQuality();
        //then
        assertEquals("Conjured Mana Cake, 2, 5", app.items[0].toString());
    }
}
