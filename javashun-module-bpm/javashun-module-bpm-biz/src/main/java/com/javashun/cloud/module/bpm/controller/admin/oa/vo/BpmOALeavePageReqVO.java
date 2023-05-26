package com.javashun.cloud.module.bpm.controller.admin.oa.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import com.javashun.cloud.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import static com.javashun.cloud.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 请假申请分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BpmOALeavePageReqVO extends PageParam {

    @Schema(description = "状态,参见 bpm_process_instance_result 枚举", example = "1")
    private Integer result;

    @Schema(description = "请假类型,参见 bpm_oa_type", example = "1")
    private Integer type;

    @Schema(description = "原因,模糊匹配", example = "阅读javashun")
    private String reason;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "申请时间")
    private Date[] createTime;

}