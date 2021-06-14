import java.util.Scanner;

public class Space {
    static int ROWS;
    static int COLS;
    static char[][] space;

    Space(int _ROWS, int _COLS){
        ROWS = _ROWS;
        COLS = _COLS;
        space = new char [ROWS][COLS];
    }

    public void fillEmptyState(){
        for (int i = 0; i < ROWS; i++)
        {
            for(int j=0; j<COLS; j++){
                space[i][j] = '.';
            }
        }
    }

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

    public void printState(){
        for(int x=0; x < ROWS; x++){
            System.out.println();
            for(int y=0; y < COLS; y++){
                System.out.print(space[x][y]);
            }
        }
    }

}
