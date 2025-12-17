# Instrucciones - Semana 01

## Configuración del Entorno

### Requisitos
- JDK 8 o superior instalado
- Editor de texto o IDE (VS Code, IntelliJ IDEA, Eclipse, etc.)
- Terminal o línea de comandos

### Verificar Instalación de Java
```bash
java -version
javac -version
```

## Compilación

Desde la carpeta `semana-01/`:

```bash
javac -encoding UTF-8 src/*.java
```

**Nota:** El parámetro `-encoding UTF-8` es importante para soportar caracteres especiales como ñ, á, é, etc.

## Ejecución

```bash
java -cp src Main
```

## Estructura de una Clase Java

```java
public class NombreClase {
    // Atributos (características)
    tipo atributo1;
    tipo atributo2;
    
    // Constructor
    public NombreClase(parametros) {
        // inicialización
    }
    
    // Métodos (comportamientos)
    public void metodo() {
        // código
    }
}
```

## Notas Importantes

- Los archivos `.java` deben tener el mismo nombre que la clase pública que contienen
- Java distingue entre mayúsculas y minúsculas
- Cada instrucción termina con punto y coma (;)
- Los bloques de código se delimitan con llaves { }


