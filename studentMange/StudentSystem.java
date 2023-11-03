package studentMange;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentSystem {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // 创建一个长度为10的学生信息管理系统对象
        List<Student> list = new ArrayList<>();

        Student s1 = new Student("张三", 18, '男'); // 创建一个普通学生对象s1
        Student s2 = new Graduate("李四", 22, '女', "王老师", "人工智能"); // 创建一个研究生对象s2，使用多态
        list.add(s1);
        list.add(s2);// 添加进去
        while (true) {
            System.out.println("请选择操作：");
            System.out.println("1. 添加学生");
            System.out.println("2. 删除学生");
            System.out.println("3. 查找学生");
            System.out.println("4. 显示所有学生");
            System.out.println("5. 修改学生信息");
            System.out.println("6. 退出");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    list = addStudent(list);
                    break;
                case 2:
                    list = deleteStudent(list);
                    break;
                case 3:
                    findStudent(list);
                    break;
                case 4:
                    showAllStudents(list);
                    break;
                case 5:
                    modilfStudent(list);
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("无效的选择，请重新输入。");
            }
        }
    }

    public static List<Student> addStudent(List<Student> list) {
        System.out.print("请输入学生姓名：");
        String name = scanner.next();
        System.out.print("请输入学生年龄：");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("请选择学生性别:1男 2女");
        int genderchoose = scanner.nextInt();
        char gender = '男';
        if (genderchoose == 2) {
            gender = '女';
        }
        System.out.println("选择学生学历:1本科生,2研究生");
        int chooce = scanner.nextInt();
        if (chooce == 1) {
            list.add(new Student(name, age, gender));
        }
        if (chooce == 2) {
            System.out.println("请输入老师");
            String tutor = scanner.next();
            System.out.println("请输入方向");
            String thesis = scanner.next();
            list.add(new Graduate(name, age, gender, tutor, thesis));
        }
        System.out.println("添加成功！");
        return list;
    }

    public static List<Student> deleteStudent(List<Student> list) {
        System.out.println("请输入删除学生姓名");
        String name = scanner.next();
        for (int i = 0; i < list.size(); i++) {
            Student s = list.get(i);
            if (s.getName().equals(name)) {
                list.remove(i);
                System.out.println("删除成功");
                return list;
            }
        }
        System.out.println("没有该学生");
        return list;
    }

    public static void findStudent(List<Student> list) {
        System.out.println("请输入查找学生姓名");
        String name = scanner.next();
        for (int i = 0; i < list.size(); i++) {
            Student s = list.get(i);
            if (s.getName().equals(name)) {
                System.out.println(list.get(i).toString());
                return;
            }
        }
        System.out.println("没有该学生");
        return;
    }

    public static List<Student> modilfStudent(List<Student> list) {
        System.out.println("请输入修改学生的姓名");
        String name = scanner.next();
        for (int i = 0; i < list.size(); i++) {
            Student s = list.get(i);
            if (s.getName().equals(name)) {
                System.out.println(list.get(i).toString());
                System.out.println("请输入修改后姓名");
                list.get(i).setName(scanner.next());
                System.out.println("请输入修改后年龄");
                list.get(i).setAge(scanner.nextInt());
                System.out.println("修改成功");
                System.out.println(list.get(i).toString());
                return list;
            }
        }
        System.out.println("没有该学生");
        return list;
    }

    public static void showAllStudents(List<Student> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }
}
