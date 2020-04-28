package org.mall.base;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Slf4j
@EnableSwagger2
@SpringBootApplication
public class BetaMallBaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BetaMallBaseApplication.class, args);
    }
}
