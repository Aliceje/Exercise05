package exercise05;

public class Player {

    public static final int NUM_OF_WALLS = 5;

    public Player(){
        //name
        //symbol
        //tile
        //winner
        //walls set
        //limit reached
    }

    public String newPlayerName(String name){

        return name;
    }

    //checks if player can still put up walls
    public boolean wallsLeft(int walls_set){
        if(walls_set == NUM_OF_WALLS){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean isWinner(){

        return false;
    }

    //if player has won move to "heaven"
    public void takeOffBoard(){

    }
}
