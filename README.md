# Java Interview Practice

Proyecto Maven con **Java 21** para practicar ejercicios típicos de entrevistas técnicas.

## Requisitos

- JDK 21
- Maven 3.8+

## Estructura

```
src/main/java/com/interview/
├── arrays/        # Two Sum (resuelto), Max Subarray, Binary Search
├── strings/       # Valid Anagram, Reverse String
├── linkedlist/    # Reverse Linked List
├── stacks/        # Valid Parentheses
├── trees/         # Invert Binary Tree
└── common/        # ListNode, TreeNode
```

Cada ejercicio tiene tests en `src/test/java`. Solo **Two Sum** viene resuelto como referencia; el resto tiene un `TODO` para que lo implementes.

## Cómo practicar

1. Abre la carpeta `java-interview-practice` en Cursor.
2. Instala **Extension Pack for Java** si no lo tienes.
3. Elige un ejercicio (por ejemplo `MaxSubarray.java`).
4. Implementa el método marcado con `TODO`.
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

Si tu `JAVA_HOME` por defecto no es Java 21, el script `mvn-java21.sh` lo fuerza a JDK 21.

## Ejercicios incluidos

| Tema | Ejercicio | Dificultad |
|------|-----------|------------|
| Arrays | Two Sum | Fácil (resuelto) |
| Arrays | Maximum Subarray | Medio |
| Arrays | Binary Search | Fácil |
| Strings | Valid Anagram | Fácil |
| Strings | Reverse String | Fácil |
| Linked List | Reverse Linked List | Fácil |
| Stacks | Valid Parentheses | Fácil |
| Trees | Invert Binary Tree | Fácil |

## Siguiente paso

Cuando termines estos, puedes pedir más ejercicios por tema (grafos, DP, sliding window, etc.) y los agregamos al proyecto.
