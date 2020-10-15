package gildedrose;

import gildedrose.qualitystrategy.QualityStrategy;
import gildedrose.qualitystrategy.QualityStrategyFactory;

class GildedRose {
    public static final int MAX_QUALITY = 50;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        updateItems();
    }

    public void updateItems(){
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        //Vi ska fråga vårt qualityStrategy vad det nya värdet är
        //vi kollar på våra item-namn och ser vilken strategi vi vill ha.
        //Detta kallas för en factorymetod
        QualityStrategy qualityStrategy = QualityStrategyFactory.getStrategy(item);

        item.quality = qualityStrategy.calculateQuality(item);
        if( !item.name.equals("Sulfuras, Hand of Ragnaros"))
            item.sellIn--;
    }

}
