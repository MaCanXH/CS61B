package Disc04;

public class TestDMSList {
    public static void main(String[] args) {
        DMSList list = new DMSList();
        list.addFirst(12);
        list.addFirst(17);
        list.addFirst(9);
        list.addFirst(1);
        System.out.println(list.max());
    }
}
