package exercise05;

public class InputAnalyzer {

    //extracts necessary information from input
    //transforms into the internal types
    //"Mensch-Maschine Schnittstelle"
    //returns direction

    //check for the letter
    public boolean goalSideValid(char input){
        if(input == 'R' || input == 'L' || input == 'U' || input == 'D'){
            return true;
        }
        else{
            return false;
        }
    }

    //check only 1 char
    public boolean lengthValid(String fromFile){
        //get length
        //not " "
        if(fromFile.length() == 1){
			return true;
		}
		else{
        return false;
        }
    }

    public char saveAsChar(String fromFile){
        //convert to char and return as player symbol
        char c = fromFile.charAt(0);
        
        return c;
    }

    //methods for saving goal side and symbol

    //method for checking the whole game
    public boolean allIsWorking(){
        return true;
    }
}
