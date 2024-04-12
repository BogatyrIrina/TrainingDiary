package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class TrainingDiary {
    private User loggedInUser;
    private List<User> users;
    private List<Training> trainingList;

    public TrainingDiary() {
        trainingList = new ArrayList<>();
        loggedInUser = null;
        users = new ArrayList<>();
    }

    public void registerUser(String username, String password) {
        User newUser = new User(username, password);
        users.add(newUser);
        System.out.println("Пользователь " + username + " успешно зарегистрирован");
    }

    public boolean authorizeUser(String username, String password) {
        if (loggedInUser != null) {
            System.out.println("Пользователь уже авторизован. Пожалуйста, выйдите из системы перед входом под новым пользователем");
            return false;
        }
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                loggedInUser = user;
                System.out.println(username + " Вы успешно вошли в систему");
                return true;
            }
        }

        System.out.println("Неверный логин или пароль");
        return false;
    }

    public void logoutUser() {
        loggedInUser = null;
        System.out.println("Вы успешно вышли из системы");
    }

    public void addTraining(String type, Date date, int duration, int calories, String additionalInfo) {
        if (loggedInUser == null) {
            System.out.println("Пользователь не авторизован");
        } else {
            Training newTraining = new Training(type, date, duration, calories, additionalInfo);
            trainingList.add(newTraining);
            loggedInUser.addTraining(newTraining);
            System.out.println(newTraining.getType() + " Тренировка успешно добавлена");
        }
    }

    public void removeTraining(Training training) {
        if (loggedInUser == null) {
            System.out.println("Пользователь не авторизован");
        } else {
            trainingList.remove(training);
            loggedInUser.removeTraining(training);
            System.out.println(training + " Тренировка успешно удалена");
        }
    }

    public List<Training> getTrainings() {
        if (loggedInUser != null) {
            return new ArrayList<>(loggedInUser.getTrainings());
        }
        return new ArrayList<>();
    }

    public List<Training> getTrainingsSortedByDate() {
        List<Training> sortedTrainings = getTrainings();
        sortedTrainings.sort(Comparator.comparing(Training::getDate));
        return sortedTrainings;
    }

    public void displayTrainings() {
        if (loggedInUser == null) {
            System.out.println("Пользователь не авторизован");
        } else {
            List<Training> userTrainings = loggedInUser.getTrainings();

            if (userTrainings.isEmpty()) {
                System.out.println("Список тренировок пуст");
            } else {
                System.out.println("Вывод тренировок для пользователя " + loggedInUser.getUsername() + ":");

                for (int i = 0; i < userTrainings.size(); i++) {
                    Training training = userTrainings.get(i);
                    System.out.println("Тренировка #" + (i + 1) + ":");
                    System.out.println("Тип: " + training.getType());
                    System.out.println("Дата: " + training.getDate());
                    System.out.println("Длительность: " + training.getDuration() + " минут");
                    System.out.println("Сжигаемые калории: " + training.getCalories());
                    System.out.println("Примечания: " + training.getAdditionalInfo());
                    System.out.println();
                }
            }
        }
    }

    public String isLoggedIn() {
        if (loggedInUser != null) {
            return "Пользователь " + loggedInUser.getUsername() + " авторизован";
        } else {
            return "Пользователь не авторизован";
        }
    }

    public boolean isTrainingAddedForTypeOnDate(String type, Date date) {
        for (Training training : trainingList) {
            if (training.getType().equals(type) && training.getDate().equals(date)) {
                return true;
            }
        }
        return false;
    }

}
