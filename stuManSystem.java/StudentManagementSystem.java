import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    private ArrayList<Student> students = new ArrayList<Student>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        system.run();
    }

    public void run() {
        while (true) {
            System.out.println("请选择操作：");
            System.out.println("1. 添加学生");
            System.out.println("2. 删除学生");
            System.out.println("3. 查找学生");
            System.out.println("4. 修改学生信息");
            System.out.println("5. 显示所有学生");
            System.out.println("6. 退出");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    deleteStudent();
                    break;
                case 3:
                    findStudent();
                    break;
                case 4:
                    modifyStudent();
                    break;
                case 5:
                    showAllStudents();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("无效的选择，请重新输入。");
            }
        }
    }

    private void addStudent() {
        System.out.print("请输入学生姓名：");
        String name = scanner.nextLine();
        System.out.print("请输入学生年龄：");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("请输入学生性别：");
        String gender = scanner.nextLine();
        Student student = new Student(name, age, gender);
        students.add(student);
        System.out.println("添加成功！");
    }

    private void deleteStudent() {
        System.out.print("请输入要删除的学生姓名：");
        String name = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(name)) {
                students.remove(i);
                System.out.println("删除成功！");
                return;
            }
        }
        System.out.println("未找到该学生！");
    }

    private void findStudent() {
        System.out.print("请输入要查找的学生姓名：");
        String name = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(name)) {
                Student student = students.get(i);
                System.out.println(student);
                return;
            }
        }
        System.out.println("未找到该学生！");
    }

    private void modifyStudent() {
        System.out.print("请输入要修改的学生姓名：");
        String name = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(name)) {
                Student student = students.get(i);
                System.out.print("请输入新的姓名（原姓名：" + student.getName() + "）：");
                String newName = scanner.nextLine();
                System.out.print("请输入新的年龄（原年龄：" + student.getAge() + "）：");
                int newAge = scanner.nextInt();
                scanner.nextLine();
                System.out.print("请输入新的性别（原性别：" + student.getGender() + "）：");
                String newGender = scanner.nextLine();
                student.setName(newName);
                student.setAge(newAge);
                student.setGender(newGender);
                System.out.println("修改成功！");
                return;
            }
        }
        System.out.println("未找到该学生！");
    }

    private void showAllStudents() {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println(student);
        }
    }
}

class Student {
    private String name;
    private int age;
    private String gender;

    public Student(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", gender=" + gender + "]";
    }
}