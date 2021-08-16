package digital.number.scanner.component;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DigitsTest {

    private Digits underTest;

    @BeforeEach
    public void setup() {
        underTest = new Digits();
    }

    @Test
    public void shouldThrowIllegalStateExceptionWhenMoreThanThreeLinesAreAdded() {
        underTest.add("string 1");
        underTest.add("string 2");
        underTest.add("string 3");

        Exception exception = assertThrows(IllegalStateException.class, () -> underTest.add("string 4"));

        assertTrue(exception.getMessage().contains("Capacity exceeded"));
    }
    
    @Test
    public void shouldReturnEmptyOptionalOnSupplyingLessThanThreeNumberSequences(){
        underTest.add(" _  _  _  _  _  _  _  _  _ ");
        underTest.add("| || || || || || || || || |");
        assertTrue(underTest.digits().isEmpty());
    }    
    
    @Test
    public void shouldReturnEmptyOptionalOnSupplyingAnyNumberSequenceNotOfLength27(){
        underTest.add(" _  _  _  _  _  _  _  _  _ ");
        underTest.add("| || || || || || || || || |");
        underTest.add("|_||_||_||_||_||_||_||_|");
        assertTrue(underTest.digits().isEmpty());
    }   
    
    @Test
    public void shouldReturnDigitsWithQuestionsMarksAndILLSuffixOnSupplyingCorruptedNumberSequences(){
        underTest.add(" _  _  _  _  _  _  _  _  _ ");
        underTest.add("| || || || || +| || || || |");
        underTest.add("|_||_||_||_||_||_||_||_*|_|");
        
        String expected = underTest.digits().get();
        assertEquals("0000?00?0ILL", expected);
    }    
    
    @Test
    public void shouldReturnWellFormedDigitsOnSupplyingRightNumberSequences(){
        underTest.add(" _  _  _  _  _  _  _  _  _ ");
        underTest.add("| || || || || || || || || |");
        underTest.add("|_||_||_||_||_||_||_||_||_|");
        
        String expected = underTest.digits().orElse(null);

        assertEquals("000000000", expected);
    }
    
}