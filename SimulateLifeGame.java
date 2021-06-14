public class SimulateLifeGame {
    int _ROWS, _COLS;
    Space spaceObj;

    SimulateLifeGame(Space _spaceObj){
        spaceObj = _spaceObj;
        _ROWS = spaceObj.getROWS();
        _COLS = spaceObj.getCOLS();
    }

    private boolean isSafe(int x, int y){
        if(x < 0 || y < 0 || x >= _ROWS || y >= _COLS ) return false;
        else return true;
    }

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

    public void play(){


        for(int x = 0; x < _ROWS; x++){
            for(int y = 0; y < _COLS; y++){
                int countLive = findLiveNeighbours(x,y);

                if(spaceObj.space[x][y] == '*'){
                    if(countLive < 2) spaceObj.space[x][y] = '.';
                    else if(countLive == 2 || countLive == 3) continue;
                    else if (countLive > 3) spaceObj.space[x][y] = '.';
                } else {
                    if(countLive == 3) spaceObj.space[x][y] = '*';
                }
            }
        }
        System.out.println("\n\n\n");
        spaceObj.printState();

    }
}

/*
Any live cell with fewer than two live neighbours dies, as if by underpopulation.
Any live cell with two or three live neighbours lives on to the next generation.
Any live cell with more than three live neighbours dies, as if by overpopulation.
Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
*/
