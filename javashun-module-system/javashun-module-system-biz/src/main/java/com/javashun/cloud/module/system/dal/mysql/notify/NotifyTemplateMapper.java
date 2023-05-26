package com.javashun.cloud.module.system.dal.mysql.notify;

import com.javashun.cloud.framework.common.pojo.PageResult;
import com.javashun.cloud.framework.mybatis.core.mapper.BaseMapperX;
import com.javashun.cloud.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.javashun.cloud.module.system.controller.admin.notify.vo.template.NotifyTemplatePageReqVO;
import com.javashun.cloud.module.system.dal.dataobject.notify.NotifyTemplateDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NotifyTemplateMapper extends BaseMapperX<NotifyTemplateDO> {

    default NotifyTemplateDO selectByCode(String code) {
        return selectOne(NotifyTemplateDO::getCode, code);
    }

    default PageResult<NotifyTemplateDO> selectPage(NotifyTemplatePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<NotifyTemplateDO>()
                .likeIfPresent(NotifyTemplateDO::getCode, reqVO.getCode())
                .likeIfPresent(NotifyTemplateDO::getName, reqVO.getName())
                .eqIfPresent(NotifyTemplateDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(NotifyTemplateDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(NotifyTemplateDO::getId));
    }

}
