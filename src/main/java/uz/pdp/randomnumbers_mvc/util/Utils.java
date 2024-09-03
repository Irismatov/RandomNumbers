package uz.pdp.randomnumbers_mvc.util;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Utils {

    public static List<Integer> generateRandomNumbers(int row, int column) {
        List<Integer> randomNumbers = new ArrayList<Integer>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                randomNumbers.add((int) (Math.random() * 100));
            }
        }
        return randomNumbers;
    }

    public static List<Integer> mapStringToList(String numbers) {
        return Arrays.stream(numbers.replaceAll("[\\[\\]]", "").split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}

