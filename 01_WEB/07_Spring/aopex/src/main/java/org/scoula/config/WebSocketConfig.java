package org.scoula.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker   // WebSocket 메시지 브로커 기능 활성화 (STOMP 사용 가능)
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    
    // 메시지 브로커 구성 메서드
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // 서버가 이 주소로 메시지 발생 시 구독자 모두가 수신
        config.enableSimpleBroker("/topic"); // 구독시 사용할 토픽 접두어
        // 클라이언트가 메시지를 보낼 주소(prefix), @MessageMapping과 연경됨
        // 클라이언트가 발행 시 사용해야하는 접두어
        config.setApplicationDestinationPrefixes("/app");
    }

    // STOMP 연결 엔드포인트 설정 메서드
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 클라이언트가 최초 WebSocket 연결 요청 시 사용할 엔드포인드
        registry.addEndpoint("/chat-app") // 접속 엔드포인트, ws://localhost:8080/chat-app
            .setAllowedOrigins("*"); // CORS 허용
    }
}
