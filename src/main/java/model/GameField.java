public class GameField {

    private int sizeX;
    private int sizeY;
    private int amountOfMines;
    private Cell[][] field;

    public GameField(int sizeX, int sizeY, int amountOfMines) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.amountOfMines = amountOfMines;
        this.field = new Cell[sizeX][sizeY];
    }

    public Cell[][] getField() {
        return field;
    }
}
