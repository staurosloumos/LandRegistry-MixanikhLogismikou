
package Model;


public class Land {
    
    private int LandID;
    private String LandName;
    private String LandPlace;
    private int KAEK;
    private String LandType;
    private String LandInfo;
    private double LandSize;
    private String LandOwn;
    private int PersonID;
    
    // Constructor.
    public Land(int _LandID, String _LandName, String _LandPlace, int _KAEK, String _LandType, String _LandInfo, double _LandSize, String _LandOwn, int _PersonID)
    {
        LandID = _LandID;
        LandName = _LandName;
        LandPlace = _LandPlace;
        KAEK = _KAEK;
        LandType = _LandType;
        LandInfo = _LandInfo;
        LandSize = _LandSize;
        LandOwn = _LandOwn;
        PersonID = _PersonID;
    }

    public Land() {
        LandID = -1;
        LandName = "Empty";
        LandPlace = "Empty";
        KAEK = -1;
        LandType = "Empty";
        LandInfo = "Empty";
        LandSize = 0.0;
        LandOwn = "Empty";
        PersonID = -1;
    }
    
    // Methods to get class members.
    
    public int getLandID() { return LandID; }
    public String getLandName() { return LandName; }
    public String getLandPlace() { return LandPlace; }
    public int getKAEK() { return KAEK; }
    public String getLandType() { return LandType; }
    public String getLandInfo() { return LandInfo; }
    public double getLandSize() { return LandSize; }
    public String getLandOwn() { return LandOwn; }
    public int getPersonID() { return PersonID; }
   
    // Methods to set class members.
    public void setLandID(int _LandID) { LandID = _LandID; }
    public void setLandName(String _LandName) { LandName = _LandName; }
    public void setLandPlace(String _LandPlace) { LandPlace = _LandPlace; }
    public void setKAEK(int _KAEK) { KAEK = _KAEK; }
    public void setLandType(String _LandType) { LandType = _LandType; }
    public void setLandInfo(String _LandInfo) { LandInfo = _LandInfo; }
    public void setLandSize(double _LandSize) { LandSize = _LandSize; }
    public void setLandOwn(String _LandOwn) { LandOwn = _LandOwn; }
    public void setPersonID(int _PersonID) { PersonID = _PersonID; }
    
}
