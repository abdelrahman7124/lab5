package Backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author abdel
 */
public class ClassDatabase extends DataBase<Class> {

    public ClassDatabase(String filename) {
        super(filename);
    }

    @Override
    public Class createRecordFrom(String line) {
        String[] tok = line.split(",");
        return new Class(tok[0], tok[1], tok[2], Integer.parseInt(tok[3]), Integer.parseInt(tok[4]), Integer.parseInt(tok[5]));
    }

}
