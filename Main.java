import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Main {

    public static void main(String[] args) throws InterruptedException {
        //Detones the generation we are on
        int generation = 1;

        //defining the space dimentions
        int spaceLength = 0, spaceWidth = 0;
        Scanner s = new Scanner(System.in);

        System.out.println("Enter space length");
        spaceLength = s.nextInt();

        System.out.println("Enter space width");
        spaceWidth = s.nextInt();

        Space spaceObj = new Space(spaceLength,spaceWidth);

        //Fill with empty state and take Initial State from the user
        spaceObj.fillEmptyState();
        spaceObj.inputState();

        //The initial state after input
        System.out.println("***********INITIAL STATE***********");
        spaceObj.printState();
        System.out.println("");

        //Defining the game object
        SimulateLifeGame gameObj = new SimulateLifeGame(spaceObj);

        //Playing the game
        //setGameState - This returns true untill there is a living cell on the board
        do{
            gameObj.setGameState(false);
            gameObj.play(generation);
            generation++;
            TimeUnit.SECONDS.sleep(1);
        } while(gameObj.getGameState());

        s.close();
    }
};