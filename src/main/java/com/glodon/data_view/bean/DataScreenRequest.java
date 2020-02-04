package com.glodon.data_view.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author liuwg-a
 * @date 2019/11/10 16:59
 * @description
 */
@ApiModel
public class DataScreenRequest {

    /**
     * 只有保存才有这两个参数
     */
    @ApiModelProperty(name = "id", value = "数据屏id，创建资源时允许由前端指定", required = false)
    private String id;

    @ApiModelProperty(name = "name", value = "数据屏名称", required = false)
    private String  name;
    @ApiModelProperty(name = "status", value = "数据屏状态，表示是否公开：true公开，false不公开(默认)", required = false)
    private Boolean status;
    @ApiModelProperty(name = "url", value = "数据屏发布的Url", required = false)
    private String  url;
    @ApiModelProperty(name = "opt", value = "opt", required = false)
    private String  opt;
    @ApiModelProperty(name = "layout", value = "layout", required = false)
    private String  layout;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }
}
