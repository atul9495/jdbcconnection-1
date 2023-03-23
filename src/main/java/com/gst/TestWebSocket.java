package com.gst;

import com.neovisionaries.ws.client.WebSocketException;
import com.zerodhatech.kiteconnect.KiteConnect;
import com.zerodhatech.kiteconnect.kitehttp.SessionExpiryHook;
import com.zerodhatech.kiteconnect.kitehttp.exceptions.KiteException;

import com.zerodhatech.models.Margin;
import com.zerodhatech.models.Order;
import com.zerodhatech.models.Tick;
import com.zerodhatech.models.User;
import com.zerodhatech.ticker.KiteTicker;
import com.zerodhatech.ticker.OnConnect;
import com.zerodhatech.ticker.OnDisconnect;
import com.zerodhatech.ticker.OnOrderUpdate;
import com.zerodhatech.ticker.OnTicks;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestWebSocket {
	ArrayList<Long> tokens = new ArrayList<Long>();
	@Autowired
	InstrumentServiceInterface instrumentServiceInterface;
	@Autowired
	TickService tickService;

	public void main(String[] args) {
		try {
			String API_KEY = "myxr2crgwg6656hv";
			String USER_ID = "AE4790";
			KiteConnect kiteConnect = new KiteConnect(API_KEY);

			// Set userId.
			kiteConnect.setUserId(USER_ID);

			/*
			 * First you should get request_token, public_token using kitconnect login and
			 * then use request_token, public_token, api_secret to make any kiteconnect api
			 * call. Get login url. Use this url in webview to login user, after
			 * authenticating user you will get requestToken. Use the same to get
			 * accessToken.
			 */
			String url = kiteConnect.getLoginURL();

			// Get accessToken as follows,
			User userModel = kiteConnect.generateSession(args[0], "orp5bw9qluhyjr0p7t763q5d82a8poam");

			// Set request token and public token which are obtained from login process.
			kiteConnect.setAccessToken(userModel.accessToken);
			kiteConnect.setPublicToken(userModel.publicToken);

			// Set session expiry callback.
			kiteConnect.setSessionExpiryHook(new SessionExpiryHook() {
				@Override
				public void sessionExpired() {
					System.out.println("session expired");
				}
			});

//			tokens.add((long) 408065);
//			tokens.add((long) 64231431);
//			tokens.add((long) 18509314);
//		tokens.add((long) 75);
//		tokens.add((long) 1);

//MCX
					tokens.add((long) 64886279);
//			tokens.add((long) 64010503);
//			tokens.add((long) 63634951);
//		tokens.add((long) 61512711);
//		tokens.add((long) 64012039);	
			kiteConnect.setUserId("AE4790");

			KiteTicker tickerProvider = new KiteTicker(kiteConnect.getAccessToken(), kiteConnect.getApiKey());

			tickerProvider.setOnConnectedListener(new OnConnect() {
				@Override
				public void onConnected() {

					/**
					 * Subscribe ticks for token. By default, all tokens are subscribed for
					 * modeQuote.
					 */

					tickerProvider.subscribe(tokens);
					tickerProvider.setMode(tokens, KiteTicker.modeFull);
				}
			});

			tickerProvider.setOnTickerArrivalListener(new OnTicks() {
				@Override
				public void onTicks(ArrayList<Tick> ticks) {
					NumberFormat formatter = new DecimalFormat();
					System.out.println("ticks size " + ticks.size());
					for (int i = 0; i < ticks.size(); i++) {

						// tickService.save(new com.gst.Tick(ticks.get(i)));
						System.out.println("Tickk=" + ticks.get(i).toString());
						System.out.println("last price " + ticks.get(i).getLastTradedPrice());
						System.out.println("open interest " + formatter.format(ticks.get(i).getOi()));
						System.out.println("day high OI " + formatter.format(ticks.get(i).getOpenInterestDayHigh()));
						System.out.println("day low OI " + formatter.format(ticks.get(i).getOpenInterestDayLow()));
						System.out.println("change " + formatter.format(ticks.get(i).getChange()));
						System.out.println("tick timestamp " + ticks.get(i).getTickTimestamp());
						System.out.println("tick timestamp date " + ticks.get(i).getTickTimestamp());
						System.out.println("last traded time " + ticks.get(i).getLastTradedTime());
						System.out.println(ticks.get(i).getMarketDepth().get("buy").size());
					}
			
				}

			});

			tickerProvider.setTryReconnection(true);
			// maximum retries and should be greater than 0
			tickerProvider.setMaximumRetries(10);
			// set maximum retry interval in seconds
			tickerProvider.setMaximumRetryInterval(30);

			/**
			 * connects to com.zerodhatech.com.zerodhatech.ticker server for getting live
			 * quotes
			 */
			tickerProvider.connect();

			/**
			 * You can check, if websocket connection is open or not using the following
			 * method.
			 */
			boolean isConnected = tickerProvider.isConnectionOpen();
			System.out.println(isConnected);

		} catch (Exception | KiteException e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}

}
