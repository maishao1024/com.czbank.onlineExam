package com.onlineExam.model.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SignResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SignResultExample() {
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

        public Criteria andBeginTimeIsNull() {
            addCriterion("begin_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(Date value) {
            addCriterion("begin_time =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(Date value) {
            addCriterion("begin_time <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(Date value) {
            addCriterion("begin_time >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("begin_time >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(Date value) {
            addCriterion("begin_time <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("begin_time <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<Date> values) {
            addCriterion("begin_time in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<Date> values) {
            addCriterion("begin_time not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(Date value1, Date value2) {
            addCriterion("begin_time between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("begin_time not between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andNeedSignIsNull() {
            addCriterion("need_sign is null");
            return (Criteria) this;
        }

        public Criteria andNeedSignIsNotNull() {
            addCriterion("need_sign is not null");
            return (Criteria) this;
        }

        public Criteria andNeedSignEqualTo(Integer value) {
            addCriterion("need_sign =", value, "needSign");
            return (Criteria) this;
        }

        public Criteria andNeedSignNotEqualTo(Integer value) {
            addCriterion("need_sign <>", value, "needSign");
            return (Criteria) this;
        }

        public Criteria andNeedSignGreaterThan(Integer value) {
            addCriterion("need_sign >", value, "needSign");
            return (Criteria) this;
        }

        public Criteria andNeedSignGreaterThanOrEqualTo(Integer value) {
            addCriterion("need_sign >=", value, "needSign");
            return (Criteria) this;
        }

        public Criteria andNeedSignLessThan(Integer value) {
            addCriterion("need_sign <", value, "needSign");
            return (Criteria) this;
        }

        public Criteria andNeedSignLessThanOrEqualTo(Integer value) {
            addCriterion("need_sign <=", value, "needSign");
            return (Criteria) this;
        }

        public Criteria andNeedSignIn(List<Integer> values) {
            addCriterion("need_sign in", values, "needSign");
            return (Criteria) this;
        }

        public Criteria andNeedSignNotIn(List<Integer> values) {
            addCriterion("need_sign not in", values, "needSign");
            return (Criteria) this;
        }

        public Criteria andNeedSignBetween(Integer value1, Integer value2) {
            addCriterion("need_sign between", value1, value2, "needSign");
            return (Criteria) this;
        }

        public Criteria andNeedSignNotBetween(Integer value1, Integer value2) {
            addCriterion("need_sign not between", value1, value2, "needSign");
            return (Criteria) this;
        }

        public Criteria andAbsentSignIsNull() {
            addCriterion("absent_sign is null");
            return (Criteria) this;
        }

        public Criteria andAbsentSignIsNotNull() {
            addCriterion("absent_sign is not null");
            return (Criteria) this;
        }

        public Criteria andAbsentSignEqualTo(Integer value) {
            addCriterion("absent_sign =", value, "absentSign");
            return (Criteria) this;
        }

        public Criteria andAbsentSignNotEqualTo(Integer value) {
            addCriterion("absent_sign <>", value, "absentSign");
            return (Criteria) this;
        }

        public Criteria andAbsentSignGreaterThan(Integer value) {
            addCriterion("absent_sign >", value, "absentSign");
            return (Criteria) this;
        }

        public Criteria andAbsentSignGreaterThanOrEqualTo(Integer value) {
            addCriterion("absent_sign >=", value, "absentSign");
            return (Criteria) this;
        }

        public Criteria andAbsentSignLessThan(Integer value) {
            addCriterion("absent_sign <", value, "absentSign");
            return (Criteria) this;
        }

        public Criteria andAbsentSignLessThanOrEqualTo(Integer value) {
            addCriterion("absent_sign <=", value, "absentSign");
            return (Criteria) this;
        }

        public Criteria andAbsentSignIn(List<Integer> values) {
            addCriterion("absent_sign in", values, "absentSign");
            return (Criteria) this;
        }

        public Criteria andAbsentSignNotIn(List<Integer> values) {
            addCriterion("absent_sign not in", values, "absentSign");
            return (Criteria) this;
        }

        public Criteria andAbsentSignBetween(Integer value1, Integer value2) {
            addCriterion("absent_sign between", value1, value2, "absentSign");
            return (Criteria) this;
        }

        public Criteria andAbsentSignNotBetween(Integer value1, Integer value2) {
            addCriterion("absent_sign not between", value1, value2, "absentSign");
            return (Criteria) this;
        }

        public Criteria andTotalSignIsNull() {
            addCriterion("total_sign is null");
            return (Criteria) this;
        }

        public Criteria andTotalSignIsNotNull() {
            addCriterion("total_sign is not null");
            return (Criteria) this;
        }

        public Criteria andTotalSignEqualTo(Integer value) {
            addCriterion("total_sign =", value, "totalSign");
            return (Criteria) this;
        }

        public Criteria andTotalSignNotEqualTo(Integer value) {
            addCriterion("total_sign <>", value, "totalSign");
            return (Criteria) this;
        }

        public Criteria andTotalSignGreaterThan(Integer value) {
            addCriterion("total_sign >", value, "totalSign");
            return (Criteria) this;
        }

        public Criteria andTotalSignGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_sign >=", value, "totalSign");
            return (Criteria) this;
        }

        public Criteria andTotalSignLessThan(Integer value) {
            addCriterion("total_sign <", value, "totalSign");
            return (Criteria) this;
        }

        public Criteria andTotalSignLessThanOrEqualTo(Integer value) {
            addCriterion("total_sign <=", value, "totalSign");
            return (Criteria) this;
        }

        public Criteria andTotalSignIn(List<Integer> values) {
            addCriterion("total_sign in", values, "totalSign");
            return (Criteria) this;
        }

        public Criteria andTotalSignNotIn(List<Integer> values) {
            addCriterion("total_sign not in", values, "totalSign");
            return (Criteria) this;
        }

        public Criteria andTotalSignBetween(Integer value1, Integer value2) {
            addCriterion("total_sign between", value1, value2, "totalSign");
            return (Criteria) this;
        }

        public Criteria andTotalSignNotBetween(Integer value1, Integer value2) {
            addCriterion("total_sign not between", value1, value2, "totalSign");
            return (Criteria) this;
        }

        public Criteria andSignPercentIsNull() {
            addCriterion("sign_percent is null");
            return (Criteria) this;
        }

        public Criteria andSignPercentIsNotNull() {
            addCriterion("sign_percent is not null");
            return (Criteria) this;
        }

        public Criteria andSignPercentEqualTo(String value) {
            addCriterion("sign_percent =", value, "signPercent");
            return (Criteria) this;
        }

        public Criteria andSignPercentNotEqualTo(String value) {
            addCriterion("sign_percent <>", value, "signPercent");
            return (Criteria) this;
        }

        public Criteria andSignPercentGreaterThan(String value) {
            addCriterion("sign_percent >", value, "signPercent");
            return (Criteria) this;
        }

        public Criteria andSignPercentGreaterThanOrEqualTo(String value) {
            addCriterion("sign_percent >=", value, "signPercent");
            return (Criteria) this;
        }

        public Criteria andSignPercentLessThan(String value) {
            addCriterion("sign_percent <", value, "signPercent");
            return (Criteria) this;
        }

        public Criteria andSignPercentLessThanOrEqualTo(String value) {
            addCriterion("sign_percent <=", value, "signPercent");
            return (Criteria) this;
        }

        public Criteria andSignPercentLike(String value) {
            addCriterion("sign_percent like", value, "signPercent");
            return (Criteria) this;
        }

        public Criteria andSignPercentNotLike(String value) {
            addCriterion("sign_percent not like", value, "signPercent");
            return (Criteria) this;
        }

        public Criteria andSignPercentIn(List<String> values) {
            addCriterion("sign_percent in", values, "signPercent");
            return (Criteria) this;
        }

        public Criteria andSignPercentNotIn(List<String> values) {
            addCriterion("sign_percent not in", values, "signPercent");
            return (Criteria) this;
        }

        public Criteria andSignPercentBetween(String value1, String value2) {
            addCriterion("sign_percent between", value1, value2, "signPercent");
            return (Criteria) this;
        }

        public Criteria andSignPercentNotBetween(String value1, String value2) {
            addCriterion("sign_percent not between", value1, value2, "signPercent");
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