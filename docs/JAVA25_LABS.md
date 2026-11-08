# Laboratorios evaluables de Java 25

Nueve programas pequeños con una implementación de ejemplo y comprobaciones
ejecutables. Primero lee el objetivo, predice el resultado, ejecútalo y después
implementa la extensión propuesta conservando las comprobaciones originales.
Los fallos lanzan `AssertionError`: no necesitas activar `-ea`.

## Ejecutar

Necesitas **JDK 25 exactamente**, especialmente para las previews de esa versión.
Los scripts respetan `JAVA_HOME` y validan la versión. Si no está definido,
buscan JDK 25 en macOS y usan `java` del `PATH` en otros sistemas.

```bash
# macOS, si JAVA_HOME apunta a otro JDK:
export JAVA_HOME=$(/usr/libexec/java_home -v 25)

./scripts/java25-labs.sh             # seis estables
./scripts/java25-labs.sh preview     # tres preview
./scripts/java25-labs.sh all         # los nueve, de básico a experto
./scripts/java25-labs.sh nivel01_basico # solo ejecución y módulos
./scripts/java25-labs.sh ScopedValuesLab
./scripts/java25-labs.sh StructuredConcurrencyLab
```

Cada programa imprime `OK` solo si termina sus comprobaciones. El script se
detiene con un código distinto de cero ante un fallo. Usa el lanzador de archivos
fuente; no necesita Maven ni genera clases dentro de `src/`. Los programas están
en `labs/com/interview/java25/`, separados del build Maven y de sus ajustes del IDE.
Se organizan por **nivel → concepto**, igual que los ejercicios principales.
El script respeta ese orden incluso al filtrar estables o previews.

Los archivos con clase explícita declaran su package
`com.interview.java25.<nivel>.<concepto>`. `CompactMainLab` es la excepción:
los archivos compactos utilizan el package sin nombre, por lo que se ordena por
su carpeta de nivel y concepto. Consulta la [ruta completa](ORDEN_DE_ESTUDIO.md).

También puedes ejecutar un archivo directamente con el `java` de JDK 25:

```bash
java --source 25 labs/com/interview/java25/nivel01_basico/p01_ejecucion/CompactMainLab.java
java --enable-preview --source 25 labs/com/interview/java25/nivel03_avanzado/p01_patrones/PrimitivePatternsLab.java
```

## Estado de cada característica en JDK 25

| Nivel / concepto | Laboratorio | Característica | Estado en 25 | Qué evalúa |
|---|---|---|---|---|
| `nivel01_basico/p01_ejecucion` | [CompactMainLab](../labs/com/interview/java25/nivel01_basico/p01_ejecucion/CompactMainLab.java) | JEP 512 · Compact Source Files and Instance Main Methods | Definitiva en 25 | Archivo compacto, `main` de instancia e `IO.println` |
| `nivel01_basico/p02_modulos` | [ModuleImportsLab](../labs/com/interview/java25/nivel01_basico/p02_modulos/ModuleImportsLab.java) | JEP 511 · Module Import Declarations | Definitiva en 25 | Tipos exportados de varios paquetes con `import module` |
| `nivel02_intermedio/p01_constructores` | [FlexibleConstructorsLab](../labs/com/interview/java25/nivel02_intermedio/p01_constructores/FlexibleConstructorsLab.java) | JEP 513 · Flexible Constructor Bodies | Definitiva en 25 | Validar y normalizar antes de `super` |
| `nivel02_intermedio/p02_streams` | [StreamGatherersLab](../labs/com/interview/java25/nivel02_intermedio/p02_streams/StreamGatherersLab.java) | JEP 485 · Stream Gatherers | Definitiva **desde 24** | Ventanas completas y entradas cortas |
| `nivel03_avanzado/p01_patrones` | [PrimitivePatternsLab](../labs/com/interview/java25/nivel03_avanzado/p01_patrones/PrimitivePatternsLab.java) | JEP 507 · Primitive Types in Patterns | Tercera preview | Rangos y conversiones exactas de primitivos |
| `nivel03_avanzado/p02_criptografia` | [KeyDerivationLab](../labs/com/interview/java25/nivel03_avanzado/p02_criptografia/KeyDerivationLab.java) | JEP 510 · Key Derivation Function API | Definitiva en 25 | HKDF-SHA256 frente a vector RFC conocido |
| `nivel03_avanzado/p03_contexto` | [ScopedValuesLab](../labs/com/interview/java25/nivel03_avanzado/p03_contexto/ScopedValuesLab.java) | JEP 506 · Scoped Values | Definitiva en 25 | Binding, rebinding y limpieza al fallar |
| `nivel04_experto/p01_inicializacion` | [StableValuesLab](../labs/com/interview/java25/nivel04_experto/p01_inicializacion/StableValuesLab.java) | JEP 502 · Stable Values | Preview | Inicialización lazy única ante 100 tareas virtuales |
| `nivel04_experto/p02_concurrencia` | [StructuredConcurrencyLab](../labs/com/interview/java25/nivel04_experto/p02_concurrencia/StructuredConcurrencyLab.java) | JEP 505 · Structured Concurrency | Quinta preview | Composición, fallo y cancelación de la tarea hermana |

Las previews requieren habilitación explícita y su diseño puede cambiar en otras
versiones. `StructuredConcurrencyLab` usa la API de 25 (`open`, `fork`, `join`,
`Joiner`), que difiere de ejemplos antiguos con `ShutdownOnFailure`.
Virtual threads son definitivos desde Java 21; aquí se usan como herramienta.

La tabla cubre las características de estos laboratorios, no todos los cambios
de JDK 25. PEM Encodings es otra preview; Vector API sigue en incubación y usa
un módulo explícito (`jdk.incubator.vector`). Las mejoras de GC, JFR y AOT tienen
una evaluación distinta: requieren cargas y mediciones reproducibles.

## Extensiones para demostrar dominio

### 1. Compact Source Files: una pequeña CLI

Transforma el programa en `void main(String[] args)` y cuenta números distintos
pasados como argumentos. Para cero argumentos imprime cero; para un argumento
no numérico imprime un mensaje claro. Conserva `countDistinct` y sus casos.
Ejecuta directamente el archivo para pasar argumentos.

**Criterio:** explicas cuándo una clase y un paquete explícitos ayudan a
organizar una aplicación que crece.

Fuente para archivos compactos, imports de módulos, constructores y patrones primitivos:
[Cambios del lenguaje Java 25](https://docs.oracle.com/en/java/javase/25/language/java-language-changes-summary.html).

### 2. Module Imports: alcance y ambigüedad

Sustituye temporalmente el import de módulo por imports explícitos y compara.
Prueba la ambigüedad de `Date` entre `java.base` y `java.sql`: agrega
`import module java.sql;` y usa `Date` sin calificar; después resuélvelo con
`import java.util.Date;` o con el nombre completo del tipo que deseas utilizar.

**Criterio:** explicas que importar un módulo no equivale a declarar `requires`
en un `module-info.java` ni da acceso a paquetes no exportados.

### 3. Flexible Constructor Bodies: validación temprana

Añade un contador de construcciones a la superclase. Comprueba que las entradas
inválidas no llegan a su constructor y que la válida incrementa una sola vez.
Intenta llamar un método de instancia antes de `super`, observa el error de
compilación y retira ese cambio antes de dejar el laboratorio terminado.

**Criterio:** distingues cálculos sobre parámetros del acceso a la instancia en
construcción y justificas dónde debe vivir cada validación.

### 4. Gatherers: del ejemplo a un flujo propio

Implementa media móvil sin crear listas de ventanas completas y compara su
memoria con el ejemplo. Decide cómo tratar prefijos incompletos y añade casos
con negativos y valores extremos. La versión entregada solo acepta ventanas
completas y omite el prefijo corto que puede emitir `windowSliding`.

**Criterio:** explicas por qué usar la API no garantiza por sí solo el coste
óptimo: promediar cada ventana vuelve a recorrer sus elementos.

Fuente: [Gatherers, disponible desde Java 24](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/stream/Gatherers.html).

### 5. Primitive Patterns: conversión exacta

Añade los límites `-128`, `-129`, `32767` y `32768`. Explora un `long` alrededor
de 2⁵³ al comprobar representabilidad exacta como `double`. Contrasta el
resultado del patrón con un cast que pierde precisión.

**Criterio:** predices el resultado antes de ejecutar y explicas por qué
`16_777_217` no coincide con el patrón `float`.

### 6. KDF: separar contextos

Deriva dos salidas de 32 bytes con el mismo material de entrada y salt, pero
distintos valores `info` (`catalog` y `billing`, codificados en UTF-8). Verifica
longitud, determinismo y diferencia. Mantén el vector de prueba original.

**Criterio:** explicas las fases extract/expand y el papel de `info`. El material
del ejemplo es público y solo sirve para tests. HKDF no sustituye una función
de almacenamiento de contraseñas diseñada para ese fin.

Fuentes: [KDF, Java 25](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/javax/crypto/KDF.html),
[RFC 5869, caso A.1](https://www.rfc-editor.org/rfc/rfc5869.html#appendix-A.1).

### 7. Scoped Values: contexto de petición

Añade un record `RequestContext(requestId, tenantId)`. Ejecuta dos peticiones en
virtual threads, cada una con su binding, y verifica que no se mezclan. Conserva
el test de excepción y añade rebinding que falle. Un virtual thread creado
directamente no hereda automáticamente el binding: establece el contexto dentro
de cada tarea; la herencia estructurada se explora con `StructuredTaskScope`.

**Criterio:** puedes explicar la duración del binding, su restauración y por qué
un valor vinculado puede seguir siendo mutable si eliges un objeto mutable.

Fuente: [ScopedValue, Java 25](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/lang/ScopedValue.html).

### 8. Stable Values: fallos durante inicialización

Haz que el primer supplier falle y el siguiente produzca un objeto. Comprueba
que el fallo deja el valor sin inicializar y que un intento posterior puede
completarlo. Conserva la prueba concurrente de identidad y contador.

**Criterio:** distingues la inicialización exitosa única de las reevaluaciones
posibles tras un fallo; no concluyes que un objeto almacenado sea profundamente
inmutable o seguro entre hilos por estar en un `StableValue`.

Fuente: [StableValue, Java 25 preview](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/lang/StableValue.html).

### 9. Structured Concurrency: plazo y políticas de resultado

Haz configurable el timeout. Añade una tarea que espera en un latch, verifica
`StructuredTaskScope.TimeoutException` y demuestra que su hilo fue interrumpido.
Después crea una variante con `Joiner.anySuccessfulResultOrThrow()` y prueba
dos fallos, un éxito y un fallo, y dos éxitos. Inyecta tareas locales, sin HTTP.

**Criterio:** pruebas que no quedan tareas vivas después del cierre; explicas
por qué una tarea que ignora interrupciones puede retrasarlo incluso con timeout.

Fuentes: [StructuredTaskScope](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/concurrent/StructuredTaskScope.html),
[Joiner](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/concurrent/StructuredTaskScope.Joiner.html).

## Cómo evaluar cada extensión

Una extensión está terminada cuando conserva las comprobaciones originales,
añade las comprobaciones nuevas descritas y puedes explicar el criterio sin
mirar el código. Los `OK` del ejemplo inicial prueban únicamente sus casos
incluidos; las extensiones no se evalúan automáticamente hasta que añadas sus
comprobaciones. Usa la rúbrica de [la ruta de retos](RETOS_JAVA25.md).
