class LifeGame {

    public static void main(String[] args) {
        int generation = 1;
        Space spaceObj = new Space(10,10);
        spaceObj.fillEmptyState();
        spaceObj.inputState();

        System.out.println("***********INITIAL STATE***********");
        spaceObj.printState();

        SimulateLifeGame gameObj = new SimulateLifeGame(spaceObj);

        do{
            gameObj.setGameState(false);
            gameObj.play(generation);
            generation++;
        } while(gameObj.getGameState());
    }
};