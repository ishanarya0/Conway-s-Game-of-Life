import java.util.Scanner;

public class Space {
    int ROWS;
    int COLS;
    char[][] space;

    //Constructor
    Space(int _ROWS, int _COLS){
        ROWS = _ROWS;
        COLS = _COLS;
        space = new char [ROWS][COLS];
    }

    //Copy Constructor
    public Space (Space _spaceObj) {
        this.ROWS = _spaceObj.ROWS;
        this.COLS = _spaceObj.COLS;
        this.space = _spaceObj.space;
    }

    //A few getter setter functions

    public char[][] getSpace(){
        return space;
    }

    public void setSpace(char[][] _space){
        space = _space;
    }

    public int getROWS(){
        return ROWS;
    }

    public int getCOLS(){
        return COLS;
    }

    //Fills space with empty state
    //TO DO - Find some efficient method to fill it
    public void fillEmptyState(){
        for (int i = 0; i < ROWS; i++)
        {
            for(int j=0; j<COLS; j++){
                space[i][j] = '.';
            }
        }
    }

    //Takes user input
    //TO DO - Better input method like from a file
    public void inputState(){
        int sizeOfInput = 0, inputCount = 1;
        Scanner s = new Scanner(System.in);

        System.out.println("What is the size of your input?");
        sizeOfInput = s.nextInt();

        
        while(inputCount <= sizeOfInput){
            int x,y;

            System.out.println("Input number "+inputCount);
            System.out.println("  Enter x coordinate ");
            x = s.nextInt();
            System.out.println("  Enter y coordinate ");
            y  = s.nextInt();

            space[x][y] = '*';

            inputCount++;
        }

        s.close();
    }

    //Prints the current state of the board
    //TO DO - Handle large boards in a visually efficient manner
    public void printState(){
        for(int x=0; x < ROWS; x++){
            System.out.println();
            for(int y=0; y < COLS; y++){
                System.out.print(space[x][y]);
            }
        }
    }

}
