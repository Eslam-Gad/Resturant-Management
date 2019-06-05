
package resturant;


public class Meels {
    
    private final int ID;
    private final int cost;
    private final String name;
    private final String type;
    
    Meels(int ID , String name , String type , int cost){
    this.ID = ID;
    this.name = name;
    this.type=type;
    this.cost = cost;
    }

    public int getID() {
        return ID;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
    
}
