package com.glodon.data_view.service;

import com.glodon.data_view.bean.Page;
import com.glodon.data_view.bean.PagedList;
import com.glodon.data_view.bean.ProjectRequest;
import com.glodon.data_view.dao.model.Project;

/**
 * @author liuwg-a
 * @date 2019/11/10 14:28
 * @description
 */
public interface ProjectService {

    /**
     * 查询所有项目
     *
     * @param userId userId
     * @param page page
     * @return list
     */
    PagedList<Project> list(Integer userId, Page page);

    /**
     * save
     * 
     * @param projectRequest projectRequest
     * @return Project
     */
    Project save(ProjectRequest projectRequest);

    /**
     * delete
     * 
     * @param projectId projectId
     */
    void delete(Integer projectId);
}
