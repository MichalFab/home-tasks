package com.michal.hometasks.controller;

import com.michal.hometasks.service.PolishNotationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(
        produces = APPLICATION_JSON_VALUE,
        consumes = APPLICATION_JSON_VALUE)
public class PolishNotationController {
    private final PolishNotationService polishNotationService;


    public PolishNotationController(PolishNotationService polishNotationService) {
        this.polishNotationService = polishNotationService;
    }

    @PostMapping(value = "/polishNotation")
    public ResponseEntity<List<String>> polishExpression(@RequestBody List<String> expressions) {
        if (expressions.isEmpty()) {
            throw new IllegalArgumentException("Expression list is empty");
        }
        return ResponseEntity.ok(polishNotationService.calculatePolishNotation(expressions));
    }

}
