package com.registration.config;


import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import static org.hibernate.cfg.Environment.*;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com.registration.dao"),
      @ComponentScan("com.registration.service") })
public class AppConfig {

   @Autowired
   private Environment env;

   @Bean
   public LocalSessionFactoryBean getSessionFactory() {
      LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
      String environment="local";

      Properties props = new Properties();
      // Setting JDBC properties
      props.put(DRIVER, env.getProperty("mysql.driver"));
      
      if(environment.equals("local")){
      props.put(URL, env.getProperty("mysql.local.url"));
      props.put(USER, env.getProperty("mysql.local.user"));
      props.put(PASS, env.getProperty("mysql.local.password"));
      }
      else{
    	  props.put(URL, env.getProperty("mysql.cloud.url"));
          props.put(USER, env.getProperty("mysql.cloud.user"));
          props.put(PASS, env.getProperty("mysql.cloud.password"));
      }

      props.put(DIALECT, env.getProperty("dialect"));
      // Setting Hibernate properties
      props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
      //props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));

      // Setting C3P0 properties
      props.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
      props.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
      props.put(C3P0_ACQUIRE_INCREMENT, 
            env.getProperty("hibernate.c3p0.acquire_increment"));
      props.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
      props.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));

      factoryBean.setHibernateProperties(props);
      factoryBean.setPackagesToScan("com.registration.model");

      return factoryBean;
   }

   @Bean
   public HibernateTransactionManager getTransactionManager() {
      HibernateTransactionManager transactionManager = new HibernateTransactionManager();
      transactionManager.setSessionFactory(getSessionFactory().getObject());
      return transactionManager;
   }
}
