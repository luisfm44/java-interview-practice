# Ruta de práctica hacia Java 25 experto

Sigue primero el [orden completo de estudio](ORDEN_DE_ESTUDIO.md). Los ocho retos
pendientes viven en `src/main/java/com/interview/nivel03_avanzado/` y
`src/main/java/com/interview/nivel04_experto/`, agrupados por concepto. Están
**sin resolver**: cada `TODO` lanza `UnsupportedOperationException`. Su Javadoc
define el contrato y sus tests reflejan los mismos packages en `src/test/java`.

## Empezar desde tu ejercicio actual

En `ContainsDuplicate`, tu variante imperativa recorre pares: O(n²) tiempo y O(1)
espacio. Como calentamiento, crea una tercera variante con `HashSet` y salida
temprana: O(n) tiempo esperado y O(n) espacio. Explica qué intercambias y añade
un caso vacío, negativos y un duplicado al principio y al final.

## Ocho retos nuevos

El orden recomendado prioriza las dependencias de aprendizaje, no el número del reto.
Las estimaciones son orientativas; termina cada contrato antes de avanzar.

| Orden | Archivo / reto | Nivel | Objetivo | Tiempo orientativo |
|---|---|---|---|---|
| 1 | `CoinChange` · R06 | Avanzado · `p01_programaciondinamica` | DP, imposibilidad, contraejemplo para greedy | 45–60 min |
| 2 | `ExpressionEvaluator` · R08 | Avanzado · `p02_modelado` | `sealed`, records, patrones y exhaustividad | 45–60 min |
| 3 | `CourseSchedule` · R04 | Avanzado · `p03_grafos` | Grafos dirigidos, ciclos, orden topológico | 60 min |
| 4 | `ShortestPaths` · R05 | Avanzado · `p03_grafos` | Dijkstra, heap, aristas de peso cero y overflow | 90 min |
| 5 | `MinimumWindowSubstring` · R01 | Experto · `p01_ventanas` | Ventana deslizante y multiplicidades | 60–90 min |
| 6 | `SlidingWindowMaximum` · R02 | Experto · `p01_ventanas` | Invariante de una cola monótona | 60–90 min |
| 7 | `LruCache` · R03 | Experto · `p02_cache` | API con estado, recencia, mapa y lista doble | 90 min |
| 8 | `MedianFinder` · R07 | Experto · `p03_heaps` | Dos heaps, equilibrio y mediana incremental | 60–90 min |

`ExpressionEvaluator` usa características ya estables en Java 21. Sirven para
dominar Java moderno; las novedades específicas de 25 están en los laboratorios.

## Evaluar una solución

Desde la raíz, con `JAVA_HOME` apuntando a JDK 25:

```bash
# macOS: selección para esta terminal si tu entorno usa Java 21
export JAVA_HOME=$(/usr/libexec/java_home -v 25)

# Empieza por un reto y repite este comando mientras lo implementas
./scripts/mvn-java25.sh test -Pretos -Dtest=CoinChangeTest

# Toda la batería, incluidos los ocho retos pendientes
./scripts/mvn-java25.sh test -Pretos

# Solo la batería original: los retos pendientes quedan excluidos
./scripts/mvn-java25.sh test
```

**Al principio, los tests de retos deben fallar por los TODO.** No hay soluciones
ocultas ni tests desactivados con `@Disabled`. La etiqueta JUnit `reto` queda
excluida por defecto y el perfil Maven `retos` la habilita. Si ejecutas un test
directamente desde el IDE, también evaluará el TODO y fallará hasta resolverlo.
Los informes Maven están en `target/surefire-reports/`.

Los tests comprueban ejemplos, entradas límite, contratos y errores frecuentes.
En `MedianFinder` comparan además 200 inserciones reproducibles con un oráculo
basado en ordenar. **Pasar los tests no demuestra la complejidad pedida ni el
dominio experto**: revisa tu algoritmo y justifica sus invariantes.

## Autoevaluación por reto: 10 puntos

| Criterio | Puntos | Evidencia que debes producir |
|---|---:|---|
| Corrección | 4 | Todos los tests del reto pasan sin modificar su contrato |
| Casos propios | 2 | Dos tests relevantes nuevos y un contraejemplo para una solución ingenua |
| Complejidad | 2 | Análisis de tiempo/espacio y por qué mantienes el invariante |
| Diseño Java | 1 | API y estructuras adecuadas, sin mutaciones no permitidas |
| Explicación | 1 | Explicas la solución y sus límites en cinco minutos sin leer código |

Objetivo para avanzar: al menos 8/10, con los cuatro puntos de corrección.
Esta puntuación es una guía manual; Maven solo evalúa los tests.

## Progresión más allá de entrevistas

1. **Algoritmos y colecciones.** Completa los ocho retos. Domina `equals/hashCode`,
   comparadores, genéricos (`? extends` / `? super`) e inmutabilidad. En LRU, explica
   por qué una vista mutable expuesta podría romper el invariante.
2. **Lenguaje y APIs modernas.** Ejecuta y amplía los seis laboratorios estables
   de [Java 25](JAVA25_LABS.md). Explica qué versión introdujo cada característica.
3. **Concurrencia.** Amplía los laboratorios de `ScopedValue`, `StableValue` y
   `StructuredTaskScope`. Documenta visibilidad, cancelación, interrupción y
   happens-before. Contrasta virtual threads para espera de I/O con trabajo CPU.
4. **JVM y rendimiento.** Perfila un escenario reproducible con JFR. Para comparar
   algoritmos usa JMH, con warmup, forks y consumo de resultados; registra versión,
   heap, GC y dataset. No uses un único `nanoTime()` como conclusión de rendimiento.
5. **Proyecto final.** Construye un agregador de catálogo, precio y stock mediante
   tres proveedores simulados e inyectables. Usa records, validación, caché acotada,
   contexto de petición, plazo global y cancelación. Empieza con APIs definitivas;
   compara después una variante con structured concurrency preview de Java 25.

Para evaluar el proyecto final, demuestra: mismo resultado ante concurrencia,
proveedor fallido, timeout, limpieza del contexto y cierre de tareas. Usa latches
y proveedores falsos para coordinar tests. Entrega análisis de complejidad, un
perfil JFR y una explicación de cuándo no usarías tu diseño.

## Registro personal

Marca cada reto al acabar y guarda tu evidencia en tus propias notas:

- [ ] R06 CoinChange
- [ ] R08 ExpressionEvaluator
- [ ] R04 CourseSchedule
- [ ] R05 ShortestPaths
- [ ] R01 MinimumWindowSubstring
- [ ] R02 SlidingWindowMaximum
- [ ] R03 LruCache
- [ ] R07 MedianFinder
- [ ] Seis laboratorios estables y sus extensiones
- [ ] Tres laboratorios preview y sus extensiones
- [ ] Proyecto final con pruebas de concurrencia y medición
