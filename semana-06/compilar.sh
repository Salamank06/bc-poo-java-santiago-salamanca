#!/bin/bash
# Script de compilación para Semana 06
# Compila todos los archivos en el mismo directorio

echo "=== Compilando Semana 06 ==="

cd src

# Compilar todo junto (los .class quedan en las carpetas correspondientes)
javac -encoding UTF-8 interfaces/*.java abstractas/*.java implementaciones/*.java Main.java

# Copiar todas las clases al directorio actual para que Java las encuentre
cp interfaces/*.class . 2>/dev/null
cp abstractas/*.class . 2>/dev/null
cp implementaciones/*.class . 2>/dev/null

echo "✓ Compilación completada"
echo ""
echo "Para ejecutar: java Main"

