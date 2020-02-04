package com.glodon.data_view.controller;

import com.glodon.data_view.bean.GeneralResponse;
import com.glodon.data_view.service.ViewTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuwg-a
 * @date 2019/12/5 19:42
 * @description
 */
@RestController
@RequestMapping("/components")
public class ComponentController {

    @Autowired
    private ViewTokenService viewTokenService;

    @RequestMapping(value = "/{component_id}/view_token", method = RequestMethod.GET)
    public GeneralResponse<String> getViewToken(@PathVariable("component_id") Long componentId) {
        return new GeneralResponse<>(viewTokenService.getViewToken(componentId));
    }
}
