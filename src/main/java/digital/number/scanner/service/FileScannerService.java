package digital.number.scanner.service;

import digital.number.scanner.component.Digits;
import digital.number.scanner.exception.InputSourceException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * author : Govindaraju Kalyanaraman
 * email: govind.kalyana@gmail.com
 */
public class FileScannerService implements ScannerService {
    @Override
    public List<String> scan(String file) {
        List<Digits> numbers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.lines().forEach(line -> scanSequence(line, numbers));
        } catch (IOException e) {
            throw new InputSourceException(String.format("Unable to read file contents %s", e.getMessage()));
        }
        return numbers.stream().filter(number -> number.digits().isPresent()).map(number -> number.digits().get()).collect(Collectors.toList());
    }

    private void scanSequence(String line, List<Digits> numbers) {
        String trimmedLine = line.trim();
        Optional<Digits> lastDigits = Optional.ofNullable(numbers.isEmpty() ? null : numbers.get(numbers.size() - 1));

        Digits digits;
        if (lastDigits.isEmpty() || trimmedLine.isEmpty()) {
            digits = new Digits();
            numbers.add(digits);
        } else {
            digits = lastDigits.get();
        }

        if (!trimmedLine.isEmpty()) {
            digits.add(line);
        }
    }

}
