package Backend;

import java.util.ArrayList;

public class AdminRole {

    public TrainerDatabase database;

    public AdminRole() {
        this.database = new TrainerDatabase("Trainer");
    }

    public boolean addTrainer(String trainerId, String name, String email, String specialty, String phoneNumber) {
        return database.insertRecord(new Trainer(trainerId, name, email, specialty, phoneNumber));
    }

    public ArrayList<Trainer> getListOfTrainers() {
        return database.returnAllRecords();
    }

    public boolean removeTrainer(String key) {
        return database.deleteRecord(key);
    }

    public void logout() {
        database.saveToFile();
    }
}

