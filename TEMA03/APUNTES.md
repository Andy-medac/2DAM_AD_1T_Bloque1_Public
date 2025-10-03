# Tema 3: Trabajo con ficheros XML

## 1. Introducción
- El lenguaje **XML** permite estructurar y almacenar datos de forma jerárquica.
- En Java podemos trabajar con XML para extraer, modificar o validar información.
- Herramientas habituales: **DOM**, **SAX** y **XPath**.

---

## 2. Acceso a datos con DOM y SAX

### DOM (Document Object Model)
- **Cómo funciona**: lee el XML entero y lo carga en memoria como un árbol de nodos (Document).
- **Recorrido**: tú decides cómo recorrer ese árbol, por ejemplo con bucles, getElementsByTagName(), etc.
- **Ejemplo**: es como abrir un libro, fotocopiar todas las páginas y guardarlas en tu mesa; después puedes ir saltando de capítulo a capítulo, volver atrás, modificar frases…

👉 Entonces, DOM también recorre nodo a nodo, pero en memoria, y no tiene que ser en orden: puedes saltar, volver atrás, modificar.

### SAX (Simple API for XML)
- **Cómo funciona**: no guarda todo el documento. Va leyendo el XML secuencialmente, de arriba a abajo.
- **Recorrido**:Cada vez que encuentra algo (inicio de etiqueta, texto, fin de etiqueta…) lanza un evento que tú capturas en tu código, solo mantiene en memoria el nodo actual
- **Ejemplo**: es como leer un libro en voz alta: avanzas línea a línea y no puedes volver atrás (a menos que lo vuelvas a abrir).

👉 SAX recorre nodo a nodo en orden secuencial, pero no puedes volver atrás ni modificar nada, solo reaccionar al evento.

**Resumen:**
- DOM → carga todo el XML en memoria → tú recorres los nodos como quieras (orden secuencial, saltando, buscando, modificando).

- SAX → lee nodo a nodo solo hacia adelante (streaming) → tú reaccionas a cada nodo al pasar, no puedes volver atrás ni modificar. Es más rápido y ligero, pero de solo lectura.

---

## 3. Conversión de ficheros XML
- En Java existen librerías estándar para parsear XML: `javax.xml.parsers`.
- DOM carga todo el fichero en memoria con un `DocumentBuilderFactory`, `DocumentBuilder`.
- SAX analiza el fichero por eventos con un `SAXParserFactory`, `SAXParser` y un `Handler`.

### Ejemplo DOM ###
Con este código cargamos un XML en memoria y podemos recorrer sus nodos.

```java
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;


public class EjemploDOM {
  public static void main(String[] args) {
    try {
            // Crear una instancia de DocumentBuilderFactory.
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Configurar la factoria para que el fichero que se carga está bien validado e ignora espacios en blanco.
            factory.setValidating(true);
            factory.setIgnoringElementContentWhitespace(true);

            //se crea un objeto DocumentBuilder por medio de la factoría creada previamente.
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Especificar el archivo XML que deseas analizar.
            File file = new File(".\\TEMA03\\Ejemplos\\fichero.xml");

            // Parsear (analizar) el archivo XML y obtener un objeto Document.
            Document doc = builder.parse(file);  
            doc.getDocumentElement().normalize();

            // Acceso al nodo raíz
            Element root = doc.getDocumentElement();
            System.out.println("Elemento raíz: " + root.getNodeName());

    } catch (Exception e) {
        e.printStackTrace();
    }
  }
}

```

### Ejemplo SAX ###
Con SAX no cargamos el documento completo, sino que reaccionamos a eventos como apertura, cierre de elementos o texto.

```java
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.io.*;


public class EjemploSAX {
  public static void main(String[] args) {
    try {
           // Crear una instancia de SAXParserFactory para configurar y crear un analizador SAX.
            SAXParserFactory factory = SAXParserFactory.newInstance();
            // Configurar la fábrica para que el analizador realice la validación del documento XML.
            factory.setValidating(true);
            // Crear un objeto SAXParser utilizando la fábrica configurada.
            SAXParser saxParser = factory.newSAXParser();
            // Crear un objeto File que representa el archivo XML que se va a analizar.
            File file = new File("prueba.xml");
            // Iniciar el proceso de análisis del archivo XML utilizando el analizador SAX.
            // Se utiliza un controlador predeterminado (DefaultHandler) para manejar los eventos.
            saxParser.parse(file, new DefaultHandler());

      } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
```

---

## 4. Procesamiento de XML con XPath
- XPath es un lenguaje para **buscar información en documentos XML**.
- Permite seleccionar nodos, atributos y textos.
- Características:
  - Definición de estructuras (elementos, atributos, nodos).
  - Expresiones: posee expresiones potentes para el manejo de ficheros, como por ejemplo seleccionar nodos o listas de nodos
  - Funciones estándar (strings, números, fechas, booleanos).

**Pasos básicos en Java:**
1. Importar paquetes de XPath.
2. Crear `DocumentBuilder` y cargar el fichero XML.
3. Crear objeto `XPath` y compilar expresión con xPath.compile("...").
4. Evaluar la expresión sobre el documento con xPath.evaluate(...) y obtener la lista de nodos..
5. Iterar sobre la lista de nodos.
6. Examinar los atributos de cada nodo.
7. Examinar los subelementos de cada nodo.

---

## 5. Excepciones

### Concepto general
- Una excepción es un evento que interrumpe el flujo del programa.
- Tipos:
  - **Checked** → detectadas en compilación (ej: IOException).
  - **Unchecked** → ocurren en ejecución (ej: NullPointerException).
  - **Errores** → fallos graves (ej: StackOverflowError).

### Métodos útiles en excepciones
- `getMessage()` → detalle de la excepción.
- `printStackTrace()` → traza completa.
- `getCause()` → causa original.
- `printStackTrace()` → imprime en consola la traza completa de la pila donde ocurrió la excepción.
- `toString()` → devuelve una representación en texto de la excepción (tipo + mensaje).
- `getStackTrace()` → devuelve un array de StackTraceElement con toda la traza (se puede recorrer programáticamente).
- `fillInStackTrace()` → actualiza el stack trace con el punto actual donde se invoca.

### Excepciones en XML
- `ParserConfigurationException`
- `IOException`
- `SAXException`
- `XPathExpressionException`

---

## 6. Pruebas unitarias con JUnit
- **JUnit** es el framework estándar en Java para tests unitarios.
- Un test es un método dentro de una clase de pruebas.
- Se identifican con la anotación `@Test`.

### Anotaciones importantes
- `@Before` → se ejecuta antes de cada test (inicialización).
- `@After` → se ejecuta después de cada test (limpieza).
- `@Test` → marca un método como prueba.

---

## 7. Casos prácticos (para trabajar en clase)

### Caso práctico 1: DOM o SAX
- Escenario: Una aplicación web necesita procesar clientes de una tienda desde un fichero XML.
- Condiciones: el fichero debe ser ligero en memoria y solo de lectura.
- **Pregunta:** ¿qué parser usarías y por qué?

---

## 8. Resumen
- DOM y SAX son las principales formas de trabajar con XML en Java.
- XPath permite búsquedas potentes en documentos XML.
- Las excepciones en XML deben manejarse adecuadamente con `try/catch`.
- JUnit nos permite probar nuestro código de manera sencilla con anotaciones.

---

## 9. Recursos

📺 [Vídeo: XPATH](https://bit.ly/2YS7mv3)  
- [Documentación oficial SAX](https://docs.oracle.com/javase/tutorial/jaxp/sax/parsing.html)
- [Documentación oficial Excepciones](https://docs.oracle.com/javase/7/docs/api/java/lang/Exception.html)
- [XPath W3C](https://www.w3.org/TR/xpath/)
