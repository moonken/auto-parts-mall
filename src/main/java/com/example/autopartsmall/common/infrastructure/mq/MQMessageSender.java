package com.example.autopartsmall.common.infrastructure.mq;

import com.example.autopartsmall.common.ddd.InfrastructureService;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@InfrastructureService
@AllArgsConstructor
// 模拟MQ
public class MQMessageSender {
    private ApplicationEventPublisher publisher;

    public void sendMessage(MQMessage message) {
        publisher.publishEvent(message);
    };
}
