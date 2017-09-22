/**
 * Created by Chris on 2017-09-20.
 */
public class Main {

    public static void main(String [] args){

        Trie tries = new Trie();
        tries.put("ab");
        tries.put("ac");
        tries.put("lul");
        tries.put("banana");
        tries.put("bad");
        tries.put("baf");
        tries.put("baf");
        tries.put("baf");
        System.out.println(tries.getVal("baf"));
        System.out.println(tries.countSamePrefix("ba"));
        tries.counterReset();
        System.out.println(tries.countSamePrefix("a"));
        tries.counterReset();
        System.out.println(tries.countSamePrefix("ba"));

    }
}
