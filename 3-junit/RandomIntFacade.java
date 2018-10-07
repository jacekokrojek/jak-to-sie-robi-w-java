import java.util.Random;

public class RandomIntFacade {

    Random random;

    public RandomIntFacade(){
        this.random = new Random();
    }

    public RandomIntFacade(int seed){
        this.random = new Random(seed);
    }


    public int generate(){
        return this.random.nextInt();
    }

}
