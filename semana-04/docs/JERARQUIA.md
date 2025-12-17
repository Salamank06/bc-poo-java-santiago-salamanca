# Jerarquía de Clases - Semana 04

## 1. Diagrama de Jerarquía

```
                    AquaticActivity
                   (Clase Padre)
                         |
            +------------+------------+
            |            |            |
      SwimmingLesson  AquaAerobics  HydroTherapy
      (Subclase 1)    (Subclase 2)  (Subclase 3)
```

### Representación Detallada

```
┌─────────────────────────────────────┐
│      AquaticActivity (Padre)        │
├─────────────────────────────────────┤
│ # activityCode: String              │
│ # activityName: String              │
│ # instructorName: String            │
│ # schedule: String                  │
│ # durationMinutes: int              │
│ # pricePerSession: double           │
│ # maxParticipants: int              │
│ # currentParticipants: int          │
├─────────────────────────────────────┤
│ + showInfo(): void                  │
│ + calculateMonthlyPrice(): double   │
│ + enrollParticipant(): boolean      │
│ + getActivityType(): String         │
└─────────────────────────────────────┘
           ▲          ▲          ▲
           │          │          │
    ┌──────┘          │          └──────┐
    │                 │                 │
┌───┴────────┐  ┌─────┴─────┐  ┌───────┴──────┐
│Swimming    │  │AquaAero   │  │HydroTherapy  │
│Lesson      │  │bics       │  │              │
├────────────┤  ├───────────┤  ├──────────────┤
│- level     │  │- intensity│  │- medical     │
│- techniques│  │- music    │  │  Condition   │
│- certifica │  │- equipment│  │- therapist   │
│  tion      │  │- calories │  │- sessions    │
└────────────┘  └───────────┘  └──────────────┘
```

---

## 2. Descripción de la Clase Padre

### AquaticActivity (Actividad Acuática)

**Propósito:**  
Clase padre abstracta que representa cualquier actividad que se realiza en el centro de natación Aqua Fitness. Encapsula las características y comportamientos comunes a todas las actividades acuáticas.

**¿Por qué es clase padre?**  
Porque todas las actividades del centro (natación, aquaeróbicos, hidroterapia) comparten atributos y comportamientos básicos como código, instructor, horario, precio y capacidad de participantes.

**Atributos protected (heredables):**

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| `activityCode` | String | Código único de identificación |
| `activityName` | String | Nombre descriptivo de la actividad |
| `instructorName` | String | Nombre del instructor/terapeuta |
| `schedule` | String | Horario de la actividad |
| `durationMinutes` | int | Duración en minutos |
| `pricePerSession` | double | Precio por sesión individual |
| `maxParticipants` | int | Capacidad máxima |
| `currentParticipants` | int | Participantes actuales inscritos |

**Métodos heredables:**

1. `showInfo()` - Muestra información básica de la actividad
2. `calculateMonthlyPrice()` - Calcula precio mensual (3 sesiones/semana * 4 semanas)
3. `enrollParticipant()` - Inscribe un participante
4. `getAvailableSpots()` - Retorna cupos disponibles
5. `getActivityType()` - Retorna tipo de actividad (sobrescrito en subclases)

---

## 3. Descripción de las Subclases

### 3.1 SwimmingLesson (Clase de Natación)

**Hereda de:** `AquaticActivity`

**Propósito:**  
Representa clases de natación para diferentes niveles (bebés, niños, adolescentes, adultos).

**Atributos específicos:**
- `level` (String) - Nivel de la clase (Bebés, Niños, Adolescentes, Adultos)
- `techniquesFocus` (String) - Técnicas que se enseñan (Crol, Espalda, Pecho, Mariposa)
- `includesCertification` (boolean) - Si incluye certificación oficial

**Métodos sobrescritos (@Override):**
- `showInfo()` - Agrega información de nivel y técnicas
- `calculateMonthlyPrice()` - Aplica ajustes según nivel (bebés +20%, adultos -10%)
- `getActivityType()` - Retorna "Clase de Natación - [Nivel]"

**Métodos específicos:**
- `evaluateProgress()` - Evalúa progreso de los estudiantes
- `getSkillLevel()` - Retorna estado de la clase según ocupación

**Justificación:**  
Las clases de natación requieren especificar el nivel y las técnicas, además de calcular precios diferenciados según la edad de los participantes.

---

### 3.2 AquaAerobics (Aquaeróbicos)

**Hereda de:** `AquaticActivity`

**Propósito:**  
Representa clases de ejercicio aeróbico en el agua con música.

**Atributos específicos:**
- `intensityLevel` (String) - Intensidad (Baja, Media, Alta)
- `musicGenre` (String) - Género musical (Pop, Electrónica, Latina)
- `requiresEquipment` (boolean) - Si requiere equipo (flotadores, pesas)
- `caloriesBurned` (int) - Calorías quemadas estimadas

**Métodos sobrescritos (@Override):**
- `showInfo()` - Agrega información de intensidad, música y calorías
- `calculateMonthlyPrice()` - Agrega $20,000 si requiere equipo
- `getActivityType()` - Retorna "Aquaeróbicos - Intensidad [Nivel]"

**Métodos específicos:**
- `warmUp()` - Inicia calentamiento con música
- `coolDown()` - Enfriamiento y estiramientos
- `getHealthBenefits()` - Retorna beneficios para la salud
- `calculateCalories()` - Calcula calorías según intensidad

**Justificación:**  
Los aquaeróbicos tienen características únicas como intensidad variable, uso de música y quema de calorías, que no aplican a otras actividades.

---

### 3.3 HydroTherapy (Hidroterapia)

**Hereda de:** `AquaticActivity`

**Propósito:**  
Representa sesiones de hidroterapia para rehabilitación y tratamiento médico.

**Atributos específicos:**
- `medicalCondition` (String) - Condición a tratar (Rehabilitación, Lesiones, Estrés, Post-operatorio)
- `therapistName` (String) - Nombre del terapeuta especializado
- `requiresMedicalApproval` (boolean) - Si requiere aprobación médica
- `sessionsRecommended` (int) - Número de sesiones recomendadas

**Métodos sobrescritos (@Override):**
- `showInfo()` - Agrega información médica y terapeuta
- `calculateMonthlyPrice()` - Aplica +50% por ser servicio especializado
- `getActivityType()` - Retorna "Hidroterapia - [Condición]"
- `enrollParticipant()` - Verifica si requiere aprobación médica antes de inscribir

**Métodos específicos:**
- `assessPatient()` - Evaluación inicial del paciente
- `generateTherapyPlan()` - Genera plan de tratamiento
- `calculateTreatmentCost()` - Calcula costo del tratamiento completo
- `getTherapyGoals()` - Retorna objetivos según condición

**Justificación:**  
La hidroterapia es un servicio médico especializado que requiere aprobación, tiene costos más altos y necesita planes de tratamiento personalizados.

---

## 4. Justificación del Diseño

### ¿Por qué elegí esta jerarquía?

**Análisis del dominio:**

El Centro de Natación Aqua Fitness ofrece tres tipos principales de actividades acuáticas:
1. Clases de natación (enseñanza)
2. Aquaeróbicos (fitness)
3. Hidroterapia (salud/rehabilitación)

Todas comparten características comunes:
- Código de identificación
- Instructor responsable
- Horario y duración
- Precio y capacidad
- Inscripción de participantes

Pero cada una tiene características específicas que las diferencian.

### Ventajas de usar Herencia en este caso:

1. **Reutilización de código:** Los 8 atributos comunes y 4 métodos base se definen una sola vez en la clase padre

2. **Polimorfismo:** Puedo tratar todas las actividades de forma uniforme en arrays y métodos genéricos

3. **Extensibilidad:** Agregar un nuevo tipo de actividad (ej: Natación Sincronizada) solo requiere crear una nueva subclase

4. **Especialización:** Cada subclase puede sobrescribir métodos para comportamientos específicos (ej: cálculo de precio diferenciado)

5. **Organización lógica:** La jerarquía refleja la estructura real del negocio

6. **Mantenibilidad:** Cambios en comportamientos comunes se hacen en un solo lugar (clase padre)

---

## 5. Atributos Heredados

Todos estos atributos son **protected** para que las subclases puedan accederlos directamente:

| Atributo | Tipo | Acceso desde subclases |
|----------|------|----------------------|
| `activityCode` | String | ✅ Directo |
| `activityName` | String | ✅ Directo |
| `instructorName` | String | ✅ Directo |
| `schedule` | String | ✅ Directo |
| `durationMinutes` | int | ✅ Directo |
| `pricePerSession` | double | ✅ Directo |
| `maxParticipants` | int | ✅ Directo |
| `currentParticipants` | int | ✅ Directo |

**Uso de protected:**  
Los atributos son `protected` (no `private`) porque las subclases necesitan acceso directo para sus cálculos específicos. Por ejemplo:
- `SwimmingLesson` usa `pricePerSession` para calcular descuentos
- `AquaAerobics` usa `durationMinutes` para calcular calorías
- `HydroTherapy` usa `currentParticipants` para validar aprobación médica

---

## 6. Métodos Sobrescritos

### 6.1 showInfo()

**Clase padre:** Muestra información básica (código, nombre, instructor, horario, precio, participantes)

**SwimmingLesson:** Agrega nivel, técnicas y certificación

**AquaAerobics:** Agrega intensidad, música, equipo y calorías

**HydroTherapy:** Agrega condición médica, terapeuta y sesiones recomendadas

**Técnica:** Todas las subclases llaman primero a `super.showInfo()` y luego agregan su información específica.

```java
@Override
public void showInfo() {
    super.showInfo(); // Primero mostrar info básica
    // Luego agregar info específica
    System.out.println("Nivel: " + level);
}
```

---

### 6.2 calculateMonthlyPrice()

**Clase padre:** Precio base = sesión * 3 * 4 (3 sesiones/semana, 4 semanas/mes)

**SwimmingLesson:**
- Bebés: +20% (requieren cuidado especial)
- Adultos: -10% (descuento)
- Otros: precio base

**AquaAerobics:**
- +$20,000 si requiere equipo
- Precio base si no requiere equipo

**HydroTherapy:**
- +50% sobre precio base (servicio médico especializado)

**Lógica:**
```java
@Override
public double calculateMonthlyPrice() {
    double basePrice = super.calculateMonthlyPrice(); // Obtener base
    // Aplicar ajustes específicos
    return basePrice * factor;
}
```

---

### 6.3 getActivityType()

**Clase padre:** "Actividad Acuática Genérica"

**SwimmingLesson:** "Clase de Natación - [Nivel]"

**AquaAerobics:** "Aquaeróbicos - Intensidad [Nivel]"

**HydroTherapy:** "Hidroterapia - [Condición]"

**Propósito:** Identificar el tipo específico de actividad en tiempo de ejecución (polimorfismo).

---

### 6.4 enrollParticipant() (solo HydroTherapy)

**Clase padre:** Inscribe si hay cupos disponibles

**HydroTherapy:** Verifica primero si requiere aprobación médica, luego llama al método del padre

```java
@Override
public boolean enrollParticipant() {
    if (requiresMedicalApproval) {
        System.out.println("⚠️ Requiere aprobación médica");
    }
    return super.enrollParticipant(); // Inscripción normal
}
```

---

## 7. Uso de super()

### En Constructores

Todas las subclases usan `super()` para llamar al constructor del padre:

```java
public SwimmingLesson(...params específicos..., ...params del padre...) {
    super(...params del padre...); // Primero inicializar el padre
    // Luego inicializar atributos propios
    this.level = level;
    this.techniquesFocus = techniquesFocus;
}
```

**Orden obligatorio:** `super()` DEBE ser la primera línea del constructor.

### En Métodos

Las subclases usan `super.metodo()` para reutilizar lógica del padre:

```java
@Override
public void showInfo() {
    super.showInfo(); // Ejecutar lógica del padre primero
    // Agregar lógica propia
}
```

---

## 8. Polimorfismo Demostrado

### Arrays Polimórficos

```java
AquaticActivity[] activities = new AquaticActivity[6];
activities[0] = new SwimmingLesson(...);
activities[1] = new AquaAerobics(...);
activities[2] = new HydroTherapy(...);

// Mismo bucle, diferentes comportamientos
for (AquaticActivity activity : activities) {
    activity.showInfo(); // Llama al método de cada subclase
}
```

### instanceof y Casting

```java
if (activity instanceof SwimmingLesson) {
    SwimmingLesson lesson = (SwimmingLesson) activity;
    lesson.evaluateProgress(); // Método específico
}
```

---

## 9. Beneficios Logrados

1. **Código DRY (Don't Repeat Yourself):** 8 atributos y 4 métodos definidos una sola vez

2. **Flexibilidad:** Mismo código puede manejar diferentes tipos de actividades

3. **Escalabilidad:** Agregar nuevos tipos es fácil (nueva subclase)

4. **Mantenibilidad:** Cambios en comportamiento común se hacen en un lugar

5. **Polimorfismo real:** Arrays y métodos genéricos que funcionan con cualquier actividad

6. **Especialización controlada:** Cada subclase puede personalizar comportamientos según sus necesidades

---

## 10. Conclusiones

La jerarquía de clases implementada refleja perfectamente la estructura del Centro de Natación Aqua Fitness. El uso de herencia permite:

- **Modelar la realidad:** Las actividades comparten características pero tienen especialidades
- **Código eficiente:** Reutilización máxima sin duplicación
- **Flexibilidad:** Polimorfismo permite tratar actividades diferentes de forma uniforme
- **Extensibilidad:** Fácil agregar nuevos tipos de actividades

Esta jerarquía es la base para implementar **polimorfismo avanzado** en la Semana 05.
