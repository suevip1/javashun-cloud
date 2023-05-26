package com.javashun.cloud.module.system.mq.producer.auth;

import com.javashun.cloud.framework.mq.core.bus.AbstractBusProducer;
import com.javashun.cloud.module.system.mq.message.auth.OAuth2ClientRefreshMessage;
import org.springframework.stereotype.Component;

/**
 * OAuth 2.0 客户端相关消息的 Producer
 */
@Component
public class OAuth2ClientProducer extends AbstractBusProducer {

    /**
     * 发送 {@link OAuth2ClientRefreshMessage} 消息
     */
    public void sendOAuth2ClientRefreshMessage() {
        publishEvent(new OAuth2ClientRefreshMessage(this, getBusId(), selfDestinationService()));
    }

}
