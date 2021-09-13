package P2_Surprise_Sharing_Application.Surprises;

public class MinionToy  implements ISurprise{
    private static  final   String[]    MINIONS =   {"Dave" , "Carl" , "Kevin" , "Stuart" , "Jerry" , "Tim"};
    private static  int   index;
    private final   String  minionName;

    private MinionToy(String minionName){   this.minionName =   minionName; }

    public static   MinionToy generate(){
        MinionToy minion = new MinionToy(MINIONS[index++]);
        if(MINIONS.length   ==  index){
            MinionToy.index =   0;
        }
        return minion;
    }
 
    @Override
    public void enjoy() {
        System.out.println("[!]\tYou got a minion named " + this.minionName + " ...");
    }

    @Override
    public  String  toString(){
        return "[MinionToy]\t Name: " + this.minionName;
    }
}
