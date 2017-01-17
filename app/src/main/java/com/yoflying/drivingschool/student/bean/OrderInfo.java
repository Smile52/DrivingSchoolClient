package com.yoflying.drivingschool.student.bean;

import java.util.List;

/**
 * Created by yaojiulong on 2017/1/7.
 */

public class OrderInfo {

    /**
     * status : 0
     * message : 返回数据
     * pageNum : 0
     * total : 0
     * data : [{"id":134,"dsId":1,"coachId":1,"testCourse":2,"testAddress":"民乐","studentsIds":null,"appointmentDate":"{\"size\": 2, \"time\": {\"stop\": \"2017-01-11 09:30:00\", \"start\": \"2017-01-11 08:30:00\"}}","status":1,"createTime":1483775506000,"modifyTime":1483775506000},{"id":138,"dsId":1,"coachId":1,"testCourse":2,"testAddress":"民乐","studentsIds":null,"appointmentDate":"{\"size\": 2, \"time\": {\"stop\": \"2017-01-13 09:30:00\", \"start\": \"2017-01-13 08:30:00\"}}","status":1,"createTime":1483775507000,"modifyTime":1483775507000},{"id":132,"dsId":1,"coachId":1,"testCourse":2,"testAddress":"民乐","studentsIds":null,"appointmentDate":"{\"size\": 2, \"time\": {\"stop\": \"2017-01-10 09:30:00\", \"start\": \"2017-01-10 08:30:00\"}}","status":1,"createTime":1483775505000,"modifyTime":1483775505000},{"id":126,"dsId":1,"coachId":1,"testCourse":2,"testAddress":"民乐","studentsIds":null,"appointmentDate":"{\"size\": 2, \"time\": {\"stop\": \"2017-01-07 09:30:00\", \"start\": \"2017-01-07 08:30:00\"}}","status":1,"createTime":1483775504000,"modifyTime":1483775504000},{"id":130,"dsId":1,"coachId":1,"testCourse":2,"testAddress":"民乐","studentsIds":null,"appointmentDate":"{\"size\": 2, \"time\": {\"stop\": \"2017-01-09 09:30:00\", \"start\": \"2017-01-09 08:30:00\"}}","status":1,"createTime":1483775505000,"modifyTime":1483775505000},{"id":128,"dsId":1,"coachId":1,"testCourse":2,"testAddress":"民乐","studentsIds":null,"appointmentDate":"{\"size\": 2, \"time\": {\"stop\": \"2017-01-08 09:30:00\", \"start\": \"2017-01-08 08:30:00\"}}","status":1,"createTime":1483775504000,"modifyTime":1483775504000},{"id":136,"dsId":1,"coachId":1,"testCourse":2,"testAddress":"民乐","studentsIds":null,"appointmentDate":"{\"size\": 2, \"time\": {\"stop\": \"2017-01-12 09:30:00\", \"start\": \"2017-01-12 08:30:00\"}}","status":1,"createTime":1483775506000,"modifyTime":1483775506000}]
     */

    private int status;
    private String message;
    private int pageNum;
    private int total;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 134
         * dsId : 1
         * coachId : 1
         * testCourse : 2
         * testAddress : 民乐
         * studentsIds : null
         * appointmentDate : {"size": 2, "time": {"stop": "2017-01-11 09:30:00", "start": "2017-01-11 08:30:00"}}
         * status : 1
         * createTime : 1483775506000
         * modifyTime : 1483775506000
         */

        private int id;
        private int dsId;
        private int coachId;
        private int testCourse;
        private String testAddress;
        private Object studentsIds;
        private String appointmentDate;
        private int status;
        private long createTime;
        private long modifyTime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getDsId() {
            return dsId;
        }

        public void setDsId(int dsId) {
            this.dsId = dsId;
        }

        public int getCoachId() {
            return coachId;
        }

        public void setCoachId(int coachId) {
            this.coachId = coachId;
        }

        public int getTestCourse() {
            return testCourse;
        }

        public void setTestCourse(int testCourse) {
            this.testCourse = testCourse;
        }

        public String getTestAddress() {
            return testAddress;
        }

        public void setTestAddress(String testAddress) {
            this.testAddress = testAddress;
        }

        public Object getStudentsIds() {
            return studentsIds;
        }

        public void setStudentsIds(Object studentsIds) {
            this.studentsIds = studentsIds;
        }

        public String getAppointmentDate() {
            return appointmentDate;
        }

        public void setAppointmentDate(String appointmentDate) {
            this.appointmentDate = appointmentDate;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public long getModifyTime() {
            return modifyTime;
        }

        public void setModifyTime(long modifyTime) {
            this.modifyTime = modifyTime;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", dsId=" + dsId +
                    ", coachId=" + coachId +
                    ", testCourse=" + testCourse +
                    ", testAddress='" + testAddress + '\'' +
                    ", studentsIds=" + studentsIds +
                    ", appointmentDate='" + appointmentDate + '\'' +
                    ", status=" + status +
                    ", createTime=" + createTime +
                    ", modifyTime=" + modifyTime +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", pageNum=" + pageNum +
                ", total=" + total +
                ", data=" + data +
                '}';
    }
}
