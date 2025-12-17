# Semana 02: Clases, Objetos y ArrayList

## 📝 Descripción

Esta semana se expande el sistema del Centro de Natación Aqua Fitness agregando nuevas clases, implementando relaciones entre objetos y utilizando ArrayList para gestionar colecciones dinámicas.

## 🎯 Objetivos Cumplidos

- [x] Crear 2 nuevas clases relacionadas con el dominio
- [x] Implementar relaciones entre objetos (composición/agregación)
- [x] Usar ArrayList para gestionar colecciones
- [x] Crear clase gestora del centro acuático
- [x] Programa Main completo con demostración de todas las funcionalidades

## 📂 Archivos Entregados

### Código Fuente (`src/`)

#### **Nuevas Clases (Ejercicio 1 - 30 puntos)**

1. **`Pool.java`** - Representa las piscinas del centro
   - 6 atributos: poolId, poolName, poolType, maxCapacity, temperature, isAvailable
   - Constructor completo
   - Getters y setters
   - Método de negocio: `canAccommodate(int)` - verifica si puede acomodar cierto número de personas
   - Método: `getPoolSummary()` - resumen de la piscina

2. **`Schedule.java`** - Representa horarios de las clases
   - 4 atributos: dayOfWeek, startTime, endTime, durationMinutes
   - Constructor que calcula automáticamente la duración
   - Getters y setters
   - Método de negocio: `isInMorning()` - determina si el horario es matutino
   - Método: `calculateDuration()` - calcula duración en minutos

#### **Clases con Relaciones (Ejercicio 2 - 25 puntos)**

3. **`SwimmingClass.java`** - Clase de natación mejorada con relaciones
   - **Relación con `Instructor`**: cada clase tiene un instructor asignado
   - **Relación con `Pool`**: cada clase se imparte en una piscina específica
   - **Relación con `Schedule`**: cada clase tiene un horario definido
   - Composición: la clase contiene objetos de otras clases

4. **`Student.java`** - Estudiante mejorado
   - Atributo adicional: phoneNumber
   - Método: `activateMembership()` - activa la membresía del estudiante

5. **`Instructor.java`** - Instructor mejorado
   - Atributo adicional: specialization
   - Método: `isExperienced()` - determina si tiene 5+ años de experiencia

#### **Clase Gestora con ArrayList (Ejercicio 3 - 20 puntos)**

6. **`AquaticsCenter.java`** - Gestora principal del sistema
   - **4 ArrayList:**
     - `ArrayList<SwimmingClass> swimmingClasses` - gestiona clases
     - `ArrayList<Student> students` - gestiona estudiantes  
     - `ArrayList<Pool> pools` - gestiona piscinas
     - `ArrayList<Instructor> instructors` - gestiona instructores
   
   - **Métodos de gestión:**
     - `addSwimmingClass()`, `addStudent()`, `addPool()`, `addInstructor()`
     - `showAllClasses()` - itera y muestra todas las clases
     - `showAllStudents()` - itera y muestra todos los estudiantes
     - `showStatistics()` - estadísticas generales del centro
   
   - **Métodos de búsqueda:**
     - `findClassByCode()` - busca clase por código
     - `getClassesByLevel()` - filtra clases por nivel
     - `countActiveClasses()` - cuenta clases activas
     - `getTotalAvailableSpots()` - suma cupos disponibles

#### **Programa Principal (Ejercicio 4 - 25 puntos)**

7. **`Main.java`** - Demostración completa del sistema
   - Crea 2 piscinas
   - Crea 3 instructores
   - Crea 4 horarios
   - Crea 4 clases de natación con relaciones
   - Crea 5 estudiantes
   - Demuestra inscripciones
   - Usa métodos de ArrayList (add, size, get, iteración)
   - Muestra búsquedas y filtros
   - Ejecuta métodos de negocio

## 🔗 Relaciones Implementadas

### Composición (has-a)
```
SwimmingClass HAS-A Instructor
SwimmingClass HAS-A Pool
SwimmingClass HAS-A Schedule
```

### Agregación (manages)
```
AquaticsCenter MANAGES SwimmingClass (ArrayList)
AquaticsCenter MANAGES Student (ArrayList)
AquaticsCenter MANAGES Pool (ArrayList)
AquaticsCenter MANAGES Instructor (ArrayList)
```

### Diagrama de Relaciones
```
┌─────────────────────┐
│  AquaticsCenter     │
│  (Gestora)          │
├─────────────────────┤
│ - swimmingClasses   │───┐
│ - students          │   │
│ - pools             │   │ ArrayList
│ - instructors       │   │
└─────────────────────┘   │
                          ▼
        ┌────────────────────────────┐
        │    SwimmingClass           │
        ├────────────────────────────┤
        │ - instructor: Instructor   │───> Instructor
        │ - assignedPool: Pool       │───> Pool
        │ - schedule: Schedule       │───> Schedule
        └────────────────────────────┘
```

## 🚀 Instrucciones de Ejecución

### Desde la carpeta `semana-02/`:

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
javac -encoding UTF-8 semana-02/src/*.java

# Ejecutar
java -cp semana-02/src Main
```

## 📊 Salida del Programa

El programa ejecuta 12 pasos que demuestran:

1. ✅ Registro de piscinas en el centro
2. ✅ Registro de instructores
3. ✅ Creación de horarios
4. ✅ Creación de clases con relaciones (Instructor + Pool + Schedule)
5. ✅ Registro de estudiantes
6. ✅ Inscripción de estudiantes en clases
7. ✅ Información detallada de una clase (muestra relaciones)
8. ✅ Información de piscina y horario
9. ✅ Uso de métodos de la clase gestora con ArrayList
10. ✅ Búsquedas y filtros en ArrayList
11. ✅ Demostración de métodos de negocio
12. ✅ Resumen final con estadísticas

## 🔍 Conceptos de POO Aplicados

### 1. Relaciones entre Clases
- **Composición:** SwimmingClass contiene objetos Instructor, Pool y Schedule
- **Agregación:** AquaticsCenter gestiona colecciones de objetos

### 2. ArrayList (java.util.ArrayList)
- Colecciones dinámicas que crecen automáticamente
- Métodos usados: `add()`, `get()`, `size()`, iteración con for-each
- Gestión de múltiples objetos sin arrays de tamaño fijo

### 3. Iteración
```java
for (SwimmingClass sc : swimmingClasses) {
    // procesar cada clase
}
```

### 4. Métodos de Búsqueda
```java
public SwimmingClass findClassByCode(String code) {
    for (SwimmingClass sc : swimmingClasses) {
        if (sc.getClassCode().equals(code)) {
            return sc;
        }
    }
    return null;
}
```

### 5. Composición de Objetos
```java
SwimmingClass class1 = new SwimmingClass(
    "SWIM-101", 
    "Bebés", 
    instructor1,    // Objeto Instructor
    pool2,          // Objeto Pool
    schedule1,      // Objeto Schedule
    8, 
    150000
);
```

## 📈 Requerimientos Cumplidos

### Ejercicio 1: 2 Nuevas Clases (30/30 puntos)
- ✅ Pool.java con 6 atributos y método de negocio
- ✅ Schedule.java con 4 atributos y cálculo automático de duración
- ✅ Constructores completos
- ✅ Getters y setters
- ✅ Relación con clases existentes

### Ejercicio 2: Relaciones (25/25 puntos)
- ✅ SwimmingClass con composición de 3 objetos
- ✅ Relaciones bien definidas y funcionales
- ✅ Métodos que utilizan objetos relacionados

### Ejercicio 3: ArrayList (20/20 puntos)
- ✅ AquaticsCenter con 4 ArrayList
- ✅ Métodos de gestión (add, show, count)
- ✅ Iteración sobre colecciones
- ✅ Búsquedas y filtros

### Ejercicio 4: Main Completo (25/25 puntos)
- ✅ Crea objetos de todas las clases
- ✅ Demuestra relaciones entre objetos
- ✅ Usa ArrayList extensivamente
- ✅ Salida formateada y profesional
- ✅ Compila y ejecuta sin errores

**TOTAL: 100/100 puntos** ✅

## 💡 Nuevos Conceptos Aprendidos

1. **ArrayList vs Arrays:** Colecciones dinámicas más flexibles
2. **Import:** Uso de `import java.util.ArrayList`
3. **Generics:** `ArrayList<SwimmingClass>` especifica el tipo
4. **Composición:** Objetos que contienen otros objetos
5. **Navegación de relaciones:** `class1.getInstructor().getFullName()`

## 🔗 Comparación Semana 01 vs Semana 02

| Aspecto | Semana 01 | Semana 02 |
|---------|-----------|-----------|
| Clases | 2 clases básicas | 6 clases interrelacionadas |
| Relaciones | Sin relaciones | Composición y agregación |
| Colecciones | No | ArrayList (4 colecciones) |
| Gestión | Manual | Clase gestora centralizada |
| Complejidad | Baja | Media |

## 🚀 Próximos Pasos

En la **Semana 03** trabajaremos en:
- Encapsulamiento completo (private + getters/setters)
- Sobrecarga de constructores
- Validaciones en setters
- Mejora de la robustez del código

---

**Autor:** Santiago Salamanca Narváez  
**Ficha:** 3228973A  
**Fecha:** Diciembre 2025

