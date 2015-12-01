package com.rrh.mapper.user;

import java.util.List;

import com.rrh.model.user.TbUsers;

public interface TbUsersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_users
     *
     * @mbggenerated Wed Nov 25 14:34:16 CST 2015
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_users
     *
     * @mbggenerated Wed Nov 25 14:34:16 CST 2015
     */
    int insert(TbUsers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_users
     *
     * @mbggenerated Wed Nov 25 14:34:16 CST 2015
     */
    TbUsers selectByPrimaryKey(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_users
     *
     * @mbggenerated Wed Nov 25 14:34:16 CST 2015
     */
    List<TbUsers> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_users
     *
     * @mbggenerated Wed Nov 25 14:34:16 CST 2015
     */
    int updateByPrimaryKey(TbUsers record);
    
    /**
     * 选择性更新用户
     * @param record
     * @return
     */
    int updateByModelSelective(TbUsers record);
    /**
     * 选择性，多条件查询用户
     * @param record
     * @return
     */
    List<TbUsers> selectByModelSelective(TbUsers record);
    /**
     * 通过电话验证用户是否已注册 
     * @param mobile
     * @return
     */
    int selectUserIdByPhone(String mobile);
    /**
     * 通过电话号码查询用户信息
     * @param mobile
     * @return
     */
    TbUsers selectUserByPhone(String mobile);
    TbUsers selectUserByOpenId(TbUsers record);
    /**
     * 通过用户名验证用户是否已经存在
     * @param userName
     * @return
     */
    int selectUserIdByUserName(String userName);
}