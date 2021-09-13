package P2_Surprise_Sharing_Application.GiveSurprises;

public class GiveSurpriseAndApplause extends AbstractGiveSurprises{
    public GiveSurpriseAndApplause(String type, int time){  super(type,time);   }
 
    @Override
    void giveWithPassion() {
        System.out.println("Loud applause to you… For it is in giving that we receive.\n");
    }
}
