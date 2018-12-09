package top.qingrang.text;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.qingrang.pojo.Student;
import top.qingrang.service.IStudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MyTest {

	@Autowired
	IStudentService studentService;

	/**
	 * 正常插入
	 */
	@Test
	public void test() {
		Student s1 = new Student("张三",23);
		Student s2 = new Student("李四",25);
		studentService.addTwoStudent(s1,s2);
	}

	/**
	 * 回滚，抛出异常
	 */
	@Test
	public void test2() {
		Student s1 = new Student("张三",23);
		Student s2 = new Student("字段长度超过限制，字段长度超过限制",25);
		studentService.addTwoStudentThrowsException(s1,s2);
	}

	/**
	 * 回滚，抛出自定义异常
	 */
	@Test
	public void test3() {
		Student s1 = new Student("张三",23);
		Student s2 = new Student("字段长度超过限制，字段长度超过限制",25);
		studentService.addTwoStudentThrowsCustomException(s1,s2);
	}
}
