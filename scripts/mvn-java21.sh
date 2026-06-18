#!/usr/bin/env bash
set -euo pipefail

export JAVA_HOME="${JAVA_HOME:-/Users/luisfelipemarincano/Library/Java/JavaVirtualMachines/ms-21.0.8/Contents/Home}"
cd "$(dirname "$0")/.."

echo "Usando Java: $($JAVA_HOME/bin/java -version 2>&1 | head -1)"
mvn "$@"
