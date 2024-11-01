package Backend;

import java.time.LocalDate;


public class MemberClassRegistrationDatabase extends DataBase<MemberClassRegistration> {

    public MemberClassRegistrationDatabase(String filename) {
        super(filename);
    }

    @Override
    public MemberClassRegistration createRecordFrom(String line) {
        String[] tok = line.split(",");
        return new MemberClassRegistration(tok[0], tok[1], tok[3], LocalDate.parse(tok[2]));
    }

    @Override
    public boolean insertRecord(MemberClassRegistration record) {
        if (!contains(record.getSearchKey())) {
            records.add(record);
            return true;
        } else {
            String tok[] = record.lineRepresentation().split(",");
            if (tok[3].equalsIgnoreCase("canceled")) {
                record.setRegistrationStatus("Active");
                return true;
            }
            return false;
        }
    }
}
