package Backend;

public abstract class Human extends Interface {

    protected String Id, name, email, phoneNumber;

    public Human(String Id, String name, String email, String phoneNumber) {
        this.Id = Id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    protected String getSearchKey() {
        return Id;
    }

}
