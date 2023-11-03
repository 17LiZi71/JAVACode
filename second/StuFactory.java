package second;

import java.util.Scanner;

import second.bean.Graduate;
import second.bean.Student;

public class StuFactory {
    public static Student stuFactory(Student newStudent, String education) {
        Scanner sc = ManSystem.sc;
        if (education.equals("研究生")) {
            System.out.println("请输入指导老师");
            String Instructor = sc.next();
            System.out.println("请输入研究方向");
            String researchDirection = sc.next();
            Graduate newGraduate = new Graduate();
            newGraduate.setAccount(newStudent.getAccount());
            newGraduate.setPassword(newStudent.getPassword());
            newGraduate.setName(newStudent.getName());
            newGraduate.setAge(newStudent.getAge());
            newGraduate.setStudentID(newStudent.getStudentID());
            newGraduate.setCollege(newStudent.getCollege());
            newGraduate.setGender(newStudent.getGender());
            newGraduate.setInstructor(Instructor);
            newGraduate.setResearchDirection(researchDirection);
            return newGraduate;
        }
        return newStudent;
    }
}
