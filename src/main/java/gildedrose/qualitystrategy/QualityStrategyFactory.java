package gildedrose.qualitystrategy;

import gildedrose.Item;

public class QualityStrategyFactory {
    //inte egentligen clean code att ha factory med i namnet men det är vanligt.


    public static QualityStrategy getStrategy(Item item) {
        //case "Conjured Mana Cake" -> new ConjuredStrategy();
        switch (item.name) {
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackStageStrategy();
            case "Aged Brie":
                return new AgedBrieStrategy();
            case "Sulfuras, Hand of Ragnaros":
                return new SulfurusStrategy();
            case "Conjured Mana Cake":
                return new ConjuredManaCakeStrategy();
            default:
                return new DefaultStrategy();
        }
    }
}
