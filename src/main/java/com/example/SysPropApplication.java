package com.example;

import com.example.service.SysPropLogService;
import com.example.sysprop.propertie.CustomSystemProperties;
import com.example.sysprop.propertie.listener.impl.DefaultChangeListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Properties;

@SpringBootApplication
public class SysPropApplication {

    static {
        Properties originSysProp = System.getProperties();
        CustomSystemProperties newSysProp = CustomSystemProperties.getInstance();
        newSysProp.putAll(originSysProp);
        System.setProperties(newSysProp);
        System.out.println(
                "Set system properties class => CustomSystemProperties.class");
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =
                SpringApplication.run(SysPropApplication.class, args);
        CustomSystemProperties customSysProp = CustomSystemProperties.getInstance();
        DefaultChangeListener defaultChangeListener
                = ctx.getBean(DefaultChangeListener.class);
        customSysProp.addChangeListener("default", defaultChangeListener);
        SysPropLogService sysPropLogService = ctx.getBean(SysPropLogService.class);

        //add prop1
        System.setProperty("mark", "isHandsome");
        System.out.println(sysPropLogService.findAll());

        //add not allow prop2
        System.setProperty("citi", "isGoodCompany");
        System.out.println(sysPropLogService.findAll());

        //clear prop1
        System.clearProperty("mark");
        System.out.println(sysPropLogService.findAll());
    }

}
