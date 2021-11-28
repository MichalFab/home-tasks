package com.michal.hometasks.service;

import com.michal.hometasks.polishnotation.PolishNotation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Service
public class PolishNotationService {

    public List<String> calculatePolishNotation(List<String> inputs) {
        PolishNotation polishNotation = new PolishNotation();
        List<String> results = new ArrayList<>();
        for (String input : inputs) {
            Stack<String> stack = new Stack();
            for (String value : input.split(" ")) {
                stack.push(value);
            }
            results.add(polishNotation.evaluate(stack));
        }
        return results;
    }


}
