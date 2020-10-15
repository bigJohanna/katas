package gildedrose.qualitystrategy;

import gildedrose.Item;

public class SulfurusStrategy implements QualityStrategy {
    @Override
    public int calculateQuality(Item item) {
        return item.quality;
    }
}
