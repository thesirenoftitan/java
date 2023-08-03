public class Player {

    private int ID;
    private String firstName;
    private String lastName;
    private int APT;
    private int SET;
    private String nationalAssociation;
    private String position;

    // the constructor
    public Player(int ID, String firstName, String lastName, int APT, int SET, String nationalAssociation, String position) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.APT = APT;
        this.SET = SET;
        this.nationalAssociation = nationalAssociation;
        this.position = position;
    }

    // Getter methods

    public int getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAPT() {
        return APT;
    }

    public int getSET() {
        return SET;
    }

    public String getNationalAssociation() {
        return nationalAssociation;
    }

    public String getPosition() {
        return position;
    }

    public double getAverageScore() {
        return (APT + SET) / 2.0;
    }

    public String getPlayer() {
        return "ID: " + ID + "\n"
               + "Name: " + firstName + " " + lastName + "\n"
               + "APT: " + APT + "\n"
               + "SET: " + SET + "\n"
               + "National Association: " + nationalAssociation + "\n"
               + "Average Score: " + getAverageScore() + "\n"
               + "Position: " + position + "\n";
    }
    
    
}
