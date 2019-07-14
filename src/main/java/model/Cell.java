public class Cell {

    private State state;
    private Integer adjacentMinesCount;

    public Cell(State state, Integer adjacentMinesCount) {
        this.state = state;
        this.adjacentMinesCount = adjacentMinesCount;
    }


    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Integer getAdjacentMinesCount() {
        return adjacentMinesCount;
    }

    public void setAdjacentMinesCount(Integer adjacentMinesCount) {
        this.adjacentMinesCount = adjacentMinesCount;
    }
}
