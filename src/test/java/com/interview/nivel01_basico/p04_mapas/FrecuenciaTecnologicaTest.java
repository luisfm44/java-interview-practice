package com.interview.nivel01_basico.p04_mapas;

import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FrecuenciaTecnologicaTest {
  @Test
  void countsEachTechnologyAndDistinguishesCase() {
    assertEquals(Map.of("Java", 2, "java", 1, "AWS", 2),
        FrecuenciaTecnologica.calculateFrecuencies(new String[] {"Java", "java", "AWS", "Java", "AWS"}));
  }

  @Test
  void handlesEmptyInput() {
    assertEquals(Map.of(), FrecuenciaTecnologica.calculateFrecuencies(new String[0]));
  }
}
