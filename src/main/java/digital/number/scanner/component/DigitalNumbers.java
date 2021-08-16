package digital.number.scanner.component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum DigitalNumbers {

    //@formatter:off

    // ...._.._....._.._.._.._.._.
    // ..|._|._||_||_.|_...||_||_|
    // ..||_.._|..|._||_|..||_|._|

    ZERO(
            new char[][]{
                    {' ', '_', ' '},

                    {'|', ' ', '|'},

                    {'|', '_', '|'}
            },
            "0"
    ),

    ONE(
            new char[][]{
                    {' ', ' ', ' '},

                    {' ', ' ', '|'},

                    {' ', ' ', '|'}
            },
            "1"
    ),

    TWO(
            new char[][]{
                    {' ', '_', ' '},

                    {' ', '_', '|'},

                    {'|', '_', ' '}
            },
            "2"
    ),

    THREE(
            new char[][]{
                    {' ', '_', ' '},

                    {' ', '_', '|'},

                    {' ', '_', '|'}
            },
            "3"
    ),

    FOUR(
            new char[][]{
                    {' ', ' ', ' '},

                    {'|', '_', '|'},

                    {' ', ' ', '|'}
            },
            "4"
    ),

    FIVE(
            new char[][]{
                    {' ', '_', ' '},

                    {'|', '_', ' '},

                    {' ', '_', '|'}
            },
            "5"
    ),

    SIX(
            new char[][]{
                    {' ', '_', ' '},

                    {'|', '_', ' '},

                    {'|', '_', '|'}
            },
            "6"
    ),

    SEVEN(
            new char[][]{
                    {' ', '_', ' '},

                    {' ', ' ', '|'},

                    {' ', ' ', '|'}
            },
            "7"
    ),

    EIGHT(
            new char[][]{
                    {' ', '_', ' '},

                    {'|', '_', '|'},

                    {'|', '_', '|'}
            },
            "8"
    ),

    NINE(
            new char[][]{
                    {' ', '_', ' '},

                    {'|', '_', '|'},

                    {' ', '_', '|'}
            },
            "9"
    ),
    NAN(new char[][]{}, "?");


    //@formatter:on
    private static final Map<String, DigitalNumbers> characterSequenceCache = new HashMap<>();

    static {

        for (DigitalNumbers number : values()) {
            characterSequenceCache.put(stringify(number.charSequence), number);
        }
    }

    private final char[][] charSequence;
    private final String stringRepresentation;

    DigitalNumbers(char[][] charSequence, String stringRepresentation) {
        this.charSequence = charSequence;
        this.stringRepresentation = stringRepresentation;
    }

    private static String stringify(char[][] characterSequence) {
        StringBuilder sb = new StringBuilder();
        boolean notWellFormed = characterSequence == null || Arrays.stream(characterSequence).anyMatch(chars -> chars.length != 3);
        if (notWellFormed) return sb.toString();

        Arrays.stream(characterSequence).forEach(chars -> sb.append(String.valueOf(chars)));
        return sb.toString();
    }

    public static DigitalNumbers valueOf(char[][] someCharacterSequence) {

        String stringValueOfCharacterSequence = stringify(someCharacterSequence);
        DigitalNumbers digitalNumber = characterSequenceCache.get(stringValueOfCharacterSequence);
        return (digitalNumber == null) ? DigitalNumbers.NAN : digitalNumber;
    }

    public static String StringValueOf(char[][] someCharacterSequence) {
        return valueOf(someCharacterSequence).stringRepresentation;
    }

}
