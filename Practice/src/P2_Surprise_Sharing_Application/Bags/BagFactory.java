package P2_Surprise_Sharing_Application.Bags;

public class BagFactory implements IbagFactory{
    private static final    BagFactory  INSTANCE =   new BagFactory();

    private BagFactory(){}

    public  static  BagFactory  getInstance(){
        return  INSTANCE;
    }

    @Override
    public IBag makeBag(String type) {
        if(type.equalsIgnoreCase("FIFO")){
            return new BagFifo();
        } else if(type.equalsIgnoreCase("LIFO")){
            return new BagLifo();
        } else{
            return new BagRandom();
        }
    }
}
