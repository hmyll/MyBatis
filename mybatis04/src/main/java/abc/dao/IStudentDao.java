package abc.dao;

import abc.beans.Student;

public interface IStudentDao {
    public Student selectStudentById(int sid);
}
