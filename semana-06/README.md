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

## 🔧 Compilación y Ejecución

### Opción 1: Usando scripts (Recomendado)

**En Linux/Mac/Git Bash:**
```bash
cd semana-06
bash compilar.sh
cd src
java Main
```

**En Windows (CMD):**
```cmd
cd semana-06
compilar.bat
cd src
java Main
```

### Opción 2: Manual

```bash
cd semana-06/src

# Compilar todo junto
javac -encoding UTF-8 interfaces/*.java abstractas/*.java implementaciones/*.java Main.java

# Copiar clases al directorio actual (para que Java las encuentre)
cp interfaces/*.class .
cp abstractas/*.class .
cp implementaciones/*.class .

# Ejecutar
java Main
```

**Nota:** El problema del classpath en Windows requiere que las clases estén en el mismo directorio que Main.class, por eso se copian.

## Conceptos Clave

- Clases abstractas vs Interfaces
- implements
- Contratos de comportamiento
- Paquetes (packages)
- Organización del código

