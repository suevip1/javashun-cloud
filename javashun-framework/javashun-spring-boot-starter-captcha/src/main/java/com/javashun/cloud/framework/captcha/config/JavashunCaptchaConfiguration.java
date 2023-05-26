package com.javashun.cloud.framework.captcha.config;

import cn.hutool.core.util.ClassUtil;
import com.javashun.cloud.framework.captcha.core.enums.CaptchaRedisKeyConstants;
import com.javashun.cloud.framework.captcha.core.service.RedisCaptchaServiceImpl;
import com.xingyuv.captcha.service.CaptchaCacheService;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

@AutoConfiguration
public class JavashunCaptchaConfiguration {

    static {
        // 手动加载 Lock4jRedisKeyConstants 类，因为它不会被使用到
        // 如果不加载，会导致 Redis 监控，看到它的 Redis Key 枚举
        ClassUtil.loadClass(CaptchaRedisKeyConstants.class.getName());
    }

    @Bean
    public CaptchaCacheService captchaCacheService(StringRedisTemplate stringRedisTemplate) {
        return new RedisCaptchaServiceImpl(stringRedisTemplate);
    }

}
