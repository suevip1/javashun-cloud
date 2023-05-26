package com.javashun.cloud.module.system.service.notice;

import com.google.common.annotations.VisibleForTesting;
import com.javashun.cloud.framework.common.exception.util.ServiceExceptionUtil;
import com.javashun.cloud.framework.common.pojo.PageResult;
import com.javashun.cloud.module.system.controller.admin.notice.vo.NoticeCreateReqVO;
import com.javashun.cloud.module.system.controller.admin.notice.vo.NoticePageReqVO;
import com.javashun.cloud.module.system.controller.admin.notice.vo.NoticeUpdateReqVO;
import com.javashun.cloud.module.system.convert.notice.NoticeConvert;
import com.javashun.cloud.module.system.dal.dataobject.notice.NoticeDO;
import com.javashun.cloud.module.system.dal.mysql.notice.NoticeMapper;
import com.javashun.cloud.module.system.enums.ErrorCodeConstants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 通知公告 Service 实现类
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Resource
    private NoticeMapper noticeMapper;

    @Override
    public Long createNotice(NoticeCreateReqVO reqVO) {
        NoticeDO notice = NoticeConvert.INSTANCE.convert(reqVO);
        noticeMapper.insert(notice);
        return notice.getId();
    }

    @Override
    public void updateNotice(NoticeUpdateReqVO reqVO) {
        // 校验是否存在
        validateNoticeExists(reqVO.getId());
        // 更新通知公告
        NoticeDO updateObj = NoticeConvert.INSTANCE.convert(reqVO);
        noticeMapper.updateById(updateObj);
    }

    @Override
    public void deleteNotice(Long id) {
        // 校验是否存在
        validateNoticeExists(id);
        // 删除通知公告
        noticeMapper.deleteById(id);
    }

    @Override
    public PageResult<NoticeDO> getNoticePage(NoticePageReqVO reqVO) {
        return noticeMapper.selectPage(reqVO);
    }

    @Override
    public NoticeDO getNotice(Long id) {
        return noticeMapper.selectById(id);
    }

    @VisibleForTesting
    public void validateNoticeExists(Long id) {
        if (id == null) {
            return;
        }
        NoticeDO notice = noticeMapper.selectById(id);
        if (notice == null) {
            throw ServiceExceptionUtil.exception(ErrorCodeConstants.NOTICE_NOT_FOUND);
        }
    }

}
