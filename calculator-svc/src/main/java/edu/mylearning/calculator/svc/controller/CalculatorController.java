package edu.mylearning.calculator.svc.controller;

import edu.mylearning.calculator.svc.model.Operation;
import edu.mylearning.calculator.svc.service.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }

    @GetMapping
    @RequestMapping("/calculate")
    public ResponseEntity<Double> calculate(@RequestParam("firstNumber") double firstNumber,
                                    @RequestParam("secondNumber") double secondNumber,
                                    @RequestParam("operation") String operation){
        Operation determinedOperation = calculatorService.determineOperation(operation);
        double calculatedValue = calculatorService.calculate(firstNumber, secondNumber, determinedOperation);
        return ResponseEntity.ok().body(calculatedValue);
    }
}
