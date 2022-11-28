import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Follower implements Observer{

    private List<TwitterAccount> accounts = new ArrayList<TwitterAccount>(); //


    @Override
    public void update(Observable observable) {
        System.out.println(((TwitterAccount)observable).getLastTweet());
        ((TwitterAccount)observable).getLastTweet();
    }

    public void follow(TwitterAccount account){
        accounts.add(account);
        account.addObserver(this);
    }

    public void unfollow(TwitterAccount account){
        accounts.remove(account);
        account.deleteObserver(this);
    }
}
