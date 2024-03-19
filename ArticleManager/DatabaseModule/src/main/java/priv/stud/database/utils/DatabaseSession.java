package priv.stud.database.utils;

import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;


public class DatabaseSession {
    @Getter
    private static final Session session = new Configuration().configure().buildSessionFactory().openSession();
    private DatabaseSession(){};

//    public static Session getSession(){
//        return session;
//    }
}
