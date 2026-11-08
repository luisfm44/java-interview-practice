#!/usr/bin/env bash
set -euo pipefail

source "$(dirname "$0")/java25-env.sh"
cd "$(dirname "$0")/.."

java -version
mvn "$@"
