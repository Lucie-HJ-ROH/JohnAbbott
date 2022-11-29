package Activity24th;

public class Cow extends Animal{

    public Cow(){
        super(true,false);
    }

    @Override
    public boolean getIsMammal() {
        return super.getIsMammal();
    }

    @Override
    public boolean getIsCarnivorous() {
        return super.getIsCarnivorous();
    }

    public String getGreeting(){
        return "'moo'";
    }

    @Override
    public String toString() {
        String isCarnivorous;
        String isMammal;


        if(getIsCarnivorous() == true){
            isCarnivorous = "Carnivorous";
        }else{
            isCarnivorous = "not Carnivorous";
        }

        if(getIsMammal() == true){
            isMammal = "is a mammal";
        }else{
            isMammal = "is not a mammal";
        }

        String output = "A Cow says " + getGreeting() + ", is " + isCarnivorous +", and  "  + isMammal;

        return output ;
    }
}
