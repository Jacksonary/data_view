package com.glodon.data_view.dao.model;

import java.util.Date;

public class DataScreen {

    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column data_screen.id
     *
     * @mbg.generated Thu Nov 14 20:26:50 CST 2019
     */
    private String  id;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column data_screen.name
     *
     * @mbg.generated Thu Nov 14 20:26:50 CST 2019
     */
    private String  name;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column data_screen.status
     *
     * @mbg.generated Thu Nov 14 20:26:50 CST 2019
     */
    private Boolean status;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column data_screen.url
     *
     * @mbg.generated Thu Nov 14 20:26:50 CST 2019
     */
    private String  url;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * data_screen.project_id
     *
     * @mbg.generated Thu Nov 14 20:26:50 CST 2019
     */
    private Integer projectId;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * data_screen.create_time
     *
     * @mbg.generated Thu Nov 14 20:26:50 CST 2019
     */
    private Date    createTime;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column
     * data_screen.update_time
     *
     * @mbg.generated Thu Nov 14 20:26:50 CST 2019
     */
    private Date    updateTime;

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column
     * data_screen.id
     *
     * @return the value of data_screen.id
     * @mbg.generated Thu Nov 14 20:26:50 CST 2019
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column data_screen.id
     *
     * @param id the value for data_screen.id
     * @mbg.generated Thu Nov 14 20:26:50 CST 2019
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column
     * data_screen.name
     *
     * @return the value of data_screen.name
     * @mbg.generated Thu Nov 14 20:26:50 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column
     * data_screen.name
     *
     * @param name the value for data_screen.name
     * @mbg.generated Thu Nov 14 20:26:50 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column
     * data_screen.status
     *
     * @return the value of data_screen.status
     * @mbg.generated Thu Nov 14 20:26:50 CST 2019
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column
     * data_screen.status
     *
     * @param status the value for data_screen.status
     * @mbg.generated Thu Nov 14 20:26:50 CST 2019
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column
     * data_screen.url
     *
     * @return the value of data_screen.url
     * @mbg.generated Thu Nov 14 20:26:50 CST 2019
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column data_screen.url
     *
     * @param url the value for data_screen.url
     * @mbg.generated Thu Nov 14 20:26:50 CST 2019
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column
     * data_screen.project_id
     *
     * @return the value of data_screen.project_id
     * @mbg.generated Thu Nov 14 20:26:50 CST 2019
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column
     * data_screen.project_id
     *
     * @param projectId the value for data_screen.project_id
     * @mbg.generated Thu Nov 14 20:26:50 CST 2019
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column
     * data_screen.create_time
     *
     * @return the value of data_screen.create_time
     * @mbg.generated Thu Nov 14 20:26:50 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column
     * data_screen.create_time
     *
     * @param createTime the value for data_screen.create_time
     * @mbg.generated Thu Nov 14 20:26:50 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column
     * data_screen.update_time
     *
     * @return the value of data_screen.update_time
     * @mbg.generated Thu Nov 14 20:26:50 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column
     * data_screen.update_time
     *
     * @param updateTime the value for data_screen.update_time
     * @mbg.generated Thu Nov 14 20:26:50 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
