package com.gst;

 

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * A wrapper for Instrument.
 */
@Entity
@Table(name = "Instrument")
public class Instrument implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "instrument_id")
	private Long instrumentId;
	
	@Column(name = "instrument_token")
    public long instrument_token;
	
	@Column(name = "exchange_token")
    public long exchange_token;
	
	@Column(name = "tradingsymbol")
    public String tradingsymbol;
 
	@Column(name = "name")
    public String name;
	
	@Column(name = "last_price")
    public double last_price; 
	
	@Column(name = "tick_size")
    public double tick_size;
	
	@Column(name = "instrument_type")
    public String instrument_type;
	
	@Column(name = "segment")
    public String  segment;
	
	@Column(name = "exchange")
    public String  exchange; 
	
	@Column(name = "strike")
    public String  strike;
	
	@Column(name = "lot_size")
    public int lot_size;
	
	@Column(name = "expiry")
    public Date expiry;
	 


    public Instrument() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Instrument(Long instrumentId, long instrument_token, long exchange_token, String tradingsymbol, String name,
			double last_price, double tick_size, String instrument_type, String segment, String exchange, String strike,
			int lot_size, Date expiry) {
		super();
		this.instrumentId = instrumentId;
		this.instrument_token = instrument_token;
		this.exchange_token = exchange_token;
		this.tradingsymbol = tradingsymbol;
		this.name = name;
		this.last_price = last_price;
		this.tick_size = tick_size;
		this.instrument_type = instrument_type;
		this.segment = segment;
		this.exchange = exchange;
		this.strike = strike;
		this.lot_size = lot_size;
		this.expiry = expiry;
	}
    public Instrument(int instrumentId,com.zerodhatech.models.Instrument ee) {
 		super();
 	 	this.instrumentId =Long.valueOf( instrumentId);
 		this.instrument_token = ee.getInstrument_token();
 		this.exchange_token = ee.getExchange_token();
 		this.tradingsymbol = ee.getTradingsymbol();
 		this.name = ee.getName();
 		this.last_price = ee.getLast_price();
 		this.tick_size = ee.getTick_size();
 		this.instrument_type = ee.getInstrument_type();
 		this.segment = ee.getSegment();
 		this.exchange = ee.getExchange();
 		this.strike = ee.getStrike();
 		this.lot_size = ee.getLot_size();
 		this.expiry = ee.getExpiry();
 	}
	public Long getInstrumentId() {
		return instrumentId;
	}

	public void setInstrumentId(Long instrumentId) {
		this.instrumentId = instrumentId;
	}

	public long getInstrument_token() {
        return instrument_token;
    }

    public void setInstrument_token(long instrument_token) {
        this.instrument_token = instrument_token;
    }

    public long getExchange_token() {
        return exchange_token;
    }

    public void setExchange_token(long exchange_token) {
        this.exchange_token = exchange_token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTradingsymbol() {
        return tradingsymbol;
    }

    public void setTradingsymbol(String tradingsymbol) {
        this.tradingsymbol = tradingsymbol;
    }

    public double getLast_price() {
        return last_price;
    }

    public void setLast_price(double last_price) {
        this.last_price = last_price;
    }

    public double getTick_size() {
        return tick_size;
    }

    public void setTick_size(double tick_size) {
        this.tick_size = tick_size;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public String getInstrument_type() {
        return instrument_type;
    }

    public void setInstrument_type(String instrument_type) {
        this.instrument_type = instrument_type;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getStrike() {
        return strike;
    }

    public void setStrike(String strike) {
        this.strike = strike;
    }

    public int getLot_size() {
        return lot_size;
    }

    public void setLot_size(int lot_size) {
        this.lot_size = lot_size;
    }
}
