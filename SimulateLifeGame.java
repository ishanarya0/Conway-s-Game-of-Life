public class SimulateLifeGame {
    int _ROWS, _COLS;
    Space spaceObj;
    boolean isGameActive;

    //Constructors
    SimulateLifeGame(Space _spaceObj){
        spaceObj = new Space(_spaceObj);
        isGameActive = false;
        _ROWS = spaceObj.getROWS();
        _COLS = spaceObj.getCOLS();
    }

    //A few getter setter methods
    public boolean getGameState(){
        return isGameActive;
    }

    public void setGameState(boolean _gameState){
        isGameActive = _gameState;
    }

    //To check if the coordinates are within the board
    private boolean isSafe(int x, int y){
        if(x < 0 || y < 0 || x >= _ROWS || y >= _COLS ) return false;
        else return true;
    }

    //Counts the number of live neighbours in the board area
    private int findLiveNeighbours(int x, int y){
        int count = 0;
        int[] yMoves = {-1,0,1,1,1,0,-1,-1};
        int[] xMoves = {-1,-1,-1,0,1,1,1,0};

        for(int move = 0; move < 8; move++){
            if(isSafe(x+xMoves[move], y+yMoves[move]) ){
                if(spaceObj.space[x+xMoves[move]][y+yMoves[move]] == '*'){
                    count++;
                }
            }
        }

        return count;
        
    }

    //TO DO - A function to compare the current state wit the previoud state
   /*
    private boolean isStateSame(){
        System.out.println("Yo\n\n");
        System.out.println("Prev\n\n");
        prevspaceObj.printState();

        System.out.println("\n\nCurrent\n\n");
        spaceObj.printState();
        System.out.println("\nEnd\n\n");

        for(int x = 0; x < _ROWS; x++){
            for(int y = 0; y < _COLS; y++){
                if(prevspaceObj.space[x][y] == spaceObj.space[x][y]) continue;
                else {
                    prevspaceObj = spaceObj;


                    return false;
                } 
            }
        }
        return true;
    }
    */

    //Function that simulates the game - updates the board
    public void play(int generation){
        char[][] tempSpace = spaceObj.space;

        for(int x = 0; x < _ROWS; x++){
            for(int y = 0; y < _COLS; y++){
                int countLive = findLiveNeighbours(x,y);

                if(tempSpace[x][y] == '*'){
                    if(countLive < 2) tempSpace[x][y] = '.';
                    else if(countLive == 2 || countLive == 3) isGameActive = true;
                    else if (countLive > 3) tempSpace[x][y] = '.';
                } else {
                    if(countLive == 3) {
                        tempSpace[x][y] = '*';
                        isGameActive = true;
                    }
                }
            }
        }

        //Prints the Current generation with the state of the board
        System.out.println("\nGeneration : "+generation);
        spaceObj.printState();

        //if(isStateSame()) isGameActive = false;
    }
}

/*
RULES: 
Any live cell with fewer than two live neighbours dies, as if by underpopulation.
Any live cell with two or three live neighbours lives on to the next generation.
Any live cell with more than three live neighbours dies, as if by overpopulation.
Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
*/
