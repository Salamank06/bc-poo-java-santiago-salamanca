# 📦 Entrega: Semana 02 - Clases, Objetos y Colecciones

**Dominio:** Centro de Natación AQUA FITNESS

---

## 🎯 Objetivos Cumplidos

El objetivo de esta entrega fue expandir el sistema AQUA FITNESS, implementando relaciones de objetos y el manejo de colecciones dinámicas.

## ✅ Checklist de Entrega

| Criterio | Estado | Detalle de la Implementación |
| :--- | :--- | :--- |
| **Mínimo 2 nuevas clases** | [X] Cumplido | **`Instructor.java`** y **`Pago.java`**. |
| **ArrayList implementado** | [X] Cumplido | Usado en **`ClaseNatacion.java`** (`ArrayList<Estudiante>`) y en la clase gestora **`CentroNatacion.java`** (`ArrayList<ClaseNatacion>` y `ArrayList<Pago>`). |
| **Relaciones entre objetos** | [X] Cumplido | **`ClaseNatacion`** tiene un `Instructor` y `ArrayList<Estudiante>`. **`Pago`** tiene un `Estudiante`. |
| **Main.java funcional** | [X] Cumplido | El programa demuestra la inscripción de estudiantes, el registro de pagos y el cálculo de bonos por experiencia. |
| **README.md completo** | [X] Cumplido | Este documento. |
| **Código compila sin errores** | [X] Cumplido | Verificado en terminal. |

---

## 🧱 Estructura y Componentes de la Solución

### Clases y Relaciones Implementadas

| Archivo | Rol en el Proyecto | Implementación Clave |
| :--- | :--- | :--- |
| **`Instructor.java`** | Clase Nueva 1 | Atributos y método de negocio (`calcularBonoExperiencia`). |
| **`Pago.java`** | Clase Nueva 2 | Registra transacciones (relación con `Estudiante`). |
| **`CentroNatacion.java`** | Clase Gestora | Contiene `ArrayList<ClaseNatacion>` y `ArrayList<Pago>`. |
| **`ClaseNatacion.java`** | Base (Modificada) | Contiene relación con `Instructor` y `ArrayList<Estudiante>`. |
| **`Estudiante.java`** | Base (Corregida) | Clase que se relaciona con `Pago` y `ClaseNatacion`. |
| **`Main.java`** | Driver | Prueba las inscripciones, pagos y resultados de la gestora. |

---

## 🔄 Proceso de Entrega

El código se implementó siguiendo la nomenclatura **`PascalCase`** para clases y **`camelCase`** para variables, y se subió con el siguiente comando:

```bash
git commit -m "feat(semana-02): Final delivery with corrected classes, relationships, and ArrayList in AQUA FITNESS."