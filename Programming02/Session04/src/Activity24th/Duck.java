package Activity24th;

public class Duck extends Animal{

    public Duck(){
        super(false,false);
    }

    public String getGreeting(){
        return "'quack'";
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

        String output = "A Duck says " + getGreeting() + ", is " + isCarnivorous +", and  "  + isMammal;

        return output ;
    }
}
