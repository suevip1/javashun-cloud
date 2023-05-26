package com.javashun.cloud.module.system.convert.permission;

import com.javashun.cloud.module.system.dal.dataobject.permission.RoleDO;
import com.javashun.cloud.module.system.service.permission.bo.RoleCreateReqBO;
import com.javashun.cloud.module.system.controller.admin.permission.vo.role.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleConvert {

    RoleConvert INSTANCE = Mappers.getMapper(RoleConvert.class);

    RoleDO convert(RoleUpdateReqVO bean);

    RoleRespVO convert(RoleDO bean);

    RoleDO convert(RoleCreateReqVO bean);

    List<RoleSimpleRespVO> convertList02(List<RoleDO> list);

    List<RoleExcelVO> convertList03(List<RoleDO> list);

    RoleDO convert(RoleCreateReqBO bean);

}
