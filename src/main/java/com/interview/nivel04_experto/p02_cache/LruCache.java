package com.interview.nivel04_experto.p02_cache;

/**
 * R03 · Difícil · Diseña una caché de int -> int con get/put O(1) promedio.
 * get devuelve -1 si falta la clave; tanto get exitoso como put actualizan la recencia.
 * Al exceder capacidad expulsa la entrada menos recientemente usada.
 * Capacidad <= 0: IllegalArgumentException. No requiere seguridad entre hilos.
 * Bonus: resuélvelo sin LinkedHashMap, con mapa + lista doblemente enlazada.
 */
public class LruCache {
    public LruCache(int capacity) {
        throw new UnsupportedOperationException("TODO R03: inicializar capacidad y estructuras");
    }

    public int get(int key) {
        throw new UnsupportedOperationException("TODO R03: consultar y actualizar recencia");
    }

    public void put(int key, int value) {
        throw new UnsupportedOperationException("TODO R03: insertar y expulsar LRU");
    }
}
