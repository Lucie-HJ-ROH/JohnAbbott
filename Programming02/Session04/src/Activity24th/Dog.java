package Activity24th;

public class Dog extends Animal{

    public Dog(){
        super(true,true);

    }
    @Override
    public boolean getIsMammal() {
        return true;
    }

    @Override
    public boolean getIsCarnivorous() {
        return true;
    }

    public String getGreeting(){
        return "'ruff'";
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

        String output = "A dog says " + getGreeting() + ", is " + isCarnivorous +", and  "  + isMammal;

        return output ;
    }
}
