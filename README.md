# Java Interview Practice

Proyecto Maven con **Java 25** organizado para estudiar de menor a mayor
complejidad: **nivel → concepto → ejercicio**.

Empieza por el **[orden completo de estudio](docs/ORDEN_DE_ESTUDIO.md)**: contiene
los 41 ejercicios, sus enlaces y el orden dentro de cada concepto. Cada package
de ejercicios incluye un `package-info.java` con su objetivo y recorrido recomendado.

## Estructura por dificultad y concepto

```text
src/main/java/com/interview/
├── nivel01_basico/
│   ├── p01_arrays/
│   ├── p02_strings/
│   ├── p03_conjuntos/             # ContainsDuplicate está aquí
│   └── p04_mapas/
├── nivel02_intermedio/
│   ├── p01_busqueda/
│   ├── p02_dospunteros/
│   ├── p03_pilas/
│   ├── p04_listas/
│   ├── p05_arboles/
│   ├── p06_agrupacion/
│   ├── p07_greedy/
│   ├── p08_ventanas/
│   ├── p09_intervalos/
│   └── p10_programaciondinamica/
├── nivel03_avanzado/
│   ├── p01_programaciondinamica/
│   ├── p02_modelado/
│   └── p03_grafos/
├── nivel04_experto/
│   ├── p01_ventanas/
│   ├── p02_cache/
│   └── p03_heaps/
└── common/                       # ListNode y TreeNode reutilizables
```

Los tests en `src/test/java/com/interview/` reflejan los mismos niveles y
conceptos. `integracion/FunctionalVariantsTest` comprueba variantes de varios
packages. Los números de los niveles y conceptos marcan el orden; dentro de cada
package sigue la guía, ya que las clases conservan sus nombres originales.

Los niveles indican la complejidad de aprendizaje: un ejercicio fácil de entrevista
puede introducir una técnica que se estudia en intermedio. Algunos conceptos,
como ventanas y programación dinámica, reaparecen con mayor dificultad en los
niveles superiores.

## Cómo practicar

1. Recorre `nivel01_basico`, `nivel02_intermedio`, `nivel03_avanzado` y
   `nivel04_experto`, siguiendo `p01`, `p02`, etc.
2. Dentro de cada concepto, sigue el orden de
   [la guía](docs/ORDEN_DE_ESTUDIO.md) o de su `package-info.java`.
3. Intenta resolver el ejercicio, explica su complejidad y ejecuta su test.
4. Para los ocho retos pendientes de los niveles avanzado y experto, usa
   [los contratos y la rúbrica](docs/RETOS_JAVA25.md).
5. Practica en paralelo los [nueve laboratorios Java 25](docs/JAVA25_LABS.md),
   también organizados por nivel y concepto, con extensiones para autoevaluarte.

## Requisitos y comandos

Necesitas **JDK 25** y **Maven 3.9+**. Los scripts respetan `JAVA_HOME`; si no está
definido, buscan JDK 25 en macOS y usan el Java del `PATH` en otros sistemas.
Si el entorno selecciona otro JDK, muestran cómo corregirlo. En macOS:

```bash
export JAVA_HOME=$(/usr/libexec/java_home -v 25)
```

Desde la raíz del proyecto:

```bash
# Toda la batería de ejercicios resueltos
./scripts/mvn-java25.sh test

# Tu ejercicio actual, en nivel01_basico/p03_conjuntos
./scripts/mvn-java25.sh test -Dtest=ContainsDuplicateTest

# Todos los tests de un nivel o un concepto
./scripts/mvn-java25.sh test '-Dtest=com/interview/nivel01_basico/**/*Test,!**/._*'
./scripts/mvn-java25.sh test '-Dtest=com/interview/nivel01_basico/p03_conjuntos/*Test,!**/._*'

# Evaluar un reto pendiente
./scripts/mvn-java25.sh test -Pretos -Dtest=CoinChangeTest

# Toda la batería, incluidos los ocho retos con TODO
./scripts/mvn-java25.sh test -Pretos

# Compilar
./scripts/mvn-java25.sh compile

# Laboratorios: todos en orden, o solo los de un nivel
./scripts/java25-labs.sh all
./scripts/java25-labs.sh nivel01_basico

# Filtrar por estado de la característica o elegir un laboratorio
./scripts/java25-labs.sh stable
./scripts/java25-labs.sh preview
./scripts/java25-labs.sh ScopedValuesLab
```

En los comandos por nivel o concepto, `!**/._*` excluye los metadatos de macOS
que pueden crearse en la unidad externa al seleccionar tests con `-Dtest`.

Los tests de los retos pendientes llevan la etiqueta `reto`, excluida por defecto.
Al activar `-Pretos`, fallan hasta implementar sus `TODO`. Los laboratorios son
programas con comprobaciones ejecutables y se ejecutan por separado del build
Maven; el script habilita preview solo cuando corresponde.

## Contratos de ejercicios adicionales

- `CountUniqueNumbers`: cuenta valores distintos.
- `FirstDuplicate`: devuelve el primer valor que se repite durante el recorrido;
  devuelve `-1` si no hay repetidos.
- `FrecuenciaTecnologica`: distingue mayúsculas y minúsculas.
- `MostFrequentTechnology`: en empate gana la primera tecnología en aparecer;
  para entrada vacía devuelve `""`.
- `NumAvailableServers`: máximo de trabajos simultáneos con intervalos
  `[inicio, fin)` de duración positiva.

## Configuración del IDE

Las configuraciones compartidas de `.vscode/launch.json` apuntan a los packages
nuevos y aparecen ordenadas por nivel y concepto. También puedes ejecutar el
`main` del archivo actual. Si conservabas un archivo abierto en su ubicación
anterior, vuelve a abrirlo desde la nueva carpeta.

`target/`, los metadatos de macOS, `.vscode/settings.json` y `*.code-workspace`
quedan fuera del control de versiones. Los scripts y las configuraciones
compartidas no requieren rutas personales al JDK.
