import java.util.Comparator;

public class Dog implements Comparable<Dog> {
    public String name;
    private int size;

    public Dog(String n, int s) {
        name = n;
        size = s;
    }

    @Override
    public int compareTo(Dog uddaDog) {
        //assume nobody is messing up and giving us
        //something that isn't a dog.
        return size - uddaDog.size;
    }

//    public static Dog maxDog(Dog[] dogs){
//        if (dogs == null || dogs.length ==0 ){
//            return null;
//        }
//
//        Dog maxDog = dogs[0];
//        for (Dog d : dogs){
//            if (d.size > maxDog.size){
//                maxDog = d;
//            }
//        }
//        return maxDog;
//    }

    private static class NameComparator implements Comparator<Dog>{
        public int compare(Dog a, Dog b){
            return a.name.compareTo(b.name);
        }
    }

    private static Comparator<Dog> getNameComparator(){
        return new NameComparator();
    }

    public static String NameCompare(Dog a, Dog b){
        Comparator<Dog> nameCompare = Dog.getNameComparator();

        int cmp = nameCompare.compare(a, b);
        if (cmp < 0){
            return a.name;
        }
        else return b.name;
    }

    public void bark() {
        System.out.println(name + " says: bark");
    }
}