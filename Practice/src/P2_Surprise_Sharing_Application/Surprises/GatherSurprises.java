package P2_Surprise_Sharing_Application.Surprises;

import java.util.Random;
 
public final class GatherSurprises {
    private static  final Random    random  =   new Random();
    private GatherSurprises(){}

    public  static  ISurprise[] gather(int size){
        ISurprise[] result  =   new ISurprise[size];
        for(int i=0;i<size;++i){
            result[i]   =   gather();
        }
        return result;
    }

    public static ISurprise gather(){
        int randomNumber = random.nextInt(3);
        if(randomNumber ==  0){
            return Candies.generate();
        } else if (randomNumber ==  1){
            return MinionToy.generate();
        } else{
            return FortuneCookie.generate();
        }
    }
}
