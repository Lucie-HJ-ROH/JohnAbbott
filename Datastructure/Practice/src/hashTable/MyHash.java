package hashTable;

public class MyHash {
    public Slot[] hashTable;

    public MyHash(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot{
        String value;

        public Slot(String value) {
            this.value = value;
        }
    }
}
