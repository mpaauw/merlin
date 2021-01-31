package org.mpaauw.merlin.common.cache;

import org.mpaauw.merlin.common.pojo.Coin;

import java.util.HashMap;
import java.util.List;

public class CoinCache extends HashMap<String, Coin> {
    public void fillCache(List<Coin> coins) {
        for(Coin coin : coins) {
            this.put(coin.getSymbol(), coin);
        }
    }
}
