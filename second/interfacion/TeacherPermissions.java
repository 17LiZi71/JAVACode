package second.interfacion;

import java.util.List;

import second.bean.Person;

public interface TeacherPermissions {
    public void showStudent(List<Person> list);

    public boolean findStudent(List<Person> list, String findId);

    public boolean addStudent(List<Person> list);

    public boolean deleteStudent(List<Person> list);

    public boolean changeStudent(List<Person> list);
    
}
