package digital.number.scanner.service;

import digital.number.scanner.component.Digits;
import digital.number.scanner.exception.InputSourceException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author : Govindaraju Kalyanaraman
 * email: govind.kalyana@gmail.com
 */
public class ScannerService {

    private final List<Digits> numbers;
    private final String file;

    public ScannerService(String file) {
        numbers = new ArrayList<>();
        this.file = file;
    }

    public static void main(String[] args) {
        ScannerService fileScanner = new ScannerService("Please provide a fully qualified path before you execute this");
        List<String> scannedNumbers = fileScanner.scan();
        scannedNumbers.forEach(number -> System.out.println(number));
    }

    public List<String> scan() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.lines().forEach(this::scanSequence);
        } catch (IOException e) {
            throw new InputSourceException(String.format("Unable to read file contents %s", e.getMessage()));
        }
        return this.numbers.stream().map(number -> number.get()).filter(digits -> null != digits).collect(Collectors.toList());
    }

    private void scanSequence(String line) {
        String trimmedLine = line.trim();
        Digits lastDigits = !numbers.isEmpty() ? numbers.get(numbers.size() - 1) : null;

        if (null == lastDigits || trimmedLine.isEmpty()) {
            lastDigits = new Digits();
            numbers.add(lastDigits);
        }
        if (!trimmedLine.isEmpty()) {
            lastDigits.add(line);
        }
    }

}
