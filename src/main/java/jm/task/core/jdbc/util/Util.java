package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "root"; // имя пользователя воркбенча
    private static final String PASSWORD = "wErFg45!!!"; // пароль, соответственно

    //public static Connection getConnection() throws SQLException {
    // return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    //}
    private static SessionFactory sessionFactory;
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("jdbc connected to database");
        } catch (SQLException e) {
            e.printStackTrace();
        } return connection;
    }
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration()
                        .setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
                        .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/mydatabase")
                        .setProperty("hibernate.connection.username", "root")
                        .setProperty("hibernate.connection.password", "wErFg45!!!")
                        .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect")
                        .setProperty("hibernate.show_sql", "true")
                        .setProperty("hibernate.hbm2ddl.auto", "update")
                        .addAnnotatedClass(User.class);

                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                System.out.println("hibernate session factory failed !");
                e.printStackTrace();
            }
        } return sessionFactory;
    }
    public static void closeSessionFactory(){
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}