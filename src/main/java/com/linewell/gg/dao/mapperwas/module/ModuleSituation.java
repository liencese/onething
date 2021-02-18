package com.linewell.gg.dao.mapperwas.module;

import java.io.Serializable;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table module_situation
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class ModuleSituation implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column module_situation.unid
     *
     * @mbg.generated
     */
    private String unid;

    /**
     * Database Column Remarks:
     *   模板id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column module_situation.module_unid
     *
     * @mbg.generated
     */
    private String moduleUnid;

    /**
     * Database Column Remarks:
     *   问题描述
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column module_situation.question
     *
     * @mbg.generated
     */
    private String question;

    /**
     * Database Column Remarks:
     *   答案1
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column module_situation.answer1
     *
     * @mbg.generated
     */
    private String answer1;

    /**
     * Database Column Remarks:
     *   答案2
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column module_situation.answer2
     *
     * @mbg.generated
     */
    private String answer2;

    /**
     * Database Column Remarks:
     *   答案1关联事项
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column module_situation.answer1_sids
     *
     * @mbg.generated
     */
    private String answer1Sids;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column module_situation.answer2_sids
     *
     * @mbg.generated
     */
    private String answer2Sids;

    /**
     * Database Column Remarks:
     *   答案1关联材料
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column module_situation.answer1_mids
     *
     * @mbg.generated
     */
    private String answer1Mids;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column module_situation.answer2_mids
     *
     * @mbg.generated
     */
    private String answer2Mids;

    /**
     * Database Column Remarks:
     *   排序
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column module_situation.sortid
     *
     * @mbg.generated
     */
    private Integer sortid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table module_situation
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    private String createtime;

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column module_situation.unid
     *
     * @return the value of module_situation.unid
     *
     * @mbg.generated
     */
    public String getUnid() {
        return unid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column module_situation.unid
     *
     * @param unid the value for module_situation.unid
     *
     * @mbg.generated
     */
    public void setUnid(String unid) {
        this.unid = unid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column module_situation.module_unid
     *
     * @return the value of module_situation.module_unid
     *
     * @mbg.generated
     */
    public String getModuleUnid() {
        return moduleUnid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column module_situation.module_unid
     *
     * @param moduleUnid the value for module_situation.module_unid
     *
     * @mbg.generated
     */
    public void setModuleUnid(String moduleUnid) {
        this.moduleUnid = moduleUnid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column module_situation.question
     *
     * @return the value of module_situation.question
     *
     * @mbg.generated
     */
    public String getQuestion() {
        return question;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column module_situation.question
     *
     * @param question the value for module_situation.question
     *
     * @mbg.generated
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column module_situation.answer1
     *
     * @return the value of module_situation.answer1
     *
     * @mbg.generated
     */
    public String getAnswer1() {
        return answer1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column module_situation.answer1
     *
     * @param answer1 the value for module_situation.answer1
     *
     * @mbg.generated
     */
    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column module_situation.answer2
     *
     * @return the value of module_situation.answer2
     *
     * @mbg.generated
     */
    public String getAnswer2() {
        return answer2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column module_situation.answer2
     *
     * @param answer2 the value for module_situation.answer2
     *
     * @mbg.generated
     */
    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column module_situation.answer1_sids
     *
     * @return the value of module_situation.answer1_sids
     *
     * @mbg.generated
     */
    public String getAnswer1Sids() {
        return answer1Sids;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column module_situation.answer1_sids
     *
     * @param answer1Sids the value for module_situation.answer1_sids
     *
     * @mbg.generated
     */
    public void setAnswer1Sids(String answer1Sids) {
        this.answer1Sids = answer1Sids;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column module_situation.answer2_sids
     *
     * @return the value of module_situation.answer2_sids
     *
     * @mbg.generated
     */
    public String getAnswer2Sids() {
        return answer2Sids;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column module_situation.answer2_sids
     *
     * @param answer2Sids the value for module_situation.answer2_sids
     *
     * @mbg.generated
     */
    public void setAnswer2Sids(String answer2Sids) {
        this.answer2Sids = answer2Sids;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column module_situation.answer1_mids
     *
     * @return the value of module_situation.answer1_mids
     *
     * @mbg.generated
     */
    public String getAnswer1Mids() {
        return answer1Mids;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column module_situation.answer1_mids
     *
     * @param answer1Mids the value for module_situation.answer1_mids
     *
     * @mbg.generated
     */
    public void setAnswer1Mids(String answer1Mids) {
        this.answer1Mids = answer1Mids;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column module_situation.answer2_mids
     *
     * @return the value of module_situation.answer2_mids
     *
     * @mbg.generated
     */
    public String getAnswer2Mids() {
        return answer2Mids;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column module_situation.answer2_mids
     *
     * @param answer2Mids the value for module_situation.answer2_mids
     *
     * @mbg.generated
     */
    public void setAnswer2Mids(String answer2Mids) {
        this.answer2Mids = answer2Mids;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column module_situation.sortid
     *
     * @return the value of module_situation.sortid
     *
     * @mbg.generated
     */
    public Integer getSortid() {
        return sortid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column module_situation.sortid
     *
     * @param sortid the value for module_situation.sortid
     *
     * @mbg.generated
     */
    public void setSortid(Integer sortid) {
        this.sortid = sortid;
    }
}