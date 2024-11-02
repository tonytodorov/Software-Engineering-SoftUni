//package org.hibernate;
//
//import org.hibernate.cfg.Configuration;
//import org.hibernate.entities.Student;
//
//public class Main {
//    public static void main(String[] args) {
//        Configuration config = new Configuration();
//        config.configure();
//
//        SessionFactory sessionFactory = config.buildSessionFactory();
//        Session currentSession = sessionFactory.openSession();
//        currentSession.beginTransaction();
//
//        Student student = new Student();
//        student.setName("Hiber");
//
//        currentSession.persist(student);
//
//        currentSession.getTransaction().commit();
//        currentSession.close();
//    }
//}