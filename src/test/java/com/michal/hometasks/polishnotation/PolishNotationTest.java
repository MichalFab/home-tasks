package com.michal.hometasks.polishnotation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Stack;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PolishNotationTest {

    @DisplayName("Should calculate result")
    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    void shouldCalculateResult(Stack<String> input, String expected) {
        PolishNotation polishNotation = new PolishNotation();
        assertEquals(expected, polishNotation.evaluate(input));
    }

    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of(createStack("+ + 0.5 1.5 * 4 10"), "42,00"),
                Arguments.of(createStack("- 2e3 - 700 + 7 * 2 15"), "1337,00"),
                Arguments.of(createStack("- -1.5 * 3.1415 / -7 -2"), "-12,50"),
                Arguments.of(createStack("100500"), "100500,00"),
                Arguments.of(createStack("1 2"), "error"),
                Arguments.of(createStack("+ 1"), "error")
        );
    }

    private static Stack<String> createStack(String inputLine){
        String[] tokens = inputLine.split(" ");
        Stack<String> stack = new Stack<>();
        for (String i : tokens) {
            stack.push(i);
        }
        return stack;
    }

}