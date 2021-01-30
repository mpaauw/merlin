package org.mpaauw.merlin.query;

import java.io.IOException;

public interface QueryService {


    public double GetLastTradePrice(String symbol) throws IOException;
}
