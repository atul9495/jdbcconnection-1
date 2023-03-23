package com.gst;

import java.io.IOException;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.zerodhatech.kiteconnect.KiteConnect;
import com.zerodhatech.kiteconnect.kitehttp.SessionExpiryHook;
import com.zerodhatech.kiteconnect.kitehttp.exceptions.KiteException;
import com.zerodhatech.models.User;

@RestController
public class RequestTokenController {
	
	@Autowired
	TestWebSocket testWebSocket;
	
	@RequestMapping(value = "/rt", method = RequestMethod.GET)
	public RedirectView rt(HttpServletRequest request, HttpServletResponse response)

	{
		String webUrl = "https://kite.zerodha.com/connect/login?v=3&api_key=myxr2crgwg6656hv";

		return new RedirectView(webUrl);
		// return new RedirectView("http://localhost/EsignWeb08July/dashboard");
	}

	@RequestMapping(value = "/rs", method = RequestMethod.GET)
	public String rs(@RequestParam(name = "action") String action, @RequestParam(name = "type") String type,
			@RequestParam(name = "status") String status, @RequestParam(name = "request_token") String request_token) {
		User user = null;
		try {
			
			 
			String []arg= {request_token};
			testWebSocket.main(arg);
			// Initialize Kiteconnect using apiKey.
			KiteConnect kiteConnect = new KiteConnect("myxr2crgwg6656hv");

			// Set userId.
			kiteConnect.setUserId("AE4790");

			user = kiteConnect.generateSession(request_token, "orp5bw9qluhyjr0p7t763q5d82a8poam");

			// Set request token and public token which are obtained from login process.
			kiteConnect.setAccessToken(user.accessToken);
			kiteConnect.setPublicToken(user.publicToken);
			kiteConnect.setSessionExpiryHook(new SessionExpiryHook() {
				@Override
				public void sessionExpired() {
					System.out.println("session expired");
				}
			});
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
		return user.accessToken;

	}
}
