package stusystem;

public class Student {
    private String id;
    private String name;
    private String age;
    private String address;
    private String sex;

    public Student() {
    }

    public Student(String id, String name, String age, String address, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.sex = sex;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", sex=" + sex + "]";
    }

    public static void showStudent() {
        
    }
}
