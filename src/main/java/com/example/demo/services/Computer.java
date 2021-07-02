package com.example.demo.services;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Computer {

    private static final String NEGATIVE_NUMBERS_REGEX = "(-\\d*)";

    private static final String STATIC_DELIMITERS_REGEX = ",|\\n";

    private static final String DYNAMIC_DELIMITERS_REGEX = "^//(.)\\n";

    public int add(String numbers) throws Exception {
        if (StringUtils.isEmpty(numbers)) {
            return 0;
        }
        if (findPattern(numbers, NEGATIVE_NUMBERS_REGEX)) {
            throw new Exception("Negatives not allowed : \n" + this.getNegativeNumbers(numbers));
        }
        if (findPattern(numbers, DYNAMIC_DELIMITERS_REGEX)) {
            String dynamicDelimiter = this.getDynamicDelimiter(numbers);
            String numbersWithoutBeginningDelimiter = removeDynamicDelimiter(numbers);
            return this.splitAndAdd(numbersWithoutBeginningDelimiter, dynamicDelimiter);
        }
        if (findPattern(numbers, STATIC_DELIMITERS_REGEX)) {
            return this.splitAndAdd(numbers, STATIC_DELIMITERS_REGEX);
        }
        return Integer.parseInt(numbers);
    }

    private boolean findPattern(String numbers, String delimiters) {
        Pattern pattern = Pattern.compile(delimiters);
        Matcher matcher = pattern.matcher(numbers);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    private String getNegativeNumbers(String numbers) {
        Pattern pattern = Pattern.compile(NEGATIVE_NUMBERS_REGEX);
        Matcher matcher = pattern.matcher(numbers);
        StringBuilder stringBuilder = new StringBuilder();
        matcher.results().forEach(result -> stringBuilder.append(result.group()).append(" "));
        return stringBuilder.toString();
    }

    private int splitAndAdd(String numbers, String delimiters) {
        return Arrays.stream(numbers.split(delimiters)).mapToInt(Integer::parseInt).sum();
    }

    private String getDynamicDelimiter(String numbers) {
        Pattern pattern = Pattern.compile(DYNAMIC_DELIMITERS_REGEX);
        Matcher matcher = pattern.matcher(numbers);
        matcher.find();
        return matcher.group(1);
    }

    private String removeDynamicDelimiter(String numbers) {
        return numbers.split(DYNAMIC_DELIMITERS_REGEX)[1];
    }
}
