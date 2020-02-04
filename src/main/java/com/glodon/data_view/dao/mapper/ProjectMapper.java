package com.glodon.data_view.dao.mapper;

import com.glodon.data_view.dao.model.Project;

import java.util.List;
import java.util.Map;

public interface ProjectMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Sun Nov 10 13:51:31 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Sun Nov 10 13:51:31 CST 2019
     */
    int insert(Project record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Sun Nov 10 13:51:31 CST 2019
     */
    int insertSelective(Project record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Sun Nov 10 13:51:31 CST 2019
     */
    Project selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Sun Nov 10 13:51:31 CST 2019
     */
    int updateByPrimaryKeySelective(Project record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Sun Nov 10 13:51:31 CST 2019
     */
    int updateByPrimaryKey(Project record);

    /**
     * 根据指定条件查询记录
     *
     * @param condition condition
     * @return int
     */
    int countByCondition(Map<String, Object> condition);

    /**
     * 根据条件查询记录
     *
     * @param condition condition
     * @return List<Project>
     */
    List<Project> selectByCondition(Map<String, Object> condition);

    Project selectTopOneByCreateTime();
}