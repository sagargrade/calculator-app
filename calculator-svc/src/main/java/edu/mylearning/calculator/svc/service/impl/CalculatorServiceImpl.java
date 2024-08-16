package edu.mylearning.calculator.svc.service.impl;

import edu.mylearning.calculator.svc.model.Operation;
import edu.mylearning.calculator.svc.model.OperationType;
import edu.mylearning.calculator.svc.model.impl.Addition;
import edu.mylearning.calculator.svc.model.impl.Division;
import edu.mylearning.calculator.svc.model.impl.Multiplication;
import edu.mylearning.calculator.svc.model.impl.Subtraction;
import edu.mylearning.calculator.svc.service.CalculatorService;
import org.springframework.stereotype.Service;


@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public double calculate(double firstNumber, double secondNumber, Operation operation) {
        return operation.execute(firstNumber, secondNumber);
    }

    @Override
    public Operation determineOperation(String operationName) {
        switch (OperationType.fromString(operationName)){
            case ADDITION:
                return new Addition();
            case SUBTRACTION:
                return new Subtraction();
            case MULTIPLICATION:
                return new Multiplication();
            case DIVISION:
                return new Division();
            default:
                throw new IllegalArgumentException("Unknown Operation : " + operationName);
        }
    }
}
