package org.example;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        TrainingDiary diary = new TrainingDiary();

        // Регистрация пользователей
        diary.registerUser("user1", "password1");
        diary.registerUser("user2", "password2");

        // Авторизация пользователя
        diary.authorizeUser("user2", "password2");
        System.out.println("Пользователь авторизован: " + diary.isLoggedIn()); // для проверки, авторизован ли пользователь


        // Добавление тренировок
        diary.addTraining("Cardio", new Date(), 60, 500, "");
        diary.addTraining("Strength Training", new Date(), 45, 400, "10 exercises");

        // Вывод тренировок
        diary.displayTrainings();

        // Разлогин пользователя
        diary.logoutUser();
        System.out.println("Пользователь разлогинен: " + diary.isLoggedIn()); // для проверки, разлогинен ли пользователь

    }
}