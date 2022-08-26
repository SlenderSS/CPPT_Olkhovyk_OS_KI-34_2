package KI34.Olkhovyk.Lab7;

public class Passengers implements Filling {

    private int numOfSits;
    private int passengers;
    private int capacity;
    private int averageWeight;

    public Passengers(int numOfSits, int passengers, int averageWeight) {
        this.numOfSits = numOfSits;
        if (this.passengers > this.numOfSits)
            this.passengers = this.numOfSits;
        else
            this.passengers = passengers;
        this.averageWeight = averageWeight;

        this.capacity = this.averageWeight * this.passengers;
    }

    @Override
    public int compareTo(Filling o) {
        Integer s = capacity;
        return s.compareTo(o.getCapacity());
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }
    
    public double getNumOfPassengers() {
        return this.passengers;
    }

    @Override
    public String getAllInfo() {
        
        return "Type: passenger; Number of passenger: " + this.passengers + "; Total weight : " + this.capacity;
    }

}
