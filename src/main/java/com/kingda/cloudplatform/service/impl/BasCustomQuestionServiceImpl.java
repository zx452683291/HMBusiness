package com.kingda.cloudplatform.service.impl;

import com.kingda.cloudplatform.dao.BasCustomQuestionDao;
import com.kingda.cloudplatform.pojo.BasCustomQuestionDO;
import com.kingda.cloudplatform.service.BasCustomQuestionService;
import com.kingda.cloudplatform.util.SysUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Constanline
 * @description
 * @date 2019/10/18
 */
@Service
public class BasCustomQuestionServiceImpl implements BasCustomQuestionService {

    @Autowired
    private BasCustomQuestionDao basCustomQuestionDao;

    /**
     * 添加自定义问题
     *
     * @param modal 自定义问题实体
     * @return 返回自定义问题id
     * @author Constanline
     * @date 2019/10/17
     */
    @Override
    public String addBasCustomQuestion(BasCustomQuestionDO modal) {
        String id = SysUtil.getId();
        modal.setId(id);
        modal.setCreateTime(LocalDateTime.now());
        modal.setUpdateTime(modal.getCreateTime());
        basCustomQuestionDao.addBasCustomQuestion(modal);
        return id;
    }

    /**
     * 删除自定义问题
     *
     * @param id 自定义问题id
     * @author Constanline
     * @date 2019/10/17
     */
    @Override
    public void deleteBasCustomQuestion(String id) {
        basCustomQuestionDao.deleteBasCustomQuestion(id);
    }

    /**
     * 更新自定义问题
     *
     * @param modal 自定义问题实体
     * @author Constanline
     * @date 2019/10/17
     */
    @Override
    public void updateBasCustomQuestion(BasCustomQuestionDO modal) {
        modal.setUpdateTime(LocalDateTime.now());
        basCustomQuestionDao.updateBasCustomQuestion(modal);
    }

    /**
     * 通过id获取自定义问题
     *
     * @param id 自定义问题id
     * @return 返回自定义问题实体
     * @author Constanline
     * @date 2019/10/17
     */
    @Override
    public BasCustomQuestionDO queryById(String id) {
        return basCustomQuestionDao.queryById(id);
    }

    /**
     * 获取全部自定义问题
     *
     * @return 返回自定义问题实体列表
     * @author Constanline
     * @description
     * @date 2019/10/17
     */
    @Override
    public List<BasCustomQuestionDO> queryAll() {
        return basCustomQuestionDao.queryAll();
    }
}
