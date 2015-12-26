package com.rrh.mapper.group;

import java.util.List;

import com.rrh.common.mybatis.bean.GroupUserBean;
import com.rrh.model.group.TbGroupUser;

public interface TbGroupUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_group_user
     *
     * @mbggenerated Wed Nov 25 14:34:45 CST 2015
     */
    int deleteByPrimaryKey(Integer groupUserId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_group_user
     *
     * @mbggenerated Wed Nov 25 14:34:45 CST 2015
     */
    int insert(TbGroupUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_group_user
     *
     * @mbggenerated Wed Nov 25 14:34:45 CST 2015
     */
    TbGroupUser selectByPrimaryKey(Integer groupUserId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_group_user
     *
     * @mbggenerated Wed Nov 25 14:34:45 CST 2015
     */
    List<TbGroupUser> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_group_user
     *
     * @mbggenerated Wed Nov 25 14:34:45 CST 2015
     */
    int updateByPrimaryKey(TbGroupUser record);
    //根据群编号，查询群成员列表
    List<GroupUserBean> findByGroupID(int groupId);
}