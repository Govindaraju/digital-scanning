package digital.number.scanner.service;

import digital.number.scanner.exception.InputSourceException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseScannerServiceIntegrationTestImpl extends BaseScannerServiceIntegrationTest {

    @Override
    protected List<String> performScanning(String inputFilePath) {
        ScannerService scannerService = new ScannerService(inputFilePath);
        return scannerService.scan();
    }

    @Test
    public void shouldThrowInputSourceException() {
        ScannerService scannerService = new ScannerService("invalid path");
        Exception exception = assertThrows(InputSourceException.class, () -> {
            scannerService.scan();
        });
        assertTrue(exception.getMessage().contains("Unable to read file contents"));
    }
}