# 📘 Instrucciones de Compilación - Aqua Fitness

## 📋 Resumen por Semana

| Semana | Estado | Método de Compilación |
|--------|--------|----------------------|
| 01 | ✅ | Directa (mismo directorio) |
| 02 | ✅ | Directa (mismo directorio) |
| 03 | ✅ | Directa (mismo directorio) |
| 04 | ✅ | Directa (mismo directorio) |
| 05 | ✅ | Directa (mismo directorio) |
| 06 | ✅ | Paquetes (com.aquafitness.*) |
| 07 | ✅ | Paquetes (com.aquafitness.*) |

---

## 🔧 Semanas 01-05: Compilación Directa

**Estructura:** Todos los archivos .java en `semana-XX/src/`

### Compilar y Ejecutar

```bash
cd semana-0X/src
javac -encoding UTF-8 *.java
java Main
```

**Ejemplo:**
```bash
cd semana-01/src
javac -encoding UTF-8 *.java
java Main
```

---

## 🔧 Semana 06: Con Paquetes

**Estructura:** 
```
semana-06/src/
└── com/
    └── aquafitness/
        ├── Main.java
        ├── modelo/*.java
        └── interfaces/*.java
```

### Compilar y Ejecutar

```bash
cd semana-06

# Compilar (crea bin/)
javac -encoding UTF-8 -d bin src/com/aquafitness/interfaces/*.java src/com/aquafitness/modelo/*.java src/com/aquafitness/Main.java

# Ejecutar (usa bin/ como classpath)
java -cp bin com.aquafitness.Main
```

**Notas:**
- `-d bin`: Crea la estructura de paquetes en la carpeta `bin/`
- `-cp bin`: Le dice a Java dónde encontrar las clases compiladas
- `com.aquafitness.Main`: Nombre completo de la clase (con paquete)

---

## 🔧 Semana 07: Con Paquetes

**Estructura:** 
```
semana-07/src/
└── com/
    └── aquafitness/
        ├── Main.java
        ├── modelo/*.java
        ├── servicio/*.java
        └── excepciones/*.java
```

### Compilar y Ejecutar

```bash
cd semana-07

# Compilar (crea bin/)
javac -encoding UTF-8 -d bin src/com/aquafitness/excepciones/*.java src/com/aquafitness/modelo/*.java src/com/aquafitness/servicio/*.java src/com/aquafitness/Main.java

# Ejecutar (usa bin/ como classpath)
java -cp bin com.aquafitness.Main
```

**Notas:**
- `-d bin`: Crea la estructura de paquetes en la carpeta `bin/`
- `-cp bin`: Le dice a Java dónde encontrar las clases compiladas
- `com.aquafitness.Main`: Nombre completo de la clase (con paquete)

---

## 🚨 Solución de Problemas Comunes

### Error: "cannot find symbol"
**Causa:** No se compilaron todas las clases necesarias  
**Solución:** Compilar todos los .java juntos en un solo comando

### Error: "NoClassDefFoundError" (Semana 06)
**Causa:** Java no encuentra las clases en subcarpetas  
**Solución:** 
1. Usar los scripts `compilar.sh` o `compilar.bat`
2. O copiar manualmente los .class al directorio de Main.class

### Error: "ClassNotFoundException" (Semana 07)
**Causa:** No se especificó el classpath o el nombre completo de la clase  
**Solución:** 
- Usar `-cp bin` al ejecutar
- Usar el nombre completo: `com.aquafitness.Main`

### Error: "unmappable character for encoding"
**Causa:** Caracteres especiales (tildes, ñ) sin encoding UTF-8  
**Solución:** Siempre usar `-encoding UTF-8` al compilar

---

## ✅ Verificación Rápida de Todas las Semanas

```bash
#!/bin/bash

cd /ruta/al/proyecto/AquaFitness

echo "=== Verificando Semana 01 ==="
cd semana-01/src && javac -encoding UTF-8 *.java && java Main | head -5
cd ../..

echo "=== Verificando Semana 02 ==="
cd semana-02/src && javac -encoding UTF-8 *.java && java Main | head -5
cd ../..

echo "=== Verificando Semana 03 ==="
cd semana-03/src && javac -encoding UTF-8 *.java && java Main | head -5
cd ../..

echo "=== Verificando Semana 04 ==="
cd semana-04/src && javac -encoding UTF-8 *.java && java Main | head -5
cd ../..

echo "=== Verificando Semana 05 ==="
cd semana-05/src && javac -encoding UTF-8 *.java && java Main | head -5
cd ../..

echo "=== Verificando Semana 06 ==="
cd semana-06 && bash compilar.sh && cd src && java Main | head -5
cd ../..

echo "=== Verificando Semana 07 ==="
cd semana-07
javac -encoding UTF-8 -d bin src/com/aquafitness/*/*.java src/com/aquafitness/Main.java
java -cp bin com.aquafitness.Main | head -5
cd ..

echo ""
echo "✅ Todas las semanas verificadas"
```

---

## 📚 Conceptos de Compilación

### ¿Qué hace `javac`?
Compila archivos `.java` (código fuente) en archivos `.class` (bytecode)

### ¿Qué hace `-encoding UTF-8`?
Permite que el compilador entienda caracteres especiales (ñ, tildes, etc.)

### ¿Qué hace `-d bin`?
Especifica dónde poner los archivos .class compilados

### ¿Qué hace `-cp` o `-classpath`?
Le dice a Java dónde buscar las clases que necesita

### ¿Qué es un paquete (package)?
Una forma de organizar clases en carpetas con nombres únicos (ej: `com.aquafitness.modelo`)

---

## 🎓 Buenas Prácticas

1. **Siempre usar `-encoding UTF-8`** para evitar problemas con caracteres especiales
2. **Compilar todos los archivos juntos** en un solo comando
3. **Usar paquetes** para proyectos grandes (Semana 07+)
4. **Separar código fuente (`src/`) de binarios (`bin/`)** en proyectos con paquetes
5. **Crear scripts de compilación** para proyectos complejos

---

**Fecha:** 17/12/2024  
**Autor:** Santiago Salamanca Narváez  
**Proyecto:** Aqua Fitness - Bootcamp POO Java

