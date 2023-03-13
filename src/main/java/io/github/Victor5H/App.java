package io.github.Victor5H;

import io.github.Victor5H.dao.StudentDao;
import io.github.Victor5H.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext con = new AnnotationConfigApplicationContext(BeanConfig.class);
        StudentDao studentDao = con.getBean("studentDao", StudentDao.class);
        Student student = new Student(1,"harshit","NGP");
        System.out.println(studentDao.selectOne(1));
        System.out.println(studentDao.selectAll());
    }
}
