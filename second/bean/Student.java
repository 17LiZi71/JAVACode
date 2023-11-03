package second.bean;

import java.util.List;
import java.util.Scanner;

import second.ManSystem;
import second.interfacion.StudentPermissions;

public class Student extends Person implements StudentPermissions {
    private String studentID;
    private String college;
    Scanner sc = ManSystem.sc;

    // 查看学校所有老师
    @Override
    public void showTeacher(List<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Teacher) {
                Teacher teacher = (Teacher) list.get(i);
                System.out.println(teacher.toString());
            }
        }
    }

    // 查找老师
    @Override
    public boolean findTeacher(List<Person> list) {
        System.out.println("请输入老师姓名");
        String name = sc.next();
        boolean result = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Teacher) {
                Teacher teacher = (Teacher) list.get(i);
                if (teacher.getName().equals(name)) {
                    System.out.println(teacher.toString());
                    result = true;
                }
            }
        }
        if (!result) {
            System.out.println("未找到该老师");
        }
        return result;
    }

    // 更改账号密码
    @Override
    public boolean modifyPassword(List<Person> list) {
        System.out.println("请输入新账号");
        String newAccount = sc.next();
        System.out.println("请输入新密码");
        String newPassword = sc.next();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAccount().equals(newAccount) && list.get(i).getPassword().equals(newPassword)) {
                System.out.println("该账号密码已经被使用");
                return false;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAccount().equals(super.getAccount())
                    && list.get(i).getPassword().equals(super.getPassword())) {
                list.get(i).setAccount(newAccount);
                list.get(i).setPassword(newPassword);
                System.out.println("修改成功");
                return true;
            }
        }
        return false;
    }

    public Student() {

    }

    public Student(String studentID, String college) {
        this.studentID = studentID;
        this.college = college;
    }

    public Student(String account, String password, String name, String gender, int age, String studentID,
            String college) {
        super(account, password, name, gender, age);
        this.studentID = studentID;
        this.college = college;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Override
    public String toString() {
        return super.toString() + "Student [studentID=" + studentID + ", college=" + college + "]";
    }

}
