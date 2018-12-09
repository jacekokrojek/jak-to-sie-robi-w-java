package b.klasy;

// Demonstration of a simple constructor
class Rock {
    Rock() { // This is the constructor
        System.out.println("Creating Rock");
    }

    Rock(int param){
        System.out.println("Creating Rock with param " + param);
    }
}
public class SimpleConstructor {
    public static void main(String args[]) {
        for(int i = 0; i < 10; i++)
            new Rock();
    }
}