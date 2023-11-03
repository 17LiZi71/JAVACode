package second;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import second.bean.Graduate;
import second.bean.Person;
import second.bean.Student;
import second.bean.Teacher;

public class ManSystem {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        Teacher t1 = new Teacher("01", "01", "王建国", "男", 47, "讲师", "理学院", "151");
        Teacher t2 = new Teacher("02", "02", "张惠", "女", 55, "教授", "工学院", "131");
        Student s = new Student("2201", "2201", "张三", "男", 20, "2201", "理学院");
        Graduate g = new Graduate("2002", "2002", "李四", "女", 26, "2002", "土木院", "李老师", "建筑力学");
        list.add(s);
        list.add(t1);
        list.add(t2);
        list.add(g);
        while (true) {
            Person user = null;
            while (user == null) {
                user = Person.logOn(list);
            }
            int chooose = 0;
            if (user instanceof Student) {
                System.out.println("按1查看个人信息");
                System.out.println("按2修改账号密码");
                System.out.println("按3查看学校老师");
                System.out.println("按4查找学校老师");
                System.out.println("按7退出登录");
                System.out.println("按8退出系统");
                while (chooose != 7) {
                    switch (chooose) {
                        case 1:
                            System.out.println(user.toString());
                            break;
                        case 2:
                            ((Student) user).modifyPassword(list);
                            break;
                        case 3:
                            ((Student) user).showTeacher(list);
                            break;
                        case 4:
                            ((Student) user).findTeacher(list);
                            break;
                        case 7:
                            break;
                        case 8:
                            System.exit(0);
                            break;
                        default:
                            break;
                    }
                    try {
                        chooose = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("输入有误，请重新输入");
                        sc.next();
                    }
                }
            }
            if (user instanceof Teacher) {
                System.out.println("按1查看个人信息");
                System.out.println("按2查看学生信息");
                System.out.println("按3查找学校学生");
                System.out.println("按4添加学生");
                System.out.println("按5删除学生");
                System.out.println("按6修改学生信息");
                System.out.println("按7退出登录");
                System.out.println("按8退出系统");
                while (chooose != 7) {
                    switch (chooose) {
                        case 1:
                            System.out.println(user.toString());
                            break;
                        case 2:
                            ((Teacher) user).showStudent(list);
                            break;
                        case 3:
                            System.out.println("请输入学生学号");
                            ((Teacher) user).findStudent(list, sc.next());
                            break;
                        case 4:
                            ((Teacher) user).addStudent(list);
                            break;
                        case 5:
                            ((Teacher) user).deleteStudent(list);
                            break;
                        case 6:
                            ((Teacher) user).changeStudent(list);
                            break;
                        case 7:
                            break;
                        case 8:
                            System.exit(0);
                            break;
                        default:
                            break;
                    }
                    try {
                        chooose = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("输入有误，请重新输入");
                        sc.next();
                        // TODO: handle exception
                    }
                }
            }
            System.out.println("退出系统成功");
        }
    }
}