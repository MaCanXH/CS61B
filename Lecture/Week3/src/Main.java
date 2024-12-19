import Disc03.SLList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SLList list = new SLList();
        list.addFirst(12);
        list.addFirst(13);
        list.addFirst(14);
        list.insert(1, 0);
        list.insert(2, 2);
        list.insert(3, 5);
    }
}

