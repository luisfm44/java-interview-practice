package com.interview.java25.nivel02_intermedio.p01_constructores;

// JEP 513: validación y cálculos antes de super(...), definitivo en Java 25.
class FlexibleConstructorsLab {
    static class Account {
        final String owner;
        Account(String owner) { this.owner = owner; }
    }

    static class PremiumAccount extends Account {
        final int limit;
        PremiumAccount(String owner, int limit) {
            // Antes de super no se puede usar libremente la instancia en construcción.
            if (owner == null || owner.isBlank() || limit <= 0) {
                throw new IllegalArgumentException("Titular y límite inválidos");
            }
            String normalized = owner.strip();
            super(normalized);
            this.limit = limit;
        }
    }

    void main() {
        var account = new PremiumAccount("  Ada  ", 100);
        if (!account.owner.equals("Ada") || account.limit != 100) throw new AssertionError("Normalización");
        for (String owner : new String[] {null, "", "   "}) {
            try {
                new PremiumAccount(owner, 1);
                throw new AssertionError("Se aceptó titular inválido");
            } catch (IllegalArgumentException expected) { /* contrato */ }
        }
        try {
            new PremiumAccount("Ada", 0);
            throw new AssertionError("Se aceptó límite inválido");
        } catch (IllegalArgumentException expected) { /* contrato */ }
        System.out.println("OK: constructor valida antes de invocar super");
    }
}
