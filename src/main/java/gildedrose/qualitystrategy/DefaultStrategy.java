package gildedrose.qualitystrategy;

import gildedrose.Item;

public class DefaultStrategy implements QualityStrategy{
    @Override
    public int calculateQuality(Item item) {
        var quality = item.quality -1;

        if(item.sellIn <= 0)
            quality--;
        return Math.max(quality, 0);
    }
}