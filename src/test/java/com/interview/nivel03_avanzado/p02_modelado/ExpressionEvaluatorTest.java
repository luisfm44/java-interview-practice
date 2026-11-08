package com.interview.nivel03_avanzado.p02_modelado;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/** Evaluación del reto; activa con -Pretos -Dtest=ExpressionEvaluatorTest. */
@Tag("reto")
class ExpressionEvaluatorTest {
    private final ExpressionEvaluator challenge = new ExpressionEvaluator();

    @Test void evaluatesNestedTreesAndNegativeLiterals() {
        var tree = new ExpressionEvaluator.Multiply(
            new ExpressionEvaluator.Add(new ExpressionEvaluator.Literal(2), new ExpressionEvaluator.Literal(3)),
            new ExpressionEvaluator.Literal(-4));
        assertEquals(-20, challenge.evaluate(tree));
        assertEquals(0, challenge.evaluate(new ExpressionEvaluator.Literal(0)));
        assertEquals(Long.MIN_VALUE, challenge.evaluate(new ExpressionEvaluator.Literal(Long.MIN_VALUE)));
    }

    @Test void detectsOverflowInBothOperatorsAndEvaluatesBothBranches() {
        assertThrows(ArithmeticException.class, () -> challenge.evaluate(new ExpressionEvaluator.Add(
            new ExpressionEvaluator.Literal(Long.MAX_VALUE), new ExpressionEvaluator.Literal(1))));
        var overflowing = new ExpressionEvaluator.Multiply(
            new ExpressionEvaluator.Literal(Long.MAX_VALUE), new ExpressionEvaluator.Literal(2));
        assertThrows(ArithmeticException.class, () -> challenge.evaluate(overflowing));
        assertThrows(ArithmeticException.class, () -> challenge.evaluate(new ExpressionEvaluator.Multiply(
            new ExpressionEvaluator.Literal(0), overflowing)));
    }
}
