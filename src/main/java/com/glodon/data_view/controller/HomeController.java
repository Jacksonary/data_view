package com.glodon.data_view.controller;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.glodon.data_view.dao.model.Project;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.glodon.data_view.bean.GeneralResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author liuwg-a
 * @date 2019/11/10 11:03
 * @description 服务检测
 */
@Api(value = "HomeController", tags = { "服务检测" })
@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    @Autowired
    RedissonClient                redissonClient;

    @ApiOperation(value = "服务检测")
    @RequestMapping(value = "/go", method = RequestMethod.GET)
    public GeneralResponse<String> go() {
        RLock rLock = redissonClient.getLock("test-lock");
        try {
            boolean lock = rLock.tryLock(10, 60, TimeUnit.SECONDS);
            if (lock) {
                System.out.println("get lock success!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        redisTemplate.opsForValue().set("test2", buildProject());

        return new GeneralResponse<>("go");
    }

    private Project buildProject() {
        Project project = new Project();
        project.setId(1);
        project.setName("测试");
        project.setUserId(111);
        project.setCreateTime(new Date());
        return project;
    }

    public static void main(String[] args) {
        double pow = Math.pow(3, 2);
        System.out.println(pow);
    }

}
