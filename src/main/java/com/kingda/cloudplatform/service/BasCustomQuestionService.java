package com.kingda.cloudplatform.service;

import com.kingda.cloudplatform.pojo.BasCustomQuestionDO;

import java.util.List;

/**
 * @author Constanline
 * @description
 * @date 2019/10/17
 */
public interface BasCustomQuestionService {
    /**
     * 添加自定义问题
     *
     * @param modal 自定义问题实体
     * @return 返回自定义问题id
     * @author Constanline
     * @date 2019/10/17
     */
    String addBasCustomQuestion(BasCustomQuestionDO modal);

    /**
     * 删除自定义问题
     *
     * @param id 自定义问题id
     * @author Constanline
     * @date 2019/10/17
     */
    void deleteBasCustomQuestion(String id);

    /**
     * 更新自定义问题
     *
     * @param modal 自定义问题实体
     * @author Constanline
     * @date 2019/10/17
     */
    void updateBasCustomQuestion(BasCustomQuestionDO modal);

    /**
     * 通过id获取自定义问题
     *
     * @param id 自定义问题id
     * @return 返回自定义问题实体
     * @author Constanline
     * @date 2019/10/17
     */
    BasCustomQuestionDO queryById(String id);

    /**
     * 获取全部自定义问题
     *
     * @return 返回自定义问题实体列表
     * @author Constanline
     * @date 2019/10/17
     */
    List<BasCustomQuestionDO> queryAll();
}
