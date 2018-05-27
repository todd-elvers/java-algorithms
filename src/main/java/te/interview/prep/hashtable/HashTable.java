package te.interview.prep.hashtable;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashTable {
    private LinkedList<Entry>[] table;


    HashTable() {
        this(25);
    }

    HashTable(int size) {
        this.table = new LinkedList[size];
        System.out.println(table.length);
    }

    void add(String key, String value) {
        int index = calcIndex(key);

        // See if entry already exists
        LinkedList<Entry> entriesForKey = table[index];
        Entry existingEntry = null;
        if(entriesForKey == null) {
            entriesForKey = new LinkedList<>();
        } else {
            for(Entry e : entriesForKey) {
                if (e.key.equals(key)) {
                    existingEntry = e;
                    break;
                }
            }
        }

        // If entry exists, update it, otherwise add one
        if(existingEntry == null) {
            entriesForKey.add(new Entry(key, value));
        } else {
            existingEntry.value = value;
        }

        table[index] = entriesForKey;
    }

    String get(String key) {
        int index = calcIndex(key);

        if(index > table.length) return null;

        LinkedList<Entry> entriesForKey = table[index];
        if(entriesForKey == null) {
            // Value doesn't exist
            return null;
        }

        for(Entry entry : entriesForKey) {
            if(entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;
    }

    boolean remove(String key) {
        int index = calcIndex(key);

        // Key doesn't exist in table
        if(index > table.length) return false;

        LinkedList<Entry> entriesForKey = table[index];
        if(entriesForKey == null) {
            // Key doesn't exist in table
            return false;
        }

        boolean elementRemoved = false;
        for(int i = 0; i < entriesForKey.size(); i++) {
            if(entriesForKey.get(i).key.equals(key)) {
                entriesForKey.remove(i);
                elementRemoved = true;
                break;
            }
        }

        table[index] = entriesForKey;

        return elementRemoved;
    }

    private int calcIndex(String key) {
        return key.hashCode() % table.length;
    }

    private class Entry {
        Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String key;
        public String value;
    }
}
