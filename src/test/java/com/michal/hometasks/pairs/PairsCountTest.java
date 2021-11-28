package com.michal.hometasks.pairs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PairsCountTest {

    @Test
    @DisplayName("Should find two pairs")
    void shouldCalculateResult() {
//        given
        PairsCount pairsCount = new PairsCount();
        var arr = new ArrayList<>(Arrays.asList(2, 1, 4, 5, 3));
//        when
        int pairs = pairsCount.getPairsCount(6, arr);
//        then
        assertEquals(2, pairs);
    }

    @Test
    @DisplayName("Should return 0 if there is no pair")
    void shouldReturn0() {
        //        given
        PairsCount pairsCount = new PairsCount();
        var arr = new ArrayList<>(Arrays.asList(2, 1, 4, 5, 3));
//        when
        int pairs = pairsCount.getPairsCount(25, arr);
//        then
        assertEquals(0, pairs);
    }

}