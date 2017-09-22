import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris on 2017-09-20.
 */
public class Trie {
    private static final int ASCII_MAX = 256;
    private Node root = new Node();
    private int assCount = 0;
    private int distinctCount;

    private static class Node{
        private int value;
        private Node[] children = new Node[ASCII_MAX];
    }

    public Trie(){
    }
    public void put(String key){
        if (key == null)    //if the key doesn't have any characters return null.
            return;

        root = put(root, key, 0); //the root of the trie creates a new node
    }

    private Node put(Node x, String key, int d){
        if (x == null) {       //if the node doesn't exist, create a new one.
            x = new Node();
        }

        if (d == key.length()){ //our base case, after the recursive calls until the increasing value of d
            x.value++;          //reaches key length, then we stop calling and return our new created node.
            return x;           //When the key length is reached, we add + 1 to the node value, this helps us check how
        }                       //many times a certain key as been inserted to the Trie.

        char c = key.charAt(d);
        x.children[c] = put(x.children[c], key, d + 1); //recursive, inserts every char position of the key in the
                                                            //children array.
        return x;
    }

    public int getVal(String key){
        if (key == null)
            return 0;

        Node x = getVal(root, key, 0);   //x points to the root and follow the path were the key is put, it then
        if (x == null)                      //counts the value of that certain key if it exists, and it iterates the
            return 0;                       //x node the same as when we add a key, difference is we do not create a new
                                            // node since we are only checking for the count value, not adding a new
        return x.value;                     //element.
    }

    private Node getVal(Node x, String key, int d){
        if (x == null)
            return null;

        if (d == key.length())
            return x;

        char c = key.charAt(d);
        return getVal(x.children[c], key, d + 1);
    }

    private void prefixCollector(Node x, StringBuilder prefix){
        if (x == null)
            return;
        if (x.value != 0) {             //if the key exists, i.e value is not equal to 0, add that value to the
            assCount += x.value;        //association count.
        }

        for(char c = 0; c < ASCII_MAX; c++){             //append every character in the ascii table to the prefix given,
            prefix.append(c);                            //then recursively call back to collect to check if that sequence
            prefixCollector(x.children[c], prefix);       //exists in the trie, if it doesn't it returns null, if x.value exists,
        }                                                //we add that value to the assCount variable.
    }

    public int countSamePrefix(String prefix){
        if (prefix == null)
            return 0;
        Node x = getVal(root, prefix, 0);
        prefixCollector(x, new StringBuilder(prefix));
        return assCount;
    }

    public void counterReset(){
        assCount = 0;
    }

    private void distinctCollector(Node x, StringBuilder prefix){
        if (x == null)
            return;
        if (x.value != 0) {
            this.distinctCount += x.value;
        }
        for(char c = 0; c < ASCII_MAX; c++){
            prefix.append(c);
            distinctCollector(x.children[c], prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public int distinctKey(String prefix){
        if (prefix == null)
            return 0;
        Node x = getVal(root, prefix, 0);
        distinctCollector(x, new StringBuilder(prefix));
        return this.distinctCount;
    }

}
