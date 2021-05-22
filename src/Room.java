/*
Room class is a room object for displaying the options
 */
public class Room {
    String adj, obj;
    String nDoor, sDoor;
    String item;


    /*
    Instantiates room object with its accompanying adjective and object in the room
     */
    public Room(String adj, String obj, String nDoor, String sDoor, String item){
        this.adj = adj;
        this.obj = obj;
        this.nDoor = nDoor;
        this.sDoor = sDoor;
        this.item = item;
    }

    public String getAdj(){
        return adj;
    }

    public String getObj(){
        return obj;
    }

    public String getNorthDoor(){
        return nDoor;
    }

    public String getSouthDoor(){
        return sDoor;
    }

    public String getItem(){
        return item;
    }

    @Override
    public String toString(){
        if(getNorthDoor() == null){
            return "You see a " + getAdj() + " room." +
                    "\nIt has a " + getObj() +
                    "\nA " + getSouthDoor() + " door leads South.";
        }

        else if(getSouthDoor() == null){
            return "You see a " + getAdj() + " room." +
                    "\nIt has a " + getObj() +
                    "\nA " + getNorthDoor() + " door leads North.";
        }

        else {
            return "You see a " + getAdj() + " room." +
                    "\nIt has a " + getObj() +
                    "\nA " + getNorthDoor() + " door leads North." +
                    "\nA " + getSouthDoor() + " door leads South.";
        }

    }

}
