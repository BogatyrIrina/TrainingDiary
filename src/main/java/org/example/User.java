package org.example;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private List<Training> trainings;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.trainings = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTrainings(List<Training> trainings) {
        this.trainings = trainings;
    }

    public void addTraining(Training training) {
        trainings.add(training);
    }

    public void removeTraining(Training training) {
        trainings.remove(training);
    }

    public List<Training> getTrainings() {
        return trainings;
    }

}
