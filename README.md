# Bootcamp Programación Orientada a Objetos - Java

**Estudiante:** Santiago Salamanca Narváez  
**Ficha:** 3228973A  
**Correo:** santicosalamanca@gmail.com  
**Dominio:** Centro de Natación "Aqua Fitness"

---

## 📋 Descripción del Proyecto

Este repositorio contiene el desarrollo completo del bootcamp de Programación Orientada a Objetos en Java, aplicado al dominio de un **Centro de Natación "Aqua Fitness"**.

### Sobre el Dominio

**Aqua Fitness** es un centro acuático ubicado en Bogotá (Salitre) que ofrece:
- Clases de natación para bebés, niños, adolescentes y adultos
- Entrenamiento deportivo para competencia
- Aquaeróbicos
- Hidroterapia y rehabilitación acuática

**Infraestructura:**
- 2 piscinas (semi-olímpica y recreativa)
- 8 instructores certificados
- Vestiers, duchas y zona de hidratación
- 250 estudiantes activos

---

## 📂 Estructura del Repositorio

```
AquaFitness/
├── README.md                       # Este archivo
├── .gitignore
├── entregables/                    # Actividades y documentos entregables
│   ├── semana01/
│   ├── semana02/
│   └── ...
├── semana-01/                      # Introducción a POO
├── semana-02/                      # Clases y Objetos
├── semana-03/                      # Encapsulamiento y Constructores
├── semana-04/                      # Herencia
├── semana-05/                      # Polimorfismo
├── semana-06/                      # Clases Abstractas e Interfaces
├── semana-07/                      # Excepciones
└── semana-08/                      # Colecciones
```

---

## 📅 Contenido por Semana

### Semana 01: Introducción al Paradigma Orientado a Objetos
- Conceptos fundamentales de POO
- Identificación de objetos en el dominio
- Primera clase simple en Java

### Semana 02: Clases y Objetos
- Creación de múltiples clases
- Relaciones entre objetos
- Métodos y atributos

### Semana 03: Encapsulamiento y Constructores
- Modificadores de acceso
- Getters y Setters
- Sobrecarga de constructores

### Semana 04: Herencia
- Clases padre e hijas
- Método `super()`
- Jerarquía de clases

### Semana 05: Polimorfismo
- Sobrecarga de métodos
- Sobrescritura de métodos
- Polimorfismo dinámico

### Semana 06: Clases Abstractas e Interfaces
- Clases abstractas
- Interfaces y contratos
- Implementación múltiple

### Semana 07: Manejo de Excepciones
- Try-catch-finally
- Excepciones personalizadas
- Validaciones robustas

### Semana 08: Colecciones
- ArrayList, HashMap
- Gestión de datos con colecciones
- Proyecto integrador final

---

## 🚀 Compilación y Ejecución

### Semanas 01-05 (sin paquetes)
```bash
cd semana-XX
javac -encoding UTF-8 src/*.java
java -cp src Main
```

### Semana 06 (con paquetes simples)
```bash
cd semana-06
javac -encoding UTF-8 src/abstractas/*.java src/interfaces/*.java src/implementaciones/*.java src/Main.java
java -cp src Main
```

### Semanas 07-08 (con paquetes completos)
```bash
cd semana-XX
javac -encoding UTF-8 -d bin src/com/aquafitness/**/*.java
java -cp bin com.aquafitness.Main
```

---

## 📝 Notas

- **Encoding:** Todos los archivos Java usan codificación UTF-8 para soportar caracteres especiales (ñ, á, é, etc.)
- **Progresión:** Cada semana construye sobre los conceptos de la anterior
- **Dominio consistente:** Todas las implementaciones están contextualizadas en el Centro de Natación Aqua Fitness

---

## 🛠️ Tecnologías

- Java SE (Standard Edition)
- JDK 8 o superior
- Git para control de versiones

---

**Repositorio creado para el Bootcamp de Programación Orientada a Objetos**

