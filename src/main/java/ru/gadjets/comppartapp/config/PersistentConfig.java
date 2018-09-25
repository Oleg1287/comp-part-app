package ru.gadjets.comppartapp.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.gadjets.comppartapp.entity.Part;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"ru.gadjets.comppartapp.service", "ru.gadjets.comppartapp.dao", "ru.gadjets.comppartapp.dao.utils"})
public class PersistentConfig {

    private DriverManagerDataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        List<String> jdbcProp = new ArrayList<String>();
        jdbcProp.add("useSSL=false");
        jdbcProp.add("useJDBCCompliantTimezoneShift=true");
        jdbcProp.add("useLegacyDatetimeCode=false");
        jdbcProp.add("serverTimezone=UTC");
        jdbcProp.add("serverTimezone=UTC");
        jdbcProp.add("characterEncoding=utf-8");

        dataSource.setUrl("jdbc:mysql://localhost:3306/test?"+String.join("&", jdbcProp));
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        return dataSource;
    }

    private Properties hibernateProperies() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL57InnoDBDialect");
        properties.put("hbm2ddl.auto", "update");

        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        return properties;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(getDataSource());
        factoryBean.setHibernateProperties(hibernateProperies());

        factoryBean.setAnnotatedClasses(Part.class);
        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory s) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }
}