package by.training.task3.util;

import by.training.task3.exception.CalculateException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExpressionCalculatorTest {

    ExpressionCalculator expressionCalculator;

    @Before
    public void init() {
        expressionCalculator = new ExpressionCalculator("(4^5|1&2<<(2|5>>2&71))|1200");
    }

    @Test
    public void calculateExpression() throws CalculateException {
        int expected = 1201;
        int actual = expressionCalculator.calculateExpression();
        Assert.assertEquals(expected, actual);
    }
}