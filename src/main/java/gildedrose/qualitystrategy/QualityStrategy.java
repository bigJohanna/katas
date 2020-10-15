package gildedrose.qualitystrategy;

import gildedrose.Item;

public interface QualityStrategy {
    //Skall beräkna det nya qualityvärdet för en viss typ av produkt.
    //Metoderna borde göra dom som pure functions för att implementera med lambda
    int calculateQuality(Item item);
}
