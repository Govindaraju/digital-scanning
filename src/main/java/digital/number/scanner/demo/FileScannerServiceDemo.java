package digital.number.scanner.demo;

import digital.number.scanner.service.FileScannerService;
import digital.number.scanner.service.ScannerService;

import java.util.List;

public class FileScannerServiceDemo {

    public static void main(String[] args) {
        ScannerService scannerService = new FileScannerService();
        List<String> scannedNumbers = scannerService.scan("Please provide a fully qualified path before you execute this");
        scannedNumbers.forEach(number -> System.out.println(number));
    }
}
