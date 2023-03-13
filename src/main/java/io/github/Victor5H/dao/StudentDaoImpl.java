package io.github.Victor5H.dao;

import io.github.Victor5H.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentDaoImpl implements StudentDao{
    @Autowired
    @Qualifier("temp")
    private JdbcTemplate template;

    public StudentDaoImpl() {
    }

    public StudentDaoImpl(JdbcTemplate template) {
        this.template = template;
    }

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int insert(Student student) {
        String query="insert into student values(?,?,?)";
        return template.update(query,student.getId(),student.getName(),student.getCity());
    }

    public int delete(int id) {
        String query = "delete from student where id=?";
        return template.update(query,id);
    }

    public int update(Student student) {
        String query="update student set name = ?, city =? where id = ?";
        return template.update(query,student.getName(),student.getCity(),student.getId());
    }

    public Student selectOne(int id) {
        String query = "select * from student where id = ?";
        return  template.queryForObject(query,new RowMapperImpl(),id);
    }

    public List<Student> selectAll() {
        String query = "select * from student";
        return template.query(query,new RowMapperImpl());
    }


}
