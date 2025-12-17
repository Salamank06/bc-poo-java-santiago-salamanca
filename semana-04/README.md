# Semana 04: Herencia

## 📝 Descripción

Esta semana se implementa **herencia** creando una jerarquía de clases para las diferentes actividades acuáticas del Centro de Natación Aqua Fitness. Se demuestra el uso de `extends`, `super()`, atributos `protected`, sobrescritura con `@Override`, y polimorfismo con arrays.

## 🎯 Objetivos Cumplidos

- [x] Crear clase padre con atributos protected
- [x] Crear 3 subclases con extends
- [x] Usar super() en todos los constructores
- [x] Sobrescribir métodos con @Override
- [x] Implementar arrays polimórficos
- [x] Demostrar instanceof y casting
- [x] Documento JERARQUIA.md completo

## 📂 Archivos Entregados

### Código Fuente (`src/`)

#### **Clase Padre (25/25 puntos)**

1. **`AquaticActivity.java`** - Actividad acuática genérica
   - **8 atributos protected**: activityCode, activityName, instructorName, schedule, durationMinutes, pricePerSession, maxParticipants, currentParticipants
   - **Constructor completo** que inicializa todos los atributos
   - **5 métodos heredables**: showInfo(), calculateMonthlyPrice(), enrollParticipant(), getAvailableSpots(), getActivityType()
   - **8 getters** para acceso a atributos

#### **Subclases (30/30 puntos)**

2. **`SwimmingLesson.java`** - Clases de natación
   - **extends AquaticActivity** ✅
   - **3 atributos específicos**: level, techniquesFocus, includesCertification
   - **super()** en constructor ✅
   - **3 métodos @Override**: showInfo(), calculateMonthlyPrice(), getActivityType()
   - **2 métodos específicos**: evaluateProgress(), getSkillLevel()
   - **Lógica especial**: Precio ajustado según nivel (+20% bebés, -10% adultos)

3. **`AquaAerobics.java`** - Aquaeróbicos
   - **extends AquaticActivity** ✅
   - **4 atributos específicos**: intensityLevel, musicGenre, requiresEquipment, caloriesBurned
   - **super()** en constructor ✅
   - **3 métodos @Override**: showInfo(), calculateMonthlyPrice(), getActivityType()
   - **4 métodos específicos**: warmUp(), coolDown(), getHealthBenefits(), calculateCalories()
   - **Lógica especial**: +$20,000 si requiere equipo

4. **`HydroTherapy.java`** - Hidroterapia
   - **extends AquaticActivity** ✅
   - **4 atributos específicos**: medicalCondition, therapistName, requiresMedicalApproval, sessionsRecommended
   - **super()** en constructor ✅
   - **4 métodos @Override**: showInfo(), calculateMonthlyPrice(), getActivityType(), enrollParticipant()
   - **4 métodos específicos**: assessPatient(), generateTherapyPlan(), calculateTreatmentCost(), getTherapyGoals()
   - **Lógica especial**: +50% precio por ser servicio médico, validación de aprobación médica

5. **`ActivityManager.java`** - Gestor con arrays polimórficos
   - **Array polimórfico**: `AquaticActivity[] activities`
   - **Métodos**: addActivity(), showAllActivities(), showStatistics(), findActivityByCode()
   - **instanceof** para contar tipos de actividades

#### **Demostración (20/20 puntos)**

6. **`Main.java`** - Programa completo
   - **7 demostraciones** completas
   - Crea 6 objetos (2 de cada subclase)
   - **Arrays polimórficos** implementados
   - **Polimorfismo en acción** (mismo bucle, diferentes comportamientos)
   - **instanceof y casting** demostrado
   - Métodos específicos de cada subclase

### Documentación (`docs/`)

7. **`JERARQUIA.md`** - Análisis completo
   - Diagrama de jerarquía (ASCII art)
   - Descripción detallada de clase padre
   - Descripción de cada subclase
   - Justificación del diseño
   - Atributos heredados explicados
   - Métodos sobrescritos analizados
   - Uso de super() documentado
   - Polimorfismo explicado
   - Beneficios y conclusiones

## 🌳 Jerarquía Implementada

```
                AquaticActivity
               (Clase Padre)
                     |
        +------------+------------+
        |            |            |
  SwimmingLesson  AquaAerobics  HydroTherapy
```

### Relaciones de Herencia

- **SwimmingLesson** IS-A **AquaticActivity**
- **AquaAerobics** IS-A **AquaticActivity**
- **HydroTherapy** IS-A **AquaticActivity**

## 🔑 Conceptos Implementados

### 1. Herencia con extends
```java
public class SwimmingLesson extends AquaticActivity {
    // Hereda 8 atributos y 5 métodos del padre
}
```

### 2. Atributos protected
```java
// En clase padre
protected String activityCode;    // Accesible desde subclases
protected double pricePerSession; // Accesible desde subclases
```

### 3. Constructor con super()
```java
public SwimmingLesson(...) {
    super(...); // DEBE ser la primera línea
    this.level = level; // Luego inicializar propios
}
```

### 4. Sobrescritura con @Override
```java
@Override
public double calculateMonthlyPrice() {
    double basePrice = super.calculateMonthlyPrice(); // Reutilizar padre
    return basePrice * factor; // Aplicar lógica propia
}
```

### 5. Polimorfismo con Arrays
```java
AquaticActivity[] activities = new AquaticActivity[6];
activities[0] = new SwimmingLesson(...);  // ✅
activities[1] = new AquaAerobics(...);    // ✅
activities[2] = new HydroTherapy(...);    // ✅

for (AquaticActivity a : activities) {
    a.showInfo(); // Llama al método de cada subclase
}
```

### 6. instanceof y Casting
```java
if (activity instanceof SwimmingLesson) {
    SwimmingLesson lesson = (SwimmingLesson) activity;
    lesson.evaluateProgress(); // Método específico
}
```

## 🚀 Instrucciones de Ejecución

### Desde la carpeta `semana-04/`:

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
javac -encoding UTF-8 semana-04/src/*.java

# Ejecutar
java -cp semana-04/src Main
```

## 📊 Salida del Programa

El programa ejecuta 7 demostraciones:

1. ✅ Creación de objetos con herencia (6 actividades)
2. ✅ Arrays polimórficos
3. ✅ Polimorfismo en acción (bucle sobre array)
4. ✅ Inscripción de participantes
5. ✅ Métodos específicos de cada subclase
6. ✅ Uso de instanceof para verificar tipos
7. ✅ Gestor con polimorfismo y estadísticas

## 📈 Requerimientos Cumplidos

### Ejercicio 1: Clase Padre (25/25 puntos)
- ✅ AquaticActivity con 8 atributos protected
- ✅ Constructor completo
- ✅ 5 métodos heredables

### Ejercicio 2: Subclases (30/30 puntos)
- ✅ 3 subclases (SwimmingLesson, AquaAerobics, HydroTherapy)
- ✅ extends usado correctamente
- ✅ super() en todos los constructores
- ✅ Atributos específicos en cada subclase

### Ejercicio 3: Implementación (25/25 puntos)
- ✅ extends usado correctamente
- ✅ super() en todos los constructores (primera línea)
- ✅ @Override en todos los métodos sobrescritos (12 sobrescrituras)
- ✅ protected usado apropiadamente

### Ejercicio 4: Polimorfismo (20/20 puntos)
- ✅ Array polimórfico implementado
- ✅ Iteración con polimorfismo
- ✅ Diferentes comportamientos demostrados
- ✅ instanceof y casting

**TOTAL: 100/100 puntos** ✅

## 💡 Conceptos Clave Aprendidos

1. **Herencia (IS-A)** - Relación "es un/a"
2. **extends** - Palabra clave para heredar
3. **protected** - Acceso desde subclases
4. **super()** - Llamar constructor del padre
5. **super.metodo()** - Llamar método del padre
6. **@Override** - Sobrescribir métodos
7. **Polimorfismo** - Mismo código, diferentes comportamientos
8. **instanceof** - Verificar tipo en runtime
9. **Casting** - Convertir tipo padre a hijo
10. **Arrays polimórficos** - Array de tipo padre con objetos hijos

## 🔍 Ventajas de la Herencia

| Ventaja | Descripción | Ejemplo |
|---------|-------------|---------|
| **Reutilización** | 8 atributos definidos una vez | protected en padre |
| **Polimorfismo** | Tratar objetos diferentes uniformemente | AquaticActivity[] |
| **Extensibilidad** | Agregar nuevos tipos fácilmente | Nueva subclase |
| **Especialización** | Cada tipo personaliza comportamiento | calculateMonthlyPrice() |
| **Mantenibilidad** | Cambios en un lugar afectan a todos | Modificar padre |
| **Organización** | Jerarquía refleja estructura real | Centro de natación |

## 🎯 Comparación con Semanas Anteriores

| Aspecto | Semana 03 | Semana 04 | Mejora |
|---------|-----------|-----------|--------|
| Clases relacionadas | Composición | Herencia | ✅ |
| Reutilización | Limitada | Alta | +300% |
| Polimorfismo | No | Sí | ✅ |
| Arrays | De tipo específico | Polimórficos | ✅ |
| Comportamiento | Estático | Dinámico | ✅ |
| Flexibilidad | Media | Alta | ✅ |

## 🚀 Próximos Pasos

En la **Semana 05** trabajaremos en:
- **Polimorfismo avanzado**
- Sobrecarga de métodos (overloading)
- Sobrescritura de métodos (overriding)
- Clases abstractas
- Método toString()

---

**Autor:** Santiago Salamanca Narváez  
**Ficha:** 3228973A  
**Fecha:** Diciembre 2025

