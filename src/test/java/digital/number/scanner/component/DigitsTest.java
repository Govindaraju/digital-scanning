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

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            underTest.add("string 4");
        });

        assertTrue(exception.getMessage().contains("Capacity exceeded"));
    }
    
    @Test
    public void shouldReturnNullOnSupplyingLessThanThreeNumberSequences(){
        underTest.add(" _  _  _  _  _  _  _  _  _ ");
        underTest.add("| || || || || || || || || |");
        
        String expected = underTest.get();
        
        assertNull(expected);
    }    
    
    @Test
    public void shouldReturnNullOnSupplyingAnyNumberSequenceNotOfLength27(){
        underTest.add(" _  _  _  _  _  _  _  _  _ ");
        underTest.add("| || || || || || || || || |");
        underTest.add("|_||_||_||_||_||_||_||_|");
        
        String expected = underTest.get();
        
        assertNull(expected);
    }   
    
    @Test
    public void shouldReturnDigitsWithQuestionsMarksAndILLSuffixOnSupplyingCorruptedNumberSequences(){
        underTest.add(" _  _  _  _  _  _  _  _  _ ");
        underTest.add("| || || || || +| || || || |");
        underTest.add("|_||_||_||_||_||_||_||_*|_|");
        
        String expected = underTest.get();
        
        assertTrue(expected.equals("0000?00?0ILL"));
    }    
    
    @Test
    public void shouldReturnWellFormedDigitsOnSupplyingRightNumberSequences(){
        underTest.add(" _  _  _  _  _  _  _  _  _ ");
        underTest.add("| || || || || || || || || |");
        underTest.add("|_||_||_||_||_||_||_||_||_|");
        
        String expected = underTest.get();
        
        assertTrue(expected.equals("000000000"));
    }
    
}