# Semana 06: Clases Abstractas e Interfaces

## Descripción

Esta semana se profundiza en clases abstractas e interfaces. Se organiza el código en paquetes y se implementan interfaces para definir contratos de comportamiento.

## Estructura de Archivos

```
semana-06/
├── README.md (este archivo)
├── src/
│   ├── Main.java
│   ├── abstractas/
│   │   └── AquaticActivity.java
│   ├── interfaces/
│   │   ├── Reservable.java
│   │   ├── Evaluable.java
│   │   └── Certifiable.java
│   └── implementaciones/
│       ├── ActivityManager.java
│       ├── SwimmingLesson.java
│       ├── AquaAerobics.java
│       └── HydroTherapy.java
└── docs/
    └── ANALISIS.md
```

## Objetivos de Aprendizaje

- Diferenciar entre clases abstractas e interfaces
- Implementar interfaces
- Organizar código en paquetes
- Aplicar principios de diseño

## Compilación y Ejecución

```bash
# Compilar
javac -encoding UTF-8 src/abstractas/*.java src/interfaces/*.java src/implementaciones/*.java src/Main.java

# Ejecutar
java -cp src Main
```

## Conceptos Clave

- Clases abstractas vs Interfaces
- implements
- Contratos de comportamiento
- Paquetes (packages)
- Organización del código

