package org.mpaauw.merlin.common.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coin {

    @JsonProperty("id")
    private String id;

    @JsonProperty("symbol")
    private String symbol;

    @JsonProperty("name")
    private String name;

    @JsonProperty("nameid")
    private String nameId;

    @JsonProperty("rank")
    private int rank;

    @JsonProperty("price_usd")
    private String priceUsd;

    @JsonProperty("percent_change_24h")
    private String percentChange24h;

    @JsonProperty("percent_change_1h")
    private String percentChange1h;

    @JsonProperty("percent_change_7d")
    private String percentChange7d;

    @JsonProperty("price_btc")
    private String priceBtc;

    @JsonProperty("market_cap_usd")
    private String marketCapUsd;

    @JsonProperty("volume24")
    private double volume24;

    @JsonProperty("volume24a")
    private double volume24a;

    @JsonProperty("csupply")
    private String cSupply;

    @JsonProperty("tsupply")
    private String tSupply;

    @JsonProperty("msupply")
    private String mSupply;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(String priceUsd) {
        this.priceUsd = priceUsd;
    }

    public String getPercentChange24h() {
        return percentChange24h;
    }

    public void setPercentChange24h(String percentChange24h) {
        this.percentChange24h = percentChange24h;
    }

    public String getPercentChange1h() {
        return percentChange1h;
    }

    public void setPercentChange1h(String percentChange1h) {
        this.percentChange1h = percentChange1h;
    }

    public String getPercentChange7d() {
        return percentChange7d;
    }

    public void setPercentChange7d(String percentChange7d) {
        this.percentChange7d = percentChange7d;
    }

    public String getPriceBtc() {
        return priceBtc;
    }

    public void setPriceBtc(String priceBtc) {
        this.priceBtc = priceBtc;
    }

    public String getMarketCapUsd() {
        return marketCapUsd;
    }

    public void setMarketCapUsd(String marketCapUsd) {
        this.marketCapUsd = marketCapUsd;
    }

    public double getVolume24() {
        return volume24;
    }

    public void setVolume24(double volume24) {
        this.volume24 = volume24;
    }

    public double getVolume24a() {
        return volume24a;
    }

    public void setVolume24a(double volume24a) {
        this.volume24a = volume24a;
    }

    public String getcSupply() {
        return cSupply;
    }

    public void setcSupply(String cSupply) {
        this.cSupply = cSupply;
    }

    public String gettSupply() {
        return tSupply;
    }

    public void settSupply(String tSupply) {
        this.tSupply = tSupply;
    }

    public String getmSupply() {
        return mSupply;
    }

    public void setmSupply(String mSupply) {
        this.mSupply = mSupply;
    }
}
