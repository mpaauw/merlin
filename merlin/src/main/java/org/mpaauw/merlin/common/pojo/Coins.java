package org.mpaauw.merlin.common.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coins {

    @JsonProperty("data")
    private Coin[] data;

    @JsonProperty("info")
    private CoinsInfo info;

    public Coin[] getData() {
        return data;
    }

    public void setData(Coin[] data) {
        this.data = data;
    }

    public CoinsInfo getInfo() {
        return info;
    }

    public void setInfo(CoinsInfo info) {
        this.info = info;
    }
}
