# Análisis de Diseño - Semana 06: Centro de Natación Aqua Fitness

## 📋 Información del Proyecto

**Estudiante:** Santiago Salamanca Narváez  
**Ficha:** 3228973A  
**Dominio:** Centro de Natación Aqua Fitness  
**Semana:** 06 - Abstracción e Interfaces

---

## 1. Identificación de Abstracciones

### Clase Abstracta: AquaticActivity

**¿Por qué es abstracta?**

La clase `AquaticActivity` es abstracta porque:

1. **Representa un concepto general**: Una "actividad acuática" es un concepto amplio que engloba diferentes tipos de actividades (natación, aquaeróbicos, hidroterapia, etc.)

2. **Comportamiento común**: Todas las actividades acuáticas comparten atributos y comportamientos comunes:
   - Código de actividad
   - Nombre e instructor
   - Horario y duración
   - Precio y capacidad
   - Inscripciones de participantes

3. **Comportamiento variable**: Cada tipo de actividad calcula su precio de forma diferente, tiene un tipo específico y muestra información particular, por lo que estos métodos deben ser abstractos.

4. **No tiene sentido instanciarla directamente**: No creamos una "actividad acuática genérica", siempre creamos una actividad específica (natación, aquaeróbicos, etc.)

**Métodos Abstractos:**

```java
public abstract double calculateMonthlyPrice();
public abstract String getActivityType();
public abstract void showInfo();
```

**Métodos Concretos:**

```java
public boolean enrollParticipant()
public boolean withdrawParticipant()
public int getAvailableSpots()
public boolean isFull()
public void setActive(boolean active)
```

**Jerarquía:**

```
          AquaticActivity (abstracta)
                  |
     ┌────────────┼────────────┐
     |            |            |
SwimmingLesson AquaAerobics HydroTherapy
     |            |            |
implements:   implements:   implements:
- Reservable  - Evaluable   - Reservable
- Evaluable   - Cancelable  - Evaluable
                            - Cancelable
```

---

## 2. Interfaces Implementadas

### Interface 1: Reservable

**Capacidad que define:** Capacidad de reservar cupos anticipadamente

**Justificación en el dominio:**  
En un centro acuático, las actividades más populares requieren reservas con anticipación. Algunas actividades permiten reservas (natación bebés, hidroterapia) mientras otras no (clases drop-in).

**Métodos:**
- `boolean verificarDisponibilidad(String fecha)`
- `String realizarReserva(String nombreCliente, String fecha, int numeroCupos)`
- `boolean cancelarReserva(String codigoReserva)`
- `int obtenerNumeroReservas()`

**Clases que la implementan:**

| Clase | Justificación |
|-------|---------------|
| **SwimmingLesson** | Las clases de natación, especialmente para bebés y niños, requieren reserva por cupos limitados y atención personalizada |
| **HydroTherapy** | La hidroterapia siempre requiere reserva por ser un servicio médico especializado con cupos muy limitados |

**¿Por qué AquaAerobics NO la implementa?**  
Los aquaeróbicos son clases grupales estilo "drop-in" donde los participantes llegan sin reserva previa, similar a un gimnasio.

---

### Interface 2: Evaluable

**Capacidad que define:** Capacidad de recibir calificaciones y retroalimentación de los participantes

**Justificación en el dominio:**  
En un centro deportivo moderno, la calidad del servicio es fundamental. Permitir que los participantes evalúen las actividades ayuda a:
- Mejorar la calidad del servicio
- Identificar instructores destacados
- Tomar decisiones de contratación
- Atraer nuevos clientes

**Métodos:**
- `void agregarCalificacion(int estrellas, String comentario, String nombreParticipante)`
- `double obtenerPromedioCalificaciones()`
- `int obtenerNumeroEvaluaciones()`
- `boolean tieneCalificacionAlta()`

**Clases que la implementan:**

| Clase | Justificación |
|-------|---------------|
| **SwimmingLesson** | Los padres evalúan la calidad de la enseñanza y el trato con sus hijos |
| **AquaAerobics** | Los participantes evalúan la energía del instructor y la efectividad de los ejercicios |
| **HydroTherapy** | Los pacientes evalúan la efectividad del tratamiento y el profesionalismo del terapeuta |

**¿Por qué TODAS la implementan?**  
En el mundo real, TODAS las actividades de un centro deportivo son evaluadas por los clientes para mantener estándares de calidad.

---

### Interface 3: Cancelable

**Capacidad que define:** Capacidad de cancelar inscripciones con políticas de reembolso

**Justificación en el dominio:**  
Las cancelaciones son inevitables (enfermedad, viajes, emergencias). Un sistema profesional debe manejar:
- Políticas de cancelación claras
- Cálculo de reembolsos según anticipación
- Registro de motivos de cancelación

**Métodos:**
- `boolean cancelarInscripcion(String nombreParticipante, String motivo)`
- `double calcularReembolso(int diasAnticipacion, double montoTotal)`
- `boolean esCancelable(int diasAnticipacion)`
- `String obtenerPoliticaCancelacion()`

**Clases que la implementan:**

| Clase | Justificación |
|-------|---------------|
| **AquaAerobics** | Clases grupales con política de cancelación estándar (7 días: 100%, 3 días: 50%, etc.) |
| **HydroTherapy** | Servicio médico con política más estricta (14 días: 100%, 7 días: 70%, etc.) por la naturaleza especializada |

**¿Por qué SwimmingLesson NO la implementa?**  
Las lecciones de natación tienen cupos muy limitados y lista de espera, por lo que manejan cancelaciones directamente a través del sistema de reservas (interface Reservable).

---

## 3. Decisiones de Diseño

### ¿Por qué Clase Abstracta vs Interface?

#### Elegí Clase Abstracta para AquaticActivity porque:

1. **Relación "es-un" clara:**
   - SwimmingLesson **es una** AquaticActivity
   - AquaAerobics **es una** AquaticActivity
   - HydroTherapy **es una** AquaticActivity

2. **Necesitaba compartir estado (atributos):**
   - Todas las actividades tienen código, nombre, instructor, horario, precio, capacidad
   - Estos atributos son `protected` y se heredan

3. **Había comportamiento común implementable:**
   - `enrollParticipant()`: Lógica común de inscripción
   - `withdrawParticipant()`: Lógica común de baja
   - `getAvailableSpots()`: Cálculo común de cupos

4. **Jerarquía natural:**
   - Las actividades acuáticas forman una jerarquía taxonómica natural

#### Elegí Interfaces para las capacidades porque:

1. **Definen capacidades independientes de jerarquía:**
   - No todas las actividades son "Reservable"
   - No todas las actividades son "Cancelable"
   - Pero TODAS son "Evaluable"

2. **Necesitaba múltiple implementación:**
   - HydroTherapy necesita ser Reservable + Evaluable + Cancelable
   - Si usara clases abstractas, solo podría extender una

3. **Solo definen contrato, no implementación:**
   - Las interfaces solo declaran QUÉ se puede hacer
   - Cada clase decide CÓMO hacerlo según su contexto

4. **Capacidades ortogonales:**
   - Reservar, evaluar y cancelar son capacidades independientes
   - Una actividad puede tener cualquier combinación de estas

### Tabla Comparativa: Cuándo usar cada una

| Situación | Usar Clase Abstracta | Usar Interface |
|-----------|---------------------|----------------|
| Relación "es-un" | ✓ | ✗ |
| Compartir atributos | ✓ | ✗ |
| Compartir implementación | ✓ | ✗ |
| Múltiple herencia | ✗ | ✓ |
| Capacidad independiente | ✗ | ✓ |
| Contrato sin implementación | ✗ | ✓ |

---

## 4. Principios SOLID Aplicados

### Single Responsibility Principle (SRP) ✓

**Aplicación:**

Cada clase tiene una única responsabilidad:

- `AquaticActivity`: Gestionar el comportamiento común de actividades acuáticas
- `SwimmingLesson`: Gestionar lecciones de natación específicamente
- `AquaAerobics`: Gestionar clases de aquaeróbicos
- `HydroTherapy`: Gestionar tratamientos de hidroterapia
- `Reservable`: Definir el contrato de reservas
- `Evaluable`: Definir el contrato de evaluaciones
- `Cancelable`: Definir el contrato de cancelaciones

**Beneficio:** Si necesito cambiar la lógica de reservas, solo modifico las clases que implementan `Reservable`, sin afectar evaluaciones o cancelaciones.

---

### Open/Closed Principle (OCP) ✓

**Aplicación:**

El sistema está **abierto a extensión** pero **cerrado a modificación**:

```java
// ABIERTO: Puedo agregar nuevos tipos de actividades
public class SynchronizedSwimming extends AquaticActivity implements Reservable, Evaluable {
    // Nueva clase sin modificar código existente
}

// ABIERTO: Puedo agregar nuevas interfaces
public interface Descuentable {
    double aplicarDescuento(double porcentaje);
}

// CERRADO: No necesito modificar AquaticActivity para agregar nuevas actividades
```

**Beneficio:** Agregar un nuevo tipo de actividad acuática (natación sincronizada, polo acuático) NO requiere modificar la clase abstracta ni las clases existentes.

---

### Liskov Substitution Principle (LSP) ✓

**Aplicación:**

Cualquier subclase de `AquaticActivity` puede sustituir a la clase padre sin romper el programa:

```java
// Puedo usar cualquier subclase donde se espera AquaticActivity
AquaticActivity activity1 = new SwimmingLesson(...);
AquaticActivity activity2 = new AquaAerobics(...);
AquaticActivity activity3 = new HydroTherapy(...);

// Todas funcionan correctamente
activity1.enrollParticipant();  // ✓ Funciona
activity2.calculateMonthlyPrice();  // ✓ Funciona
activity3.getAvailableSpots();  // ✓ Funciona
```

**Beneficio:** El polimorfismo funciona correctamente. Puedo procesar un array de `AquaticActivity[]` sin saber los tipos específicos.

---

### Interface Segregation Principle (ISP) ✓

**Aplicación:**

Las interfaces son específicas y no obligan a implementar métodos innecesarios:

```java
// ✓ BIEN: Interfaces pequeñas y específicas
interface Reservable { /* solo 4 métodos de reservas */ }
interface Evaluable { /* solo 4 métodos de evaluaciones */ }
interface Cancelable { /* solo 4 métodos de cancelaciones */ }

// ✗ MAL (lo que evité):
interface GestionActividad {
    // Reservas
    boolean verificarDisponibilidad(String fecha);
    String realizarReserva(...);
    
    // Evaluaciones
    void agregarCalificacion(...);
    double obtenerPromedio();
    
    // Cancelaciones
    boolean cancelarInscripcion(...);
    double calcularReembolso(...);
    
    // AquaAerobics tendría que implementar TODOS aunque no use reservas
}
```

**Beneficio:**
- `AquaAerobics` solo implementa `Evaluable` y `Cancelable` (no necesita `Reservable`)
- `SwimmingLesson` solo implementa `Reservable` y `Evaluable` (no necesita `Cancelable`)
- Cada clase implementa solo lo que necesita

---

### Dependency Inversion Principle (DIP) ✓

**Aplicación:**

El código depende de abstracciones, no de implementaciones concretas:

```java
// ✓ Depende de abstracción (interface)
public void procesarReserva(Reservable actividad) {
    if (actividad.verificarDisponibilidad("2025-01-15")) {
        actividad.realizarReserva(...);
    }
}

// Este método funciona con SwimmingLesson Y HydroTherapy
// No depende de clases concretas

// ✓ Depende de abstracción (clase abstracta)
public double calcularIngresosTotales(AquaticActivity[] actividades) {
    double total = 0;
    for (AquaticActivity act : actividades) {
        total += act.calculateMonthlyPrice();  // Polimorfismo
    }
    return total;
}
```

**Beneficio:** El código de alto nivel (métodos de gestión) no depende de detalles de implementación, solo de abstracciones. Esto hace el sistema flexible y testeable.

---

## 5. Mejoras Logradas

### Antes (Semana 05):

```java
// Semana 05: Clases con polimorfismo básico
public abstract class AquaticActivity {
    // Solo métodos abstractos básicos
    public abstract double calculateMonthlyPrice();
    public abstract String getActivityType();
}

// Sin interfaces
// Sin capacidades definidas formalmente
// Cada clase implementaba sus métodos de forma ad-hoc
```

**Problemas:**
- No había forma estandarizada de manejar reservas
- No había sistema de evaluación formal
- No había políticas de cancelación definidas
- Cada clase "inventaba" sus propios métodos

### Después (Semana 06):

```java
// Semana 06: Sistema con interfaces bien definidas
public abstract class AquaticActivity {
    // Comportamiento común + abstractos
}

public interface Reservable { /* contrato de reservas */ }
public interface Evaluable { /* contrato de evaluaciones */ }
public interface Cancelable { /* contrato de cancelaciones */ }

public class SwimmingLesson extends AquaticActivity 
    implements Reservable, Evaluable {
    // Implementación específica
}
```

**Mejoras:**
1. **Contratos formales:** Las interfaces definen claramente QUÉ puede hacer cada actividad
2. **Implementación múltiple:** Una clase puede tener varias capacidades
3. **Código reutilizable:** Métodos que aceptan interfaces funcionan con cualquier implementación
4. **Sistema extensible:** Agregar nuevas capacidades no rompe código existente
5. **Diseño profesional:** Refleja cómo se diseñan sistemas reales

### Ventajas del Nuevo Diseño:

| Aspecto | Antes | Ahora |
|---------|-------|-------|
| **Claridad** | Métodos dispersos | Contratos explícitos en interfaces |
| **Flexibilidad** | Cada clase hace lo suyo | Capacidades combinables |
| **Mantenibilidad** | Cambios dispersos | Cambios localizados en interfaces |
| **Testabilidad** | Difícil de testear | Fácil de mockear interfaces |
| **Documentación** | Implícita | Explícita en interfaces |
| **Extensibilidad** | Requiere modificar clases | Solo implementar interfaces |

---

## 6. Diagrama de Clases

```
┌─────────────────────────────────────────────────────────┐
│         <<abstract>> AquaticActivity                    │
├─────────────────────────────────────────────────────────┤
│ # activityCode: String                                  │
│ # activityName: String                                  │
│ # instructorName: String                                │
│ # schedule: String                                      │
│ # durationMinutes: int                                  │
│ # pricePerSession: double                               │
│ # maxParticipants: int                                  │
│ # currentParticipants: int                              │
│ # isActive: boolean                                     │
├─────────────────────────────────────────────────────────┤
│ + AquaticActivity(...)                                  │
│ + abstract calculateMonthlyPrice(): double              │
│ + abstract getActivityType(): String                    │
│ + abstract showInfo(): void                             │
│ + enrollParticipant(): boolean                          │
│ + withdrawParticipant(): boolean                        │
│ + getAvailableSpots(): int                              │
│ + isFull(): boolean                                     │
│ + setActive(boolean): void                              │
│ + getters/setters...                                    │
└─────────────────────────────────────────────────────────┘
                            △
                            │ extends
            ┌───────────────┼───────────────┐
            │               │               │
┌───────────────────┐ ┌──────────────┐ ┌────────────────┐
│ SwimmingLesson    │ │ AquaAerobics │ │ HydroTherapy   │
├───────────────────┤ ├──────────────┤ ├────────────────┤
│ - level           │ │ - intensity  │ │ - medicalCond  │
│ - techniques      │ │ - musicGenre │ │ - therapist    │
│ - certification   │ │ - equipment  │ │ - approval     │
│ - reservas        │ │ - calorias   │ │ - sessions     │
│ - calificaciones  │ │ - calif      │ │ - reservas     │
│                   │ │ - cancelac   │ │ - calif        │
│                   │ │              │ │ - cancelac     │
├───────────────────┤ ├──────────────┤ ├────────────────┤
│ implements:       │ │ implements:  │ │ implements:    │
│ - Reservable      │ │ - Evaluable  │ │ - Reservable   │
│ - Evaluable       │ │ - Cancelable │ │ - Evaluable    │
│                   │ │              │ │ - Cancelable   │
└───────────────────┘ └──────────────┘ └────────────────┘
         │  │                │  │              │  │  │
         │  │                │  │              │  │  │
         │  └────────────────┼──┘              │  │  │
         │                   │                 │  │  │
         └───────────────────┼─────────────────┘  │  │
                             │                    │  │
                             │                    │  │
    ┌────────────────────────┼────────────────────┼──┘
    │                        │                    │
┌───────────┐         ┌──────────┐         ┌────────────┐
│Reservable │         │Evaluable │         │Cancelable  │
├───────────┤         ├──────────┤         ├────────────┤
│+verificar │         │+agregar  │         │+cancelar   │
│+realizar  │         │+promedio │         │+calcReemb  │
│+cancelar  │         │+numero   │         │+esCancelab │
│+obtenerNum│         │+altaCal  │         │+politica   │
└───────────┘         └──────────┘         └────────────┘
```

**Leyenda:**
- `<<abstract>>`: Clase abstracta
- `△`: Herencia (extends)
- `implements`: Implementación de interface
- `#`: protected
- `-`: private
- `+`: public

---

## 7. Desafíos y Soluciones

### Desafío 1: ¿Qué actividades deben implementar qué interfaces?

**Problema:**  
Al principio consideré que TODAS las actividades deberían implementar TODAS las interfaces, pero eso violaba ISP (Interface Segregation Principle).

**Análisis:**
- ¿SwimmingLesson necesita cancelación formal? No, usa el sistema de reservas
- ¿AquaAerobics necesita reservas? No, es drop-in
- ¿Todas necesitan evaluación? Sí, para mantener calidad

**Solución:**  
Analicé el dominio real de un centro acuático:
- Clases para bebés/niños: SIEMPRE requieren reserva → `Reservable`
- Hidroterapia: Servicio médico → `Reservable` + `Cancelable` (política estricta)
- Aquaeróbicos: Clase grupal → Solo `Cancelable` (sin reserva)
- Todas: Control de calidad → `Evaluable`

---

### Desafío 2: Gestionar estado en interfaces

**Problema:**  
Las interfaces no pueden tener atributos de instancia, pero necesitaba almacenar reservas, calificaciones y cancelaciones.

**Solución:**  
Cada clase que implementa una interface declara sus propios atributos privados:

```java
public class SwimmingLesson extends AquaticActivity implements Reservable, Evaluable {
    // Atributos para Reservable
    private ArrayList<String> reservas;
    private int contadorReservas;
    
    // Atributos para Evaluable
    private ArrayList<Integer> calificaciones;
    private ArrayList<String> comentarios;
    
    // Implementación de métodos...
}
```

**Ventaja:** Cada clase gestiona su propio estado, manteniendo encapsulación.

---

### Desafío 3: Políticas de cancelación diferentes

**Problema:**  
AquaAerobics y HydroTherapy tienen políticas de reembolso muy diferentes:
- Aquaeróbicos: Estándar (7 días: 100%, 3 días: 50%)
- Hidroterapia: Estricta (14 días: 100%, 7 días: 70%)

**Solución:**  
La interface `Cancelable` define el contrato, pero cada clase implementa su propia lógica:

```java
// AquaAerobics
@Override
public double calcularReembolso(int dias, double monto) {
    if (dias >= 7) return monto;        // 100%
    if (dias >= 3) return monto * 0.5;  // 50%
    if (dias >= 1) return monto * 0.25; // 25%
    return 0;
}

// HydroTherapy (más estricta)
@Override
public double calcularReembolso(int dias, double monto) {
    if (dias >= 14) return monto;        // 100%
    if (dias >= 7) return monto * 0.70;  // 70%
    if (dias >= 3) return monto * 0.40;  // 40%
    return 0;
}
```

**Ventaja:** Flexibilidad para definir políticas específicas según el tipo de servicio.

---

### Desafío 4: Compilación con múltiples carpetas

**Problema:**  
Java tenía problemas para encontrar las clases en diferentes carpetas (interfaces/, abstractas/, implementaciones/).

**Solución:**  
Usar compilación secuencial y classpath:

```bash
javac interfaces/*.java
javac -cp .:interfaces abstractas/*.java
javac -cp .:interfaces:abstractas implementaciones/*.java
javac -cp .:interfaces:abstractas:implementaciones Main.java
```

**Alternativa simple:** Copiar todos los archivos a un directorio temporal para compilar juntos (usado en desarrollo).

---

## 8. Próximos Pasos

### Mejoras Futuras

1. **Agregar más interfaces:**
   - `Descuentable`: Para aplicar descuentos por membresía, temporada, etc.
   - `Programable`: Para gestionar horarios y cambios de programación
   - `Certificable`: Para actividades que otorgan certificados

2. **Nuevas actividades:**
   - `WaterPolo`: Deporte competitivo (Reservable + Evaluable)
   - `SynchronizedSwimming`: Natación sincronizada (Reservable + Evaluable)
   - `BabyShower`: Eventos especiales (Reservable + Cancelable)

3. **Sistema de gestión completo:**
   - Clase `AquaFitnessCenter`: Gestión centralizada
   - Persistencia de datos: Guardar reservas, evaluaciones, cancelaciones
   - Reportes: Estadísticas de ocupación, ingresos, satisfacción

4. **Mejoras técnicas:**
   - Usar `LocalDate` en lugar de String para fechas
   - Agregar validaciones más robustas
   - Implementar excepciones personalizadas
   - Crear tests unitarios para cada interface

---

## 9. Conclusiones

### Lecciones Aprendidas

1. **Las interfaces definen contratos:** Son promesas de lo que una clase puede hacer

2. **Abstracción reduce duplicación:** La clase abstracta evita repetir código en todas las subclases

3. **Múltiple implementación da flexibilidad:** Una clase puede tener múltiples capacidades independientes

4. **SOLID mejora el diseño:** Aplicar estos principios hace el código más mantenible y extensible

5. **El dominio guía el diseño:** Las decisiones (qué implementa qué) se basan en la realidad del negocio

### Impacto del Diseño

Este diseño permite:
- ✅ Agregar nuevas actividades fácilmente
- ✅ Agregar nuevas capacidades sin romper código existente
- ✅ Reutilizar código mediante herencia y polimorfismo
- ✅ Mantener responsabilidades separadas (SRP)
- ✅ Testear cada componente independientemente

### Reflexión Final

La combinación de **clase abstracta** (para jerarquía y comportamiento común) más **interfaces** (para capacidades específicas) crea un sistema robusto, flexible y profesional. Este patrón de diseño es fundamental en la programación orientada a objetos moderna y se usa extensivamente en frameworks como Spring, Android, y aplicaciones empresariales.

---

**Fecha de análisis:** Diciembre 2024  
**Versión:** 1.0  
**Estado:** Completado ✓


