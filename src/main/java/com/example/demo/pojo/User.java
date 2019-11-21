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
        private String id;

        private String name;

        private String  sex;

        private String age;

        private String classes;

        public String getClasses() {
            return classes;
        }

        public void setClasses(String classes) {
            this.classes = classes;
        }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

/* public User(Object[] values) {
     this.id = values[0].toString();
     this.name = values[1].toString();
     this.sex = values[2].toString();
     this.age = values[3].toString();
     this.classes = values[4].toString();
 }*/
/*public User(Object[] values){
    this.id = values[0].toString();
    this.name = values[1].toString();
    this.sex = values[2].toString();
    this.age = values[3].toString();
    this.classes = values[4].toString();
}*/

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", classes='" + classes + '\'' +
                '}';
    }
}
