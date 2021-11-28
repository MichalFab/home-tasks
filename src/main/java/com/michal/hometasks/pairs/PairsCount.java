package com.michal.hometasks.pairs;


import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class PairsCount {

    private static final String WRONG_TYPE_MESSAGE = "The provided argument must be an integer";

    public int getPairsCount(int sum, List<Integer> arr) {
        var hashMap = new HashMap<Integer, Integer>();
        if (arr.size() <= 1) {
            return 0;
        }
        var count = 0;
        for (int i : arr) {
            var tmp = sum - arr.get(i - 1);
            if (hashMap.containsKey(tmp)) {
                count += hashMap.getOrDefault(tmp, 0);
            }
            hashMap.merge(i, 1, Integer::sum);
        }
        return count;
    }

    public static void main(String[] args) {
        PairsCount pairsCount = new PairsCount();
        int k;
        var arr = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                k = scanner.nextInt();
                break;
            } catch (InputMismatchException ex) {
                System.out.println(WRONG_TYPE_MESSAGE);
                scanner.next();
            }
        }

        while (true) {
            if (scanner.hasNext("calculate")) {
                break;
            } else {
                if (scanner.hasNextInt()) {
                    arr.add(scanner.nextInt());
                } else {
                    System.out.println(WRONG_TYPE_MESSAGE);
                }
            }
        }
        var result = pairsCount.getPairsCount(k, arr);
        System.out.println(result);
        System.out.println();
    }
}
