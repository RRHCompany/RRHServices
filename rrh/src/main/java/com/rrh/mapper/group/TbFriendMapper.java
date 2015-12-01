package com.rrh.mapper.group;

import java.util.List;

import com.rrh.model.group.TbFriend;

public interface TbFriendMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_friend
     *
     * @mbggenerated Wed Nov 25 14:34:45 CST 2015
     */
    int deleteByPrimaryKey(Integer friendId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_friend
     *
     * @mbggenerated Wed Nov 25 14:34:45 CST 2015
     */
    int insert(TbFriend record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_friend
     *
     * @mbggenerated Wed Nov 25 14:34:45 CST 2015
     */
    TbFriend selectByPrimaryKey(Integer friendId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_friend
     *
     * @mbggenerated Wed Nov 25 14:34:45 CST 2015
     */
    List<TbFriend> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_friend
     *
     * @mbggenerated Wed Nov 25 14:34:45 CST 2015
     */
    int updateByPrimaryKey(TbFriend record);
}