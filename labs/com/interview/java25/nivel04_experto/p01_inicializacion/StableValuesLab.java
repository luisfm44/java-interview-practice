package com.interview.java25.nivel04_experto.p01_inicializacion;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;
import java.util.concurrent.Future;

// JEP 502: preview en Java 25. orElseSet garantiza inicialización exitosa única.
class StableValuesLab {
    void main() throws Exception {
        var initializations = new AtomicInteger();
        StableValue<Object> value = StableValue.of();
        var start = new CountDownLatch(1);
        var futures = new ArrayList<Future<Object>>();
        if (value.isSet()) throw new AssertionError("Debe ser lazy");
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            try {
                for (int i = 0; i < 100; i++) {
                    futures.add(executor.submit(() -> {
                        start.await();
                        return value.orElseSet(() -> {
                            initializations.incrementAndGet();
                            return new Object();
                        });
                    }));
                }
                start.countDown();
                Object first = futures.getFirst().get(5, TimeUnit.SECONDS);
                for (var future : futures) {
                    if (future.get(5, TimeUnit.SECONDS) != first) throw new AssertionError("Identidades distintas");
                }
                if (initializations.get() != 1) throw new AssertionError("Inicialización duplicada");
            } finally {
                start.countDown();
                futures.forEach(future -> future.cancel(true));
            }
        }
        System.out.println("OK: 100 tareas virtuales comparten una única instancia lazy");
    }
}
