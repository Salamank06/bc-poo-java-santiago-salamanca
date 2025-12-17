# Análisis Orientado a Objetos - Centro de Natación Aqua Fitness

## 1. Identificación del Dominio

**Nombre del negocio:** Aqua Fitness  
**Tipo:** Centro de Natación y Actividades Acuáticas  
**Descripción:** Centro acuático ubicado en Bogotá (Salitre) que ofrece clases de natación para bebés, niños, adolescentes y adultos, entrenamiento deportivo para competencia, aquaeróbicos, hidroterapia y rehabilitación acuática. Cuenta con 2 piscinas (semi-olímpica y recreativa), 8 instructores certificados, vestiers, duchas y zona de hidratación. Atiende 250 estudiantes activos.

---

## 2. Objetos Identificados

### Objeto Principal: SwimmingClass (Clase de Natación)

**¿Qué es?:** Representa una sesión o curso de natación que se ofrece en el centro acuático. Es el producto/servicio principal que se comercializa.

**Atributos identificados:**
- `classCode`: String - Código único de identificación de la clase (ej: SWIM-001)
- `level`: String - Nivel de habilidad (Bebés, Niños Principiantes, Adolescentes Intermedio, Adultos Avanzado)
- `instructor`: String - Nombre del instructor asignado a la clase
- `capacity`: int - Capacidad máxima de estudiantes por clase
- `enrolledStudents`: int - Número actual de estudiantes inscritos
- `monthlyPrice`: double - Precio mensual de la clase en pesos colombianos
- `isActive`: boolean - Estado de la clase (activa/inactiva)

**Métodos identificados:**
- `showInfo()`: void - Muestra toda la información de la clase de forma formateada
- `calculateQuarterlyPrice()`: double - Calcula el precio trimestral con 10% de descuento
- `enrollStudent()`: boolean - Inscribe un estudiante si hay cupos disponibles
- `isFull()`: boolean - Verifica si la clase está llena
- `getClassCode()`: String - Obtiene el código de la clase
- `getLevel()`: String - Obtiene el nivel de la clase
- `getAvailableSpots()`: int - Calcula cuántos cupos disponibles quedan
- `setActive(boolean)`: void - Activa o desactiva la clase
- `setMonthlyPrice(double)`: void - Actualiza el precio mensual con validación

---

### Objeto Secundario: Student (Estudiante)

**¿Qué es?:** Representa a una persona inscrita o por inscribirse en el centro de natación. Es el cliente/usuario del servicio.

**Atributos identificados:**
- `studentId`: String - Identificador único del estudiante (ej: EST-001)
- `fullName`: String - Nombre completo del estudiante
- `age`: int - Edad del estudiante (importante para asignación de nivel)
- `email`: String - Correo electrónico de contacto
- `enrolledClass`: String - Código de la clase en la que está inscrito
- `hasActiveMembership`: boolean - Indica si tiene membresía activa

**Métodos identificados:**
- `showStudentInfo()`: void - Muestra información completa del estudiante
- `enrollInClass(String)`: void - Inscribe al estudiante en una clase específica
- `canEnroll()`: boolean - Verifica si el estudiante puede inscribirse (no tiene membresía activa)
- `getAgeCategory()`: String - Retorna la categoría de edad según rangos establecidos
- `getFullName()`: String - Obtiene el nombre completo
- `getStudentId()`: String - Obtiene el ID del estudiante
- `setEmail(String)`: void - Actualiza el correo electrónico
- `setActiveMembership(boolean)`: void - Actualiza el estado de la membresía

---

## 3. Relación entre Objetos

**Tipo de relación:** Asociación / Inscripción

**Descripción:** Un **Student** se inscribe en una **SwimmingClass**. La relación es de muchos a uno: múltiples estudiantes pueden inscribirse en una misma clase de natación, pero cada estudiante solo puede estar inscrito en una clase a la vez (según el atributo `enrolledClass` y `hasActiveMembership`).

- Un `Student` necesita conocer el código de la `SwimmingClass` para registrar su inscripción
- Una `SwimmingClass` controla el número de estudiantes inscritos mediante el contador `enrolledStudents`
- La capacidad de la clase limita cuántos estudiantes pueden inscribirse
- El nivel de la clase debe ser apropiado para la edad del estudiante (categoría de edad)

**Ejemplo de flujo:**
1. Se crea una `SwimmingClass` con capacidad definida
2. Se crea un `Student` sin clase asignada
3. El `Student` verifica si puede inscribirse (`canEnroll()`)
4. El `Student` se inscribe con `enrollInClass(classCode)`
5. La `SwimmingClass` registra la inscripción con `enrollStudent()`
6. El sistema verifica si hay cupos disponibles con `getAvailableSpots()`

---

## 4. Justificación del Diseño

### ¿Por qué elegí estos objetos?

Elegí **SwimmingClass** y **Student** porque son los dos objetos fundamentales en el modelo de negocio de un centro de natación:

1. **SwimmingClass** representa el producto/servicio que se vende
2. **Student** representa el cliente que consume el servicio
3. La relación entre ambos (inscripción) es el proceso de negocio principal

Estos dos objetos permiten modelar las operaciones básicas del centro: crear clases, inscribir estudiantes, gestionar capacidad, calcular precios.

### ¿Por qué estos atributos son importantes?

**SwimmingClass:**
- `classCode`: Necesario para identificación única y referencias
- `level`: Define qué estudiantes son apropiados para la clase
- `instructor`: Información clave para los clientes
- `capacity` y `enrolledStudents`: Control de cupos (regla de negocio crítica)
- `monthlyPrice`: Base para facturación y decisiones de compra
- `isActive`: Permite desactivar clases temporalmente sin eliminar datos

**Student:**
- `studentId`: Identificación única en el sistema
- `fullName`: Información básica del cliente
- `age`: Determina la categoría y nivel apropiado
- `email`: Canal de comunicación principal
- `enrolledClass`: Registra la relación con SwimmingClass
- `hasActiveMembership`: Evita inscripciones duplicadas

### ¿Por qué estos métodos son necesarios?

**Métodos de información (`showInfo`, `showStudentInfo`):**
- Necesarios para visualizar datos en consola
- Facilitan el debugging y demostración del sistema

**Métodos de cálculo (`calculateQuarterlyPrice`, `getAgeCategory`):**
- Implementan lógica de negocio específica del dominio
- `calculateQuarterlyPrice`: Incentiva compras a largo plazo con descuento
- `getAgeCategory`: Clasifica estudiantes para asignación de nivel

**Métodos de validación (`isFull`, `canEnroll`):**
- Implementan reglas de negocio (capacidad máxima, inscripción única)
- Previenen errores de operación

**Getters y Setters:**
- Permiten acceso controlado a atributos privados (encapsulamiento)
- Los setters incluyen validaciones cuando es necesario

---

## 5. Comparación: POO vs Programación Estructurada

### Sin POO (Estructurado):

En programación estructurada, manejaríamos la información con variables separadas y funciones independientes:

```
// Variables globales sueltas
String[] classCodes = new String[100];
String[] classLevels = new String[100];
String[] classInstructors = new String[100];
int[] classCapacities = new int[100];
int[] classEnrolled = new int[100];
double[] classPrices = new double[100];
boolean[] classActive = new boolean[100];

String[] studentIds = new String[250];
String[] studentNames = new String[250];
int[] studentAges = new int[250];
String[] studentEmails = new String[250];

// Funciones independientes
void showClassInfo(int index) { ... }
double calculatePrice(int index) { ... }
boolean enrollStudentInClass(int studentIndex, int classIndex) { ... }
```

**Problemas:**
- Datos desorganizados en múltiples arrays paralelos
- Difícil mantener sincronización entre arrays relacionados
- No hay relación explícita entre datos que pertenecen juntos
- Funciones no están asociadas a los datos que manipulan
- Propenso a errores de índices
- Difícil de escalar y mantener

### Con POO:

Los datos y comportamientos están encapsulados en clases:

```java
SwimmingClass class1 = new SwimmingClass("SWIM-001", "Bebés", "Pérez", 8, 150000);
Student student1 = new Student("EST-001", "María González", 8, "maria@email.com");

// Datos y métodos están juntos
class1.showInfo();
double price = class1.calculateQuarterlyPrice();
student1.enrollInClass(class1.getClassCode());
```

**Ventajas:**
- Datos relacionados están agrupados en objetos
- Métodos pertenecen a los objetos que manipulan
- Código más legible y mantenible
- Fácil crear múltiples instancias
- Encapsulamiento protege la integridad de los datos

### Ventajas específicas en mi dominio:

1. **Modelado natural del mundo real:** Las clases y estudiantes en el código reflejan directamente las clases y estudiantes reales del centro de natación

2. **Escalabilidad:** Es fácil agregar nuevas clases o estudiantes creando nuevas instancias, sin modificar la estructura de datos

3. **Mantenimiento de reglas de negocio:** Las validaciones (capacidad máxima, edad apropiada) están encapsuladas en los métodos, garantizando consistencia

4. **Reutilización:** Puedo crear 100 clases diferentes usando la misma plantilla `SwimmingClass` sin duplicar código

5. **Extensibilidad futura:** Puedo agregar fácilmente nuevos atributos (horario, piscina asignada) o métodos (cancelar clase, generar reporte) sin afectar el código existente

---

## 6. Diagrama de Clases

```
┌─────────────────────────────┐         ┌─────────────────────────────┐
│      SwimmingClass          │         │         Student             │
├─────────────────────────────┤         ├─────────────────────────────┤
│ - classCode: String         │         │ - studentId: String         │
│ - level: String             │         │ - fullName: String          │
│ - instructor: String        │         │ - age: int                  │
│ - capacity: int             │         │ - email: String             │
│ - enrolledStudents: int     │<--------|  - enrolledClass: String    │
│ - monthlyPrice: double      │inscribe │ - hasActiveMembership: bool │
│ - isActive: boolean         │         │                             │
├─────────────────────────────┤         ├─────────────────────────────┤
│ + showInfo(): void          │         │ + showStudentInfo(): void   │
│ + calculateQuarterlyPrice() │         │ + enrollInClass(String)     │
│ + enrollStudent(): boolean  │         │ + canEnroll(): boolean      │
│ + isFull(): boolean         │         │ + getAgeCategory(): String  │
│ + getClassCode(): String    │         │ + getFullName(): String     │
│ + getLevel(): String        │         │ + getStudentId(): String    │
│ + getAvailableSpots(): int  │         │ + setEmail(String): void    │
│ + setActive(boolean): void  │         │ + setActiveMembership(bool) │
│ + setMonthlyPrice(double)   │         │                             │
└─────────────────────────────┘         └─────────────────────────────┘
```

**Relación:** Un estudiante se inscribe en una clase (asociación). El atributo `enrolledClass` del estudiante almacena el código de la clase en la que está inscrito.

---

## 7. Conclusiones

Este diseño orientado a objetos proporciona una base sólida para modelar el dominio del Centro de Natación Aqua Fitness. Los objetos `SwimmingClass` y `Student` encapsulan tanto los datos como el comportamiento relevante, siguiendo los principios de POO.

El sistema es extensible: en futuras semanas puedo agregar clases como `Instructor`, `Pool`, `Payment`, `Schedule` para completar el modelo del negocio, manteniendo la coherencia y reutilizando los objetos ya creados.

