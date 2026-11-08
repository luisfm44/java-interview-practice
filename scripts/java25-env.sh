#!/usr/bin/env bash
# Compartido por Maven y los laboratorios; no modifica la configuración del usuario.
if [[ -z "${JAVA_HOME:-}" && -x /usr/libexec/java_home ]]; then
    export JAVA_HOME="$(/usr/libexec/java_home -v 25)"
fi
if [[ -n "${JAVA_HOME:-}" ]]; then
    export PATH="$JAVA_HOME/bin:$PATH"
fi

java25_version="$(java -XshowSettings:properties -version 2>&1)"
if ! [[ "$java25_version" =~ java.specification.version[[:space:]]*=[[:space:]]*25([[:space:]]|$) ]]; then
    echo "Se requiere JDK 25. El Java seleccionado es:" >&2
    java -version >&2
    echo 'Configura JAVA_HOME con tu JDK 25; en macOS: export JAVA_HOME=$(/usr/libexec/java_home -v 25)' >&2
    return 1
fi
