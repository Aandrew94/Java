package P2_Surprise_Sharing_Application.Surprises;

import java.util.Random;

public class Candies implements ISurprise{
    private static  final   int     LOW_EDGE    =   1;
    private static  final   int     HIGH_EDGE   =   14;
    private static  final   Random  RANDOM      =   new Random();
    private static  final   String[]    TYPES_OF_CANDIES =   {"chocolate" , "jelly" , "fruits" , "vanilla"};
    private final   int     candiesNumber;
    private final   String  candyType;

    private Candies(int candiesNumber, String candyType){
        this.candiesNumber  =   candiesNumber;
        this.candyType      =   candyType;
    }

    public static Candies generate(){
        int indexOfCandy    =   RANDOM.nextInt(4);
        int numberOfCandy   =   RANDOM.nextInt(HIGH_EDGE-LOW_EDGE) + LOW_EDGE;
        return new Candies(numberOfCandy,TYPES_OF_CANDIES[indexOfCandy]);
    }

    @Override
    public  void enjoy() {
        System.out.println("[!]\tYou have received " + this.candiesNumber + " " + this.candyType + " candies");
    }

    @Override
    public  String   toString(){
        return  "[Candies]\tNumber of candies: " + this.candiesNumber + ", type: " + this.candyType;
    }
}