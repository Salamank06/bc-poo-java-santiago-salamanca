# Semana 08: Colecciones

## Descripción

Esta semana se implementan colecciones de Java (ArrayList, HashMap) para gestionar múltiples objetos de manera eficiente. Se integra todo lo aprendido en el bootcamp en un proyecto final.

## Estructura de Archivos

```
semana-08/
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
│           │   └── ActivityService.java (mejorado con colecciones)
│           └── excepciones/
│               ├── InvalidCapacityException.java
│               ├── ScheduleConflictException.java
│               └── InsufficientFundsException.java
└── docs/
```

## Objetivos de Aprendizaje

- Usar ArrayList para listas dinámicas
- Usar HashMap para mapeo de datos
- Iterar sobre colecciones
- Integrar todos los conceptos del bootcamp

## Compilación y Ejecución

```bash
# Compilar
javac -encoding UTF-8 -d bin src/com/aquafitness/**/*.java

# Ejecutar
java -cp bin com.aquafitness.Main
```

## Conceptos Clave

- ArrayList
- HashMap
- Iteradores
- Generics
- Proyecto integrador

