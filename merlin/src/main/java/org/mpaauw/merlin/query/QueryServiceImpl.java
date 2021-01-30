package org.mpaauw.merlin.query;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class QueryServiceImpl implements QueryService{

    private static final String ENDPOINT = "https://api.coinlore.net/api/ticker/?id=80";

    private RestTemplate restTemplate = new RestTemplate();

    // TODO: cache the ticker IDs during app startup so that they can be easily referenced when an API is called.
    @Override
    public double GetLastTradePrice(String symbol) throws IOException {
        ResponseEntity<String> response = restTemplate.getForEntity(ENDPOINT, String.class);
        if(response.getStatusCode().is2xxSuccessful()) {
            System.out.println(String.format("API call successful. Payload: %s", response.getBody()));
            System.in.read();
        } else {
            System.out.println(String.format("API call failed with status: %s", response.getStatusCode()));
            System.in.read();
        }
        return 0.0;
    }


}
