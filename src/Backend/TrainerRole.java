package Backend;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


public class TrainerRole implements FileNames{

    private MemberDatabase memberDatabase;
    private ClassDatabase classDatabase;
    private MemberClassRegistrationDatabase registrationDatabase;

    public TrainerRole() {
        this.memberDatabase = new MemberDatabase(MEMBER_FILENAME);
        this.classDatabase = new ClassDatabase(CLASS_FILENAME);
        this.registrationDatabase = new MemberClassRegistrationDatabase(REGISTRATION_FILENAME);

    }

    public void addMember(String memberID, String name, String membershipType, String email, String phoneNumber, String status) {
        memberDatabase.insertRecord(new Member(membershipType, status, memberID, name, email, phoneNumber));
    }

    public ArrayList<Member> getListOfMembers() {
        return memberDatabase.returnAllRecords();
    }

    public void addClass(String classID, String className, String trainerID, int duration, int maxParticipants) {
        classDatabase.insertRecord(new Class(classID, className, trainerID, duration, maxParticipants));
    }

    public ArrayList<Class> getListOfClasses() {
        return classDatabase.returnAllRecords();
    }

    public boolean registerMemberForClass(String memberID, String classID, LocalDate registrationDate) {
        if (classDatabase.contains(classID)) {
            if (classDatabase.getRecord(classID).getAvailableSeats() > 0) {
                registrationDatabase.insertRecord(new MemberClassRegistration(memberID, classID, "ِactive", registrationDate));
                modifyAvailableSeats(2, classID);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean cancelRegistration(String memberID, String classID) {
        if (registrationDatabase.contains(memberID + "-" + classID)) {
            if (checkIfCanceled(memberID, classID)) {
                System.out.println("Already cancelled.");
            } else {
                LocalDate d1 = registrationDatabase.getRecord(memberID + "-" + classID).getRegistrationDate();
                LocalDate d2 = LocalDate.now();
                if (diffBetweenDays(d1, d2)) {
                    registrationDatabase.getRecord(memberID + "-" + classID).setRegistrationStatus("canceled");
                    modifyAvailableSeats(1, classID);
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<MemberClassRegistration> getListOfRegistrations() {
        return registrationDatabase.returnAllRecords();
    }

    public void logout() {
        registrationDatabase.saveToFile();
        classDatabase.saveToFile();
        memberDatabase.saveToFile();
    }

    private boolean diffBetweenDays(LocalDate d1, LocalDate d2) {
        long daysBetween = d1.until(d2, ChronoUnit.DAYS);
        return Math.abs(daysBetween) <= 3;
    }

    private boolean checkIfCanceled(String memberID, String classID) {
        MemberClassRegistration mcr = registrationDatabase.getRecord(memberID + "-" + classID);
        String tok[] = mcr.lineRepresentation().split(",");
        if (tok[3].equalsIgnoreCase("canceled")) {
            return true;
        }
        return false;
    }

    private void modifyAvailableSeats(int choice, String classID) {
        Class cl = classDatabase.getRecord(classID);
        switch (choice) {
            case 1:
                cl.setAvailableSeats(cl.getAvailableSeats() + 1);
                break;
            case 2:
                cl.setAvailableSeats(cl.getAvailableSeats() - 1);
                break;
        }
    }
}
