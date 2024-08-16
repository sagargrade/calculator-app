package edu.mylearning.calculator.svc.service;

import edu.mylearning.calculator.svc.model.Operation;

public interface CalculatorService {
    double calculate(double firstNumber, double secondNumber, Operation operation);

    Operation determineOperation(String operationName);
}
