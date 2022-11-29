import java.util.LinkedList;

public class TwitterAccount extends Observable{
    private LinkedList<String> tweets = new LinkedList<String>();

    public String getLastTweet(){
        return tweets.get(tweets.size()-1);
    }

    public void tweet(String message){
        tweets.add(message);
        notifyObservers();
    }

}
