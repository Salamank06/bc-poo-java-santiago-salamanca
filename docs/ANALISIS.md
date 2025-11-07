# Análisis Orientado a Objetos - Centro de Natación Aqua Fitness

## 1. Identificación del Dominio

**Nombre del negocio:** Aqua Fitness
**Tipo:** Centro de Natación
**Descripción:** Centro acuático que ofrece clases de natación para todas las edades, entrenamiento deportivo, aquaeróbicos, hidroterapia y rehabilitación acuática, en dos piscinas (semi-olímpica y recreativa).

## 2. Objetos Identificados

### Objeto Principal: ClaseNatacion

**¿Qué es?:** Es el servicio fundamental que vende el centro; una sesión programada con un instructor, un nivel y cupos definidos.

**Atributos identificados:**
- **codigoClase:** `String` - Identificador único de la clase.
- **nivel:** `String` - Categoría de la clase (e.g., "Bebés", "Avanzado").
- **instructor:** `String` - Nombre del instructor responsable.
- **cuposDisponibles:** `int` - Número de espacios que quedan para inscribir estudiantes.
- **precioMensual:** `double` - Costo recurrente para acceder a esta clase.
- **esActiva:** `boolean` - Indica si la clase está abierta a inscripciones (true/false).

**Métodos identificados:**
- **mostrarDetalles():** Muestra todos los datos de la clase en consola.
- **calcularIngresoMaximo():** Calcula el ingreso que se generaría si todos los cupos ocupados pagaran la mensualidad.
- **getInstructor():** Retorna el nombre del instructor.
- **setEsActiva(boolean activa):** Permite cambiar el estado de la clase (activar/desactivar).
- **inscribirEstudiante():** Reduce el contador de cupos disponibles si la clase está activa.

### Objeto Secundario: Estudiante

**¿Qué es?:** La entidad que consume el servicio principal. Es la persona inscrita que paga una mensualidad para asistir a una clase.

**Atributos identificados:**
- **idEstudiante:** `int` - Identificador numérico único.
- **nombreCompleto:** `String` - Nombre de la persona inscrita.
- **telefonoContacto:** `String` - Número de contacto del estudiante o acudiente.
- **nivelAsignado:** `String` - El nivel de natación que tiene o al que está asignado.

**Métodos identificados:**
- **mostrarPerfil():** Imprime los datos básicos del estudiante.
- **realizarPago(double monto):** Simula el proceso de pago y verifica si el monto es suficiente.
- **getNombreCompleto():** Retorna el nombre del estudiante.

## 3. Relación entre Objetos

**Tipo de relación:** Asociación
**Descripción:**
La relación es fundamental en el negocio: la `ClaseNatacion` tiene la responsabilidad de saber cuántos cupos le quedan, y el objeto `Estudiante` necesita invocar el método de inscripción en la clase para poder asistir. Por ejemplo, al inscribir un estudiante, el sistema debe usar la información del `Estudiante` y actualizar el estado de la `ClaseNatacion`.

## 4. Justificación del Diseño

**¿Por qué elegí estos objetos?**
Elegí `ClaseNatacion` porque es el producto central del centro `Aqua Fitness`. Elegí `Estudiante` porque es el cliente y la entidad que genera ingresos. Sin estos dos objetos, el sistema no modelaría el proceso de negocio principal (vender clases a personas).

**¿Por qué estos atributos son importantes?**
Los atributos seleccionados son esenciales para la gestión:
- `codigoClase` / `idEstudiante`: Necesarios para la identificación única en cualquier sistema de gestión.
- `cuposDisponibles` / `esActiva`: Clave para la lógica de negocio (no se puede inscribir si no hay cupos o no está activa).
- `precioMensual`: Necesario para el flujo de pagos e ingresos.
- `nivel` / `instructor`: Detallan el servicio que se ofrece.

**¿Por qué estos métodos son necesarios?**
Los métodos modelan las acciones reales del negocio:
- **`inscribirEstudiante()` / `realizarPago()`:** Reflejan las transacciones principales del centro.
- **`calcularIngresoMaximo()`:** Proporciona un dato útil para la administración (lógica de negocio).
- **Getters y Setters:** Son necesarios para cumplir con el Encapsulamiento y permitir una interacción controlada con los datos privados.

## 5. Comparación: POO vs Programación Estructurada

**Sin POO (Estructurado):**
Para gestionar una inscripción, necesitaríamos una función principal `inscribir(codigo, nivel, cupos, nombre_estudiante, pago_estudiante)`. Los datos de la clase (`cupos`, `nivel`) y los datos del estudiante (`nombre`, `pago`) existirían como variables separadas en diferentes partes del código. Si cambiamos cómo se manejan los cupos, tendríamos que revisar todas las funciones que manipulan esa variable suelta.

**Con POO:**
La lógica de inscripción se encapsula en el método `inscribirEstudiante()` de la clase `ClaseNatacion`. El objeto **`ClaseNatacion`** es responsable de su propia integridad (de no bajar los cupos por debajo de cero). El objeto **`Estudiante`** es responsable de su propio método `realizarPago()`. Esto hace el código más modular, reutilizable y fácil de mantener.

**Ventajas específicas en mi dominio:**
1. **Modularidad y Reutilización:** El código de `Estudiante` (su pago, su información) es un módulo independiente que puede usarse para otras cosas (ej: facturación, historial médico).
2. **Control de Estado (Encapsulamiento):** La clase `ClaseNatacion` controla internamente `cuposDisponibles` sin permitir acceso directo, evitando errores como que un desarrollador escriba por accidente un valor negativo.
3. **Modelado Intuitivo:** Las clases `ClaseNatacion` y `Estudiante` son abstracciones directas de las entidades que el personal de Aqua Fitness maneja a diario.
