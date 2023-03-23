package com.gst;

/**
 * A wrapper for tick.
 */

import com.google.gson.annotations.SerializedName;
import com.zerodhatech.models.Depth;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "tick")
public class Tick implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tick_id")
	private Long tickId;
	
    @Column(name = "mode")
    private String mode;
    
    @Column(name = "tradable")
    private boolean tradable;
    
    @Column(name = "token")
    private Long instrumentToken;
    
    @Column(name = "lastTradedPrice")
    private double lastTradedPrice;
    
    @Column(name = "highPrice")
    private double highPrice;
    
    @Column(name = "lowPrice")
    private double lowPrice;
    
    @Column(name = "openPrice")
    private double openPrice;
    
    @Column(name = "closePrice")
    private double closePrice;
    
    @Column(name = "change_new")
    private double change;
    
    @Column(name = "lastTradeQuantity")
    private double lastTradedQuantity;
    
    @Column(name = "averageTradePrice")
    private double averageTradePrice;
    
    @Column(name = "volumeTradedToday")
    private Long volumeTradedToday;
    
    @Column(name = "totalBuyQuantity")
    private double totalBuyQuantity;
    
    @Column(name = "totalSellQuantity")
    private double totalSellQuantity;
    
    @Column(name = "lastTradedTime")
    private Date lastTradedTime;
    
    @Column(name = "oi")
    private double oi;
    
    @Column(name = "openInterestDayHigh")
    private double oiDayHigh;
    
    @Column(name = "openInterestDayLow")
    private double oiDayLow;
    
    @Column(name = "tickTimestamp")
    private Date tickTimestamp;

//    @Column(name = "depth")
//    private Map<String, ArrayList<Depth>> depth;

    
    
    
    
    
    
    public Tick() {
		super();
	}

	public Tick(Long tickId, com.zerodhatech.models.Tick tick) {
		super();
		this.tickId = tickId;
		this.mode = tick.getMode();
		this.tradable = tick.isTradable();
		this.instrumentToken = tick.getInstrumentToken();
		this.lastTradedPrice = tick.getLastTradedPrice();
		this.highPrice = tick.getHighPrice();
		this.lowPrice = tick.getLowPrice();
		this.openPrice = tick.getOpenPrice();
		this.closePrice = tick.getClosePrice();
		this.change = tick.getChange();
		this.lastTradedQuantity = tick.getLastTradedPrice();
		this.averageTradePrice = tick.getAverageTradePrice();
		this.volumeTradedToday = tick.getVolumeTradedToday();
		this.totalBuyQuantity = tick.getTotalBuyQuantity();
		this.totalSellQuantity = tick.getTotalSellQuantity();
		this.lastTradedTime = tick.getLastTradedTime();
		this.oi = tick.getOi();
		this.oiDayHigh = tick.getOpenInterestDayHigh();
		this.oiDayLow = tick.getOpenInterestDayLow();
		this.tickTimestamp = tick.getTickTimestamp();
	//	this.depth = tick.getMarketDepth();
	}
	public Tick(com.zerodhatech.models.Tick tick) {
		super();
		
		this.mode = tick.getMode();
		this.tradable = tick.isTradable();
		this.instrumentToken = tick.getInstrumentToken();
		this.lastTradedPrice = tick.getLastTradedPrice();
		this.highPrice = tick.getHighPrice();
		this.lowPrice = tick.getLowPrice();
		this.openPrice = tick.getOpenPrice();
		this.closePrice = tick.getClosePrice();
		this.change = tick.getChange();
		this.lastTradedQuantity = tick.getLastTradedPrice();
		this.averageTradePrice = tick.getAverageTradePrice();
		this.volumeTradedToday = tick.getVolumeTradedToday();
		this.totalBuyQuantity = tick.getTotalBuyQuantity();
		this.totalSellQuantity = tick.getTotalSellQuantity();
		this.lastTradedTime = tick.getLastTradedTime();
		this.oi = tick.getOi();
		this.oiDayHigh = tick.getOpenInterestDayHigh();
		this.oiDayLow = tick.getOpenInterestDayLow();
		this.tickTimestamp = tick.getTickTimestamp();
	//	this.depth = tick.getMarketDepth();
	}
	public Date getLastTradedTime() {
        return lastTradedTime;
    }

    public void setLastTradedTime(Date lastTradedTime) {
        this.lastTradedTime = lastTradedTime;
    }

    public double getOi() {
        return oi;
    }

    public void setOi(double oi) {
        this.oi = oi;
    }

    public double getOpenInterestDayHigh() {
        return oiDayHigh;
    }

    public void setOpenInterestDayHigh(double dayHighOpenInterest) {
        this.oiDayHigh = dayHighOpenInterest;
    }

    public double getOpenInterestDayLow() {
        return oiDayLow;
    }

    public void setOpenInterestDayLow(double dayLowOpenInterest) {
        this.oiDayLow = dayLowOpenInterest;
    }

    public Date getTickTimestamp() {
        return tickTimestamp;
    }

    public void setTickTimestamp(Date tickTimestamp) {
        this.tickTimestamp = tickTimestamp;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public boolean isTradable() {
        return tradable;
    }

    public void setTradable(boolean tradable) {
        this.tradable = tradable;
    }

    public long getInstrumentToken() {
        return instrumentToken;
    }

    public void setInstrumentToken(long token) {
        this.instrumentToken = token;
    }

    public double getLastTradedPrice() {
        return lastTradedPrice;
    }

    public void setLastTradedPrice(double lastTradedPrice) {
        this.lastTradedPrice = lastTradedPrice;
    }

    public double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(double highPrice) {
        this.highPrice = highPrice;
    }

    public double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(double openPrice) {
        this.openPrice = openPrice;
    }

    public double getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(double closePrice) {
        this.closePrice = closePrice;
    }

    public double getChange() {
        return change;
    }

    public void setNetPriceChangeFromClosingPrice(double netPriceChangeFromClosingPrice) {
        this.change = netPriceChangeFromClosingPrice;
    }

    public double getLastTradedQuantity() {
        return lastTradedQuantity;
    }

    public void setLastTradedQuantity(double lastTradedQuantity) {
        this.lastTradedQuantity = lastTradedQuantity;
    }

    public double getAverageTradePrice() {
        return averageTradePrice;
    }

    public void setAverageTradePrice(double averageTradePrice) {
        this.averageTradePrice = averageTradePrice;
    }

    public long getVolumeTradedToday() {
        return volumeTradedToday;
    }

    public void setVolumeTradedToday(long volumeTradedToday) {
        this.volumeTradedToday = volumeTradedToday;
    }

    public double getTotalBuyQuantity() {
        return totalBuyQuantity;
    }

    public void setTotalBuyQuantity(double totalBuyQuantity) {
        this.totalBuyQuantity = totalBuyQuantity;
    }

    public double getTotalSellQuantity() {
        return totalSellQuantity;
    }

    public void setTotalSellQuantity(double totalSellQuantity) {
        this.totalSellQuantity = totalSellQuantity;
    }

//    public Map<String, ArrayList<Depth>> getMarketDepth() {
//        return depth;
//    }
//
//    public void setMarketDepth(Map<String, ArrayList<Depth>> marketDepth) {
//        this.depth = marketDepth;
//    }

}
