package com.vebinar.config;

import com.vebinar.dao.UserDao;
import com.vebinar.dao.UserDaoImpl;
import com.vebinar.service.UserServiceImpl;
import com.vebinar.service.TestBean;
import com.vebinar.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


@Configuration
public class SpringConfig {

//    @Bean
//    public TestBean getTestBean(){
//        return new TestBean("hello");
//    }

    @Bean
    public JdbcTemplate getJdbcTemplate (){
        return new JdbcTemplate(getDataSource());

    }

    @Bean

    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:firebirdsql://localhost:3050/D:/java/Plan1/WebContent/Base/BASE.FDB");
        dataSource.setUsername("SYSDBA");
        dataSource.setPassword("masterkey");
        dataSource.setDriverClassName("org.firebirdsql.jdbc.FBDriver");
        return dataSource;
    }
//    public DataSource getDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl("jdbc:mysql://localhost:3306/base_wa2");
//        dataSource.setUsername("root");
//        dataSource.setPassword("");
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        return dataSource;
//    }

    @Bean
    public UserDao getUserDao(){
        return new UserDaoImpl(getJdbcTemplate());
    }

    @Bean
    public UserService getUserService(){
        return new UserServiceImpl();
    }

}

