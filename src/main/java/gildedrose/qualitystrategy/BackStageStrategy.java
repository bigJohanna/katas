package gildedrose.qualitystrategy;

import gildedrose.Item;

public class BackStageStrategy implements QualityStrategy {
    private static final int MAX_QUALITY = 50;

    @Override
    public int calculateQuality(Item item) {
        //Vi vill inte förändra värdet vi vill räkna fram det nya
        int quality = item.quality+1;
        if (item.sellIn < 11 && quality < MAX_QUALITY) {
                 quality++;
        }

        if (item.sellIn < 6 && quality < MAX_QUALITY) {
                 quality++;
        }

        if(item.sellIn<=0) {
            quality = 0;
        }



        return quality;
    }
}
