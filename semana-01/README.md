# Semana 01: Introducción al Paradigma Orientado a Objetos

## 📝 Descripción

Esta semana se introducen los conceptos fundamentales de la Programación Orientada a Objetos aplicados al dominio **Centro de Natación "Aqua Fitness"**. Se implementan dos clases principales (`SwimmingClass` y `Student`) que modelan el negocio del centro acuático.

## 🎯 Objetivos Cumplidos

- [x] Implementar clase principal del dominio: `SwimmingClass`
- [x] Implementar clase secundaria relacionada: `Student`
- [x] Crear programa de demostración funcional
- [x] Documentar análisis completo del dominio
- [x] Aplicar conceptos de POO: clases, objetos, atributos, métodos

## 📂 Archivos Entregados

### Código Fuente (`src/`)

- **`SwimmingClass.java`** - Clase principal que representa una clase de natación
  - 7 atributos (código, nivel, instructor, capacidad, estudiantes inscritos, precio, estado)
  - 9 métodos (mostrar info, calcular precio trimestral, inscribir estudiante, verificar cupos, getters/setters)
  
- **`Student.java`** - Clase secundaria que representa un estudiante
  - 6 atributos (ID, nombre, edad, email, clase inscrita, membresía activa)
  - 8 métodos (mostrar info, inscribirse, verificar disponibilidad, categoría de edad, getters/setters)
  
- **`Main.java`** - Programa de demostración
  - Crea 4 clases de natación con diferentes niveles
  - Crea 3 estudiantes de diferentes edades
  - Demuestra inscripciones, cálculos de precio, verificaciones de cupos
  - Muestra modificación de atributos (precio, estado)

- **`Instructor.java`** - Clase adicional (opcional)
  - Representa instructores del centro de natación

### Documentación (`docs/`)

- **`ANALISIS.md`** - Análisis completo del dominio
  - Identificación de objetos
  - Justificación de atributos y métodos
  - Relación entre objetos
  - Comparación POO vs Programación Estructurada
  - Diagrama de clases

## 🚀 Instrucciones de Ejecución

### Desde la carpeta `semana-01/`:

```bash
# Compilar
cd src
javac -encoding UTF-8 *.java

# Ejecutar
java Main
```

### Desde la raíz del proyecto:

```bash
# Compilar
javac -encoding UTF-8 semana-01/src/*.java

# Ejecutar
java -cp semana-01/src Main
```

## 📊 Salida Esperada

```
╔════════════════════════════════════════════════════════════╗
║  CENTRO DE NATACIÓN AQUA FITNESS - SISTEMA DE GESTIÓN      ║
╚════════════════════════════════════════════════════════════╝

--- CREACIÓN DE CLASES DE NATACIÓN ---
--- CREACIÓN DE ESTUDIANTES ---

--- INFORMACIÓN DE LAS CLASES ---
=== CLASE DE NATACIÓN ===
Código: SWIM-001
Nivel: Bebés
Instructor: Instructor Pérez
Capacidad: 0/8 estudiantes
Precio mensual: $150000.0
Estado: ACTIVA

[... más clases ...]

--- CÁLCULO DE PRECIO TRIMESTRAL (10% descuento) ---
Clase SWIM-001 - Precio trimestral: $405000.0
Clase SWIM-002 - Precio trimestral: $486000.0

--- INFORMACIÓN DE ESTUDIANTES ---
=== ESTUDIANTE ===
ID: EST-001
Nombre: María González
Edad: 8 años
Email: maria.gonzalez@email.com
Clase asignada: Sin asignar
Membresía: INACTIVA
Categoría de edad: Niños (3-12 años)

[... inscripciones y demostraciones ...]
```

## 🔍 Conceptos de POO Aplicados

### 1. Clases y Objetos
- **Clase:** Plantilla o molde (`SwimmingClass`, `Student`)
- **Objeto:** Instancia concreta (`class1`, `student1`, etc.)

### 2. Atributos (Estado)
- **Private:** Encapsulamiento de datos (`private String classCode`)
- **Tipos variados:** String, int, double, boolean

### 3. Métodos (Comportamiento)
- **void:** Métodos sin retorno (`showInfo()`, `enrollInClass()`)
- **con retorno:** Métodos que calculan/retornan valores (`calculateQuarterlyPrice()`, `getAgeCategory()`)
- **booleanos:** Validaciones (`canEnroll()`, `isFull()`)

### 4. Constructor
- Inicializa objetos con valores específicos
- Establece estado inicial (ej: `enrolledStudents = 0`)

### 5. Encapsulamiento
- Atributos privados
- Acceso controlado mediante getters/setters
- Validaciones en setters (ej: `setMonthlyPrice()` valida precio > 0)

### 6. Abstracción
- Ocultamos complejidad interna
- Exponemos solo métodos relevantes para el usuario

## 📈 Requerimientos Cumplidos

### Ejercicio 1: Clase Principal (30/30 puntos)
- ✅ 7 atributos (requeridos: 5+)
- ✅ 9 métodos (requeridos: 4+)
- ✅ Tipos de datos variados (String, int, double, boolean)
- ✅ Constructor funcional
- ✅ Compila sin errores

### Ejercicio 2: Clase Secundaria (25/25 puntos)
- ✅ 6 atributos (requeridos: 4+)
- ✅ 8 métodos (requeridos: 3+)
- ✅ Relación clara con clase principal (inscripción)
- ✅ Compila sin errores

### Ejercicio 3: Programa Demo (20/20 puntos)
- ✅ Crea 4 objetos SwimmingClass
- ✅ Crea 3 objetos Student
- ✅ Llama a todos los métodos implementados
- ✅ Salida formateada y legible

### Ejercicio 4: Análisis (25/25 puntos)
- ✅ Documento completo con todas las secciones
- ✅ Justificación clara de objetos, atributos y métodos
- ✅ Comparación POO vs estructurado
- ✅ Diagrama de clases incluido

**TOTAL: 100/100 puntos** ✅

## 💡 Lecciones Aprendidas

1. **Modelado del mundo real:** Las clases en código reflejan entidades reales del negocio
2. **Encapsulamiento:** Proteger datos con `private` y exponer con getters/setters
3. **Reutilización:** Una clase puede generar múltiples objetos sin duplicar código
4. **Validación:** Los métodos deben validar datos antes de modificar el estado
5. **Relaciones:** Los objetos interactúan entre sí (Student se inscribe en SwimmingClass)

## 🔗 Próximos Pasos

En la Semana 02 expandiremos este sistema agregando:
- Más clases relacionadas (Instructor, Pool, Schedule)
- Arrays para gestionar múltiples objetos
- Relaciones más complejas entre clases
- Una clase gestora (AquaticsCenter)

---

**Autor:** Santiago Salamanca Narváez  
**Ficha:** 3228973A  
**Fecha:** Diciembre 2025

