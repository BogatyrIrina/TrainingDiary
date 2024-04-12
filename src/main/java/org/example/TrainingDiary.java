package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class TrainingDiary {
    private User loggedInUser;
    private List<User> users;


    public TrainingDiary() {
        this.users = new ArrayList<>();
    }

    public void registerUser(String username, String password) {
        User newUser = new User(username, password);
        users.add(newUser);
    }

    public boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                loggedInUser = user;
                return true;
            }
        }
        return false;
    }

    public void logout() {
        loggedInUser = null;
    }

    public void addTraining(String type, Date date, int duration, int calories, String additionalInfo) {
        if (loggedInUser != null) {
            Training newTraining = new Training(type, date, duration, calories, additionalInfo);
            loggedInUser.addTraining(newTraining);
        }
    }

    public void removeTraining(Training training) {
        if (loggedInUser != null) {
            loggedInUser.removeTraining(training);
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
        List<Training> trainings = getTrainingsSortedByDate();
        for (Training training : trainings) {
            System.out.println(training);
        }
    }

    public String isLoggedIn() {
        if (loggedInUser != null) {
            return "Пользователь " + loggedInUser.getUsername() + " авторизован";
        } else {
            return "Пользователь не авторизован";
        }
    }
}
