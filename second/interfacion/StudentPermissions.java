package second.interfacion;

import java.util.List;

import second.bean.Person;

public interface StudentPermissions {
    public void showTeacher(List<Person> list);

    public boolean findTeacher(List<Person> list);

    public boolean modifyPassword(List<Person> list);
    
}
