package com.dktechno.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
//@PropertySource("classpath:custom.properties")
@PropertySources({
        @PropertySource("classpath:custom.properties"),
        @PropertySource("classpath:custom2.properties")
})
public class MyFirstService {
//    @Autowired
//    @Qualifier("mySecondBean")
    private final MyFirstClass myFirstClass;

    @Value("${my-prop}")
    private String customPropertyFromAnotherFile;

    @Value("${my-prop.2}")
    private String customPropertyFromAnotherFile2;

    @Value("${my.custom.property}")
    private String customProperty;

    @Value("${my.custom.property.int}")
    private Integer customPropertyInt;

//    private Environment environment;

//    @Autowired
//    public void injectDependencies(@Qualifier("myFirstBean") MyFirstClass myFirstClass) {
//        this.myFirstClass = myFirstClass;
//    }
//
//    @Autowired
//    public void setMyFirstClass(@Qualifier("myFirstBean") MyFirstClass myFirstClass) {
//        this.myFirstClass = myFirstClass;
//    }

//    public MyFirstService(@Qualifier("bean2") MyFirstClass myFirstClass) {
//        this.myFirstClass = myFirstClass;
//    }

    public MyFirstService(@Qualifier("mySecondBean") MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory() {
        return "The dependency is saving: " + myFirstClass.sayHello();
    }

    public String getCustomPropertyFromAnotherFile() {
        return customPropertyFromAnotherFile;
    }

    public String getCustomPropertyFromAnotherFile2() {
        return customPropertyFromAnotherFile2;
    }

    public String getCustomProperty() {
        return customProperty;
    }

    public Integer getCustomPropertyInt() {
        return customPropertyInt;
    }

    //    public String getJavaVersion() {
//        return environment.getProperty("java.version");
//    }
//
//    public String getOsName() {
//        return environment.getProperty("os.name");
//    }
//
//    public String readProp() {
//        return environment.getProperty("my.customer.property");
//    }
//
//    @Autowired
//    public void setEnvironment(Environment environment) {
//        this.environment = environment;
//    }
}
