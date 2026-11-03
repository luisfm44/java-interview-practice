# Java Interview Practice

Proyecto Maven con **Java 21** para practicar ejercicios típicos de entrevistas técnicas.

## Requisitos

- JDK 21
- Maven 3.8+

## Estructura

```
src/main/java/com/interview/
├── arrays/        # Two Sum (resuelto), Max Subarray, Binary Search
├── strings/       # Reverse String, Valid Anagram, Valid Palindrome, y más
├── linkedlist/    # Reverse Linked List
├── stacks/        # Valid Parentheses
├── trees/         # Invert Binary Tree
└── common/        # ListNode, TreeNode
```

Repositorio de soluciones con tests JUnit en `src/test/java`. Los ejercicios originales incluyen variantes imperativas y funcionales o recursivas; los ejercicios adicionales practican conjuntos, mapas e intervalos.

## Cómo practicar

1. Abre la carpeta `java-interview-practice` en Cursor.
2. Instala **Extension Pack for Java** si no lo tienes.
3. Elige un ejercicio (por ejemplo `MaxSubarray.java`).
4. Intenta resolverlo antes de consultar la implementación y compara las alternativas.
5. Ejecuta los tests de esa clase.

## Comandos

```bash
# Desde java-interview-practice/
./scripts/mvn-java21.sh test

# Solo un ejercicio
./scripts/mvn-java21.sh test -Dtest=MaxSubarrayTest

# Compilar sin tests
./scripts/mvn-java21.sh compile
```

Puedes ejecutar `mvn test` directamente con un JDK 21 o posterior. El script respeta `JAVA_HOME`; si no está definido, busca JDK 21 en macOS y usa el Java del `PATH` en otros sistemas. No contiene rutas personales.

## Ejercicios incluidos

| Tema | Ejercicio | Dificultad |
|------|-----------|------------|
| Arrays | Two Sum | Fácil |
| Arrays | Maximum Subarray | Medio |
| Arrays | Binary Search | Fácil |
| Arrays | Contains Duplicate | Fácil |
| Arrays | Intersection of Two Arrays | Fácil |
| Arrays | Majority Element | Fácil |
| Arrays | Merge Sorted Array | Fácil |
| Arrays | Missing Number | Fácil |
| Arrays | Move Zeroes | Fácil |
| Arrays | Plus One | Fácil |
| Arrays | Best Time to Buy and Sell Stock | Fácil |
| Arrays | Remove Duplicates from Sorted Array | Fácil |
| Arrays | Rotate Array | Medio |
| Strings | Reverse String | Fácil |
| Strings | Valid Anagram | Fácil |
| Strings | Valid Palindrome | Fácil |
| Strings | First Unique Character | Fácil |
| Strings | Longest Common Prefix | Fácil |
| Strings | Is Subsequence | Fácil |
| Strings | Length of Last Word | Fácil |
| Strings | Reverse Words | Medio |
| Strings | Valid Palindrome II | Medio |
| Strings | strStr (Find Index) | Medio |
| Strings | Longest Substring Without Repeating | Medio |
| Strings | Group Anagrams | Medio |
| Linked List | Reverse Linked List | Fácil |
| Stacks | Valid Parentheses | Fácil |
| Trees | Invert Binary Tree | Fácil |

## Ejercicios adicionales

- `CountUniqueNumbers`: cantidad de valores distintos, no de valores que aparecen una sola vez.
- `FirstDuplicate`: primer valor que se repite durante el recorrido; devuelve `-1` si no hay repetidos.
- `FrecuenciaTecnologica`: mapa de frecuencias que distingue mayúsculas y minúsculas.
- `MostFrequentTechnology`: tecnología más frecuente; en empate gana la primera en aparecer y para entrada vacía devuelve `""`.
- `NumAvailableServers`: máximo de trabajos simultáneos. Usa intervalos `[inicio, fin)`, de duración positiva; un servidor queda disponible exactamente al terminar un trabajo.

## Archivos locales

`target/`, los metadatos de macOS, `.vscode/settings.json` y los archivos `*.code-workspace` quedan fuera del control de versiones. La configuración compartida de ejecución en `.vscode/launch.json` no requiere rutas locales al JDK.
