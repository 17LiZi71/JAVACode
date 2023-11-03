package studentMange;

public class Student {
    // 定义一个学生类，包含姓名，年龄，性别，成绩等属性
    // 使用private修饰符来实现封装，保护属性不被外部直接访问
    private String name;
    private int age;
    private char gender;

    // 定义一个构造方法，用于创建学生对象时初始化属性
    public Student(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // 定义一些公共的get和set方法，用于外部访问和修改属性
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", gender=" + gender + "]";
    }

    // 定义一个toString方法，用于返回学生对象的字符串表示
}