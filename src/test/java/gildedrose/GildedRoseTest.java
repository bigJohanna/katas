package gildedrose;


import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {
    Item[] items;
    GildedRose app;


    @BeforeEach
    void setUp() {
        items = new Item[] {
                new Item("+5 Dexterity Vest", 1, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

        app = new GildedRose(items);
    }

    @Test
    void whenDateHasPassedQualityShouldDegradeTwiceAsFast() {

        for (int i = 0; i < 2; i++) {
            app.updateQuality();
        }
        assertEquals(17, app.items[0].quality);
    }

    @Test
    void whenBriePassesDateQualityShouldIncrese(){
            app.updateQuality();
            app.updateQuality();
            app.updateQuality();

        assertTrue(app.items[1].quality>0);
        //sellin

    }

    @Test
    void qualityOfItemSHouldNeverBeNegative() {
        for (int i = 0; i < 20; i++) {
            app.updateQuality();
        }

        assertFalse(app.items[2].quality<0);
    }

    @Test
    void qualityOfBrieIsNeverMoreThan50() {
        for (int i = 0; i < 55; i++) {
            app.updateQuality();
        }
        assertTrue(app.items[1].quality<=50);
    }

    @Test
    void RagnarosShouldNotChangeQuality() {
        for (int i = 0; i < 50; i++) {
            app.updateQuality();
        }
        assertEquals(80, app.items[3].quality);
        assertEquals(80, app.items[4].quality);
    }

    @Test
    void backstagepassesQualityShouldIncreaseByTwoTenDaysBeforeSellin() {
        for (int i = 0; i < 6; i++) {
            app.updateQuality();
        }
        assertEquals(27, app.items[5].quality);
    }

    @Test
    void backstagepassesQualityShouldIncreaseByThreeThreeDaysBeforeSellin() {
        for (int i = 0; i < 12; i++) {
            app.updateQuality();
        }
        assertEquals(41, app.items[5].quality);
    }

    @Test
    void backstagepassesQualityShouldDropTo0AfterConcert() {
        for (int i = 0; i < 16; i++) {
            app.updateQuality();
        }
        assertEquals(0, app.items[5].quality);
    }
}