package com.javashun.cloud.module.infra.api.logger;

import com.javashun.cloud.framework.common.pojo.CommonResult;
import com.javashun.cloud.module.infra.api.logger.dto.ApiAccessLogCreateReqDTO;
import com.javashun.cloud.module.infra.service.logger.ApiAccessLogService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.javashun.cloud.framework.common.pojo.CommonResult.success;
import static com.javashun.cloud.module.system.enums.ApiConstants.VERSION;

@RestController // 提供 RESTful API 接口，给 Feign 调用
@DubboService(version = VERSION) // 提供 Dubbo RPC 接口，给 Dubbo Consumer 调用
@Validated
public class ApiAccessLogApiImpl implements ApiAccessLogApi {

    @Resource
    private ApiAccessLogService apiAccessLogService;

    @Override
    public CommonResult<Boolean> createApiAccessLog(ApiAccessLogCreateReqDTO createDTO) {
        apiAccessLogService.createApiAccessLog(createDTO);
        return success(true);
    }

}
