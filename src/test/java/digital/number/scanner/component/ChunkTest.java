package digital.number.scanner.component;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ChunkTest {
    private Chunk underTest;

    @BeforeEach
    public void setup() {
        underTest = new Chunk();
    }

    @Test
    public void shouldThrowIllegalStateExceptionWhenMoreThanThreeLinesAreAdded() {
        underTest.add("st1");
        underTest.add("st2");
        underTest.add("st3");

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            underTest.add("st4");
        });
        assertTrue(exception.getMessage().contains("Capacity exceeded"));
    }

    @Test
    public void shouldThrowIllegalStateExceptionWhenNumberSequenceOfLengthMoreThanThreeAdded() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            underTest.add("string of length more than 3");
        });
        assertTrue(exception.getMessage().contains("Invalid character sequence"));
    }

    @Test
    public void shouldReturnThreeCrossThreeCharacterMatrix() {
        underTest.add(" _ ");
        underTest.add("| |");
        underTest.add(" _ ");

        char[][] threeCrossThreeMatrix = underTest.toCharacterArray();
        assertTrue(threeCrossThreeMatrix.length == 3);

        String rows[] = new String[3];
        int i = 0;
        for (char[] chars : threeCrossThreeMatrix) {
            rows[i++] = new String(chars);
        }
        assertTrue(rows.length == 3);
        assertTrue(rows[0].equals(" _ "));
        assertTrue(rows[1].equals("| |"));
        assertTrue(rows[2].equals(" _ "));
    }

}