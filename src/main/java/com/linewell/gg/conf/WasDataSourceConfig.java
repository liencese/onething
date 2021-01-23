package com.linewell.gg.conf;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 一张网was库连接配置类
 */
@Configuration
@MapperScan(basePackages = WasDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "wasSqlSessionFactory")
public class WasDataSourceConfig {
    static final String PACKAGE = "com.linewell.gg.dao.mapperwas";

    @Value("${spring.datasource.was.url}")
    private String url;

    @Value("${spring.datasource.was.username}")
    private String user;

    @Value("${spring.datasource.was.password}")
    private String password;

    @Value("${spring.datasource.was.driverClassName}")
    private String driverClass;

    @Bean(name = "wasDataSource")
    public DataSource wasDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "wasTransactionManager")
    public DataSourceTransactionManager wasTransactionManager() {
        return new DataSourceTransactionManager(wasDataSource());
    }

    @Bean(name = "wasSqlSessionFactory")
    public SqlSessionFactory wasSqlSessionFactory(@Qualifier("wasDataSource") DataSource wasDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(wasDataSource);
        return sessionFactory.getObject();
    }
}
