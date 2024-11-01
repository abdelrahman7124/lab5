package Backend;


import javax.management.relation.Role;
import java.util.ArrayList;

public class AdminRole implements FileNames {

    public TrainerDatabase database;

    public AdminRole() {
        this.database = new TrainerDatabase(TRAINER_FILENAME);
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

