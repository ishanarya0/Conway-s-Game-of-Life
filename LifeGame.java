class LifeGame {

    public static void main(String[] args) {
        Space spaceObj = new Space(100,100);
        spaceObj.fillEmptyState();
        spaceObj.inputState();

        System.out.println("***********INITIAL STATE***********");
        spaceObj.printState();
    }
};