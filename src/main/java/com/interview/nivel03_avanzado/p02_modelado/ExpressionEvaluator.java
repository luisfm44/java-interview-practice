package com.interview.nivel03_avanzado.p02_modelado;

/**
 * R08 · Avanzado · Modelado con sealed/record y switch exhaustivo (estables desde Java 21).
 * Evalúa el árbol inmutable usando pattern matching y record patterns, sin instanceof encadenados.
 * Usa Math.addExact / Math.multiplyExact para lanzar ArithmeticException en overflow.
 * Evalúa ambas ramas; las expresiones no contienen null. O(n) tiempo, O(altura) pila.
 * Bonus: añade Negate y comprueba que el compilador obliga a cubrir el nuevo subtipo.
 */
public class ExpressionEvaluator {
    public sealed interface Expression permits Literal, Add, Multiply {}
    public record Literal(long value) implements Expression {}
    public record Add(Expression left, Expression right) implements Expression {}
    public record Multiply(Expression left, Expression right) implements Expression {}

    public long evaluate(Expression expression) {
        throw new UnsupportedOperationException("TODO R08: implementar switch exhaustivo");
    }
}
