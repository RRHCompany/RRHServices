package com.rrh.mapper.business;

import java.util.List;

import com.rrh.model.business.TbBusinessKnowledge;

public interface TbBusinessKnowledgeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_business_knowledge
     *
     * @mbggenerated Wed Nov 25 14:34:55 CST 2015
     */
    int deleteByPrimaryKey(Integer knowledgeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_business_knowledge
     *
     * @mbggenerated Wed Nov 25 14:34:55 CST 2015
     */
    int insert(TbBusinessKnowledge record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_business_knowledge
     *
     * @mbggenerated Wed Nov 25 14:34:55 CST 2015
     */
    TbBusinessKnowledge selectByPrimaryKey(Integer knowledgeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_business_knowledge
     *
     * @mbggenerated Wed Nov 25 14:34:55 CST 2015
     */
    List<TbBusinessKnowledge> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_business_knowledge
     *
     * @mbggenerated Wed Nov 25 14:34:55 CST 2015
     */
    int updateByPrimaryKey(TbBusinessKnowledge record);
}