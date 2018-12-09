package top.qingrang.service;

import top.qingrang.pojo.Student;

public interface IStudentService {

	void addTwoStudent(Student s1,Student s2);
	void addTwoStudentThrowsException(Student s1,Student s2);
	void addTwoStudentThrowsCustomException(Student s1,Student s2);

}
