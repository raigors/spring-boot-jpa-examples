package com.github.spring.boot.jpa.multiple.datasources.role;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * TODO
 * <p>
 * create in 2021/4/21 3:52 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "roleEntityManagerFactory", transactionManagerRef = "roleTransactionManager")
public class RoleInfoConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.role")
    public DataSource roleDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public PlatformTransactionManager roleTransactionManager() {
        return new JpaTransactionManager(roleEntityManagerFactory().getObject());
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean roleEntityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(roleDataSource());
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        factoryBean.setPackagesToScan(RoleInfoDO.class.getPackage().getName());
        return factoryBean;
    }
}
