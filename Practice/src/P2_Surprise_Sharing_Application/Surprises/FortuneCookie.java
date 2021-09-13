package P2_Surprise_Sharing_Application.Surprises;

import java.util.Random;

public class FortuneCookie  implements ISurprise{
    private static  final   Random  RANDOM      =   new Random();
    private final   String  message;
    private static   final   String[]    MESSAGES    =   {
            "We become what we think about. – Earl Nightingale" ,
            "People who are crazy enough to think they can change the world, are the ones who do. - Rob Siltanen" ,
            "Optimism is the one quality more associated with success and happiness than any other. - Brian Tracy" ,
            "Happiness is not something readymade. It comes from your own actions. - Dalai Lama" ,
            "All our dreams can come true if we have the courage to pursue them. - Walt Disney" ,
            "Success is not final, failure is not fatal: it is the courage to continue that counts. - Winston Churchill" ,
            "Believe you can and youre halfway there. - Theodore Roosevelt" ,
            "You get what you give. – Jennifer Lopez" ,
            "Your life only gets better when you get better.- Brian Tracy" ,
            "Happiness is not by chance, but by choice. – Jim Rohn" ,
            "Be the change that you wish to see in the world.- Mahatma Ghandi" ,
            "If I cannot do great things, I can do small things in a great way. – Martin Luther King Jr." ,
            "We generate fears while we sit. We overcome them by action. – Dr. Henry Link" ,
            "Todays accomplishments were yesterdays impossibilities. – Robert H. Schuller" ,
            "Light tomorrow with today! – Elizabeth Barrett Browning" ,
            "The only limit to our realization of tomorrow will be our doubts of today. – Franklin D. Roosevelt" ,
            "Keep your face always toward the sunshine, and shadows will fall behind you. – Walt Whitman" ,
            "The bad news is time flies. The good news is youre the pilot. – Michael Altshuler" ,
            "Never limit yourself because of others limited imagination; never limit others because of your own limited imagination. – Mae Jemison" ,
            "Let us make our future now, and let us make our dreams tomorrows reality. – Malala Yousafzai"  };

    private FortuneCookie(String message){  this.message    =   message;    }


    public static FortuneCookie generate(){
        return new FortuneCookie(MESSAGES[RANDOM.nextInt(MESSAGES.length)]);
    }

    @Override
    public void enjoy() {
        System.out.println("[!]\tYou got a fortune cookie :\t " + this.message + " \t");
    }

    @Override
    public  String  toString(){
        return "[FortuneCookie]\t Message:\t" + this.message;
    }
}
