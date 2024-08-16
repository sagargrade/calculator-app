package edu.mylearning.calculator.svc.model;

import static java.util.Objects.isNull;

public enum OperationType {
    ADDITION,
    SUBTRACTION,
    MULTIPLICATION,
    DIVISION;

    public static OperationType fromString(String operation){
        if (isNull(operation) || operation.isBlank()){
            throw new IllegalArgumentException("Operation can not be empty");
        }

        switch (operation.trim().toUpperCase()){
            case "ADD", "ADDITION":
                return ADDITION;
            case "SUBTRACT", "SUBTRACTION":
                return SUBTRACTION;
            case "MULTIPLY", "MULTIPLICATION":
                return MULTIPLICATION;
            case "DIVIDE", "DIVISION":
                return DIVISION;
            default:
                throw new IllegalArgumentException("Unknown Operation:  " + operation);
        }
    }
}
