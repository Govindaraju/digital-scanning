package digital.number.scanner.component;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DigitalNumbersTest {

    // ...._.._....._.._.._.._.._.
    // ..|._|._||_||_.|_...||_||_|
    // ..||_.._|..|._||_|..||_|._|

    @Test
    void shouldReturn_NAN_IfNullValueIsPassedForCharacterSequence() {
        char[][] sequence = null;
        DigitalNumbers number = DigitalNumbers.valueOf(sequence);
        assertEquals(DigitalNumbers.NAN, number);
    }

    @Test
    void shouldReturn_NAN_IfValueIsPassedIsNot3Cross3CharacterSequence() {
        //@formatter:off
        DigitalNumbers number = DigitalNumbers.valueOf(new char[][]{
                {' ', '_'},

                {'|', '_', '|'},

                {' ', '_', '|'}
                //@formatter:on
        });
        assertEquals(DigitalNumbers.NAN, number);
    }

    @Test
    void shouldReturn_NAN_IfValueIsPassedIsNotADigitalNumber() {
        //@formatter:off
        DigitalNumbers number = DigitalNumbers.valueOf(new char[][]{
                {' ', ' ', ' '},

                {' ', ' ', ' '},

                {' ', ' ', ' '}
                //@formatter:on
        });
        assertEquals(DigitalNumbers.NAN, number);
    }

    @Test
    void shouldReturnZero() {
        //@formatter:off
        DigitalNumbers number = DigitalNumbers.valueOf(
                new char[][]{
                        {' ', '_', ' '},

                        {'|', ' ', '|'},

                        {'|', '_', '|'}
                }

        );
        //@formatter:on
        assertEquals(DigitalNumbers.ZERO, number);

    }

    @Test
    void shouldReturnOne() {
        //@formatter:off
        DigitalNumbers number = DigitalNumbers.valueOf(
                new char[][]{
                        {' ', ' ', ' '},

                        {' ', ' ', '|'},

                        {' ', ' ', '|'}
                }
        );
        //@formatter:on
        assertEquals(DigitalNumbers.ONE, number);

    }

    @Test
    void shouldReturnTwo() {
        //@formatter:off
        DigitalNumbers number = DigitalNumbers.valueOf(
                new char[][]{
                        {' ', '_', ' '},

                        {' ', '_', '|'},

                        {'|', '_', ' '}
                }

        );
        //@formatter:on
        assertEquals(DigitalNumbers.TWO, number);

    }

    @Test
    void shouldReturnThree() {
        //@formatter:off
        DigitalNumbers number = DigitalNumbers.valueOf(
                new char[][]{
                        {' ', '_', ' '},

                        {' ', '_', '|'},

                        {' ', '_', '|'}
                }
        );
        //@formatter:on
        assertEquals(DigitalNumbers.THREE, number);

    }

    @Test
    void shouldReturnFour() {
        //@formatter:off
        DigitalNumbers number = DigitalNumbers.valueOf(
                new char[][]{
                        {' ', ' ', ' '},

                        {'|', '_', '|'},

                        {' ', ' ', '|'}
                }
        );
        //@formatter:on
        assertEquals(DigitalNumbers.FOUR, number);

    }

    @Test
    void shouldReturnFive() {
        //@formatter:off
        DigitalNumbers number = DigitalNumbers.valueOf(
                new char[][]{
                        {' ', '_', ' '},

                        {'|', '_', ' '},

                        {' ', '_', '|'}
                }
        );
        //@formatter:on
        assertEquals(DigitalNumbers.FIVE, number);

    }

    @Test
    void shouldReturnSix() {
        //@formatter:off
        DigitalNumbers number = DigitalNumbers.valueOf(
                new char[][]{
                        {' ', '_', ' '},

                        {'|', '_', ' '},

                        {'|', '_', '|'}
                }
        );
        //@formatter:on
        assertEquals(DigitalNumbers.SIX, number);

    }

    @Test
    void shouldReturnSeven() {
        //@formatter:off
        DigitalNumbers number = DigitalNumbers.valueOf(
                new char[][]{
                        {' ', '_', ' '},

                        {' ', ' ', '|'},

                        {' ', ' ', '|'}
                }
        );
        //@formatter:on
        assertEquals(DigitalNumbers.SEVEN, number);

    }

    @Test
    void shouldReturnEight() {
        //@formatter:off
        DigitalNumbers number = DigitalNumbers.valueOf(
                new char[][]{
                        {' ', '_', ' '},

                        {'|', '_', '|'},

                        {'|', '_', '|'}
                }
        );
        //@formatter:on
        assertEquals(DigitalNumbers.EIGHT, number);

    }

    @Test
    void shouldReturnNine() {
        //@formatter:off
        DigitalNumbers number = DigitalNumbers.valueOf(
                new char[][]{
                        {' ', '_', ' '},

                        {'|', '_', '|'},

                        {' ', '_', '|'}
                }
        );
        //@formatter:on
        assertEquals(DigitalNumbers.NINE, number);

    }

}
