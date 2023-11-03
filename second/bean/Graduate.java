package second.bean;

public class Graduate extends Student {
    private String instructor;
    private String researchDirection;

    public Graduate() {

    }

    public Graduate(String instructor, String researchDirection) {
        this.instructor = instructor;
        this.researchDirection = researchDirection;
    }

    public Graduate(String studentID, String college, String instructor, String researchDirection) {
        super(studentID, college);
        this.instructor = instructor;
        this.researchDirection = researchDirection;
    }

    public Graduate(String account, String password, String name, String gender, int age, String studentID,
            String college, String instructor, String researchDirection) {
        super(account, password, name, gender, age, studentID, college);
        this.instructor = instructor;
        this.researchDirection = researchDirection;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getResearchDirection() {
        return researchDirection;
    }

    public void setResearchDirection(String researchDirection) {
        this.researchDirection = researchDirection;
    }

    @Override
    public String toString() {
        return super.toString()+"Graduate [instructor=" + instructor + ", researchDirection=" + researchDirection + "]";
    }
    
}
