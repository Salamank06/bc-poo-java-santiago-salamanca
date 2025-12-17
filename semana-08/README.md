# Semana 08: Colecciones y Generics - Centro de Natación Aqua Fitness

## 👤 Información del Estudiante

- **Nombre**: Santiago Salamanca Narváez
- **Ficha**: 3228973A
- **Dominio**: Centro de Natación Aqua Fitness
- **Fecha**: 17/12/2024

## 📝 Descripción del Proyecto

Sistema de gestión para el Centro de Natación Aqua Fitness que administra actividades acuáticas (clases de natación, aqua aeróbicos e hidroterapia), permitiendo inscripciones, reservas y evaluaciones.

**Esta semana**: Refactoricé el sistema para usar colecciones profesionales (HashMap, ArrayList) en lugar de arrays, agregando operaciones de búsqueda eficiente, filtrado y estadísticas. El sistema ahora permite gestionar grandes volúmenes de actividades y participantes de forma óptima.

## 📦 Colecciones Utilizadas

### HashMap

- `Map<String, AquaticActivity>` - Búsqueda rápida por código de actividad O(1)
- `Map<String, List<AquaticActivity>>` - Agrupación por tipo de actividad
- `Map<String, Integer>` - Conteo de participantes por actividad

### ArrayList

- `List<AquaticActivity>` - Catálogo ordenado de actividades
- `List<String>` - Historial de participantes inscritos

## 🔍 Operaciones Implementadas

### CRUD con Colecciones

- ✅ Agregar actividad con validación de duplicados
- ✅ Buscar por código O(1) con HashMap
- ✅ Actualizar actividad existente
- ✅ Eliminar por código con sincronización

### Filtrado

- ✅ Filtrar por rango de precio
- ✅ Filtrar por tipo de actividad
- ✅ Filtrar por disponibilidad de cupos
- ✅ Filtrar por calificación mínima

### Estadísticas

- ✅ Total de ingresos mensuales
- ✅ Promedio de precios por actividad
- ✅ Actividad más cara/económica
- ✅ Conteo por categoría
- ✅ Promedio de calificaciones
- ✅ Actividad con mejor rating

## 🚀 Cómo Ejecutar

### Desde terminal:

```bash
cd semana-08
javac -d bin src/com/aquafitness/*/*.java src/com/aquafitness/*.java
java -cp bin com.aquafitness.Main
```

### Desde IntelliJ IDEA:

1. Abrir proyecto en IntelliJ
2. Clic derecho en `Main.java`
3. Seleccionar "Run Main.main()"

## 📂 Estructura de Paquetes

```
com.aquafitness/
├── modelo/              - Clases del dominio (AquaticActivity y subclases)
├── servicio/            - ActivityManager con HashMap y ArrayList
├── excepciones/         - Excepciones personalizadas del sistema
└── Main.java            - Menú interactivo con 8 opciones
```

## 🎯 Funcionalidades del Menú

1. **Agregar actividad** - Crea nueva actividad con validación de duplicados
2. **Buscar por código** - Búsqueda O(1) usando HashMap
3. **Listar todas** - Muestra catálogo completo con detalles
4. **Filtrar por precio** - Busca actividades en rango de precios
5. **Filtrar por tipo** - Filtra por SwimmingLesson, AquaAerobics o HydroTherapy
6. **Ver estadísticas** - Total ingresos, promedios, máximos y conteos
7. **Eliminar actividad** - Borra por código manteniendo sincronización
8. **Inscribir participante** - Maneja cupos con excepciones personalizadas

## 📊 Mejoras de Rendimiento

| Operación | Antes (Array) | Ahora (HashMap) |
|-----------|---------------|-----------------|
| Búsqueda por código | O(n) | O(1) |
| Validar duplicados | O(n) | O(1) |
| Inserción | O(1) | O(1) |
| Eliminación | O(n) | O(1) |

## 📚 Conceptos Aplicados

- **Generics**: `List<E>`, `Map<K,V>` en todas las colecciones
- **HashMap**: Búsqueda eficiente por clave única
- **ArrayList**: Listas dinámicas sin tamaño fijo
- **Sincronización**: Mantener HashMap y ArrayList coherentes
- **Filtrado**: Operaciones de búsqueda con múltiples criterios
- **Estadísticas**: Cálculos agregados sobre colecciones

## 🔗 Cambios desde Semana 07

- ✅ Eliminados todos los arrays de objetos
- ✅ Implementado `ActivityManager` con HashMap y ArrayList
- ✅ Agregados 4 métodos de filtrado
- ✅ Implementadas 6 operaciones estadísticas
- ✅ Menú interactivo completo con 8 opciones
- ✅ Validación de duplicados con `containsKey()`
- ✅ Agrupación por tipo de actividad

---

*Semana 08 - Bootcamp POO Java - SENA*
