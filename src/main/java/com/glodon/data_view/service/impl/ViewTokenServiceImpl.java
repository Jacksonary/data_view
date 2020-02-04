package com.glodon.data_view.service.impl;

import com.bimface.sdk.BimfaceClient;
import com.bimface.sdk.exception.BimfaceException;
import com.glodon.data_view.service.ViewTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuwg-a
 * @date 2019/12/5 19:45
 * @description
 */
@Service("viewTokenService")
public class ViewTokenServiceImpl implements ViewTokenService {

    @Autowired
    private BimfaceClient bimfaceClient;

    @Override
    public String getViewToken(Long componentId) {
        // 直接后端写死
        componentId = 1749243137312320L;
        try {
            return bimfaceClient.getViewTokenByFileId(componentId);
        } catch (BimfaceException e) {
            throw new RuntimeException(componentId + " get viewToken failed");
        }
    }
}
