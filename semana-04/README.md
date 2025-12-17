# Semana 04: Herencia

## Descripción

Esta semana se introduce el concepto de herencia mediante la creación de una clase padre abstracta y múltiples clases hijas. Se establece una jerarquía de clases para modelar diferentes tipos de actividades acuáticas.

## Estructura de Archivos

```
semana-04/
├── README.md (este archivo)
├── src/
│   ├── AquaticActivity.java (clase abstracta padre)
│   ├── SwimmingLesson.java
│   ├── AquaAerobics.java
│   ├── HydroTherapy.java
│   ├── ActivityManager.java
│   └── Main.java
└── docs/
    └── JERARQUIA.md
```

## Objetivos de Aprendizaje

- Comprender el concepto de herencia
- Crear una clase padre y clases hijas
- Utilizar la palabra clave `extends`
- Usar `super()` para llamar al constructor padre

## Compilación y Ejecución

```bash
# Compilar
javac -encoding UTF-8 src/*.java

# Ejecutar
java -cp src Main
```

## Conceptos Clave

- Herencia (extends)
- Clase padre (superclase)
- Clase hija (subclase)
- super()
- Jerarquía de clases

