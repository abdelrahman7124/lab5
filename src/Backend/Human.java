package Backend;

public abstract class Human extends Interface {

    protected String Id, name, email, phoneNumber;

    public Human(String Id, String name, String email, String phoneNumber) {
        this.Id = Id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getSearchKey() {
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
}
