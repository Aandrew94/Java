package P2_Surprise_Sharing_Application;

import P2_Surprise_Sharing_Application.Surprises.*;
import P2_Surprise_Sharing_Application.Bags.*;
import P2_Surprise_Sharing_Application.GiveSurprises.*;

public class Main {
    public static void main(String[] args){
        System.out.println("Tests\n\n");

        testSurpriseGenerate();
        testMinionToys();

        testBagTakeOut();
        testBagOtherTakeOut();
        testNoSurprises();

        testGiveSurprisesAndApplausesFifo();
        testGiveSurprisesAndHugLifo();
        testGiveSurprisesAndSing();

    }

    public  static  void    testSurpriseGenerate(){
        System.out.println("Candies Generate");
        for(int i=0;i<11;++i){
            System.out.println(Candies.generate());
        }
        System.out.println("\nMinion Generate");
        for(int i=0;i<11;++i){
            System.out.println(MinionToy.generate());
        }
        System.out.println("\nFortune Generate");
        for(int i=0;i<11;++i){
            System.out.println(FortuneCookie.generate());
        }
    }
    public  static  void    testMinionToys(){
        System.out.println("---\t FIFO \t---");
        GiveSurpriseAndApplause bag = new GiveSurpriseAndApplause("Fifo",1);
        for(int i=0;i<8;++i){
            bag.put(MinionToy.generate());
        }
        bag.giveAll();

        System.out.println("---\t LIFO \t---");
        bag = new GiveSurpriseAndApplause("Lifo",1);
        for(int i=0;i<8;++i){
            bag.put(MinionToy.generate());
        }
        bag.giveAll();

        System.out.println("---\t Random \t---");
        bag = new GiveSurpriseAndApplause("",1);
        for(int i=0;i<8;++i){
            bag.put(MinionToy.generate());
        }
        bag.giveAll();
    }

    public  static  void    testBagTakeOut(){
        IBag    bagOne = BagFactory.getInstance().makeBag("Fifo");
        IBag    bagTwo = BagFactory.getInstance().makeBag("");
        for(int i=0;i<9;++i){
            bagOne.put(MinionToy.generate());
        }

        System.out.println("bagOne is empty ? >> \t" + bagOne.isEmpty());
        System.out.println("bagOne size ?  \t  >> \t" + bagOne.size());
        System.out.println("bagTwo is empty ? >> \t" + bagTwo.isEmpty());
        System.out.println("bagTwo size ?  \t  >> \t" + bagTwo.size());

        bagTwo.put(bagOne);

        System.out.println("\nbagOne is empty ? >> \t" + bagOne.isEmpty());
        System.out.println("bagOne size ?  \t  >> \t" + bagOne.size());
        System.out.println("bagTwo is empty ? >> \t" + bagTwo.isEmpty());
        System.out.println("bagTwo size ?  \t  >> \t" + bagTwo.size());
    }
    public  static  void    testBagOtherTakeOut(){
        GiveSurpriseAndApplause applauses = new GiveSurpriseAndApplause("LIFO", 1);
        IBag bag = BagFactory.getInstance().makeBag("FIFO");

        for(int i=0;i<6;++i){
            bag.put(Candies.generate());
        }

        System.out.println("bag is empty ? >> \t" + bag.isEmpty());
        System.out.println("bag size ?  \t  >> \t" + bag.size());
        System.out.println("applauses is empty ? >> \t" + applauses.isEmpty());

        applauses.put(bag);

        System.out.println("\nbag is empty ? >> \t" + bag.isEmpty());
        System.out.println("bag size ?  \t  >> \t" + bag.size());
        System.out.println("applauses is empty ? >> \t" + applauses.isEmpty());

    }
    public  static  void    testNoSurprises(){
        GiveSurpriseAndSing bag = new GiveSurpriseAndSing("",1);
        bag.give();
        bag.giveAll();
    }

    public  static  void    testGiveSurprisesAndApplausesFifo(){
        int howMany =   4;
        ISurprise[] surprises = new ISurprise[howMany];

        //  Create surprises
        for(int i=0;i<howMany;++i){
            surprises[i] = GatherSurprises.gather();
        }

        //  Show surprises
        for(int i=0;i<howMany;++i){
            System.out.println(surprises[i]);
        }
        System.out.println("-\t-\t-\t\n");

        //  Create bag with message
        GiveSurpriseAndApplause bag = new GiveSurpriseAndApplause("FIFO", 1);

        //  Add the surprises
        for(int i=0;i<howMany;++i){
            bag.put(surprises[i]);
        }

        //  Give all surprises
        bag.giveAll();
    }
    public  static  void    testGiveSurprisesAndHugLifo(){
        int howMany =   4;
        ISurprise[] surprises = new ISurprise[howMany];

        //  Create surprises
        for(int i=0;i<howMany;++i){
            surprises[i] = GatherSurprises.gather();
        }

        //  Show surprises
        for(int i=0;i<howMany;++i){
            System.out.println(surprises[i]);
        }
        System.out.println("-\t-\t-\t\n");

        //  Create bag with message
        GiveSurpriseAndApplause bag = new GiveSurpriseAndApplause("LIFO", 1);

        //  Add the surprises
        for(int i=0;i<howMany;++i){
            bag.put(surprises[i]);
        }

        //  Give all surprises
        bag.giveAll();
    }
    public  static  void    testGiveSurprisesAndSing(){
        int howMany =   4;
        ISurprise[] surprises = new ISurprise[howMany];

        //  Create surprises
        for(int i=0;i<howMany;++i){
            surprises[i] = GatherSurprises.gather();
        }

        //  Show surprises
        for(int i=0;i<howMany;++i){
            System.out.println(surprises[i]);
        }
        System.out.println("-\t-\t-\t\n");

        //  Create bag with message
        GiveSurpriseAndApplause bag = new GiveSurpriseAndApplause("", 1);

        //  Add the surprises
        for(int i=0;i<howMany;++i){
            bag.put(surprises[i]);
        }

        //  Give all surprises
        bag.giveAll();
    }
}
