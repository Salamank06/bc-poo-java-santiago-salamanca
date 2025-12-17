# Semana 07: Manejo de Excepciones

## Descripción

Esta semana se implementa el manejo de excepciones para crear un sistema robusto. Se crean excepciones personalizadas y se utilizan bloques try-catch-finally para manejar errores.

## Estructura de Archivos

```
semana-07/
├── README.md (este archivo)
├── src/
│   └── com/
│       └── aquafitness/
│           ├── Main.java
│           ├── modelo/
│           │   ├── AquaticActivity.java
│           │   ├── SwimmingLesson.java
│           │   ├── AquaAerobics.java
│           │   └── HydroTherapy.java
│           ├── servicio/
│           │   └── ActivityService.java
│           └── excepciones/
│               ├── InvalidCapacityException.java
│               ├── ScheduleConflictException.java
│               └── InsufficientFundsException.java
└── docs/
```

## Objetivos de Aprendizaje

- Comprender el manejo de excepciones
- Crear excepciones personalizadas
- Usar try-catch-finally
- Implementar validaciones robustas

## Compilación y Ejecución

```bash
# Compilar
javac -encoding UTF-8 -d bin src/com/aquafitness/**/*.java

# Ejecutar
java -cp bin com.aquafitness.Main
```

## Conceptos Clave

- Excepciones (Exception)
- try-catch-finally
- throw y throws
- Excepciones personalizadas
- Checked vs Unchecked exceptions

