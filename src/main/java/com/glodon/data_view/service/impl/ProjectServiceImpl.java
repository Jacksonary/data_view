package com.glodon.data_view.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.glodon.data_view.bean.Page;
import com.glodon.data_view.bean.PagedList;
import com.glodon.data_view.bean.ProjectRequest;
import com.glodon.data_view.dao.mapper.DataScreenMapper;
import com.glodon.data_view.dao.mapper.ProjectMapper;
import com.glodon.data_view.dao.model.Project;
import com.glodon.data_view.service.ProjectService;

/**
 * @author liuwg-a
 * @date 2019/11/10 14:38
 * @description
 */
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectMapper      projectMapper;
    @Autowired
    private DataScreenMapper   dataScreenMapper;
    @Autowired
    private ThreadPoolExecutor myThreadPool;

    @Override
    public PagedList<Project> list(Integer userId, Page page) {
        Assert.notNull(userId, "userId must not null");

        Map<String, Object> condition = new HashMap<>(3);
        condition.put("userId", userId);

        int totalCount = projectMapper.countByCondition(condition);
        page.setTotalCount(totalCount);
        if (totalCount <= 0) {
            return new PagedList<>(page, Collections.emptyList());
        }

        condition.put("offset", page.getStartIndex());
        condition.put("pageSize", page.getPageSize());

        return new PagedList<>(page, projectMapper.selectByCondition(condition));
    }

    @Override
    public Project save(ProjectRequest projectRequest) {
        Assert.notNull(projectRequest, "projectRequest must not null");
        Assert.hasText(projectRequest.getName(), "project's name must not null");
        Assert.notNull(projectRequest.getUserId(), "project's userId must not null");

        Project project = new Project();
        BeanUtils.copyProperties(projectRequest, project);
        project.setCreateTime(new Date());
        project.setPublished(false);
        projectMapper.insertSelective(project);

        return projectMapper.selectTopOneByCreateTime();
    }

    @Override
    public void delete(Integer projectId) {
        Assert.notNull(projectId, "projectId must not null");
        Assert.notNull(projectMapper.selectByPrimaryKey(projectId), "projectId matched none");

        projectMapper.deleteByPrimaryKey(projectId);

        myThreadPool.execute(() -> dataScreenMapper.deleteByProjectId(projectId));
    }
}
