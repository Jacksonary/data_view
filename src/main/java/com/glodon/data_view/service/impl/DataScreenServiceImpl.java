package com.glodon.data_view.service.impl;

import com.glodon.data_view.bean.DataScreenRequest;
import com.glodon.data_view.bean.Page;
import com.glodon.data_view.bean.PagedList;
import com.glodon.data_view.dao.mapper.DataScreenMapper;
import com.glodon.data_view.dao.mapper.ProjectMapper;
import com.glodon.data_view.dao.model.DataScreenWithBLOBs;
import com.glodon.data_view.service.DataScreenService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuwg-a
 * @date 2019/11/10 16:30
 * @description
 */
@Service("dataScreenService")
public class DataScreenServiceImpl implements DataScreenService {

    @Autowired
    private DataScreenMapper dataScreenMapper;
    @Autowired
    private ProjectMapper    projectMapper;

    @Override
    public PagedList<DataScreenWithBLOBs> list(Integer projectId, String dataScreenId, Page page) {
        Assert.notNull(projectId, "projectId must not null");

        Map<String, Object> condition = new HashMap<>(3);
        condition.put("projectId", projectId);
        if (dataScreenId != null) {
            condition.put("id", dataScreenId);
        }

        int totalCount = dataScreenMapper.countByCondition(condition);
        page.setTotalCount(totalCount);
        if (totalCount <= 0) {
            return new PagedList<>(page, Collections.emptyList());
        }

        return new PagedList<>(page, dataScreenMapper.selectByCondition(condition));
    }

    @Override
    public DataScreenWithBLOBs update(Integer projectId, String dataScreenId, DataScreenRequest dataScreenRequest) {
        Assert.notNull(projectId, "projectId must not null");
        Assert.notNull(dataScreenId, "dataScreenId must not null");
        Assert.notNull(dataScreenRequest, "dataScreenRequest must not null");

        DataScreenWithBLOBs dataScreen = dataScreenMapper.selectByPrimaryKey(dataScreenId);
        if (dataScreen == null || !projectId.equals(dataScreen.getProjectId())) {
            throw new IllegalArgumentException("dataScreenId matched none or dataScreen's projectId not match with your projectId");
        }

        boolean updateName = StringUtils.isNotBlank(dataScreenRequest.getName())
                             && !dataScreenRequest.getName().trim().equalsIgnoreCase(dataScreen.getName());
        boolean updateStatus = dataScreenRequest.getStatus() != null
                               && !dataScreenRequest.getStatus().equals(dataScreen.getStatus());
        boolean updateUrl = StringUtils.isNotBlank(dataScreenRequest.getUrl())
                            && !dataScreenRequest.getUrl().trim().equalsIgnoreCase(dataScreen.getUrl());
        boolean updateOpt = StringUtils.isNotBlank(dataScreenRequest.getOpt())
                            && !dataScreenRequest.getOpt().trim().equalsIgnoreCase(dataScreen.getOpt());
        boolean updateLayout = StringUtils.isNotBlank(dataScreenRequest.getLayout())
                               && !dataScreenRequest.getLayout().trim().equalsIgnoreCase(dataScreen.getLayout());
        if (updateName) {
            dataScreen.setName(dataScreenRequest.getName().trim());
        }
        if (updateStatus) {
            dataScreen.setStatus(dataScreenRequest.getStatus());
        }
        if (updateUrl) {
            dataScreen.setUrl(dataScreenRequest.getUrl().trim());
        }
        if (updateOpt) {
            dataScreen.setOpt(dataScreenRequest.getOpt().trim());
        }
        if (updateLayout) {
            dataScreen.setLayout(dataScreenRequest.getLayout());
        }
        if (!updateName && !updateStatus && !updateUrl && !updateOpt && !updateLayout) {
            return dataScreen;
        }

        dataScreen.setUpdateTime(new Date());
        dataScreenMapper.updateByPrimaryKeySelective(dataScreen);
        return dataScreen;
    }

    @Override
    public DataScreenWithBLOBs save(Integer projectId, DataScreenRequest dataScreenRequest) {
        Assert.notNull(dataScreenRequest, "dataScreenRequest must not null");
        Assert.notNull(projectMapper.selectByPrimaryKey(projectId), "projectId matched none.");

        DataScreenWithBLOBs dataScreen = new DataScreenWithBLOBs();
        String id = dataScreenRequest.getId();
        if (id != null) {
            if (dataScreenMapper.selectByPrimaryKey(id) != null) {
                throw new IllegalArgumentException("id has existed. id: " + id);
            }
            dataScreen.setId(id);
        } else {
            dataScreenRequest.setId(String.valueOf(System.currentTimeMillis()));
        }

        BeanUtils.copyProperties(dataScreenRequest, dataScreen);
        dataScreen.setProjectId(projectId);
        dataScreen.setCreateTime(new Date());

        dataScreenMapper.insertSelective(dataScreen);
        return dataScreenMapper.selectTopOneByCreateTime();
    }

    @Override
    public void delete(Integer projectId, String dataScreenId) {
        Assert.notNull(projectId, "projectId must not null");
        Assert.notNull(dataScreenId, "dataScreenId must not null");

        DataScreenWithBLOBs dataScreenWithBLOBs = dataScreenMapper.selectByPrimaryKey(dataScreenId);
        if (dataScreenWithBLOBs == null || !projectId.equals(dataScreenWithBLOBs.getProjectId())) {
            throw new IllegalArgumentException("dataScreenId matched none or dataScreen's projectId not match with your projectId");
        }

        dataScreenMapper.deleteByPrimaryKey(dataScreenId);
    }
}
