# Semana 06: Abstracción e Interfaces - Aqua Fitness

## 📝 Descripción

Implementación de **abstracción mediante clases abstractas e interfaces**, aplicando principios SOLID y organizando el código en una estructura profesional de paquetes.

**Estudiante:** Santiago Salamanca Narváez  
**Ficha:** 3228973A  
**Dominio:** Centro de Natación Aqua Fitness

---

## 📦 Estructura de Paquetes

```
semana-06/
├── README.md
├── docs/
│   └── ANALISIS.md
└── src/
    └── com/
        └── aquafitness/
            ├── Main.java
            ├── modelo/
            │   ├── AquaticActivity.java (abstract)
            │   ├── SwimmingLesson.java
            │   ├── AquaAerobics.java
            │   └── HydroTherapy.java
            └── interfaces/
                ├── Reservable.java
                ├── Evaluable.java
                └── Cancelable.java
```

---

## 🎯 Conceptos Implementados

### 1. Clase Abstracta
- **`AquaticActivity`**: Clase padre abstracta
- **Métodos abstractos**: `calculateMonthlyPrice()`, `getActivityType()`, `showInfo()`
- **Métodos concretos**: `enrollParticipant()`, `withdrawParticipant()`, etc.

### 2. Interfaces (Contratos de Comportamiento)
- **`Reservable`**: Capacidad de reservar cupos
- **`Evaluable`**: Capacidad de ser evaluado/calificado
- **`Cancelable`**: Capacidad de cancelar con políticas de reembolso

### 3. Implementación Múltiple
| Clase | Interfaces Implementadas |
|-------|-------------------------|
| `SwimmingLesson` | Reservable + Evaluable |
| `AquaAerobics` | Evaluable + Cancelable |
| `HydroTherapy` | Reservable + Evaluable + Cancelable (las 3) |

---

## 🔧 Compilación y Ejecución

### Compilar (con estructura de paquetes)

```bash
cd semana-06

# Compilar (crea carpeta bin/)
javac -encoding UTF-8 -d bin src/com/aquafitness/interfaces/*.java src/com/aquafitness/modelo/*.java src/com/aquafitness/Main.java

# Ejecutar
java -cp bin com.aquafitness.Main
```

### Comando en una línea

```bash
cd semana-06 && javac -encoding UTF-8 -d bin src/com/aquafitness/*/*.java src/com/aquafitness/Main.java && java -cp bin com.aquafitness.Main
```

**Notas importantes:**
- `-encoding UTF-8`: Para caracteres especiales (ñ, tildes)
- `-d bin`: Crea la estructura de paquetes en `bin/`
- `-cp bin`: Especifica dónde buscar las clases compiladas
- `com.aquafitness.Main`: Nombre completo de la clase (con paquete)

---

## 📊 Salida Esperada

```
╔══════════════════════════════════════════════════════════════╗
║     AQUA FITNESS - SEMANA 06: ABSTRACCIÓN E INTERFACES       ║
╚══════════════════════════════════════════════════════════════╝

═══════════════════════════════════════════════════════════════
  POLIMORFISMO CON CLASE ABSTRACTA
═══════════════════════════════════════════════════════════════

Código: SWIM-101
Tipo: Clase de Natación - Bebés
Precio mensual: $360000.0
───────────────────────────────────────
Código: AERO-101
Tipo: Aquaeróbicos - Alta
Precio mensual: $284000.0
───────────────────────────────────────
Código: HYDRO-101
Tipo: Hidroterapia - Hernia discal
Precio mensual: $900000.0
───────────────────────────────────────

═══════════════════════════════════════════════════════════════
  INTERFACES - RESERVABLE
═══════════════════════════════════════════════════════════════

✓ Participante inscrito en SWIM-101
✓ Participante inscrito en SWIM-101
Reserva creada: SWIM-101-R1000

[... más salida ...]
```

---

## 🔑 Conceptos Clave

### Clase Abstracta vs Interface

| Aspecto | Clase Abstracta | Interface |
|---------|----------------|-----------|
| **Herencia** | Una sola (extends) | Múltiple (implements) |
| **Atributos** | Puede tener | Solo constantes |
| **Métodos concretos** | Sí | No (antes de Java 8) |
| **Uso** | Relación "es-un" | Capacidad/comportamiento |

### Cuándo usar cada uno

**Clase Abstracta (`AquaticActivity`):**
- Hay una relación "es-un" clara
- Se necesita compartir estado (atributos)
- Hay comportamiento común implementable

**Interface (`Reservable`, `Evaluable`, `Cancelable`):**
- Define una capacidad independiente
- Se necesita herencia múltiple
- Solo se define contrato, no implementación

---

## 📚 Principios SOLID Aplicados

### Single Responsibility Principle (SRP)
Cada clase tiene una única responsabilidad bien definida.

### Open/Closed Principle (OCP)
Abierto a extensión (nuevas actividades), cerrado a modificación (no cambiar `AquaticActivity`).

### Liskov Substitution Principle (LSP)
Cualquier subclase puede sustituir a `AquaticActivity` sin romper el programa.

### Interface Segregation Principle (ISP)
Interfaces pequeñas y específicas (no una sola "mega-interface").

### Dependency Inversion Principle (DIP)
El código depende de abstracciones (interfaces/clase abstracta), no de implementaciones concretas.

---

## 🎓 Objetivos de Aprendizaje Cumplidos

- ✅ Diferenciar entre clases abstractas e interfaces
- ✅ Implementar interfaces (`implements`)
- ✅ Crear clases abstractas con métodos abstractos y concretos
- ✅ Organizar código en paquetes (`package` e `import`)
- ✅ Aplicar principios SOLID
- ✅ Demostrar polimorfismo con abstracciones
- ✅ Implementar múltiples interfaces en una clase

---

## 🔗 Relación con Otras Semanas

| Semana | Relación |
|--------|----------|
| **04: Herencia** | Base para entender `extends` |
| **05: Polimorfismo** | Base para entender sobrescritura |
| **06: Abstracción** | ⬅️ Estás aquí |
| **07: Paquetes y Excepciones** | Usa la misma estructura de paquetes |

---

## 📖 Documentación Adicional

Ver `docs/ANALISIS.md` para:
- Justificación de diseño
- Diagramas de clases
- Decisiones arquitectónicas
- Comparación: antes vs después

---

**Versión:** 2.0  
**Fecha:** 17/12/2024  
**Estado:** ✅ Completado con paquetes
