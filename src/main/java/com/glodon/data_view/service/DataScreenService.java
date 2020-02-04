package com.glodon.data_view.service;

import com.glodon.data_view.bean.DataScreenRequest;
import com.glodon.data_view.bean.Page;
import com.glodon.data_view.bean.PagedList;
import com.glodon.data_view.dao.model.DataScreenWithBLOBs;

/**
 * @author liuwg-a
 * @date 2019/11/10 16:29
 * @description
 */
public interface DataScreenService {

    /**
     * list
     *
     * @param projectId projectId
     * @param page page
     * @return PagedList<DataScreen>
     */
    PagedList<DataScreenWithBLOBs> list(Integer projectId, String dataScreenId, Page page);

    /**
     * update
     *
     * @param projectId projectId
     * @param dataScreenId dataScreenId
     * @param dataScreenRequest dataScreenRequest
     * @return DataScreen
     */
    DataScreenWithBLOBs update(Integer projectId, String dataScreenId, DataScreenRequest dataScreenRequest);

    /**
     * save
     *
     * @param projectId projectId
     * @param dataScreenRequest dataScreenRequest
     * @return DataScreenWithBLOBs
     */
    DataScreenWithBLOBs save(Integer projectId, DataScreenRequest dataScreenRequest);

    /**
     * delete
     * 
     * @param projectId projectId
     * @param dataScreenId dataScreenId
     */
    void delete(Integer projectId, String dataScreenId);
}
