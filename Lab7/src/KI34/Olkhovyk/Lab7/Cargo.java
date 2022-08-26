package KI34.Olkhovyk.Lab7;

public class Cargo implements Filling {

    private int carryingCapacity;
    private int capacity;
    private String CargoType;
    
    public Cargo(String CargoType, int capacity, int carryingCapacity) {
        this.CargoType = CargoType;
        this.carryingCapacity = carryingCapacity;
        if(capacity > this.carryingCapacity)
            this.capacity = this.carryingCapacity;
        else
            this.capacity = capacity;

    }
        
    public String GetCargoType() {
        return this.CargoType;
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

    @Override
    public String getAllInfo() {   
        return "Cargo`s type: "+ this.CargoType + "; Total weight : " + this.capacity ;
    }
    
}