import java.util.LinkedList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String arg[]){
//        Cat cat = new Cat("Mane");
//        Cat[] cats = new Cat[7];
//        Cat cat2 = new Cat("J");
//        cat.Name();
//        System.out.print(Cat.CompareCat(cat, cat2));
//        char c = 'H';
//        int ca = c;
//        System.out.println(c);
//        System.out.println(ca);

    SLList L = new SLList(15);
    L.addFirst(10);
    L.addFirst(5);
    L.addLast(8);
    int x = L.getFirst();

    System.out.println(x);
    System.out.println(L.size());

    }
}

