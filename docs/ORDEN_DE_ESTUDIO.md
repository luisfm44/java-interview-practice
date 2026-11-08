# Orden de estudio: de básico a experto

La estructura usa **nivel → concepto → ejercicio**. Los niveles `nivel01` a
`nivel04` y los conceptos `p01`, `p02`, etc. se ordenan alfabéticamente en el IDE.
Dentro de cada concepto sigue el orden de esta guía y de su `package-info.java`;
los nombres de las clases conservan el nombre del problema, por lo que su orden
alfabético no representa su dificultad.

La clasificación representa una progresión didáctica: algunos problemas de
entrevista considerados fáciles aparecen en intermedio porque introducen una
estructura o técnica nueva. Cada concepto continúa en niveles superiores cuando
requiere invariantes más exigentes, como ventanas, DP o grafos.

`src/test/java` refleja los mismos packages que `src/main/java`. `common` contiene
únicamente los nodos reutilizables; `integracion` agrupa el test que combina
variantes de varios conceptos. Los ocho retos nuevos conservan sus TODO y sus
etiquetas `reto`, aunque ahora viven en el package de su concepto.

## 01. Básico

Recorridos, arrays, strings, conjuntos y mapas.

| Concepto / package | Ejercicios, en orden |
|---|---|
| `p01_arrays` · Arrays y recorridos | [PlusOne](../src/main/java/com/interview/nivel01_basico/p01_arrays/PlusOne.java) → [MissingNumber](../src/main/java/com/interview/nivel01_basico/p01_arrays/MissingNumber.java) |
| `p02_strings` · Strings y caracteres | [LengthOfLastWord](../src/main/java/com/interview/nivel01_basico/p02_strings/LengthOfLastWord.java) → [ReverseString](../src/main/java/com/interview/nivel01_basico/p02_strings/ReverseString.java) → [LongestCommonPrefix](../src/main/java/com/interview/nivel01_basico/p02_strings/LongestCommonPrefix.java) |
| `p03_conjuntos` · Conjuntos y valores distintos | [ContainsDuplicate](../src/main/java/com/interview/nivel01_basico/p03_conjuntos/ContainsDuplicate.java) → [CountUniqueNumbers](../src/main/java/com/interview/nivel01_basico/p03_conjuntos/CountUniqueNumbers.java) → [FirstDuplicate](../src/main/java/com/interview/nivel01_basico/p03_conjuntos/FirstDuplicate.java) → [IntersectionOfTwoArrays](../src/main/java/com/interview/nivel01_basico/p03_conjuntos/IntersectionOfTwoArrays.java) |
| `p04_mapas` · Mapas y frecuencias | [FrecuenciaTecnologica](../src/main/java/com/interview/nivel01_basico/p04_mapas/FrecuenciaTecnologica.java) → [MostFrequentTechnology](../src/main/java/com/interview/nivel01_basico/p04_mapas/MostFrequentTechnology.java) → [ValidAnagram](../src/main/java/com/interview/nivel01_basico/p04_mapas/ValidAnagram.java) → [FirstUniqueCharacter](../src/main/java/com/interview/nivel01_basico/p04_mapas/FirstUniqueCharacter.java) → [TwoSum](../src/main/java/com/interview/nivel01_basico/p04_mapas/TwoSum.java) |

## 02. Intermedio

Búsqueda, dos punteros, estructuras y patrones algorítmicos.

| Concepto / package | Ejercicios, en orden |
|---|---|
| `p01_busqueda` · Búsqueda en arrays y strings | [BinarySearch](../src/main/java/com/interview/nivel02_intermedio/p01_busqueda/BinarySearch.java) → [StrStr](../src/main/java/com/interview/nivel02_intermedio/p01_busqueda/StrStr.java) |
| `p02_dospunteros` · Dos punteros y transformaciones in situ | [MoveZeroes](../src/main/java/com/interview/nivel02_intermedio/p02_dospunteros/MoveZeroes.java) → [RemoveDuplicatesFromSortedArray](../src/main/java/com/interview/nivel02_intermedio/p02_dospunteros/RemoveDuplicatesFromSortedArray.java) → [MergeSortedArray](../src/main/java/com/interview/nivel02_intermedio/p02_dospunteros/MergeSortedArray.java) → [IsSubsequence](../src/main/java/com/interview/nivel02_intermedio/p02_dospunteros/IsSubsequence.java) → [ValidPalindrome](../src/main/java/com/interview/nivel02_intermedio/p02_dospunteros/ValidPalindrome.java) → [ReverseWords](../src/main/java/com/interview/nivel02_intermedio/p02_dospunteros/ReverseWords.java) → [ValidPalindromeII](../src/main/java/com/interview/nivel02_intermedio/p02_dospunteros/ValidPalindromeII.java) → [RotateArray](../src/main/java/com/interview/nivel02_intermedio/p02_dospunteros/RotateArray.java) |
| `p03_pilas` · Pilas y delimitadores anidados | [ValidParentheses](../src/main/java/com/interview/nivel02_intermedio/p03_pilas/ValidParentheses.java) |
| `p04_listas` · Listas enlazadas | [ReverseLinkedList](../src/main/java/com/interview/nivel02_intermedio/p04_listas/ReverseLinkedList.java) |
| `p05_arboles` · Árboles y recursión | [InvertBinaryTree](../src/main/java/com/interview/nivel02_intermedio/p05_arboles/InvertBinaryTree.java) |
| `p06_agrupacion` · Agrupación por claves derivadas | [GroupAnagrams](../src/main/java/com/interview/nivel02_intermedio/p06_agrupacion/GroupAnagrams.java) |
| `p07_greedy` · Decisiones locales e invariantes | [BestTimeToBuyAndSellStock](../src/main/java/com/interview/nivel02_intermedio/p07_greedy/BestTimeToBuyAndSellStock.java) → [MajorityElement](../src/main/java/com/interview/nivel02_intermedio/p07_greedy/MajorityElement.java) |
| `p08_ventanas` · Ventanas deslizantes | [LongestSubstringWithoutRepeating](../src/main/java/com/interview/nivel02_intermedio/p08_ventanas/LongestSubstringWithoutRepeating.java) |
| `p09_intervalos` · Intervalos y concurrencia de eventos | [NumAvailableServers](../src/main/java/com/interview/nivel02_intermedio/p09_intervalos/NumAvailableServers.java) |
| `p10_programaciondinamica` · Programación dinámica con estado mínimo | [MaxSubarray](../src/main/java/com/interview/nivel02_intermedio/p10_programaciondinamica/MaxSubarray.java) |

## 03. Avanzado

Programación dinámica, modelado y grafos con dependencias.

| Concepto / package | Ejercicios, en orden |
|---|---|
| `p01_programaciondinamica` · Programación dinámica con múltiples decisiones | [CoinChange](../src/main/java/com/interview/nivel03_avanzado/p01_programaciondinamica/CoinChange.java) **TODO** |
| `p02_modelado` · Modelado inmutable y patrones exhaustivos | [ExpressionEvaluator](../src/main/java/com/interview/nivel03_avanzado/p02_modelado/ExpressionEvaluator.java) **TODO** |
| `p03_grafos` · Grafos dirigidos y caminos mínimos | [CourseSchedule](../src/main/java/com/interview/nivel03_avanzado/p03_grafos/CourseSchedule.java) **TODO** → [ShortestPaths](../src/main/java/com/interview/nivel03_avanzado/p03_grafos/ShortestPaths.java) **TODO** |

## 04. Experto

Ventanas óptimas y estructuras con invariantes y costes exigentes.

| Concepto / package | Ejercicios, en orden |
|---|---|
| `p01_ventanas` · Ventanas óptimas y colas monótonas | [MinimumWindowSubstring](../src/main/java/com/interview/nivel04_experto/p01_ventanas/MinimumWindowSubstring.java) **TODO** → [SlidingWindowMaximum](../src/main/java/com/interview/nivel04_experto/p01_ventanas/SlidingWindowMaximum.java) **TODO** |
| `p02_cache` · Caché LRU y estructuras combinadas | [LruCache](../src/main/java/com/interview/nivel04_experto/p02_cache/LruCache.java) **TODO** |
| `p03_heaps` · Heaps y estadísticas incrementales | [MedianFinder](../src/main/java/com/interview/nivel04_experto/p03_heaps/MedianFinder.java) **TODO** |

## Cómo seguir el recorrido

1. Recorre los niveles y sus conceptos en el orden de esta página.
2. Dentro de cada concepto, resuelve los ejercicios de izquierda a derecha.
3. Antes de pasar al siguiente, explica la estructura elegida, la complejidad y
   los casos límite. Añade un caso propio y ejecuta el test correspondiente.
4. Para los retos con TODO, activa `-Pretos`. Usa la
   [rúbrica de evaluación](RETOS_JAVA25.md) para revisar tu solución.
5. En paralelo, sigue los [laboratorios Java 25](JAVA25_LABS.md) en el mismo orden
   de niveles. El proyecto final llega después de los niveles avanzados.

Ejemplos desde la raíz con JDK 25:

```bash
# Tu ejercicio actual, ahora en nivel01_basico/p03_conjuntos
./scripts/mvn-java25.sh test -Dtest=ContainsDuplicateTest

# Todos los ejercicios del nivel básico
./scripts/mvn-java25.sh test '-Dtest=com/interview/nivel01_basico/**/*Test,!**/._*'

# Un reto avanzado pendiente
./scripts/mvn-java25.sh test -Pretos -Dtest=CoinChangeTest

# Java 25: laboratorios de un nivel o todos en orden
./scripts/java25-labs.sh nivel01_basico
./scripts/java25-labs.sh all
```

Las implementaciones existentes y los contratos se conservan. Este cambio
reorganiza los packages; no completa los retos pendientes ni cambia su dificultad
algorítmica. El siguiente paso de tu archivo actual es
[ContainsDuplicate](../src/main/java/com/interview/nivel01_basico/p03_conjuntos/ContainsDuplicate.java).
