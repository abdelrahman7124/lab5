package Backend;

public class MemberDatabase extends DataBase<Member>{

    public MemberDatabase(String filename) {
        super(filename);
    }

    @Override
    public Member createRecordFrom(String line) {
        String[] tok = line.split(",");
        return new Member(tok[2], tok[3], tok[0], tok[4], tok[5], tok[1]);
    }


}
