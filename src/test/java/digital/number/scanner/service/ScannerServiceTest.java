package digital.number.scanner.service;

import digital.number.scanner.exception.InputSourceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScannerServiceTest {

    @Test
    public void shouldThrowInputSourceException() {
        FileScannerService scannerService = new FileScannerService();
        Exception exception = assertThrows(InputSourceException.class, () -> {
            scannerService.scan("invalid path");
        });
        assertTrue(exception.getMessage().contains("Unable to read file contents"));
    }
}