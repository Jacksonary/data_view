package com.glodon.data_view;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author liuwg-a
 * @date 2019/11/10 9:50
 * @description
 */
@SpringBootApplication
@MapperScan({"com.glodon.data_view.dao"})
public class DataViewApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataViewApplication.class, args);
    }

}
