package com.example.demo.pojo;



/**
 * Created with IntelliJ IDEA
 * User: 李林威
 * Date: 2019/7/3
 * Time: 14:38
 * To change this template use File / Settings / File Templates.
 * Description:
 */

public class User {
        private Integer id;

        private String name;

        private Integer sex;

        private Integer age;

        private String classes;

        public String getClasses() {
            return classes;
        }

        public void setClasses(String classes) {
            this.classes = classes;
        }

        public Integer getSex() {
            return sex;
        }

        public void setSex(Integer sex) {
            this.sex = sex;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", classes='" + classes + '\'' +
                '}';
    }
}
