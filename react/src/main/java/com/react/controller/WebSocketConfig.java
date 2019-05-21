package com.react.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * name
 *
 * @author yuehaiming
 * @version 1.0.0.0
 * @date 2019/4/10 13:08
 */
//springBoot2.0版本后使用 实现WebSocketMessageBrokerConfigurer接口；
//2.0以下版本继承AbstractWebSocketMessageBrokerConfigurer 类；
@Configuration
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
