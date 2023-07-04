package com.qing.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author libarAdministrator
 */
@SpringBootApplication(scanBasePackages = {"com.qing.api","com.qing.common"})
@EnableScheduling
@EnableTransactionManagement
@MapperScan(value="com.qing.api.mapper")
@EnableJpaAuditing
public class FrontApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(FrontApiApplication.class);
    }
}
