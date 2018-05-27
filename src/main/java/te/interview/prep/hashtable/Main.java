package te.interview.prep.hashtable;

public class Main {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.add("hi", "there");
        System.out.println("hi " + hashTable.get("hi"));
        hashTable.add("hi", "dude");
        System.out.println("hi " + hashTable.get("hi"));
        hashTable.remove("hi");
        System.out.println("hi " + hashTable.get("hi"));
    }

}
