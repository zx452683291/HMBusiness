package com.kingda.cloudplatform.pojo;

import java.time.LocalDateTime;

/**
 * @author Constanline
 * @description
 * @date 2019/10/17
 */
public class BasCustomQuestionDO {
    private String id;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String body;
    private String extraStyle;
    private String questionType;
    private Boolean hidden;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getExtraStyle() {
        return extraStyle;
    }

    public void setExtraStyle(String extraStyle) {
        this.extraStyle = extraStyle;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BasCustomQuestionDO{" +
                "id='" + id + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", body='" + body + '\'' +
                ", extraStyle='" + extraStyle + '\'' +
                ", questionType='" + questionType + '\'' +
                ", hidden=" + hidden +
                ", description='" + description + '\'' +
                '}';
    }
}
