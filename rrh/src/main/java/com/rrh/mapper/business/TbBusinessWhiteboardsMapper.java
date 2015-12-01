package com.rrh.mapper.business;

import java.util.List;

import com.rrh.model.business.TbBusinessWhiteboards;

public interface TbBusinessWhiteboardsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_business_whiteboards
     *
     * @mbggenerated Wed Nov 25 14:34:55 CST 2015
     */
    int deleteByPrimaryKey(Integer wbId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_business_whiteboards
     *
     * @mbggenerated Wed Nov 25 14:34:55 CST 2015
     */
    int insert(TbBusinessWhiteboards record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_business_whiteboards
     *
     * @mbggenerated Wed Nov 25 14:34:55 CST 2015
     */
    TbBusinessWhiteboards selectByPrimaryKey(Integer wbId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_business_whiteboards
     *
     * @mbggenerated Wed Nov 25 14:34:55 CST 2015
     */
    List<TbBusinessWhiteboards> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_business_whiteboards
     *
     * @mbggenerated Wed Nov 25 14:34:55 CST 2015
     */
    int updateByPrimaryKey(TbBusinessWhiteboards record);
}