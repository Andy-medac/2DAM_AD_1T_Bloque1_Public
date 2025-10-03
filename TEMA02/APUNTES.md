# Tema 2: Flujos en Java

## 1. Introducción
- Los **streams (flujos)** permiten la entrada y salida secuencial de datos.
- Son **unidireccionales**: o bien de **entrada (Input)** o de **salida (Output)**.
- Se dividen en dos grandes grupos:
  - **De bytes** → para datos binarios.
  - **De caracteres** → para datos de texto (usan codificación).

---

## 2. Tipos de Streams

| Método       | Bytes (E/S)                               | Caracteres (E/S)                    |
|--------------|-------------------------------------------|--------------------------------------|
| **Ficheros** | FileInputStream / FileOutputStream        | FileReader / FileWriter              |
| **Arrays**   | ByteArrayInputStream / ByteArrayOutputStream | CharArrayReader / CharArrayWriter    |
| **Tuberías** | PipedInputStream / PipedOutputStream      | PipedReader / PipedWriter            |
| **Buffers**  | BufferedInputStream / BufferedOutputStream | BufferedReader / BufferedWriter      |
| **Análisis** | PushbackInputStream / StreamTokenizer     | PushbackReader / LineNumberReader    |
| **Info**     | DataInputStream / DataOutputStream / PrintStream | PrintWriter                    |

---

## 3. Flujos basados en tuberías
- Permiten **comunicar hilos** dentro de la misma aplicación.
- Conectan un `PipedOutputStream` con un `PipedInputStream`.

```java
final PipedOutputStream salida = new PipedOutputStream();
final PipedInputStream entrada = new PipedInputStream(salida);

Thread escritor = new Thread(() -> {
    try { salida.write("Hola por aquí!".getBytes()); }
    catch (Exception e) {}
});

Thread lector = new Thread(() -> {
    try {
        int c;
        while((c = entrada.read()) != -1){
            System.out.print((char)c);
        }
    } catch (Exception e) {}
});

escritor.start();
lector.start();
```

---

## 4. Flujos basados en arrays
- Permiten **leer/escribir arrays** como si fueran ficheros.

```java
char[] chars = "Hola amigo".toCharArray();
CharArrayReader reader = new CharArrayReader(chars);

int data;
while((data = reader.read()) != -1){
    System.out.print((char)data);
}
reader.close();
```

---

## 6. Clases de análisis

### PushbackReader
- Permite **devolver caracteres** al flujo.

```java
PushbackReader pr = new PushbackReader(new FileReader("texto.txt"));
int c = pr.read();
System.out.println((char)c);
pr.unread(c); // Devuelve el carácter al flujo
```

### StreamTokenizer
- Divide el flujo en **tokens** (palabras, números).

```java
StreamTokenizer st = new StreamTokenizer(new StringReader("Edad 25"));
while(st.nextToken() != StreamTokenizer.TT_EOF){
    if(st.ttype == StreamTokenizer.TT_WORD)
        System.out.println("Palabra: " + st.sval);
    if(st.ttype == StreamTokenizer.TT_NUMBER)
        System.out.println("Número: " + st.nval);
    if(st.ttype == StreamTokenizer.TT_EOL)
        System.out.println("Fin de línea:");
}
```

### LineNumberReader
- Permite leer **líneas numeradas**.

```java
LineNumberReader lnr = new LineNumberReader(new FileReader("texto.txt"));
String line;
while((line = lnr.readLine()) != null){
    System.out.println("Línea " + lnr.getLineNumber() + ": " + line);
}
lnr.close();
```

---

## 9. Clases para tratamiento de información
- Permiten leer y escribir **tipos primitivos** directamente en formato binario.

```java
// Escritura
DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.bin"));
dos.writeInt(123);
dos.writeFloat(45.6F);
dos.close();

// Lectura
DataInputStream dis = new DataInputStream(new FileInputStream("data.bin"));
System.out.println(dis.readInt());   // 123
System.out.println(dis.readFloat()); // 45.6
dis.close();
```

---

## Recursos

📺 [Vídeo: CharArrayReader](https://bit.ly/37wfkgi)  
📺 [Vídeo: DataOutputStream](https://bit.ly/3d7r2ik)  
- [Documentación oficial Java I/O](https://docs.oracle.com/javase/8/docs/api/java/io/package-summary.html)

