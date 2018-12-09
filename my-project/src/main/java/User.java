public class User extends Generator {
    String[] firstNames = {"Ania", "Katarzyna", "Aleksandra", "Piotr", "Marek"};
    String[] lastNames = {"Kowalski", "Nowak", "Duda", "Mickiewicz", "Zalewski"};
    String firstName;
    String lastName;

    public User(){
        super();
    }

    public User(long seed){
        super(seed);
    }

    @Override
    public String generuj(){
        int firstNameIndex = rand.nextInt( this.firstNames.length);
        this.firstName = this.firstNames[firstNameIndex];
        int lastNameIndex = rand.nextInt( this.lastNames.length);
        this.lastName = this.lastNames[lastNameIndex];
        return this.firstName + " " + this.lastName;
    }

}
