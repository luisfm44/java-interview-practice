package com.interview.nivel02_intermedio.p03_pilas;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * LeetCode 20 - Valid Parentheses.
 * Verifica si una cadena de parentesis esta balanceada.
 *
 * PATRON: Stack (LIFO) — push aperturas, pop al cerrar y verificar par.
 */
public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("()[]{}"));
    }

    public boolean isValid(String s) {
        return isValidImperative(s);
    }

    public boolean isValidImperative(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> pairs = Map.of(')', '(', ']', '[', '}', '{');

        for (char character : s.toCharArray()) {
            if (pairs.containsKey(character)) {
                // es cierre: debe coincidir con la ultima apertura en el stack
                if (stack.isEmpty() || stack.pop() != pairs.get(character)) {
                    return false;
                }
            } else {
                stack.push(character); // es apertura: la guardamos
            }
        }
        return stack.isEmpty(); // no debe quedar ninguna apertura sin cerrar
    }

    public boolean isValidFunctional(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> pairs = Map.of(')', '(', ']', '[', '}', '{');

        boolean valid = s.chars()
            .mapToObj(character -> (char) character)
            .reduce(true, (ok, character) -> {
                if (!ok) {
                    return false;
                }
                if (pairs.containsKey(character)) {
                    return !stack.isEmpty() && stack.pop() == pairs.get(character);
                }
                stack.push(character);
                return true;
            }, (left, right) -> left && right);
        return valid && stack.isEmpty();
    }
}
