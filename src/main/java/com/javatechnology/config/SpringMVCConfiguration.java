package com.javatechnology.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.javatechnology")
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
public class SpringMVCConfiguration {// <beans>
	
	@Autowired
	private Environment env;
	/*@Bean 
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}*/
	
	
	@Bean
	public DataSource getSource() {//<bean>
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
		return dataSource;
		
	}
	@Bean
	public LocalSessionFactoryBean getSesionFactory(DataSource dataSource) {
		//AnnotationSessionFactoryBean factory= new AnnotationSessionFactoryBean();
		LocalSessionFactoryBean factory=new LocalSessionFactoryBean();
		factory.setDataSource(dataSource);
		factory.setHibernateProperties(getProperties());
		factory.setPackagesToScan("com.javatechnology.model");
		return factory;
	}
	private Properties getProperties() {
		Properties properties=new Properties();
		 properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
	        properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
	        properties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
	        return properties;        
		
	}
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory factory) {
		HibernateTransactionManager transactionManager=new HibernateTransactionManager();
		transactionManager.setSessionFactory(factory);
		return transactionManager;
	}
	@Bean
	public TilesConfigurer tilesConfig() {
		TilesConfigurer config=new TilesConfigurer();
		config.setDefinitions(new String[] {"/WEB-INF/tiles/tiles.xml"});
		return config;
	}
	@Bean
	public ViewResolver viewResolver() {
		return new TilesViewResolver();
	}
	@Bean
	public JavaMailSender getMail() {
		JavaMailSenderImpl sender=new JavaMailSenderImpl(); 
		sender.setHost("smtp.gmail.com");
		sender.setPort(587);
		sender.setUsername("sureshyadav99636@gmail.com");
		sender.setPassword("password");
		Properties proerties=new Properties();
		proerties.put("mail.smtp.auth", true);
		proerties.put("mail.transport.protocol", "smtp");
		proerties.put("mail.degub", true);
		proerties.put("mail.smtp.starttls.enable", true);
		sender.setJavaMailProperties(proerties);
		return sender;
		
	}

}
