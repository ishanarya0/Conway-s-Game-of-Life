class LifeGame {

    public static void main(String[] args) {
        Space spaceObj = new Space(10,10);
        spaceObj.fillEmptyState();
        spaceObj.inputState();

        System.out.println("***********INITIAL STATE***********");
        spaceObj.printState();

        SimulateLifeGame gameObj = new SimulateLifeGame(spaceObj);
        gameObj.play();
    }
};