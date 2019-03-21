package com.example.sysprop;

import com.example.sysprop.propertie.CustomSystemProperties;
import com.example.sysprop.propertie.listener.impl.DefaultChangeListener;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Properties;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysPropApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Before
    public void init() {
        CustomSystemProperties customSysProp = CustomSystemProperties.getInstance();
        DefaultChangeListener defaultChangeListener
                = applicationContext.getBean(DefaultChangeListener.class);
        customSysProp.addChangeListener("default", defaultChangeListener);


//        Properties originSysProp = System.getProperties();
//        CustomSystemProperties newSysProp = CustomSystemProperties.getInstance();
//        newSysProp.putAll(originSysProp);
//        System.setProperties(newSysProp);
//        System.out.println(
//                "Set system properties class => CustomSystemProperties.class");
    }

    @Test
    public void contextLoads() {

        System.setProperty("mark", "isHandsome");

    }

}
