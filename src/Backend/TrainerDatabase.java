package Backend;

import java.util.ArrayList;

public class TrainerDatabase extends DataBase<Trainer> {

    public TrainerDatabase(String filename) {
        super(filename);
    }

    public Trainer createRecordFrom(String input) {
        String[] tok = input.split(",");
        return new Trainer(tok[0], tok[1], tok[2], tok[3], tok[4]);
    }
}
