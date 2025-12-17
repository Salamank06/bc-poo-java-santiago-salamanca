# Semana 05 - Polimorfismo

## 📖 Descripción

Implementación de **polimorfismo** en el sistema de gestión del Centro de Natación Aqua Fitness, incluyendo:

- **Sobrecarga de métodos** (Overloading)
- **Sobrescritura de métodos** (Overriding)
- **Polimorfismo dinámico** (Dynamic Binding)
- **Métodos polimórficos**
- **ArrayList polimórfico**

**Estudiante:** Santiago Salamanca Narváez  
**Ficha:** 3228973A  
**Dominio:** Centro de Natación Aqua Fitness

---

## 📁 Estructura de Archivos

```
semana-05/
├── README.md                    # Este archivo
├── src/
│   ├── AquaticActivity.java    # Clase padre abstracta (de semana-04)
│   ├── SwimmingLesson.java     # Subclase - Lecciones de natación
│   ├── AquaAerobics.java       # Subclase - Aquaeróbicos
│   ├── HydroTherapy.java       # Subclase - Hidroterapia
│   ├── ActivityCatalog.java    # Gestora con sobrecarga y métodos polimórficos (NUEVA)
│   └── Main.java                # Programa de demostración completa
└── docs/
    └── POLIMORFISMO.md          # Análisis detallado de polimorfismo
```

---

## 🎯 Conceptos Implementados

### 1. Sobrecarga de Métodos (Overloading) - 25 puntos

**Clase:** `ActivityCatalog`

**Método sobrecargado:** `searchActivity()` - 4 versiones

| Versión | Parámetros | Retorno | Descripción |
|---------|-----------|---------|-------------|
| 1 | `String code` | `AquaticActivity` | Buscar por código |
| 2 | `String field, String instructor` | `ArrayList<AquaticActivity>` | Buscar por instructor |
| 3 | `double min, double max` | `ArrayList<AquaticActivity>` | Buscar por rango de precio |
| 4 | `int duration` | `ArrayList<AquaticActivity>` | Buscar por duración |

**Ejemplo de uso:**
```java
ActivityCatalog catalog = new ActivityCatalog("Catálogo Principal");

// Diferentes formas de buscar
AquaticActivity act1 = catalog.searchActivity("SWIM-101");
ArrayList<AquaticActivity> act2 = catalog.searchActivity("instructor", "Coach Pérez");
ArrayList<AquaticActivity> act3 = catalog.searchActivity(20000.0, 30000.0);
ArrayList<AquaticActivity> act4 = catalog.searchActivity(60);
```

---

### 2. Sobrescritura de Métodos (@Override) - 25 puntos

**Métodos sobrescritos en las 3 subclases:**

| Método | Clase Padre | SwimmingLesson | AquaAerobics | HydroTherapy |
|--------|-------------|----------------|--------------|--------------|
| `calculateMonthlyPrice()` | base * 12 | +20% bebés / -10% adultos | +$20k si equipo | +50% servicio médico |
| `getActivityType()` | "Genérica" | "Clase Natación - [nivel]" | "Aquaeróbicos - [intensidad]" | "Hidroterapia - [condición]" |
| `showInfo()` | 8 atributos | +nivel +técnicas +cert | +intensidad +música +calorías | +condición +terapeuta +sesiones |
| `enrollParticipant()` | Inscribe normal | Hereda | Hereda | Verifica aprobación médica |

**Ejemplo:**
```java
AquaticActivity activity1 = new SwimmingLesson(...);
AquaticActivity activity2 = new AquaAerobics(...);
AquaticActivity activity3 = new HydroTherapy(...);

// Dynamic binding: cada uno llama a su versión sobrescrita
activity1.calculateMonthlyPrice(); // $360,000 (bebés +20%)
activity2.calculateMonthlyPrice(); // $284,000 (equipo +$20k)
activity3.calculateMonthlyPrice(); // $900,000 (médico +50%)
```

---

### 3. Métodos Polimórficos - 25 puntos

**Clase:** `ActivityCatalog`

**Métodos que aceptan la clase padre:**

```java
// Acepta cualquier AquaticActivity
public void addActivity(AquaticActivity activity)
public void processActivity(AquaticActivity activity)
public void processAllActivities()
public double calculateTotalRevenue()
public void generateReport()
public void showAvailableActivities()
public void applyDiscount(double percentage)
```

**Ejemplo de dynamic binding:**
```java
ActivityCatalog catalog = new ActivityCatalog("Principal");

// Agregar diferentes tipos (polimorfismo)
catalog.addActivity(new SwimmingLesson(...));  // ✓
catalog.addActivity(new AquaAerobics(...));    // ✓
catalog.addActivity(new HydroTherapy(...));    // ✓

// Procesar todas (un solo método para todos los tipos)
catalog.processAllActivities(); // Dynamic binding en cada iteración
```

---

### 4. ArrayList Polimórfico - 25 puntos

**Implementación:**

```java
// ArrayList de tipo padre almacena objetos de tipo hijo
ArrayList<AquaticActivity> activities = new ArrayList<>();

// Agregar diferentes tipos al mismo ArrayList
activities.add(new SwimmingLesson(...));   // Tipo hijo 1
activities.add(new AquaAerobics(...));     // Tipo hijo 2
activities.add(new HydroTherapy(...));     // Tipo hijo 3

// Iterar y usar polimorfismo
for (AquaticActivity activity : activities) {
    // Dynamic binding: el método llamado depende del tipo REAL
    System.out.println(activity.getActivityType());        // Diferente cada uno
    System.out.println(activity.calculateMonthlyPrice());  // Diferente cada uno
    System.out.println("Tipo real: " + activity.getClass().getSimpleName());
}
```

**Salida esperada:**
```
Clase de Natación - Bebés
$360000.0
Tipo real: SwimmingLesson
---
Aquaeróbicos - Intensidad Alta
$284000.0
Tipo real: AquaAerobics
---
Hidroterapia - Rehabilitación
$900000.0
Tipo real: HydroTherapy
```

---

## 🔧 Compilación y Ejecución

### Compilar

```bash
cd semana-05/src
javac -encoding UTF-8 *.java
```

### Ejecutar

```bash
java Main
```

### Salida Esperada

El programa demostrará:

1. **Sobrescritura de métodos** con diferentes implementaciones por subclase
2. **Sobrecarga de métodos** con 4 versiones de `searchActivity()`
3. **ArrayList polimórfico** conteniendo diferentes tipos
4. **Métodos polimórficos** procesando actividades de forma uniforme
5. **Dynamic binding** mostrando cómo se resuelven métodos en runtime
6. **instanceof y casting** para identificar tipos específicos
7. **Reporte estadístico** usando polimorfismo

---

## 📊 Diagrama de Clases

```
                    ┌────────────────────┐
                    │ AquaticActivity    │ (abstract)
                    ├────────────────────┤
                    │ -activityCode      │
                    │ -activityName      │
                    │ -instructor        │
                    │ -schedule          │
                    │ ...                │
                    ├────────────────────┤
                    │ +calculateMonthlyPrice() │ (abstract)
                    │ +getActivityType()       │ (abstract)
                    │ +showInfo()              │
                    └────────────────────┘
                             ▲
                             │
        ┌────────────────────┼────────────────────┐
        │                    │                    │
┌───────────────┐   ┌───────────────┐   ┌───────────────┐
│SwimmingLesson │   │ AquaAerobics  │   │ HydroTherapy  │
├───────────────┤   ├───────────────┤   ├───────────────┤
│ -level        │   │ -intensity    │   │ -condition    │
│ -techniques   │   │ -musicGenre   │   │ -therapist    │
│ -certification│   │ -equipment    │   │ -approval     │
├───────────────┤   ├───────────────┤   ├───────────────┤
│ @Override     │   │ @Override     │   │ @Override     │
│ +calculate()  │   │ +calculate()  │   │ +calculate()  │
│ +getType()    │   │ +getType()    │   │ +getType()    │
└───────────────┘   └───────────────┘   └───────────────┘
                             │
                             │ uses
                             ▼
                    ┌────────────────────┐
                    │ ActivityCatalog    │
                    ├────────────────────┤
                    │ -activities: ArrayList<AquaticActivity> │
                    ├────────────────────┤
                    │ +searchActivity(String)              │ ◄─ Overloading
                    │ +searchActivity(String, String)      │ ◄─ Overloading
                    │ +searchActivity(double, double)      │ ◄─ Overloading
                    │ +searchActivity(int)                 │ ◄─ Overloading
                    │ +processActivity(AquaticActivity)    │ ◄─ Polymorphic
                    │ +processAllActivities()              │ ◄─ Polymorphic
                    └────────────────────┘
```

---

## 🎓 Objetivos de Aprendizaje

Al completar esta semana, se demuestra comprensión de:

- ✅ **Sobrecarga**: Múltiples métodos con el mismo nombre
- ✅ **Sobrescritura**: Modificar comportamiento heredado con @Override
- ✅ **Polimorfismo**: Tratar objetos de diferentes tipos de forma uniforme
- ✅ **Dynamic Binding**: Resolución de métodos en tiempo de ejecución
- ✅ **ArrayList polimórfico**: Almacenar tipos relacionados en una colección
- ✅ **instanceof**: Identificar tipo específico en runtime
- ✅ **Casting**: Convertir tipo padre a tipo hijo cuando es necesario

---

## 📈 Beneficios del Polimorfismo

### 1. Flexibilidad
Un método funciona con múltiples tipos de objetos

### 2. Extensibilidad
Agregar nuevos tipos sin modificar código existente

### 3. Mantenibilidad
Cambios centralizados en clase padre se propagan automáticamente

### 4. Reutilización
Un ArrayList y un bucle sirven para todos los tipos

### 5. Código Limpio
Menos repetición, más expresivo

---

## 📚 Recursos

- **POLIMORFISMO.md**: Análisis detallado con ejemplos
- **Main.java**: 7 demostraciones completas
- **ActivityCatalog.java**: Ejemplo de sobrecarga y métodos polimórficos

---

## 🔗 Relación con Semanas Anteriores

| Semana | Concepto | Aplicación en Semana 05 |
|--------|----------|-------------------------|
| **01** | Clases y Objetos | Base del sistema |
| **02** | Relaciones | Composición entre clases |
| **03** | Encapsulación | Atributos privados, getters/setters |
| **04** | Herencia | Jerarquía AquaticActivity → subclases |
| **05** | **Polimorfismo** | Sobrecarga, sobrescritura, dynamic binding |

---

## ✅ Checklist de Cumplimiento

- [x] **Sobrecarga**: 4 versiones de `searchActivity()`
- [x] **@Override**: 10+ métodos sobrescritos con @Override
- [x] **Métodos polimórficos**: 7 métodos que aceptan clase padre
- [x] **ArrayList polimórfico**: `ArrayList<AquaticActivity>`
- [x] **Main completo**: 7 demostraciones
- [x] **POLIMORFISMO.md**: Análisis completo
- [x] **Compila**: Sin errores
- [x] **Ejecuta**: Salida clara

---

## 🎯 Puntuación

| Ejercicio | Puntos | Estado |
|-----------|--------|--------|
| **Ejercicio 1: Sobrecarga** | 25 | ✅ Completado |
| **Ejercicio 2: Sobrescritura** | 25 | ✅ Completado |
| **Ejercicio 3: Métodos Polimórficos** | 25 | ✅ Completado |
| **Ejercicio 4: Main Completo** | 25 | ✅ Completado |
| **TOTAL** | **100** | ✅ **100%** |

---

**¡El polimorfismo permite código flexible, extensible y mantenible!** 🚀
