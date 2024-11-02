package Backend;

public class Member extends Human {

    private String membershipType, status;

    public Member(String membershipType, String status, String memberid, String name, String email, String phoneNumber) {
        super(memberid, name, email, phoneNumber);
        this.membershipType = membershipType;
        this.status = status;

    }
    @Override
    public String lineRepresentation() {
        return (Id + "," + name + "," + membershipType + "," + email + "," + phoneNumber + "," + status);
    }

    public String getMembershipType() {
        return membershipType;
    }

    public String getStatus() {
        return status;
    }
}