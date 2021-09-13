package P2_Surprise_Sharing_Application.GiveSurprises;

import P2_Surprise_Sharing_Application.Bags.*;
import P2_Surprise_Sharing_Application.Surprises.*;

import java.util.concurrent.TimeUnit;

public abstract class AbstractGiveSurprises {
    private final IBag bag;
    private final int time;

 
    public AbstractGiveSurprises(String type, int time){
        this.bag    =   BagFactory.getInstance().makeBag(type);
        this.time   =   time;
    }

    public void put(ISurprise   newSurprises){  this.bag.put(newSurprises); }
    public void put(IBag surprises){    this.bag.put(surprises);    }

    public void give(){
        if(this.bag.isEmpty()){
            System.out.println("The bag is empty");
            return;
        }

        this.bag.takeOut().enjoy();
        this.giveWithPassion();
    }

    public void giveAll(){
        if(this.bag.isEmpty()){
            System.out.println("The bag is empty");
            return;
        }

        for(int i = this.bag.size(); i > 0; --i){
            try{
                this.give();
                TimeUnit.SECONDS.sleep(this.time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean  isEmpty(){  return this.bag.isEmpty();  }
    abstract void giveWithPassion();



}
