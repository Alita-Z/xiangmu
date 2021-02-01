package com.example.hardcoredemo.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LzUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LzUserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNull() {
            addCriterion("phone_number is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNotNull() {
            addCriterion("phone_number is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberEqualTo(String value) {
            addCriterion("phone_number =", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotEqualTo(String value) {
            addCriterion("phone_number <>", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThan(String value) {
            addCriterion("phone_number >", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThanOrEqualTo(String value) {
            addCriterion("phone_number >=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThan(String value) {
            addCriterion("phone_number <", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThanOrEqualTo(String value) {
            addCriterion("phone_number <=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLike(String value) {
            addCriterion("phone_number like", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotLike(String value) {
            addCriterion("phone_number not like", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIn(List<String> values) {
            addCriterion("phone_number in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotIn(List<String> values) {
            addCriterion("phone_number not in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberBetween(String value1, String value2) {
            addCriterion("phone_number between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotBetween(String value1, String value2) {
            addCriterion("phone_number not between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNull() {
            addCriterion("open_id is null");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNotNull() {
            addCriterion("open_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpenIdEqualTo(String value) {
            addCriterion("open_id =", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(String value) {
            addCriterion("open_id <>", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(String value) {
            addCriterion("open_id >", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("open_id >=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(String value) {
            addCriterion("open_id <", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(String value) {
            addCriterion("open_id <=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLike(String value) {
            addCriterion("open_id like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotLike(String value) {
            addCriterion("open_id not like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<String> values) {
            addCriterion("open_id in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<String> values) {
            addCriterion("open_id not in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(String value1, String value2) {
            addCriterion("open_id between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(String value1, String value2) {
            addCriterion("open_id not between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNull() {
            addCriterion("nick_name is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("nick_name =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("nick_name <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("nick_name >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("nick_name >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("nick_name <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("nick_name <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("nick_name like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("nick_name not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("nick_name in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("nick_name not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("nick_name between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("nick_name not between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andSchoolIdIsNull() {
            addCriterion("school_id is null");
            return (Criteria) this;
        }

        public Criteria andSchoolIdIsNotNull() {
            addCriterion("school_id is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolIdEqualTo(Integer value) {
            addCriterion("school_id =", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdNotEqualTo(Integer value) {
            addCriterion("school_id <>", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdGreaterThan(Integer value) {
            addCriterion("school_id >", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("school_id >=", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdLessThan(Integer value) {
            addCriterion("school_id <", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdLessThanOrEqualTo(Integer value) {
            addCriterion("school_id <=", value, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdIn(List<Integer> values) {
            addCriterion("school_id in", values, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdNotIn(List<Integer> values) {
            addCriterion("school_id not in", values, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdBetween(Integer value1, Integer value2) {
            addCriterion("school_id between", value1, value2, "schoolId");
            return (Criteria) this;
        }

        public Criteria andSchoolIdNotBetween(Integer value1, Integer value2) {
            addCriterion("school_id not between", value1, value2, "schoolId");
            return (Criteria) this;
        }

        public Criteria andIsBuyIsNull() {
            addCriterion("is_buy is null");
            return (Criteria) this;
        }

        public Criteria andIsBuyIsNotNull() {
            addCriterion("is_buy is not null");
            return (Criteria) this;
        }

        public Criteria andIsBuyEqualTo(Integer value) {
            addCriterion("is_buy =", value, "isBuy");
            return (Criteria) this;
        }

        public Criteria andIsBuyNotEqualTo(Integer value) {
            addCriterion("is_buy <>", value, "isBuy");
            return (Criteria) this;
        }

        public Criteria andIsBuyGreaterThan(Integer value) {
            addCriterion("is_buy >", value, "isBuy");
            return (Criteria) this;
        }

        public Criteria andIsBuyGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_buy >=", value, "isBuy");
            return (Criteria) this;
        }

        public Criteria andIsBuyLessThan(Integer value) {
            addCriterion("is_buy <", value, "isBuy");
            return (Criteria) this;
        }

        public Criteria andIsBuyLessThanOrEqualTo(Integer value) {
            addCriterion("is_buy <=", value, "isBuy");
            return (Criteria) this;
        }

        public Criteria andIsBuyIn(List<Integer> values) {
            addCriterion("is_buy in", values, "isBuy");
            return (Criteria) this;
        }

        public Criteria andIsBuyNotIn(List<Integer> values) {
            addCriterion("is_buy not in", values, "isBuy");
            return (Criteria) this;
        }

        public Criteria andIsBuyBetween(Integer value1, Integer value2) {
            addCriterion("is_buy between", value1, value2, "isBuy");
            return (Criteria) this;
        }

        public Criteria andIsBuyNotBetween(Integer value1, Integer value2) {
            addCriterion("is_buy not between", value1, value2, "isBuy");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNull() {
            addCriterion("total_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNotNull() {
            addCriterion("total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountEqualTo(BigDecimal value) {
            addCriterion("total_amount =", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotEqualTo(BigDecimal value) {
            addCriterion("total_amount <>", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThan(BigDecimal value) {
            addCriterion("total_amount >", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount >=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThan(BigDecimal value) {
            addCriterion("total_amount <", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount <=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIn(List<BigDecimal> values) {
            addCriterion("total_amount in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotIn(List<BigDecimal> values) {
            addCriterion("total_amount not in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount not between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andYearAmountIsNull() {
            addCriterion("year_amount is null");
            return (Criteria) this;
        }

        public Criteria andYearAmountIsNotNull() {
            addCriterion("year_amount is not null");
            return (Criteria) this;
        }

        public Criteria andYearAmountEqualTo(BigDecimal value) {
            addCriterion("year_amount =", value, "yearAmount");
            return (Criteria) this;
        }

        public Criteria andYearAmountNotEqualTo(BigDecimal value) {
            addCriterion("year_amount <>", value, "yearAmount");
            return (Criteria) this;
        }

        public Criteria andYearAmountGreaterThan(BigDecimal value) {
            addCriterion("year_amount >", value, "yearAmount");
            return (Criteria) this;
        }

        public Criteria andYearAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("year_amount >=", value, "yearAmount");
            return (Criteria) this;
        }

        public Criteria andYearAmountLessThan(BigDecimal value) {
            addCriterion("year_amount <", value, "yearAmount");
            return (Criteria) this;
        }

        public Criteria andYearAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("year_amount <=", value, "yearAmount");
            return (Criteria) this;
        }

        public Criteria andYearAmountIn(List<BigDecimal> values) {
            addCriterion("year_amount in", values, "yearAmount");
            return (Criteria) this;
        }

        public Criteria andYearAmountNotIn(List<BigDecimal> values) {
            addCriterion("year_amount not in", values, "yearAmount");
            return (Criteria) this;
        }

        public Criteria andYearAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("year_amount between", value1, value2, "yearAmount");
            return (Criteria) this;
        }

        public Criteria andYearAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("year_amount not between", value1, value2, "yearAmount");
            return (Criteria) this;
        }

        public Criteria andCurrentsTimeIsNull() {
            addCriterion("currents_time is null");
            return (Criteria) this;
        }

        public Criteria andCurrentsTimeIsNotNull() {
            addCriterion("currents_time is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentsTimeEqualTo(Date value) {
            addCriterion("currents_time =", value, "currentsTime");
            return (Criteria) this;
        }

        public Criteria andCurrentsTimeNotEqualTo(Date value) {
            addCriterion("currents_time <>", value, "currentsTime");
            return (Criteria) this;
        }

        public Criteria andCurrentsTimeGreaterThan(Date value) {
            addCriterion("currents_time >", value, "currentsTime");
            return (Criteria) this;
        }

        public Criteria andCurrentsTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("currents_time >=", value, "currentsTime");
            return (Criteria) this;
        }

        public Criteria andCurrentsTimeLessThan(Date value) {
            addCriterion("currents_time <", value, "currentsTime");
            return (Criteria) this;
        }

        public Criteria andCurrentsTimeLessThanOrEqualTo(Date value) {
            addCriterion("currents_time <=", value, "currentsTime");
            return (Criteria) this;
        }

        public Criteria andCurrentsTimeIn(List<Date> values) {
            addCriterion("currents_time in", values, "currentsTime");
            return (Criteria) this;
        }

        public Criteria andCurrentsTimeNotIn(List<Date> values) {
            addCriterion("currents_time not in", values, "currentsTime");
            return (Criteria) this;
        }

        public Criteria andCurrentsTimeBetween(Date value1, Date value2) {
            addCriterion("currents_time between", value1, value2, "currentsTime");
            return (Criteria) this;
        }

        public Criteria andCurrentsTimeNotBetween(Date value1, Date value2) {
            addCriterion("currents_time not between", value1, value2, "currentsTime");
            return (Criteria) this;
        }

        public Criteria andReferrerIsNull() {
            addCriterion("referrer is null");
            return (Criteria) this;
        }

        public Criteria andReferrerIsNotNull() {
            addCriterion("referrer is not null");
            return (Criteria) this;
        }

        public Criteria andReferrerEqualTo(Integer value) {
            addCriterion("referrer =", value, "referrer");
            return (Criteria) this;
        }

        public Criteria andReferrerNotEqualTo(Integer value) {
            addCriterion("referrer <>", value, "referrer");
            return (Criteria) this;
        }

        public Criteria andReferrerGreaterThan(Integer value) {
            addCriterion("referrer >", value, "referrer");
            return (Criteria) this;
        }

        public Criteria andReferrerGreaterThanOrEqualTo(Integer value) {
            addCriterion("referrer >=", value, "referrer");
            return (Criteria) this;
        }

        public Criteria andReferrerLessThan(Integer value) {
            addCriterion("referrer <", value, "referrer");
            return (Criteria) this;
        }

        public Criteria andReferrerLessThanOrEqualTo(Integer value) {
            addCriterion("referrer <=", value, "referrer");
            return (Criteria) this;
        }

        public Criteria andReferrerIn(List<Integer> values) {
            addCriterion("referrer in", values, "referrer");
            return (Criteria) this;
        }

        public Criteria andReferrerNotIn(List<Integer> values) {
            addCriterion("referrer not in", values, "referrer");
            return (Criteria) this;
        }

        public Criteria andReferrerBetween(Integer value1, Integer value2) {
            addCriterion("referrer between", value1, value2, "referrer");
            return (Criteria) this;
        }

        public Criteria andReferrerNotBetween(Integer value1, Integer value2) {
            addCriterion("referrer not between", value1, value2, "referrer");
            return (Criteria) this;
        }

        public Criteria andReferrerTypeIsNull() {
            addCriterion("referrer_type is null");
            return (Criteria) this;
        }

        public Criteria andReferrerTypeIsNotNull() {
            addCriterion("referrer_type is not null");
            return (Criteria) this;
        }

        public Criteria andReferrerTypeEqualTo(Integer value) {
            addCriterion("referrer_type =", value, "referrerType");
            return (Criteria) this;
        }

        public Criteria andReferrerTypeNotEqualTo(Integer value) {
            addCriterion("referrer_type <>", value, "referrerType");
            return (Criteria) this;
        }

        public Criteria andReferrerTypeGreaterThan(Integer value) {
            addCriterion("referrer_type >", value, "referrerType");
            return (Criteria) this;
        }

        public Criteria andReferrerTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("referrer_type >=", value, "referrerType");
            return (Criteria) this;
        }

        public Criteria andReferrerTypeLessThan(Integer value) {
            addCriterion("referrer_type <", value, "referrerType");
            return (Criteria) this;
        }

        public Criteria andReferrerTypeLessThanOrEqualTo(Integer value) {
            addCriterion("referrer_type <=", value, "referrerType");
            return (Criteria) this;
        }

        public Criteria andReferrerTypeIn(List<Integer> values) {
            addCriterion("referrer_type in", values, "referrerType");
            return (Criteria) this;
        }

        public Criteria andReferrerTypeNotIn(List<Integer> values) {
            addCriterion("referrer_type not in", values, "referrerType");
            return (Criteria) this;
        }

        public Criteria andReferrerTypeBetween(Integer value1, Integer value2) {
            addCriterion("referrer_type between", value1, value2, "referrerType");
            return (Criteria) this;
        }

        public Criteria andReferrerTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("referrer_type not between", value1, value2, "referrerType");
            return (Criteria) this;
        }

        public Criteria andReferrerPhoneNumberIsNull() {
            addCriterion("referrer_phone_number is null");
            return (Criteria) this;
        }

        public Criteria andReferrerPhoneNumberIsNotNull() {
            addCriterion("referrer_phone_number is not null");
            return (Criteria) this;
        }

        public Criteria andReferrerPhoneNumberEqualTo(String value) {
            addCriterion("referrer_phone_number =", value, "referrerPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andReferrerPhoneNumberNotEqualTo(String value) {
            addCriterion("referrer_phone_number <>", value, "referrerPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andReferrerPhoneNumberGreaterThan(String value) {
            addCriterion("referrer_phone_number >", value, "referrerPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andReferrerPhoneNumberGreaterThanOrEqualTo(String value) {
            addCriterion("referrer_phone_number >=", value, "referrerPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andReferrerPhoneNumberLessThan(String value) {
            addCriterion("referrer_phone_number <", value, "referrerPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andReferrerPhoneNumberLessThanOrEqualTo(String value) {
            addCriterion("referrer_phone_number <=", value, "referrerPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andReferrerPhoneNumberLike(String value) {
            addCriterion("referrer_phone_number like", value, "referrerPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andReferrerPhoneNumberNotLike(String value) {
            addCriterion("referrer_phone_number not like", value, "referrerPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andReferrerPhoneNumberIn(List<String> values) {
            addCriterion("referrer_phone_number in", values, "referrerPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andReferrerPhoneNumberNotIn(List<String> values) {
            addCriterion("referrer_phone_number not in", values, "referrerPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andReferrerPhoneNumberBetween(String value1, String value2) {
            addCriterion("referrer_phone_number between", value1, value2, "referrerPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andReferrerPhoneNumberNotBetween(String value1, String value2) {
            addCriterion("referrer_phone_number not between", value1, value2, "referrerPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andReferrerNameIsNull() {
            addCriterion("referrer_name is null");
            return (Criteria) this;
        }

        public Criteria andReferrerNameIsNotNull() {
            addCriterion("referrer_name is not null");
            return (Criteria) this;
        }

        public Criteria andReferrerNameEqualTo(String value) {
            addCriterion("referrer_name =", value, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerNameNotEqualTo(String value) {
            addCriterion("referrer_name <>", value, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerNameGreaterThan(String value) {
            addCriterion("referrer_name >", value, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerNameGreaterThanOrEqualTo(String value) {
            addCriterion("referrer_name >=", value, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerNameLessThan(String value) {
            addCriterion("referrer_name <", value, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerNameLessThanOrEqualTo(String value) {
            addCriterion("referrer_name <=", value, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerNameLike(String value) {
            addCriterion("referrer_name like", value, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerNameNotLike(String value) {
            addCriterion("referrer_name not like", value, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerNameIn(List<String> values) {
            addCriterion("referrer_name in", values, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerNameNotIn(List<String> values) {
            addCriterion("referrer_name not in", values, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerNameBetween(String value1, String value2) {
            addCriterion("referrer_name between", value1, value2, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerNameNotBetween(String value1, String value2) {
            addCriterion("referrer_name not between", value1, value2, "referrerName");
            return (Criteria) this;
        }

        public Criteria andAdvisoryIsNull() {
            addCriterion("advisory is null");
            return (Criteria) this;
        }

        public Criteria andAdvisoryIsNotNull() {
            addCriterion("advisory is not null");
            return (Criteria) this;
        }

        public Criteria andAdvisoryEqualTo(Integer value) {
            addCriterion("advisory =", value, "advisory");
            return (Criteria) this;
        }

        public Criteria andAdvisoryNotEqualTo(Integer value) {
            addCriterion("advisory <>", value, "advisory");
            return (Criteria) this;
        }

        public Criteria andAdvisoryGreaterThan(Integer value) {
            addCriterion("advisory >", value, "advisory");
            return (Criteria) this;
        }

        public Criteria andAdvisoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("advisory >=", value, "advisory");
            return (Criteria) this;
        }

        public Criteria andAdvisoryLessThan(Integer value) {
            addCriterion("advisory <", value, "advisory");
            return (Criteria) this;
        }

        public Criteria andAdvisoryLessThanOrEqualTo(Integer value) {
            addCriterion("advisory <=", value, "advisory");
            return (Criteria) this;
        }

        public Criteria andAdvisoryIn(List<Integer> values) {
            addCriterion("advisory in", values, "advisory");
            return (Criteria) this;
        }

        public Criteria andAdvisoryNotIn(List<Integer> values) {
            addCriterion("advisory not in", values, "advisory");
            return (Criteria) this;
        }

        public Criteria andAdvisoryBetween(Integer value1, Integer value2) {
            addCriterion("advisory between", value1, value2, "advisory");
            return (Criteria) this;
        }

        public Criteria andAdvisoryNotBetween(Integer value1, Integer value2) {
            addCriterion("advisory not between", value1, value2, "advisory");
            return (Criteria) this;
        }

        public Criteria andAdvisoryPhoneNumberIsNull() {
            addCriterion("advisory_phone_number is null");
            return (Criteria) this;
        }

        public Criteria andAdvisoryPhoneNumberIsNotNull() {
            addCriterion("advisory_phone_number is not null");
            return (Criteria) this;
        }

        public Criteria andAdvisoryPhoneNumberEqualTo(String value) {
            addCriterion("advisory_phone_number =", value, "advisoryPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andAdvisoryPhoneNumberNotEqualTo(String value) {
            addCriterion("advisory_phone_number <>", value, "advisoryPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andAdvisoryPhoneNumberGreaterThan(String value) {
            addCriterion("advisory_phone_number >", value, "advisoryPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andAdvisoryPhoneNumberGreaterThanOrEqualTo(String value) {
            addCriterion("advisory_phone_number >=", value, "advisoryPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andAdvisoryPhoneNumberLessThan(String value) {
            addCriterion("advisory_phone_number <", value, "advisoryPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andAdvisoryPhoneNumberLessThanOrEqualTo(String value) {
            addCriterion("advisory_phone_number <=", value, "advisoryPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andAdvisoryPhoneNumberLike(String value) {
            addCriterion("advisory_phone_number like", value, "advisoryPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andAdvisoryPhoneNumberNotLike(String value) {
            addCriterion("advisory_phone_number not like", value, "advisoryPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andAdvisoryPhoneNumberIn(List<String> values) {
            addCriterion("advisory_phone_number in", values, "advisoryPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andAdvisoryPhoneNumberNotIn(List<String> values) {
            addCriterion("advisory_phone_number not in", values, "advisoryPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andAdvisoryPhoneNumberBetween(String value1, String value2) {
            addCriterion("advisory_phone_number between", value1, value2, "advisoryPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andAdvisoryPhoneNumberNotBetween(String value1, String value2) {
            addCriterion("advisory_phone_number not between", value1, value2, "advisoryPhoneNumber");
            return (Criteria) this;
        }

        public Criteria andAdvisoryNameIsNull() {
            addCriterion("advisory_name is null");
            return (Criteria) this;
        }

        public Criteria andAdvisoryNameIsNotNull() {
            addCriterion("advisory_name is not null");
            return (Criteria) this;
        }

        public Criteria andAdvisoryNameEqualTo(String value) {
            addCriterion("advisory_name =", value, "advisoryName");
            return (Criteria) this;
        }

        public Criteria andAdvisoryNameNotEqualTo(String value) {
            addCriterion("advisory_name <>", value, "advisoryName");
            return (Criteria) this;
        }

        public Criteria andAdvisoryNameGreaterThan(String value) {
            addCriterion("advisory_name >", value, "advisoryName");
            return (Criteria) this;
        }

        public Criteria andAdvisoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("advisory_name >=", value, "advisoryName");
            return (Criteria) this;
        }

        public Criteria andAdvisoryNameLessThan(String value) {
            addCriterion("advisory_name <", value, "advisoryName");
            return (Criteria) this;
        }

        public Criteria andAdvisoryNameLessThanOrEqualTo(String value) {
            addCriterion("advisory_name <=", value, "advisoryName");
            return (Criteria) this;
        }

        public Criteria andAdvisoryNameLike(String value) {
            addCriterion("advisory_name like", value, "advisoryName");
            return (Criteria) this;
        }

        public Criteria andAdvisoryNameNotLike(String value) {
            addCriterion("advisory_name not like", value, "advisoryName");
            return (Criteria) this;
        }

        public Criteria andAdvisoryNameIn(List<String> values) {
            addCriterion("advisory_name in", values, "advisoryName");
            return (Criteria) this;
        }

        public Criteria andAdvisoryNameNotIn(List<String> values) {
            addCriterion("advisory_name not in", values, "advisoryName");
            return (Criteria) this;
        }

        public Criteria andAdvisoryNameBetween(String value1, String value2) {
            addCriterion("advisory_name between", value1, value2, "advisoryName");
            return (Criteria) this;
        }

        public Criteria andAdvisoryNameNotBetween(String value1, String value2) {
            addCriterion("advisory_name not between", value1, value2, "advisoryName");
            return (Criteria) this;
        }

        public Criteria andStudent1IsNull() {
            addCriterion("student1 is null");
            return (Criteria) this;
        }

        public Criteria andStudent1IsNotNull() {
            addCriterion("student1 is not null");
            return (Criteria) this;
        }

        public Criteria andStudent1EqualTo(String value) {
            addCriterion("student1 =", value, "student1");
            return (Criteria) this;
        }

        public Criteria andStudent1NotEqualTo(String value) {
            addCriterion("student1 <>", value, "student1");
            return (Criteria) this;
        }

        public Criteria andStudent1GreaterThan(String value) {
            addCriterion("student1 >", value, "student1");
            return (Criteria) this;
        }

        public Criteria andStudent1GreaterThanOrEqualTo(String value) {
            addCriterion("student1 >=", value, "student1");
            return (Criteria) this;
        }

        public Criteria andStudent1LessThan(String value) {
            addCriterion("student1 <", value, "student1");
            return (Criteria) this;
        }

        public Criteria andStudent1LessThanOrEqualTo(String value) {
            addCriterion("student1 <=", value, "student1");
            return (Criteria) this;
        }

        public Criteria andStudent1Like(String value) {
            addCriterion("student1 like", value, "student1");
            return (Criteria) this;
        }

        public Criteria andStudent1NotLike(String value) {
            addCriterion("student1 not like", value, "student1");
            return (Criteria) this;
        }

        public Criteria andStudent1In(List<String> values) {
            addCriterion("student1 in", values, "student1");
            return (Criteria) this;
        }

        public Criteria andStudent1NotIn(List<String> values) {
            addCriterion("student1 not in", values, "student1");
            return (Criteria) this;
        }

        public Criteria andStudent1Between(String value1, String value2) {
            addCriterion("student1 between", value1, value2, "student1");
            return (Criteria) this;
        }

        public Criteria andStudent1NotBetween(String value1, String value2) {
            addCriterion("student1 not between", value1, value2, "student1");
            return (Criteria) this;
        }

        public Criteria andStudent2IsNull() {
            addCriterion("student2 is null");
            return (Criteria) this;
        }

        public Criteria andStudent2IsNotNull() {
            addCriterion("student2 is not null");
            return (Criteria) this;
        }

        public Criteria andStudent2EqualTo(String value) {
            addCriterion("student2 =", value, "student2");
            return (Criteria) this;
        }

        public Criteria andStudent2NotEqualTo(String value) {
            addCriterion("student2 <>", value, "student2");
            return (Criteria) this;
        }

        public Criteria andStudent2GreaterThan(String value) {
            addCriterion("student2 >", value, "student2");
            return (Criteria) this;
        }

        public Criteria andStudent2GreaterThanOrEqualTo(String value) {
            addCriterion("student2 >=", value, "student2");
            return (Criteria) this;
        }

        public Criteria andStudent2LessThan(String value) {
            addCriterion("student2 <", value, "student2");
            return (Criteria) this;
        }

        public Criteria andStudent2LessThanOrEqualTo(String value) {
            addCriterion("student2 <=", value, "student2");
            return (Criteria) this;
        }

        public Criteria andStudent2Like(String value) {
            addCriterion("student2 like", value, "student2");
            return (Criteria) this;
        }

        public Criteria andStudent2NotLike(String value) {
            addCriterion("student2 not like", value, "student2");
            return (Criteria) this;
        }

        public Criteria andStudent2In(List<String> values) {
            addCriterion("student2 in", values, "student2");
            return (Criteria) this;
        }

        public Criteria andStudent2NotIn(List<String> values) {
            addCriterion("student2 not in", values, "student2");
            return (Criteria) this;
        }

        public Criteria andStudent2Between(String value1, String value2) {
            addCriterion("student2 between", value1, value2, "student2");
            return (Criteria) this;
        }

        public Criteria andStudent2NotBetween(String value1, String value2) {
            addCriterion("student2 not between", value1, value2, "student2");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andParentsIsNull() {
            addCriterion("parents is null");
            return (Criteria) this;
        }

        public Criteria andParentsIsNotNull() {
            addCriterion("parents is not null");
            return (Criteria) this;
        }

        public Criteria andParentsEqualTo(String value) {
            addCriterion("parents =", value, "parents");
            return (Criteria) this;
        }

        public Criteria andParentsNotEqualTo(String value) {
            addCriterion("parents <>", value, "parents");
            return (Criteria) this;
        }

        public Criteria andParentsGreaterThan(String value) {
            addCriterion("parents >", value, "parents");
            return (Criteria) this;
        }

        public Criteria andParentsGreaterThanOrEqualTo(String value) {
            addCriterion("parents >=", value, "parents");
            return (Criteria) this;
        }

        public Criteria andParentsLessThan(String value) {
            addCriterion("parents <", value, "parents");
            return (Criteria) this;
        }

        public Criteria andParentsLessThanOrEqualTo(String value) {
            addCriterion("parents <=", value, "parents");
            return (Criteria) this;
        }

        public Criteria andParentsLike(String value) {
            addCriterion("parents like", value, "parents");
            return (Criteria) this;
        }

        public Criteria andParentsNotLike(String value) {
            addCriterion("parents not like", value, "parents");
            return (Criteria) this;
        }

        public Criteria andParentsIn(List<String> values) {
            addCriterion("parents in", values, "parents");
            return (Criteria) this;
        }

        public Criteria andParentsNotIn(List<String> values) {
            addCriterion("parents not in", values, "parents");
            return (Criteria) this;
        }

        public Criteria andParentsBetween(String value1, String value2) {
            addCriterion("parents between", value1, value2, "parents");
            return (Criteria) this;
        }

        public Criteria andParentsNotBetween(String value1, String value2) {
            addCriterion("parents not between", value1, value2, "parents");
            return (Criteria) this;
        }

        public Criteria andLablesIsNull() {
            addCriterion("lables is null");
            return (Criteria) this;
        }

        public Criteria andLablesIsNotNull() {
            addCriterion("lables is not null");
            return (Criteria) this;
        }

        public Criteria andLablesEqualTo(String value) {
            addCriterion("lables =", value, "lables");
            return (Criteria) this;
        }

        public Criteria andLablesNotEqualTo(String value) {
            addCriterion("lables <>", value, "lables");
            return (Criteria) this;
        }

        public Criteria andLablesGreaterThan(String value) {
            addCriterion("lables >", value, "lables");
            return (Criteria) this;
        }

        public Criteria andLablesGreaterThanOrEqualTo(String value) {
            addCriterion("lables >=", value, "lables");
            return (Criteria) this;
        }

        public Criteria andLablesLessThan(String value) {
            addCriterion("lables <", value, "lables");
            return (Criteria) this;
        }

        public Criteria andLablesLessThanOrEqualTo(String value) {
            addCriterion("lables <=", value, "lables");
            return (Criteria) this;
        }

        public Criteria andLablesLike(String value) {
            addCriterion("lables like", value, "lables");
            return (Criteria) this;
        }

        public Criteria andLablesNotLike(String value) {
            addCriterion("lables not like", value, "lables");
            return (Criteria) this;
        }

        public Criteria andLablesIn(List<String> values) {
            addCriterion("lables in", values, "lables");
            return (Criteria) this;
        }

        public Criteria andLablesNotIn(List<String> values) {
            addCriterion("lables not in", values, "lables");
            return (Criteria) this;
        }

        public Criteria andLablesBetween(String value1, String value2) {
            addCriterion("lables between", value1, value2, "lables");
            return (Criteria) this;
        }

        public Criteria andLablesNotBetween(String value1, String value2) {
            addCriterion("lables not between", value1, value2, "lables");
            return (Criteria) this;
        }

        public Criteria andIsEnableIsNull() {
            addCriterion("is_enable is null");
            return (Criteria) this;
        }

        public Criteria andIsEnableIsNotNull() {
            addCriterion("is_enable is not null");
            return (Criteria) this;
        }

        public Criteria andIsEnableEqualTo(Integer value) {
            addCriterion("is_enable =", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotEqualTo(Integer value) {
            addCriterion("is_enable <>", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableGreaterThan(Integer value) {
            addCriterion("is_enable >", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_enable >=", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableLessThan(Integer value) {
            addCriterion("is_enable <", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableLessThanOrEqualTo(Integer value) {
            addCriterion("is_enable <=", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableIn(List<Integer> values) {
            addCriterion("is_enable in", values, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotIn(List<Integer> values) {
            addCriterion("is_enable not in", values, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableBetween(Integer value1, Integer value2) {
            addCriterion("is_enable between", value1, value2, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotBetween(Integer value1, Integer value2) {
            addCriterion("is_enable not between", value1, value2, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Integer value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Integer value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Integer value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Integer value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Integer value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Integer> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Integer> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Integer value1, Integer value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNull() {
            addCriterion("ctime is null");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNotNull() {
            addCriterion("ctime is not null");
            return (Criteria) this;
        }

        public Criteria andCtimeEqualTo(Date value) {
            addCriterion("ctime =", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotEqualTo(Date value) {
            addCriterion("ctime <>", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThan(Date value) {
            addCriterion("ctime >", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ctime >=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThan(Date value) {
            addCriterion("ctime <", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThanOrEqualTo(Date value) {
            addCriterion("ctime <=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeIn(List<Date> values) {
            addCriterion("ctime in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotIn(List<Date> values) {
            addCriterion("ctime not in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeBetween(Date value1, Date value2) {
            addCriterion("ctime between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotBetween(Date value1, Date value2) {
            addCriterion("ctime not between", value1, value2, "ctime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}