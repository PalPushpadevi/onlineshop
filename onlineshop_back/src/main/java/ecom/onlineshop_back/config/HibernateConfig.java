package ecom.onlineshop_back.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan(basePackages={"ecom.onlineshop_back.dto"})
@EnableTransactionManagement

public class HibernateConfig 

{

			
			private final static String DATABASE_URL="jdbc:h2:tcp://localhost/~/onlineshopping";
			private final static String DATABASE_DRIVER="org.h2.Driver";
			private final static String DATABASE_DIALECT="org.hibernate.dialect.H2Dialect";
			private final static String DATABASE_USERNAME="sa";
			private final static String DATABASE_PASSWORD="";
					
			
			//Datasource bean
			
			@Bean
			public DataSource getDataSource()
			{
				BasicDataSource datasource=new BasicDataSource();
				datasource.setDriverClassName(DATABASE_DRIVER);
				datasource.setUrl(DATABASE_URL);
				datasource.setUsername(DATABASE_USERNAME);
				datasource.setPassword(DATABASE_PASSWORD);
				
				return datasource;
			}
			
			
			//Sessionfactory bean
			
			@Bean
			public SessionFactory getSessionFactory(DataSource datasource)
			{
				LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(datasource);
				
				builder.addProperties(getHibernateProperties());
				builder.scanPackages("ecom.onlineshop_back.dto");
				return builder.buildSessionFactory();
				
			}


			private Properties getHibernateProperties() 
			
			{
				Properties properties=new Properties();
				properties.put("HibernateDialect",DATABASE_DIALECT);
				properties.put("Hibernate.show_sql", true);
				properties.put("Hibernate.format_sql", true);
				return properties;
			}
			
			
			@Bean
			public HibernateTransactionManager getTransactionManager(SessionFactory sessionfactory)
			{
				HibernateTransactionManager TransactionManager=new HibernateTransactionManager(sessionfactory);
				return TransactionManager;
			}
			
			
			
		
			











}
