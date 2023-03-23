package com.gst;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

  @Override
  public void configureMessageBroker(MessageBrokerRegistry config) {
    config.enableSimpleBroker("/user", "/topic", "/queue");
    config.setApplicationDestinationPrefixes("/app");
  }
  
//  @Override
//	public void configureMessageBroker(MessageBrokerRegistry registry) {
//		registry.setApplicationDestinationPrefixes("/app");
//		registry.setUserDestinationPrefix("/user");
//		registry.enableStompBrokerRelay("/topic", "/queue").setRelayHost("localhost").setRelayPort(61613).setClientLogin("guest")
//				.setClientPasscode("guest");
//
//	}

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/websocket-chat").setAllowedOrigins("*").withSockJS();
  }
}
