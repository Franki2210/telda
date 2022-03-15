package com.example.demo.config;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

;

@Configuration
@MapperScan("com.example.demo.mapper")
public class MyBatisConfig {
    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String URL = "jdbc:sqlite:db/regionDB.sqlite";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";

    @Bean
    public DataSource dataSource() {
        return new PooledDataSource(DRIVER, URL, USERNAME, PASSWORD);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        return factoryBean.getObject();
    }
}
