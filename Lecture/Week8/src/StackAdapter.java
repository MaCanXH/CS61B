import java.util.LinkedList;
import java.util.List;

public class StackAdapter<Item> {
    private List<Item> L;
    public StackAdapter(List<Item> Worker){
        L = Worker;
    }
    public void push(Item x){
        L.add(x);
    }
}
