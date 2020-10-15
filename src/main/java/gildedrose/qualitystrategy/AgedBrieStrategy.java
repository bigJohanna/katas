package gildedrose.qualitystrategy;

import gildedrose.Item;

public class AgedBrieStrategy implements QualityStrategy {
    @Override
    public int calculateQuality(Item item) {
        return item.quality < 50 ? item.quality + 1 : 50;
    }
}