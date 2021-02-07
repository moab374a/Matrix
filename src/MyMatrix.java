import java.util.*;

public class MyMatrix<T> implements Matrix<T> {


    private final Map<MatrixIndex, T> matrixEntries = new HashMap<>();

    public MyMatrix(int x, int y) {
        new MatrixIndex(x, y);
    }

    public MyMatrix() {
    }

    //Inner class
    class DepthFirstIterator implements Iterator {

        private int currentIndex = 0;

        //Size of The matrix
        private int currentSize;

        private ArrayList<T> sort;

        public DepthFirstIterator() {
            sort = new ArrayList<>();
            addSort();

            //CurrentSize == List Size (9)
            this.currentSize = sort.size();

        }

        private void addSort() {

            for (int col = 0; col < getColumnCount(); col++) {

                for (int row = 0; row < getRowCount(); row++) {

                    T value = get(row, col); // return value from Map

                    if (value != null) {
                        sort.add(value);
                        System.out.println("row -> " + row + " ,col -> " + col + " = " + value);
                    }


                }
            }

        }

        @Override
        public boolean hasNext() {
            return currentIndex < currentSize;
        }

        @Override
        public T next() {
            if(currentIndex >= currentSize){
                throw new NoSuchElementException();
            }
           return sort.get(currentIndex++);
        }
    }

    @Override
    public int getRowCount() {
        ArrayList<Integer> index = new ArrayList<>();

        if (matrixEntries.isEmpty()) {
            return 0;
        }
        for (Map.Entry<MatrixIndex, T> entry : matrixEntries.entrySet()) {
            int row = entry.getKey().getRow();
            index.add(row);
        }
        Integer max = Collections.max(index);
        if (max == 0) {
            return 0;
        }


        return max + 1;

    }

    @Override
    public int getColumnCount() {
        if (matrixEntries.isEmpty()) {
            return 0;
        }
        ArrayList<Integer> index = new ArrayList<>();

        for (Map.Entry<MatrixIndex, T> entry : matrixEntries.entrySet()) {
            int column = entry.getKey().getColumn();
            index.add(column);
        }

        Integer max = Collections.max(index);
        if (max == 0) {
            return 0;
        }
        return max + 1;
    }

    @Override
    public int getObjectCount() {

        return matrixEntries.size();
    }

    @Override
    public int getDistinctObjectCount() {
        List<T> duplicateValues = new ArrayList<>();

        for (Map.Entry<MatrixIndex, T> entry : matrixEntries.entrySet()) {

            T value = entry.getValue();
            if (!duplicateValues.contains(value)) {
                duplicateValues.add(value);
            }
        }

        return duplicateValues.size();
    }

    @Override
    public Iterator iterator() {

        return new DepthFirstIterator();
    }

    @Override
    public T get(int row, int column) {

        if (row >= getRowCount() || column >= getColumnCount()) throw new IllegalArgumentException();
        if (row < 0 || column < 0) throw new IllegalArgumentException();

        //Loop in the map:
        for (Map.Entry<MatrixIndex, T> entry : matrixEntries.entrySet()) {
            if (entry.getKey().getRow() == row && entry.getKey().getColumn() == column)
                return entry.getValue();
        }
        return null;
    }

    @Override
    public T put(int row, int column, T value) {
        if (row < 0 || column < 0) throw new IllegalArgumentException();
        return matrixEntries.put(new MatrixIndex(row, column), value);
    }

    @Override
    public boolean contains(T value) {

        if (matrixEntries.containsValue(value)) {
            return true;
        }
        return false;
    }


}
