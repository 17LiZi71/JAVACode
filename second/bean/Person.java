package second.bean;

import java.util.List;
import java.util.Scanner;

import second.ManSystem;

public abstract class Person {
    private String account;// 账号
    private String password;// 密码
    private String name;// 姓名
    private String gender;// 性别
    private int age;// 年龄
    static Scanner sc = ManSystem.sc;

    public static Person logOn(List<Person> list) {
        System.out.println("请输入账号");
        String account = sc.next();
        System.out.println("请输入密码");
        String password = sc.next();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAccount().equals(account) && list.get(i).getPassword().equals(password)) {
                if (list.get(i) instanceof Graduate) {
                    System.out.println("研究生登录成功");
                    return (Graduate) list.get(i);
                }
                if (list.get(i) instanceof Student) {
                    System.out.println("普通学生登录成功");
                    return (Student) list.get(i);
                }
                if (list.get(i) instanceof Teacher) {
                    System.out.println("老师登录成功");
                    return (Teacher) list.get(i);
                }
            }
        }
        System.out.println("账号密码有误，请重新输入");
        return null;
    }

    public Person() {
    }

    public Person(String account, String password, String name, String gender, int age) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", gender=" + gender
                + ", age=" + age + "]";
    }

}
