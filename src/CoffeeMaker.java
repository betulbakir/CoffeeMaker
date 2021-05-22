import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;
public class CoffeeMaker {

    String noItems = "You don't see anything out of the ordinary.";
    Scanner input;
    boolean keepPlaying = true;
    ArrayList<String> inventory;
    boolean checklist[] = {false, false, false};

    Room r1 = new Room("Small", "Quant Sofa", "Magenta", null, "Creamy Cream");
    Room r2 = new Room("Funny", "Sad record player", "Beige", "Massive", null);
    Room r3 = new Room("Refinanced", "Tight pizza", "Dead", "Smart", "caffeinated coffee");
    Room r4 = new Room("Dumb", "Flat energy drink", "Vivacious", "Slim", null);
    Room r5 = new Room("Bloodthirsty", "Beautiful bag of money", "Purple", "Sandy", null);
    Room r6 = new Room("Rough", "Perfect air hockey table", null, "Minimalist", "sweet sugar");

    LinkedList<Room> roomList;

    public CoffeeMaker(){
        roomList = new LinkedList<Room>();

        roomList.add(r1);
        roomList.add(r2);
        roomList.add(r3);
        roomList.add(r4);
        roomList.add(r5);
        roomList.add(r6);

        System.out.println(r3.toString());

        input = new Scanner(System.in);

        inventory = new ArrayList<String>();
        inventory.add("YOU HAVE NO COFFEE!");
        inventory.add("YOU HAVE NO CREAM!");
        inventory.add("YOU HAVE NO SUGAR!");

    }

    public String getInput(){
        System.out.println("\n INSTRUCTIONS (N,S,L,I,D) > ");
        String choice = input.nextLine();
        return choice;
    }

    public void printInventory(ArrayList<String> inventory){
        for(String item : inventory){
            System.out.println(item);
        }
        System.out.println("\n");
    }

    public boolean checkCoffee(boolean list[]){
        return list[0];
    }

    public boolean checkCream(boolean list[]){
        return list[1];
    }

    public boolean checkSugar(boolean list[]){
        return list[2];
    }

    public int checkWin(boolean list[]){
        int errorCode = 0;

        if(checkCoffee(list) && checkCream(list) && checkSugar(list)){
            System.out.println("You drink the beverage and are ready to study!\nYou win!");
            return 0;
        } else if(!checkCoffee(list) && checkCream(list) && checkSugar(list)){
            System.out.println("You drink the sweetened cream, but without caffeine, you cannot study.\nYou lose!");
           return 1;

        } else if(!checkCoffee(list) && !checkCream(list) && checkSugar(list)){
            System.out.println("You eat the sugar, but without caffeine, you cannot study.\nYou lose!");
            return 1;

        } else if(!checkCoffee(list) && !checkCream(list) && checkSugar(list)){
            System.out.println("You drink the air, as you have no coffee, sugar, or cream.\n" +
                    "The air is invigorating, but not invigorating enough.  You cannot study.\n" +
                    "You lose!");
            return 1;

        } else if(!checkCoffee(list) && !checkCream(list) && !checkSugar(list)){
            System.out.println("You drink the cream, but without caffeine, you cannot study.\nYou lose!");
            return 1;

        } else if(checkCoffee(list) && !checkCream(list)){
            System.out.println("Without cream, you get an ulcer and cannot study.\nYou lose!");
            return 1;

        } else if(checkCoffee(list) && checkCream(list) && !checkSugar(list)){
            System.out.println("Without sugar, the coffee is too bitter. You cannot study.\nYou lose!");
            return 1;

        } else if(!checkCoffee(list) && checkCream(list) && !checkSugar(list)){
            System.out.println("You drink the cream, but without caffeine, you cannot study.\nYou lose!");
            return 1;
        } else {
            return 1;
        }



    }

    public void Start(){
        int roomNum = 0;
        System.out.println("Coffee Maker Quest 2.0\n");

        while (keepPlaying) {
            System.out.println(roomList.get(roomNum).toString());
            String choice = getInput();

            if(choice.equalsIgnoreCase("N")){
                if(roomList.get(roomNum).getNorthDoor() == null){
                    System.out.println("You are in a magical land!  But you are returned to the beginning!");
                    roomNum = 0;
                    continue;
                }
                roomNum++;
            } else if(choice.equalsIgnoreCase("S")){
                if(roomList.get(roomNum).getSouthDoor() == null){
                    System.out.println("You are in a magical land!  But you are returned to the beginning!\n");
                    roomNum = 0;
                    continue;
                }
                roomNum--;
            } else if(choice.equalsIgnoreCase("L")){
                String item = roomList.get(roomNum).getItem();
                if(item == null){
                    System.out.println(noItems);
                } else {
                    System.out.println("You found some " + roomList.get(roomNum).getItem() + "\n");
                    if(item.equals("Creamy Cream")){
                        inventory.set(1, "You have some fresh cream.");
                        checklist[1] = true;
                    } else if(item.equals("caffeinated coffee")){
                        inventory.set(0, "You have a cup of delicious coffee.");
                        checklist[0] = true;
                    } else {
                        inventory.set(2, "You have some tasty sugar.");
                        checklist[2] = true;
                    }
                }

            } else if(choice.equalsIgnoreCase("I")){
                printInventory(inventory);
            } else if(choice.equalsIgnoreCase("D")){
                int errorCode = checkWin(checklist);
                keepPlaying = false;

                System.out.println("Exiting with error code " + errorCode);

            } else if(choice.equalsIgnoreCase("H")){
                System.out.println("Menu: " +
                        "\n\tN: move north" +
                        "\n\tS: move south" +
                        "\n\tL: look around the room for items" +
                        "\n\tI: check your inventory" +
                        "\n\tD: drink your inventory");
            } else {
                System.out.println("What?");
            }
        }
    }
    public static void main(String[] args){
        CoffeeMaker quest = new CoffeeMaker();
        quest.Start();

    }

}
