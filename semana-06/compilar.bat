@echo off
REM Script de compilación para Semana 06 (Windows)

echo === Compilando Semana 06 ===

cd src

REM Compilar todo junto
javac -encoding UTF-8 interfaces\*.java abstractas\*.java implementaciones\*.java Main.java

REM Copiar clases al directorio actual
copy interfaces\*.class . >nul 2>&1
copy abstractas\*.class . >nul 2>&1
copy implementaciones\*.class . >nul 2>&1

echo Compilacion completada
echo.
echo Para ejecutar: java Main

