package com.glodon.data_view.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author liuwg-a
 * @date 2019/11/15 9:20
 * @description
 */
@ApiModel
public class ProjectRequest {

    @ApiModelProperty(name = "name", value = "项目名（禁止为空）", required = true)
    private String  name;
    @ApiModelProperty(name = "userId", value = "所属用户Id（禁止为空），由前端硬编码：1", required = true)
    private Integer userId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
