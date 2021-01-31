package org.mpaauw.merlin.query;

import org.mpaauw.merlin.common.pojo.Coin;

import java.io.IOException;
import java.util.List;

public interface QueryService {
    String getLastTradePrice(String symbol) throws IOException;
    List<Coin> getAllCoins();
}
