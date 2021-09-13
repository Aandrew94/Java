package P2_Surprise_Sharing_Application.Bags;

import P2_Surprise_Sharing_Application.Surprises.ISurprise;
import java.util.ArrayList;
import java.util.Random;

public class BagRandom implements IBag{
    private static final Random random = new Random();
    private ArrayList<ISurprise> surprises;

    public BagRandom(){
        this.surprises  =   new ArrayList<>();
    }
 

    @Override
    public void put(ISurprise newSurprise)  {   this.surprises.add(newSurprise);    }

    @Override
    public void put(IBag bagOfSurprises) {
        int limit = bagOfSurprises.size();
        for(int i=0; i<limit; ++i){
            this.surprises.add(bagOfSurprises.takeOut());
        }
    }

    @Override
    public ISurprise takeOut() {
        if(!this.surprises.isEmpty()){
            return this.surprises.remove(random.nextInt(this.surprises.size()));
        }
        System.out.println("Bag is empty... ");
        return null;
    }

    @Override
    public boolean isEmpty()    {   return this.surprises.isEmpty();    }

    @Override
    public int size()   {   return this.surprises.size();   }
}
