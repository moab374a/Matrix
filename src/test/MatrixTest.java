package test;
import code.*;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class MatrixTest {
    @Test
    public void testInterface() {
        assertTrue(Matrix.class.isInterface());
    }
}