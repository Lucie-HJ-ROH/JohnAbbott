public class Test {
    public static void main(String[] args) {
        Observable account1 = new TwitterAccount();
        Observable account2 = new TwitterAccount();
        Observable account3 = new TwitterAccount();

        Observer follower1 = new Follower();
        Observer follower2 = new Follower();
        Observer follower3 = new Follower();

        ((Follower) follower1).follow((TwitterAccount) account1);
        ((Follower) follower2).follow((TwitterAccount) account2);
        ((Follower) follower3).follow((TwitterAccount) account3);

        account1.tweet("account1's first tweet");
        account2.tweet("account2's first tweet");
        account3.tweet("account3's first tweet");

        ((Follower) follower1).follow((TwitterAccount) account2);
        account2.tweet("I am account02 Follow me!!!");

        ((Follower) follower1).unfollow((TwitterAccount) account2);
        account2.tweet("I am account02 Why unfollow me???");
    }
}
