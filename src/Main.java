import java.util.*;
/**
 * Created by Chris on 2017-09-20.
 */
public class Main {

    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        String n = in.nextLine();

        Trie tries = new Trie();
        tries.put("ac");
        tries.put("ac");
        tries.put("ab");
        tries.put("bc");
        tries.put("bc");
        tries.put("bc");
        tries.put("bc");
        tries.put("bad");
        tries.put("baf");
        tries.put("baf");
        tries.put("baf");

        System.out.println("The amount of times '" + n + "' occurs in the list are : " + tries.getVal(n));
        System.out.println("The count for '" + n + "' is : " + tries.countSamePrefix(n));
        tries.counterReset();
        System.out.println("The amount of distinct postfixes for prefix '" + n + "' are : " +tries.distinctKey(n));
        tries.counterReset();
        System.out.println("The strings with prefix '" + n + "' are : " + tries.keysWithPrefix(n));

    }
}
