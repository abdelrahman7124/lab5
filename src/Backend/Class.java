package Backend;

public class Class extends Interface {

    private String classID, className, trainerID;
    private int duration, availableSeats;

    public Class(String classID, String className, String trainerID, int duration, int availableSeats) {
        this.classID = classID;
        this.className = className;
        this.trainerID = trainerID;
        this.duration = duration;
        this.availableSeats = availableSeats;
    }

    @Override
    public String getSearchKey() {
        return classID;
    }

    public String getClassName() {
        return className;
    }

    public String getTrainerID() {
        return trainerID;
    }

    public int getDuration() {
        return duration;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }


    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String lineRepresentation() {
        return (classID + "," + className + "," + trainerID + "," + duration + "," + availableSeats);
    }

}
