package second.bean;

import java.util.List;

import second.StuFactory;
import second.interfacion.TeacherPermissions;

public class Teacher extends Person implements TeacherPermissions {
    private String title;
    private String college;
    private String phone;

    public Teacher(String title, String college, String phone) {
        this.title = title;
        this.college = college;
        this.phone = phone;
    }

    public Teacher(String account, String password, String name, String gender, int age, String title, String college,
            String phone) {
        super(account, password, name, gender, age);
        this.title = title;
        this.college = college;
        this.phone = phone;
    }

    // 查看所有学生
    @Override
    public void showStudent(List<Person> list) {
        for (Person student : list) {
            if (student instanceof Student) {
                System.out.println(student.toString());
            }
        }
    }

    // 根据学号查找学生
    @Override
    public boolean findStudent(List<Person> list, String findId) {
        for (Person person : list) {
            if (person instanceof Student) {
                Student student = (Student) person;
                if (student.getStudentID().equals(findId)) {
                    System.out.println(student.toString());
                    return true;
                }
            }
        }
        System.out.println("没有该学生,可以添加");
        return false;
    }

    // 添加学生信息
    @Override
    public boolean addStudent(List<Person> list) {
        System.out.println("请输入新增学生学号");
        String studentID = sc.next();
        if (findStudent(list, studentID)) {
            System.out.println("该学生已存在");
            return false;
        }
        System.out.println("学生账号密码默认为学号");
        System.out.println("请输入学生姓名");
        String name = sc.next();
        System.out.println("请输入学生性别");
        String gender = sc.next();
        System.out.println("请输入学生年龄");
        int age = sc.nextInt();
        System.out.println("请输入学生学院");
        String college = sc.next();
        System.out.println("请输入学生学历");
        Student newStudent = new Student(studentID, studentID, name, gender, age, studentID, college);
        String education = sc.next();
        list.add(StuFactory.stuFactory(newStudent, education));
        System.out.println("添加成功");
        return true;
    }

    // 删除学生信息
    @Override
    public boolean deleteStudent(List<Person> list) {
        System.out.println("请输入删除学生学号");
        String findId = sc.next();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Student) {
                Student student = (Student) list.get(i);
                if (student.getStudentID().equals(findId)) {
                    list.remove(i);
                    System.out.println("删除成功");
                    return true;
                }
            }
        }
        System.out.println("未找到该学生，删除失败");
        return false;
    }

    // 更改学生信息
    @Override
    public boolean changeStudent(List<Person> list) {
        System.out.println("请输入修改学生的学号");
        String findId = sc.next();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Student) {
                Student student = (Student) list.get(i);
                if (student.getStudentID().equals(findId)) {
                    System.out.println(list.get(i).toString());
                    System.out.println("请选择修改学生的信息，按1修改姓名，按2修改性别，按3修改学院");
                    int choose = sc.nextInt();
                    System.out.println("请输入修改后信息");
                    switch (choose) {
                        case 1:
                            list.get(i).setName(sc.next());
                            break;
                        case 2:
                            list.get(i).setGender(sc.next());
                            break;
                        case 3:
                            student.setCollege(sc.next());
                            list.set(i, student);
                            break;
                        default:
                            break;
                    }
                    System.out.println("修改成功");
                    return true;
                }
            }

        }
        System.out.println("没有该学生");
        return false;
    }

    public Teacher(String title, String college) {
        this.title = title;
        this.college = college;
    }

    public Teacher(String account, String password, String name, String gender, int age, String title, String college) {
        super(account, password, name, gender, age);
        this.title = title;
        this.college = college;
    }

    public Teacher() {
    }

    public Teacher(String account, String password, String name, String gender, int age) {
        super(account, password, name, gender, age);
    }

    public Teacher(String title) {
        this.title = title;
    }

    public Teacher(String account, String password, String name, String gender, int age, String title) {
        super(account, password, name, gender, age);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return super.toString() + "Teacher [title=" + title + ", college=" + college + ", phone=" + phone + "]";
    }

}
