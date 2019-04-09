package exercise05;

public class Wall implements TileOccupier {


    public Wall() {

    }

    private boolean invariant() {
        return false; //TO DO
    }

    public boolean isPlayer() {
        return false;
    }

    public boolean isWall() {
        return true;
    }

    public String toString() {
        return ""; //TO DO
    }

/*
// Walls as arrays

    //implement in such a way that varying length technically possible
    //method to check length

    //public Wall(){
    //starting point
    //ending point
    //array of all tiles in the wall
    // }

    public boolean lengthAcceptable() {

        return true;
    }

    public boolean allInARow() {
        return false;
    }

    //only if allInARow true
    public void makeArray() {
        // if for allInARow?
    }

    public void createNewWall() {
        // put starting and ending point and array
    }
    */
}