package edu.mylearning.calculator.svc.model.impl;

import edu.mylearning.calculator.svc.model.Operation;

public class Addition implements Operation {
    @Override
    public double execute(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }
}
