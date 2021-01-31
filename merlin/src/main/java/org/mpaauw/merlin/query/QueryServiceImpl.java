package org.mpaauw.merlin.query;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.mpaauw.merlin.common.cache.CoinCache;
import org.mpaauw.merlin.common.pojo.Coin;
import org.mpaauw.merlin.common.pojo.Coins;
import org.mpaauw.merlin.common.util.Stopwatch;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class QueryServiceImpl implements QueryService{

    private static final String GET_ALL_COINS_PAGINATED_ENDPOINT = "https://api.coinlore.net/api/tickers/?start=%s&limit=%s";
    private static final String GET_SPECIFIC_COIN_ENDPOINT = "https://api.coinlore.net/api/ticker/?id=%s";

    private RestTemplate restTemplate = new RestTemplate();
    private ObjectMapper objectMapper = new ObjectMapper();
    private CoinCache coinCache;

    public QueryServiceImpl() {
        this.coinCache = new CoinCache();
        this.coinCache.fillCache(this.getAllCoins());
    }

    @Override
    public String getLastTradePrice(String symbol) {
        Stopwatch stopwatch = new Stopwatch();
        Coin coin = null;
        try {
            stopwatch.start();
            coin = coinCache.get(symbol);
            if(coin != null) {
                ResponseEntity<String> response = restTemplate.getForEntity(String.format(GET_SPECIFIC_COIN_ENDPOINT, coin.getId()), String.class);
                printResponse(response.getStatusCode(), response.getBody());
                coin = objectMapper.readValue(response.getBody(), Coin[].class)[0]; // bad api
            }
        } catch(Exception ex) {
            System.out.println(ex);
        }
        stopwatch.stop();
        System.out.println(String.format("[GetLastTradePrice] Total time elapsed: %sms", stopwatch.getElapsedTimeMs()));
        return (coin != null) ? coin.getPriceUsd() : "No price found! Coin is null.";
    }

    // TODO: paginate asynchronously
    @Override
    public List<Coin> getAllCoins() {
        Stopwatch stopwatch = new Stopwatch();
        List<Coin> allCoins = new ArrayList();
        try {
            int totalNumberOfCoins = 100;
            stopwatch.start();
            for(int offset = 0; offset < totalNumberOfCoins; offset += 100) {
                ResponseEntity<String> response = restTemplate.getForEntity(String.format(GET_ALL_COINS_PAGINATED_ENDPOINT, offset, offset + 100), String.class);
                System.out.print(String.format("Offset: %s\t", offset));
                printResponse(response.getStatusCode(), response.getBody());
                if(response.getStatusCode().is2xxSuccessful()) {
                    Coins coins = objectMapper.readValue(response.getBody(), Coins.class);
                    for(Coin coin : coins.getData()) {
                        allCoins.add(coin);
                    }
                    totalNumberOfCoins = coins.getInfo().getCoinsNum();
                }
            }
        } catch(Exception ex) {
            System.out.println(ex);
        }
        stopwatch.stop();
        System.out.println(String.format("[GetAllCoins] Total time elapsed: %sms", stopwatch.getElapsedTimeMs()));
        stopwatch.reset();
        return allCoins;
    }

    private void printResponse(HttpStatus responseStatus, String responseBody) {
        if(responseStatus.is2xxSuccessful()) {
            System.out.println(String.format("API call successful. Status: %s, Response Payload: %s", responseStatus, responseBody));
        } else {
            System.out.println(String.format("API call successful. Status: %s", responseStatus));
        }
    }


}
