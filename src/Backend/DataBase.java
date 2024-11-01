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
public abstract class DataBase<T extends Interface> {

    protected String filename;
    protected ArrayList<T> records = new ArrayList<>();

    public DataBase(String filename) {
        this.filename = filename;
        readFromFile();
    }

    // for code simplification
    private int recordIndex(String key) {
        int len = records.size();
        for (int i = 0; i < len; i++) {
            if (key.equalsIgnoreCase(records.get(i).getSearchKey())) {
                return i;
            }
        }
        return -1;
    }

    protected void readFromFile() {
        try {
            File file = new File(filename);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                insertRecord(createRecordFrom(data));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected abstract T createRecordFrom(String line);

    public ArrayList<T> returnAllRecords() {
        return records;
    }

    protected boolean contains(String key) {
        return recordIndex(key) != -1;
    }

    protected T getRecord(String key) {
        int index = recordIndex(key);
        if (index != -1) {
            return records.get(index);
        }
        return null;
    }

    protected boolean insertRecord(T record) {
        if (!contains(record.getSearchKey())) {
            records.add(record);
            return true;
        } else {
            System.out.println("Already exists.");
            return false;
        }
    }

    protected boolean deleteRecord(String Key) {
        int index = recordIndex(Key);
        if (index != -1) {
            records.remove(index);
            return true;
        }
        return false;
    }

    protected void saveToFile() {
        try {
            FileWriter writer = new FileWriter(filename);
            int len = records.size();
            for (int i = 0; i < len; i++) {
                writer.write(records.get(i).lineRepresentation());
                if (i != len - 1)
                    writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {

        }
    }

}
