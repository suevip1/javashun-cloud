package com.javashun.cloud.module.infra.mq.consumer.file;

import com.javashun.cloud.module.infra.mq.message.file.FileConfigRefreshMessage;
import com.javashun.cloud.module.infra.service.file.FileConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 针对 {@link FileConfigRefreshMessage} 的消费者
 */
@Component
@Slf4j
public class FileConfigRefreshConsumer {

    @Resource
    private FileConfigService fileConfigService;

    @EventListener
    public void execute(FileConfigRefreshMessage message) {
        log.info("[execute][收到 FileConfig 刷新消息]");
        fileConfigService.initLocalCache();
    }

}
