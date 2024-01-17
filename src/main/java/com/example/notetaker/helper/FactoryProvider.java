package com.example.notetaker.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//

public class FactoryProvider {

    public static SessionFactory factory;

    public static SessionFactory getFactory(){

        return factory == null
                ? new Configuration().configure("hibernate.cfg.xml")
                .buildSessionFactory() : factory;
    }
    public  static void closeFactory(){
        if(factory.isOpen()){
            factory.close();
        }
    }
}
