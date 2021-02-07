package code;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MyMatrix<T> implements Matrix {


    private final Map< MatrixIndex, Object> matrixEntries = new HashMap<>();


    //Inner class
    class DepthFirstIterator implements Iterator {
        public DepthFirstIterator() {
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }

        @Override
        public void remove() {

        }
    }


    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public int getObjectCount() {
        return 0;
    }

    @Override
    public int getDistinctObjectCount() {
        return 0;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object get(int row, int column) {
        return null;
    }

    @Override
    public Object put(int row, int column, Object value) {
        return null;
    }

    @Override
    public boolean contains(Object value) {
        return false;
    }


}
