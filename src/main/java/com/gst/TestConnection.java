package com.gst;

import java.io.IOException;

import org.json.JSONException;

import com.zerodhatech.kiteconnect.KiteConnect;
import com.zerodhatech.kiteconnect.kitehttp.exceptions.KiteException;
import com.zerodhatech.models.User;

public class TestConnection {

	public static void main(String[] args) {
		
		String API_KEY = "myxr2crgwg6656hv";
		String USER_ID = "AE4790";
		KiteConnect kiteSdk = new KiteConnect(API_KEY);
		kiteSdk.setUserId(USER_ID);
//		String url = kiteSdk.getLoginURL();
//		System.out.println(url);
		
		try {
			User user =  kiteSdk.generateSession("mJRLc4GonN4wB9yYmgRYmowmLBpTNtdA", "orp5bw9qluhyjr0p7t763q5d82a8poam");
			System.out.println(user.accessToken);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KiteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
