package KI34.Olkhovyk.Lab7;

import java.util.ArrayList;

public class Carriege<T extends Filling> {
    private ArrayList<T> list;
    private int numOfCarriege;

    public Carriege() {
        list = new ArrayList<T>();
        this.numOfCarriege = 0;
    }
    
    
    public T findMax() {
        if (!list.isEmpty()) {
            T max = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).compareTo(max) > 0)
                    max = list.get(i);
            }
            return max;
        }
        return null;
    }
    public void AttachCarriege(T carriege) {
        list.add(carriege);
        this.numOfCarriege++;
        System.out.print("Carriege added: "); 
        System.out.println(carriege.getAllInfo());
    }

    public int getNumOfCarriege(){
        return this.numOfCarriege;
    }
    public void DetachCarriege(T carriege) {
        list.remove(carriege);
        this.numOfCarriege--;   
    }
}
