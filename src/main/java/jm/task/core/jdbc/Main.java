package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();

        userService.createUsersTable(); //таблица users
        //добавление пользователей !!
        userService.saveUser("Irina", "Matveeva", (byte) 21);
        userService.saveUser("Mariya", "Matveeva", (byte) 46);
        userService.saveUser("Vladimir", "Matveev", (byte) 50);
        userService.saveUser("Anna", "Matveeva", (byte) 15);
        //получение всех пользователей из базы и их вывод в консоль
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        } //очистить таблицу
        userService.cleanUsersTable();
        //удаление таблицы
        userService.dropUsersTable();



    }
}
