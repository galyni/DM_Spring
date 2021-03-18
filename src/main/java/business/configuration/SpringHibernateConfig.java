package business.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan ("business")
public class SpringHibernateConfig {

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("business");
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/springhibernate");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager txManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
                //"hibernate.hbm2ddl.auto", "create-drop");
                "hbm2ddl.auto", "update");
        hibernateProperties.setProperty(
                "hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

        // Bind one session per request : configures SessionFactory.useCurrentSession()
        hibernateProperties.setProperty(
                "hibernate.current_session_context_class", "thread");

        // Disable the second-level cache
        hibernateProperties.setProperty(
                "cache.provider_class", "org.hibernate.cache.internal.NoCacheProvider");

        return hibernateProperties;
    }

}