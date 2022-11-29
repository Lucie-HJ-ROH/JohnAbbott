package Activity24th;

public abstract class Animal {
    protected boolean isMammal;
    protected boolean isCarnivorous;

    public Animal(boolean isMammal, boolean isCarnivorous){
        this.isMammal = isMammal;
        this.isCarnivorous = isCarnivorous;
    }

    public boolean getIsMammal(){
        return isMammal;
    }
    public boolean getIsCarnivorous(){
        return isCarnivorous;
    }
    public abstract String getGreeting();

}
