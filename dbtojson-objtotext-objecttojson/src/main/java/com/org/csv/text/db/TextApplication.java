package com.org.csv.text.db;

import com.org.csv.text.db.controller.CommonController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TextApplication {
    public static void main(String args[]) throws Exception {
        ApplicationContext applicationContext = SpringApplication.run(TextApplication.class, args);
        CommonController CommonController=applicationContext.getBean(CommonController.class);
        CommonController.readDataFromMongoDBToPutIntoJson();
        CommonController.writeJavaObjectToText();
        CommonController.writeObjectToCsv();
        System.out.println("success fully data saved all the files");

    }
}
