package Backend;

public class Trainer extends Human {

    private String speciality;

    public Trainer(String trainerId, String name, String email, String speciality, String phoneNumber) {
        super(trainerId, name, email, phoneNumber);
        this.speciality = speciality;
    }

    @Override
    public String lineRepresentation() {
        return (Id + "," + name + "," + email + "," + speciality + "," + phoneNumber);
    }

    public String getId() {
        return Id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getSpeciality() {
        return speciality;
    }
}
