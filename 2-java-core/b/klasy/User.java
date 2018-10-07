package b.klasy;

public class User {

    private String username;
    private String password;

    public User() {
        this("username", "password");
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void main(String[] args){
        User regular = new User();
        System.out.print(regular.getUsername() + " user has password: " + regular.getPassword());
        User admin = new User("admin", "admin");
        System.out.print(admin.getUsername() + " user has password: " + admin.getPassword());


    }
}