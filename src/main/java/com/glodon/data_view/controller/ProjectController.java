package com.glodon.data_view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.glodon.data_view.bean.*;
import com.glodon.data_view.dao.model.DataScreenWithBLOBs;
import com.glodon.data_view.dao.model.Project;
import com.glodon.data_view.service.DataScreenService;
import com.glodon.data_view.service.ProjectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author liuwg-a
 * @date 2019/11/10 14:04
 * @description
 */
@Api(value = "ProjectController", tags = { "项目相关接口" })
@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

    @Autowired
    private ProjectService    projectService;
    @Autowired
    private DataScreenService dataScreenService;

    @ApiOperation("创建项目")
    @ApiImplicitParam(name = "projectRequest", value = "projectRequest", paramType = "body", dataType = "ProjectRequest", required = true)
    @RequestMapping(value = "", method = RequestMethod.POST)
    public GeneralResponse<Project> save(@RequestBody ProjectRequest projectRequest) {
        return new GeneralResponse<>(projectService.save(projectRequest));
    }

    @ApiOperation("查询项目列表")
    @ApiImplicitParams({ @ApiImplicitParam(name = "user_id", value = "(必要字段)用户id，硬编码，用户id为1", paramType = "query", dataType = "Integer", required = false),
                         @ApiImplicitParam(name = "page_no", value = "页码", paramType = "query", dataType = "Integer", required = false),
                         @ApiImplicitParam(name = "page_size", value = "每页容量", paramType = "query", dataType = "Integer", required = false) })
    @RequestMapping(value = "", method = RequestMethod.GET)
    public GeneralResponse<PagedList<Project>> list(@RequestParam(name = "user_id", value = "user_id", required = false) Integer userId,
                                                    @RequestParam(name = "page_no", value = "page_no", required = false) Integer pageNo,
                                                    @RequestParam(name = "page_size", value = "page_size", required = false) Integer pageSize) {
        return new GeneralResponse<>(projectService.list(userId, new Page(pageNo, pageSize)));
    }

    @ApiOperation("删除项目")
    @ApiImplicitParam(name = "project_id", value = "项目id", paramType = "path", dataType = "integer", required = true)
    @RequestMapping(value = "/{project_id}", method = RequestMethod.DELETE)
    public GeneralResponse<String> delete(@PathVariable("project_id") Integer projectId) {
        projectService.delete(projectId);
        return new GeneralResponse<>("success");
    }

    @ApiOperation("查询项目下的数据屏")
    @ApiImplicitParams({ @ApiImplicitParam(name = "project_id", value = "项目id", paramType = "path", dataType = "Integer", required = true),
                         @ApiImplicitParam(name = "data_screen_id", value = "数据屏id", paramType = "query", dataType = "string", required = false),
                         @ApiImplicitParam(name = "page_no", value = "页码", paramType = "query", dataType = "Integer", required = false),
                         @ApiImplicitParam(name = "page_size", value = "每页容量", paramType = "query", dataType = "Integer", required = false) })
    @RequestMapping(value = "/{project_id}/data_screens", method = RequestMethod.GET)
    public GeneralResponse<PagedList<DataScreenWithBLOBs>> listDataScreen(@PathVariable(value = "project_id", required = true) Integer projectId,
                                                                          @RequestParam(name = "data_screen_id", required = false) String dataScreenId,
                                                                          @RequestParam(name = "page_no", value = "page_no", required = false) Integer pageNo,
                                                                          @RequestParam(name = "page_size", value = "page_size", required = false) Integer pageSize) {
        return new GeneralResponse<>(dataScreenService.list(projectId, dataScreenId, new Page(pageNo, pageSize)));
    }

    @ApiOperation(value = "创建数据屏")
    @ApiImplicitParams({ @ApiImplicitParam(name = "project_id", value = "项目id", paramType = "path", dataType = "integer", required = true),
                         @ApiImplicitParam(name = "dataScreenRequest", value = "dataScreenRequest", paramType = "body", dataType = "DataScreenRequest", required = true) })
    @RequestMapping(value = "/{project_id}/data_screens", method = RequestMethod.POST)
    public GeneralResponse<DataScreenWithBLOBs> saveDataScreen(@PathVariable(value = "project_id", required = true) Integer projectId,
                                                               @RequestBody DataScreenRequest dataScreenRequest) {
        return new GeneralResponse<>(dataScreenService.save(projectId, dataScreenRequest));
    }

    @ApiOperation(value = "更新数据屏信息")
    @ApiImplicitParams({ @ApiImplicitParam(name = "project_id", value = "项目id", paramType = "path", dataType = "integer", required = true),
                         @ApiImplicitParam(name = "data_screen_id", value = "数据屏id", paramType = "path", dataType = "string", required = true),
                         @ApiImplicitParam(name = "dataScreenRequest", value = "dataScreenRequest", paramType = "body", dataType = "DataScreenRequest", required = true) })
    @RequestMapping(value = "/{project_id}/data_screens/{data_screen_id}", method = RequestMethod.PATCH)
    public GeneralResponse<DataScreenWithBLOBs> updateDataScreen(@PathVariable("project_id") Integer projectId,
                                                                 @PathVariable("data_screen_id") String dataScreenId,
                                                                 @RequestBody DataScreenRequest dataScreenRequest) {
        return new GeneralResponse<>(dataScreenService.update(projectId, dataScreenId, dataScreenRequest));
    }

    @ApiOperation("删除项目下的数据屏")
    @ApiImplicitParams({ @ApiImplicitParam(name = "project_id", value = "项目id", paramType = "path", dataType = "integer", required = true),
                         @ApiImplicitParam(name = "data_screen_id", value = "数据屏id", paramType = "path", dataType = "string", required = true) })
    @RequestMapping(value = "/{project_id}/data_screens/{data_screen_id}", method = RequestMethod.DELETE)
    public GeneralResponse<String> deleteDataScreen(@PathVariable("project_id") Integer projectId,
                                                    @PathVariable("data_screen_id") String dataScreenId) {
        dataScreenService.delete(projectId, dataScreenId);
        return new GeneralResponse<>("success");
    }

}
