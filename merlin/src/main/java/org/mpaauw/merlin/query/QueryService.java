package org.mpaauw.merlin.query;

import org.mpaauw.merlin.common.pojo.Coin;

import java.io.IOException;
import java.util.Map;

public interface QueryService {
    String GetLastTradePrice(String symbol) throws IOException;
    Map<String, Coin> GetAllCoins();
}
