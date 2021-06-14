import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SimulateLifeGameTest {
    Space spaceObj = new Space(20,20);

    @Test
    public void testfindLiveNeighbours(){
        char[][] testSpace = {{'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'}, {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'}, {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'}, {'.','.','.','*','*','*','.','.','.','.','.','.','.','.','.','.','.','.','.','.'}, {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'}, {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'}, {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'}, {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'}, {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'}, {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'}, {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'}, {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'}, {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'}, {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'}, {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'}, {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'}, {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'}, {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'}, {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'}, {'.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.'}};

        spaceObj.fillEmptyState();
        spaceObj.space = testSpace;

        SimulateLifeGame gameObj = new SimulateLifeGame(spaceObj);

        //for (2,4)
        int count = gameObj.findLiveNeighbours(2, 4, spaceObj.space);
        assertEquals(3, count);

        //for (2,3)
        count = gameObj.findLiveNeighbours(2, 3, spaceObj.space);
        assertEquals(2, count);
    }

}