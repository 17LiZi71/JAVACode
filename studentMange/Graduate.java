package studentMange;

public class Graduate extends Student {
    // 使用private修饰符来实现封装，保护属性不被外部直接访问
    private String tutor;
    private String thesis;

    // 定义一个构造方法，用于创建研究生对象时初始化属性，同时调用父类的构造方法
    public Graduate(String name, int age, char gender, String tutor, String thesis) {
        super(name, age, gender); // 调用父类的构造方法
        this.tutor = tutor;
        this.thesis = thesis;
    }

    // 定义一些公共的get和set方法，用于外部访问和修改属性
    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getThesis() {
        return thesis;
    }

    public void setThesis(String thesis) {
        this.thesis = thesis;
    }

    @Override
    public String toString() {
        return "Graduate [name=" + super.getName() + ", age=" + super.getAge() + ", gender=" + super.getGender()
                + ", tutor=" + tutor + ", thesis=" + thesis + "]";
    }

    // 重写父类的toString方法，用于返回研究生对象的字符串表示

}
