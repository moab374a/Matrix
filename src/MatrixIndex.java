import java.util.Objects;

public class MatrixIndex {
   private int row;
   private int column;

    public MatrixIndex(int row, int column) {
        if (row <0 || column < 0) throw new IllegalArgumentException();
        this.row = row;
        this.column = column;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {

        return row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatrixIndex that = (MatrixIndex) o;
        return row == that.row && column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
