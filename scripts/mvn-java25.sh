#!/usr/bin/env bash
set -euo pipefail

if [[ -z "${JAVA_HOME:-}" && -x /usr/libexec/java_home ]]; then
    export JAVA_HOME="$(/usr/libexec/java_home -v 25)"
fi

if [[ -n "${JAVA_HOME:-}" ]]; then
    export PATH="$JAVA_HOME/bin:$PATH"
fi
cd "$(dirname "$0")/.."

java -version
mvn "$@"
