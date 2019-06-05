package resturant;

public class MN {

    private final int ID;
    private final String nameMN;
    private final String comp;

    MN(int ID, String nameMN, String comp) {
        this.ID = ID;
        this.nameMN = nameMN;
        this.comp = comp;
    }

    public int getID() {
        return ID;
    }

    public String getNameMN() {
        return nameMN;
    }

    public String getComp() {
        return comp;
    }

}
