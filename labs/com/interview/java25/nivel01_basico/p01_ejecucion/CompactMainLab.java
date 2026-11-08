// JEP 512: archivo compacto y main de instancia, definitivos en Java 25.
// Sin declaración explícita de clase. IO y tipos públicos de java.base disponibles.
int countDistinct(List<Integer> values) {
    return new HashSet<>(values).size();
}

void main() {
    if (countDistinct(List.of(1, 2, 1, 3)) != 3) throw new AssertionError("Distintos");
    if (countDistinct(List.of()) != 0) throw new AssertionError("Vacío");
    IO.println("OK: archivo compacto, método de instancia e IO.println");
}
