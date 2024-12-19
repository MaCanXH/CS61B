import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        SLList<String> SP = new SLList<String>();
//        List61B<String> LP = SP;
//        SP.addLast("elk");
//        SP.addLast("are");
//        SP.addLast("cool");
//        peek(SP);
//        peek(LP);

//        VengefulSLList<String> list = new VengefulSLList<>();
//        list.addFirst("this");
//        list.addFirst("is");
//        list.addFirst("a");
//        list.addFirst("test");
//        list.addFirst("!!!");
//
//        list.removeLast();
//        list.removeLast();
//        list.removeLast();
//
//        list.printLostItem();

        Deque<Integer> k = new ArrayDeque<>();
        LinkedList<Integer> list = new LinkedList<>();

    }
    public static void peek(List61B<String> list) {
        System.out.println(list.getLast());
    }
    public static void peek(SLList<Integer> list) {
        System.out.println(list.getFirst());
    }

    public static List<String> getWords(String inputFileName){
        List<String> lst = new ArrayList<>();
        In in = new In();

        while (!in.isEmpty()){
            lst.add(in.readString());
        }
        return lst;
    }

    public static Set<String> countUniqueWords(List<String> lst){
        Set<String> set = new HashSet<>();
        for (String s : lst){
            set.add(s);
        }
//        set.addAll(lst);
        return set;
    }

    public static Map<String, Integer> collectWordCount (List<String> targets, List<String> words){
        Map<String, Integer> numberOfTarget = new HashMap<>();

        for (String t : targets){
            numberOfTarget.put(t, 0);
        }

        for (String s : words){
            if (numberOfTarget.containsKey(s)){
                numberOfTarget.put(s, numberOfTarget.get(s) + 1);
            }
        }
        return numberOfTarget;
    }
}