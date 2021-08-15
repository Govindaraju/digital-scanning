package digital.number.scanner.component;

public class Chunk {

    private final char[][] matrix = new char[3][3];
    private int currentRow = 0;

    public void add(String row) {

        if (currentRow == 3) {
            throw new IllegalStateException("Capacity exceeded");
        }        
        
        if (row == null || row.length() != 3) {
            throw new IllegalStateException("Invalid character sequence");
        }

        char[] rowChars = row.toCharArray();
        matrix[currentRow] = rowChars;
        currentRow++;
    }

    public char[][] toCharacterArray() {
        return matrix;
    }
}
