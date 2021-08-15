package digital.number.scanner.service;

import digital.number.scanner.exception.InputSourceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScannerServiceTest {

    @Test
    public void shouldThrowInputSourceException() {
        ScannerService scannerService = new ScannerService("invalid path");
        Exception exception = assertThrows(InputSourceException.class, () -> {
            scannerService.scan();
        });
        assertTrue(exception.getMessage().contains("Unable to read file contents"));
    }
}