package io.github.Victor5H;

import io.github.Victor5H.dao.StudentDao;
import io.github.Victor5H.dao.StudentDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("io.github.Victor5H")
public class BeanConfig {
    @Bean("temp")
    public JdbcTemplate template(){
        JdbcTemplate template = new JdbcTemplate(dataSource());
        return template;
    }
    @Bean("dataSource")
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource ds  = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
        ds.setUsername("root");
        ds.setPassword("root");
        return ds;
    }
    @Bean("studentDao")
    public StudentDao getStudentDao(){
        return new StudentDaoImpl();
    }

}
