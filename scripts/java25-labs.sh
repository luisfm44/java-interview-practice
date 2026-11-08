#!/usr/bin/env bash
set -euo pipefail
source "$(dirname "$0")/java25-env.sh"
cd "$(dirname "$0")/.."

usage() {
    echo "Uso: $0 [stable|preview|all|nivel01_basico|nivel02_intermedio|nivel03_avanzado|nivel04_experto|NombreDelLaboratorio]" >&2
    exit 2
}
[[ $# -le 1 ]] || usage

# Orden de aprendizaje; el estado preview es independiente de la dificultad.
labs=(
    "stable:nivel01_basico/p01_ejecucion/CompactMainLab.java"
    "stable:nivel01_basico/p02_modulos/ModuleImportsLab.java"
    "stable:nivel02_intermedio/p01_constructores/FlexibleConstructorsLab.java"
    "stable:nivel02_intermedio/p02_streams/StreamGatherersLab.java"
    "preview:nivel03_avanzado/p01_patrones/PrimitivePatternsLab.java"
    "stable:nivel03_avanzado/p02_criptografia/KeyDerivationLab.java"
    "stable:nivel03_avanzado/p03_contexto/ScopedValuesLab.java"
    "preview:nivel04_experto/p01_inicializacion/StableValuesLab.java"
    "preview:nivel04_experto/p02_concurrencia/StructuredConcurrencyLab.java"
)
selection="${1:-stable}"
count=0
for entry in "${labs[@]}"; do
    status="${entry%%:*}"
    relative="${entry#*:}"
    name="${relative##*/}"
    name="${name%.java}"
    if [[ "$selection" == all || "$selection" == "$status" || "$selection" == "$name" || "$relative" == "$selection/"* ]]; then
        file="labs/com/interview/java25/$relative"
        echo "Evaluando $file ($status)"
        if [[ "$status" == preview ]]; then
            java --enable-preview --source 25 "$file"
        else
            java --source 25 "$file"
        fi
        count=$((count + 1))
    fi
done
[[ $count -gt 0 ]] || usage
echo "OK: laboratorios superados: $count."
