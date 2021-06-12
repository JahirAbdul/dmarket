package com.compass.config;

import com.compass.model.User;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com.compass")})
public class HibernateConfig {

    @Autowired
    private ApplicationContext appContext;

    @Bean(name = "DataSource")
    public HikariDataSource dataSourceWinMacLinux() {
        return getDataSource("127.0.0.1","intellij","intellij");
    }
    private HikariDataSource getDataSource(String serverName, String user, String password){
        HikariDataSource dataSource = new HikariDataSource();
        /*dataSource.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
        dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/dmarket");//dataSource.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource"); //`org.postgresql.ds.PGSimpleDataSource //org.postgresql.ds.PGConnectionPoolDataSource
        */
        dataSource.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource"); //org.postgresql.ds.PGSimpleDataSource //org.postgresql.ds.PGConnectionPoolDataSource
        dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/dmarket");
        dataSource.addDataSourceProperty("databaseName", "dmarket");
        dataSource.addDataSourceProperty("portNumber", "5432");
        dataSource.addDataSourceProperty("serverName", serverName);
        dataSource.addDataSourceProperty("user", user);
        dataSource.addDataSourceProperty("password", password);
        return dataSource;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager manager = new HibernateTransactionManager();
        manager.setSessionFactory(hibernate5SessionFactoryBean().getObject());
        return manager;
    }

    @Bean
    public LocalSessionFactoryBean hibernate5SessionFactoryBean(){
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource((DataSource) appContext.getBean("DataSource"));
        localSessionFactoryBean.setAnnotatedClasses(
                User.class
        );

        Properties properties = new Properties();
        properties.put("hibernate.dialect","org.hibernate.dialect.PostgreSQL95Dialect");//org.hibernate.dialect.PostgreSQL95Dialect //org.hibernate.dialect.PostgreSQL10Dialect
        //properties.put("hibernate.current_session_context_class","thread");
        properties.put("hibernate.hbm2ddl.auto","update");
        properties.put("hibernate.show_sql","true");

        localSessionFactoryBean.setHibernateProperties(properties);
        return localSessionFactoryBean;
    }

}
