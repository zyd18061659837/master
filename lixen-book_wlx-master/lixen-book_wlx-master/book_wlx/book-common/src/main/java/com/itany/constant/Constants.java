package com.itany.constant;

/**
 * Author:wenlixu
 * Date:2019/3/29 9:51
 * Description:
 * Version:1.0
 */
public class Constants {

    /**
     * 状态
     */
    public enum Status{

        ENABLE("启用",1),
        DISABLE("禁用",0);

        private String name;
        private int value;

        Status(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public enum ExaminationStatus{

        AWAIT("等待审核",0),
        SUCCESS("通过审核",1),
        FAILURE("未通过审核",2);


        private String name;
        private int value;

        ExaminationStatus(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

    }
}
