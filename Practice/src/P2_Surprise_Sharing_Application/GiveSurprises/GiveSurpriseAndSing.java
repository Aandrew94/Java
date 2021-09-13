package P2_Surprise_Sharing_Application.GiveSurprises;

public class GiveSurpriseAndSing extends AbstractGiveSurprises{
    public GiveSurpriseAndSing(String type, int time){  super(type,time);   }

    @Override
    void giveWithPassion() {
        System.out.println("Singing a nice song, full of joy and genuine excitement…");
    }
}
