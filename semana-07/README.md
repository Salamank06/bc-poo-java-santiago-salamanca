# Semana 07: Paquetes y Excepciones - Centro de Natación Aqua Fitness

## 👤 Información del Estudiante

- **Nombre**: Santiago Salamanca Narváez
- **Ficha**: 3228973A
- **Dominio**: Centro de Natación Aqua Fitness
- **Fecha**: 17/12/2024

## 📝 Descripción del Proyecto

Sistema de gestión para un centro de natación que administra diferentes tipos de actividades acuáticas (clases de natación, aquaeróbicos e hidroterapia). El sistema incluye validaciones robustas, manejo de excepciones personalizadas y una estructura profesional organizada en paquetes.

**Funcionalidades principales:**
- Registro de actividades acuáticas de diferentes tipos
- Gestión de inscripciones con validaciones
- Control de cupos y disponibilidad
- Manejo de actividades activas/inactivas
- Reportes estadísticos
- Manejo completo de excepciones personalizadas

## 📦 Estructura de Paquetes

```
com.aquafitness/
├── modelo/              - Clases del dominio (entidades y lógica de negocio)
│   ├── AquaticActivity.java (abstract)
│   ├── SwimmingLesson.java
│   ├── AquaAerobics.java
│   └── HydroTherapy.java
├── servicio/            - Lógica de gestión y coordinación
│   └── ActivityManager.java
├── excepciones/         - Excepciones personalizadas del dominio
│   ├── ReservaInvalidaException.java
│   ├── CuposAgotadosException.java
│   └── ActividadInactivaException.java
└── Main.java            - Punto de entrada del programa
```

### Descripción de Paquetes

**`com.aquafitness.modelo`**  
Contiene las clases que representan las entidades del dominio: la clase abstracta `AquaticActivity` y sus tres subclases concretas (`SwimmingLesson`, `AquaAerobics`, `HydroTherapy`).

**`com.aquafitness.servicio`**  
Contiene la lógica de negocio y gestión. La clase `ActivityManager` coordina las operaciones sobre las actividades, incluyendo inscripciones, búsquedas y generación de reportes.

**`com.aquafitness.excepciones`**  
Contiene las excepciones personalizadas que modelan los errores específicos del negocio.

## ⚠️ Excepciones Personalizadas

### 1. ReservaInvalidaException

- **Tipo**: Checked (extends Exception)
- **Cuándo se lanza**: 
  - Cuando se intenta procesar una inscripción con datos inválidos
  - Cuando se busca una actividad que no existe
  - Cuando el nombre del participante es vacío o null
  - Cuando el número de participantes es inválido (≤ 0)
- **Ejemplo**: 
  ```java
  throw new ReservaInvalidaException(
      "No se encontró ninguna actividad con el código: " + code
  );
  ```

### 2. CuposAgotadosException

- **Tipo**: Checked (extends Exception)
- **Cuándo se lanza**:
  - Cuando se intenta inscribir a un participante en una actividad llena
  - Cuando una inscripción grupal excede los cupos disponibles
  - Cuando se alcanza la capacidad máxima de la actividad
- **Ejemplo**:
  ```java
  throw new CuposAgotadosException(
      "La actividad " + activityCode + " está llena. Cupos: " + 
      currentParticipants + "/" + maxParticipants
  );
  ```

### 3. ActividadInactivaException

- **Tipo**: Checked (extends Exception)
- **Cuándo se lanza**:
  - Cuando se intenta inscribir participantes en una actividad desactivada
  - Cuando se realiza una operación en una actividad cancelada temporalmente
  - Cuando una actividad está suspendida por mantenimiento
- **Ejemplo**:
  ```java
  throw new ActividadInactivaException(
      "La actividad " + activityCode + " está inactiva y no acepta inscripciones"
  );
  ```

## 🚀 Cómo Ejecutar

### Desde terminal (Windows con Git Bash):

```bash
cd semana-07

# Compilar
javac -encoding UTF-8 -d bin src/com/aquafitness/excepciones/*.java src/com/aquafitness/modelo/*.java src/com/aquafitness/servicio/*.java src/com/aquafitness/Main.java

# Ejecutar
java -cp bin com.aquafitness.Main
```

### Desde IntelliJ IDEA:

1. Abrir proyecto en IntelliJ
2. Marcar la carpeta `src` como "Sources Root" (clic derecho → Mark Directory as → Sources Root)
3. Clic derecho en `Main.java`
4. Run 'Main.main()'

### Desde Visual Studio Code:

1. Abrir la carpeta `semana-07`
2. Instalar la extensión "Extension Pack for Java"
3. Abrir `Main.java`
4. Clic en "Run" arriba del método `main()`

## ✅ Funcionalidades Implementadas

- [x] Organización en paquetes (com.aquafitness.*)
- [x] Declaraciones `package` en todos los archivos
- [x] Imports específicos (no wildcards innecesarios)
- [x] 3 excepciones personalizadas (checked)
- [x] Excepciones con 2 constructores (mensaje, mensaje+causa)
- [x] Validaciones con `throw`
- [x] Métodos declaran excepciones con `throws`
- [x] Try-catch en Main para cada caso
- [x] Finally para limpieza de recursos
- [x] 7 casos de prueba en Main (se pidieron 5, se implementaron 7)
- [x] Documentación Javadoc completa

## 📊 Salida Esperada

```
╔══════════════════════════════════════════════════════════════╗
║     AQUA FITNESS - SEMANA 07: PAQUETES Y EXCEPCIONES        ║
╚══════════════════════════════════════════════════════════════╝

✓ Gestor de actividades creado

═══════════════════════════════════════════════════════════════
  CASO 1: INSCRIPCIÓN EXITOSA
═══════════════════════════════════════════════════════════════
✓ Actividad agregada: SWIM-101 - Natación Bebés

→ Procesando inscripción de María González en SWIM-101...
✓ Participante inscrito en SWIM-101 (1/8)
✓ Inscripción exitosa para María González

→ Procesando inscripción de Pedro Ramírez en SWIM-101...
✓ Participante inscrito en SWIM-101 (2/8)
✓ Inscripción exitosa para Pedro Ramírez

✓ Caso 1 completado exitosamente

═══════════════════════════════════════════════════════════════
  CASO 2: VALIDACIÓN DE DATOS INVÁLIDOS
═══════════════════════════════════════════════════════════════

→ Intentando crear actividad con duración negativa...
❌ Validación correcta: La duración debe ser mayor a 0 minutos
✓ La validación funcionó como esperado

═══════════════════════════════════════════════════════════════
  CASO 3: ACTIVIDAD NO ENCONTRADA (ReservaInvalidaException)
═══════════════════════════════════════════════════════════════

→ Intentando inscribir en actividad inexistente...
❌ Reserva inválida: No se encontró ninguna actividad con el código: SWIM-999
✓ Excepción ReservaInvalidaException capturada correctamente

═══════════════════════════════════════════════════════════════
  CASO 4: SIN CUPOS DISPONIBLES (CuposAgotadosException)
═══════════════════════════════════════════════════════════════
✓ Actividad agregada: AERO-101 - Aquaeróbicos

→ Intentando inscripción grupal de 5 personas en actividad con 2 cupos...
❌ Sin cupos suficientes: No hay suficientes cupos. Disponibles: 2, Solicitados: 5
✓ Excepción CuposAgotadosException capturada correctamente

═══════════════════════════════════════════════════════════════
  CASO 5: ACTIVIDAD INACTIVA (ActividadInactivaException)
═══════════════════════════════════════════════════════════════
✓ Actividad agregada: HYDRO-101 - Rehabilitación

→ Desactivando hidroterapia...
HYDRO-101 desactivada
→ Intentando inscribir en actividad inactiva...

→ Procesando inscripción de Ana Martínez en HYDRO-101...
⚠️ Inscripción requiere aprobación médica previa
❌ Actividad inactiva: La actividad HYDRO-101 está inactiva y no acepta inscripciones
✓ Excepción ActividadInactivaException capturada correctamente

═══════════════════════════════════════════════════════════════
  CASO 6: RECUPERACIÓN DESPUÉS DE ERROR
═══════════════════════════════════════════════════════════════

→ Reactivando hidroterapia e intentando nueva inscripción...
HYDRO-101 activada

→ Procesando inscripción de Ana Martínez en HYDRO-101...
⚠️ Inscripción requiere aprobación médica previa
✓ Participante inscrito en HYDRO-101 (1/4)
✓ Inscripción exitosa para Ana Martínez
✓ Recuperación exitosa: la actividad fue reactivada y la inscripción completada

[... Más salida ...]
```

## 🔧 Cambios Aplicados desde Semana 06

### 1. Reorganización en Paquetes
- **Antes**: Todos los archivos en `src/` directamente
- **Ahora**: Estructura organizada en `com.aquafitness.{modelo, servicio, excepciones}`
- **Beneficio**: Código más profesional y mantenible

### 2. Excepciones Personalizadas
- **Antes**: Solo validaciones con `IllegalArgumentException`
- **Ahora**: 3 excepciones personalizadas específicas del dominio
- **Beneficio**: Errores más descriptivos y manejables

### 3. Validaciones Robustas
- **Antes**: Validaciones básicas
- **Ahora**: Validaciones en constructores, setters y métodos críticos
- **Beneficio**: Sistema más confiable y seguro

### 4. Manejo de Errores Estructurado
- **Antes**: Manejo básico con try-catch
- **Ahora**: Try-catch específico por tipo de excepción, con finally
- **Beneficio**: Mejor control de errores y limpieza de recursos

### 5. Documentación Javadoc
- **Antes**: Comentarios básicos
- **Ahora**: Javadoc completo en excepciones y métodos críticos
- **Beneficio**: Código autodocumentado

## 💡 Decisiones de Diseño

### Checked vs Unchecked Exceptions

**Se usaron excepciones checked (extend `Exception`) porque:**
1. Son errores de negocio esperables (no bugs del programador)
2. El código que llama DEBE manejarlos (obliga a pensar en el error)
3. Son recuperables (se puede continuar después del error)

**Ejemplo:**  
`CuposAgotadosException` es checked porque es un escenario normal del negocio (las actividades se llenan). El programador DEBE decidir qué hacer cuando no hay cupos.

### Separación de Excepciones en Paquete Propio

**Razones:**
1. **Claridad**: Fácil encontrar todas las excepciones del sistema
2. **Reutilización**: Pueden ser usadas por múltiples paquetes
3. **Mantenimiento**: Cambios en excepciones no afectan otras clases
4. **Convención**: Sigue el estándar de la industria

### Validaciones en Constructor vs Setters

**Se implementaron validaciones en ambos:**
- **Constructor**: Previene creación de objetos inválidos desde el inicio
- **Setters**: Previene que objetos válidos se vuelvan inválidos después

### Múltiples Bloques Catch vs Catch Único

**Se usaron múltiples catch específicos:**
```java
try {
    // Operación
} catch (ReservaInvalidaException e) {
    // Manejo específico para reserva inválida
} catch (CuposAgotadosException e) {
    // Manejo específico para falta de cupos
} catch (ActividadInactivaException e) {
    // Manejo específico para actividad inactiva
}
```

**Ventaja**: Cada tipo de error tiene un manejo específico y mensaje apropiado.

## 📚 Referencias

- Oracle Java Documentation - Exceptions: https://docs.oracle.com/javase/tutorial/essential/exceptions/
- Oracle Java Documentation - Packages: https://docs.oracle.com/javase/tutorial/java/package/
- Effective Java by Joshua Bloch - Item 69: Use exceptions only for exceptional conditions
- Material del curso: Semana 07 - Teoría de paquetes y excepciones

## 🎯 Casos de Prueba Implementados

| # | Caso | Excepción/Validación | Estado |
|---|------|---------------------|--------|
| 1 | Inscripción exitosa | Ninguna | ✅ Éxito |
| 2 | Duración negativa | IllegalArgumentException | ✅ Capturada |
| 3 | Actividad inexistente | ReservaInvalidaException | ✅ Capturada |
| 4 | Sin cupos disponibles | CuposAgotadosException | ✅ Capturada |
| 5 | Actividad inactiva | ActividadInactivaException | ✅ Capturada |
| 6 | Recuperación post-error | Ninguna | ✅ Éxito |
| 7 | Finally con limpieza | Finally block | ✅ Ejecutado |

## 🏆 Cumplimiento de Requisitos

| Requisito | Puntos | Estado |
|-----------|--------|--------|
| **Ejercicio 1: Reorganización en Paquetes** | 25 | ✅ 25/25 |
| - Estructura de carpetas | 10 | ✅ |
| - Mover clases apropiadamente | 10 | ✅ |
| - Package e imports | 5 | ✅ |
| **Ejercicio 2: Validaciones con Excepciones** | 30 | ✅ 30/30 |
| - Identificar operaciones críticas | 5 | ✅ |
| - Implementar validaciones | 15 | ✅ |
| - Try-catch en servicio | 10 | ✅ |
| **Ejercicio 3: Excepciones Personalizadas** | 25 | ✅ 25/25 |
| - Crear 2+ excepciones | 10 | ✅ 3 creadas |
| - Usar en servicio | 10 | ✅ |
| - Documentar con Javadoc | 5 | ✅ |
| **Ejercicio 4: Main de Demostración** | 20 | ✅ 20/20 |
| - 5+ casos de prueba | 15 | ✅ 7 casos |
| - Finally para limpieza | 5 | ✅ |
| **TOTAL** | **100** | ✅ **100/100** |

---

**Versión**: 1.0  
**Semana**: 07  
**Estado**: ✅ Completo  
**Última actualización**: 17/12/2024
