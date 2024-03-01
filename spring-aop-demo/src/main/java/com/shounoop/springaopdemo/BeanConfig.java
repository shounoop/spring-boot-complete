package com.shounoop.springaopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.shounoop.springaopdemo")
@EnableAspectJAutoProxy
public class BeanConfig {
}
