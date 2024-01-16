package com.example.notetaker;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//

public class FactoryProvider {

    public static SessionFactory factory;

    public SessionFactory getFactory(){

        return factory == null
                ? new Configuration().configure("hibernate.cfg.xml")
                .buildSessionFactory() : factory;
    }
    public void closeFactory(){
        if(factory.isOpen()){
            factory.close();
        }
    }
}
