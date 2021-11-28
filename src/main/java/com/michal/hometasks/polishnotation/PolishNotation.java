package com.michal.hometasks.polishnotation;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


public class PolishNotation {

    public String evaluate(Stack<String> inputs) {
        var stack = new Stack<Double>();
        String operator;
        double tmp;

        while (!inputs.isEmpty()) {
            operator = inputs.pop();
            if ("+-*/".contains(operator)) {
                if (stack.size() < 2) {
                    return "error";
                }
                switch (operator) {
                    case "+":
                        tmp = stack.pop() + stack.pop();
                        stack.push(tmp);
                        break;
                    case "-":
                        tmp = stack.pop() - stack.pop();
                        stack.push(tmp);
                        break;
                    case "/":
                        double value = stack.pop();
                        if (value == 0) {
                            throw new UnsupportedOperationException("Cannot divide by 0");
                        }
                        tmp = value / stack.pop();
                        stack.push(tmp);
                        break;
                    case "*":
                        tmp = stack.pop() * stack.pop();
                        stack.push(tmp);
                        break;
                }
            } else {
                stack.push(Double.parseDouble(operator));
            }
        }
        if (stack.size() > 1) {
            return "error";
        }

        return String.format("%.2f", stack.pop());

    }

    public static void main(String[] args) {
        PolishNotation polishNotation = new PolishNotation();
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> results = new ArrayList<>();

        while (true) {
            if (scanner.hasNext("calculate")) {
                break;
            } else {
                String[] tokens = scanner.nextLine().split(" ");
                Stack<String> stack = new Stack<>();
                for (String i : tokens) {
                    stack.push(i);
                }
                results.add(polishNotation.evaluate(stack));
            }
        }
        for (String s : results) {
            System.out.println(s);
        }
    }
}