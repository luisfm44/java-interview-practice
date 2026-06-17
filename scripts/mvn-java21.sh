#!/usr/bin/env bash
set -euo pipefail

export JAVA_HOME="${JAVA_HOME:-/usr/lib/jvm/java-21-openjdk-amd64}"
cd "$(dirname "$0")/.."

echo "Usando Java: $($JAVA_HOME/bin/java -version 2>&1 | head -1)"
mvn "$@"
