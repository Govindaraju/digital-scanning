package digital.number.scanner.component;

import java.util.*;

public class Digits {
    public static final String ILLEGAL = "ILL";
    public static final int MAX_CAPACITY = 3;
    private final List<String> numberSequences;
    private String digits;

    public Digits() {
        this.numberSequences = new ArrayList<>();
    }

    public void add(String numberSequence) {
        if (numberSequences.size() == MAX_CAPACITY) {
            throw new IllegalStateException("Capacity exceeded");
        }
        numberSequences.add(numberSequence);
    }

    public Optional<String> digits() {
        digitise();
        return Optional.ofNullable(digits);
    }

    private void digitise() {
        if (digits != null) {
            return;
        }
        if (!isWellFormed()) {
            return;
        }
        Map<Integer, Chunk> chunks = chunkNumberSequence();
        StringBuilder sb = new StringBuilder();
        chunks.values().stream().map(chunk -> DigitalNumbers.StringValueOf(chunk.toCharacterArray())).forEach(sb::append);
        if (sb.indexOf("?") >= 0) {
            sb.append(ILLEGAL);
        }
        digits = sb.toString();
    }

    private Map<Integer, Chunk> chunkNumberSequence() {

        Map<Integer, Chunk> chunksMap = new LinkedHashMap<>();
        for (String numberSequence : numberSequences) {
            int digitPosition = 0;
            while (numberSequence.length() >= 3) {

                Chunk chunk = chunksMap.get(digitPosition);
                if (chunk == null) {
                    chunk = new Chunk();
                    chunksMap.put(digitPosition, chunk);
                }
                chunk.add(numberSequence.substring(0, 3));
                numberSequence = numberSequence.substring(3);
                digitPosition++;
            }
        }
        return chunksMap;
    }


    private boolean isWellFormed() {
        if (numberSequences.size() != 3) {
            return false;
        }

        for (String numberSequence : numberSequences) {
            if (numberSequence.length() != 27) {
                return false;
            }
        }
        return true;
    }
}
