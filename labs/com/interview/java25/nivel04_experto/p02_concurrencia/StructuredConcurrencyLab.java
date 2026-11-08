package com.interview.java25.nivel04_experto.p02_concurrencia;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.atomic.AtomicBoolean;
import java.time.Duration;

// JEP 505: quinta preview. API de Java 25: open/fork/join, NO ShutdownOnFailure.
class StructuredConcurrencyLab {
    String combine(Callable<String> left, Callable<String> right) throws InterruptedException {
        try (var scope = StructuredTaskScope.open(
                StructuredTaskScope.Joiner.awaitAllSuccessfulOrThrow(),
                config -> config.withTimeout(Duration.ofSeconds(5)))) {
            var first = scope.fork(left);
            var second = scope.fork(right);
            scope.join();
            return first.get() + ":" + second.get();
        }
    }

    void main() throws Exception {
        if (!combine(() -> "Ada", () -> "Java25").equals("Ada:Java25")) {
            throw new AssertionError("Composición incorrecta");
        }
        var started = new CountDownLatch(1);
        var interrupted = new AtomicBoolean();
        try {
            combine(() -> {
                started.countDown();
                try {
                    new CountDownLatch(1).await(); // Bloqueo interrumpible; sin sleeps.
                    return "unexpected";
                } catch (InterruptedException expected) {
                    interrupted.set(true);
                    throw expected;
                }
            }, () -> {
                started.await();
                throw new IllegalStateException("fallo simulado");
            });
            throw new AssertionError("Debe propagar el fallo");
        } catch (StructuredTaskScope.FailedException expected) {
            if (!(expected.getCause() instanceof IllegalStateException)) throw new AssertionError(expected);
        }
        if (!interrupted.get()) throw new AssertionError("La tarea hermana debe cancelarse");
        System.out.println("OK: composición, propagación de fallo y cancelación de tarea hermana");
    }
}
