package top.qingrang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.qingrang.dao.IStudentDao;
import top.qingrang.exception.SqlRollbackException;
import top.qingrang.pojo.Student;
import top.qingrang.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService{

	@Autowired
	IStudentDao studentDao;

	@Override
	public void addTwoStudent(Student s1, Student s2) {
		studentDao.insertStudent(s1);
		studentDao.insertStudent(s2);
	}

	@Override
	@Transactional(propagation= Propagation.REQUIRED,rollbackForClassName="Exception")
	public void addTwoStudentThrowsException(Student s1,Student s2) {
		studentDao.insertStudent(s1);
		studentDao.insertStudent(s2);
	}

	@Override
	@Transactional
	public void addTwoStudentThrowsCustomException(Student s1,Student s2) {
		try {
			studentDao.insertStudent(s2);
			studentDao.insertStudent(s1);
		}catch (Exception e){
			throw new SqlRollbackException("异常，回滚");
		}
	}
}
