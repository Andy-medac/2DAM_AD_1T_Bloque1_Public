
# Tema 1: Acceso a Datos en Java

---

## 1. Introducción
En este tema aprenderemos a:
- Crear, modificar y borrar **ficheros y directorios**.
- Diferenciar entre **acceso secuencial** y **acceso aleatorio**.
- Usar clases de la librería `java.io`.
---

## 2. Tipos de ficheros
- **Texto (ASCII):** código legible, ej. `.txt`, `.java`, `.html`.
- **Binarios:** representados en binario, ej. `.bin`, `.dat`.

---

## 2.1. Clase `File` (java.io.File)
Permite crear, borrar, mover y consultar información sobre un fichero.

### Crear un fichero
```java
import java.io.File;

public class crearFichero {

    public static void main(String[] args) {
        try {
            File fichero = new File(".\\TEMA01\\Ejemplos\\crearFichero.txt");
            if (fichero.createNewFile()) {
                System.out.println("Fichero creado: " + fichero.getName());
            } else {
                System.out.println("El fichero ya existe.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### Mover un fichero
```java
import java.io.File;

public class moverFichero {

    public static void main(String[] args) {
        try {
            File ficheroOrigen = new File(".\\TEMA01\\Ejemplos\\crearFichero.txt");
            String nombreCarpeta = "Backup";
            File carpeta = new File (".\\TEMA01\\Ejemplos", nombreCarpeta);
            carpeta.mkdirs();
            
            File ficheroDestino = new File (".\\TEMA01\\Ejemplos\\Backup\\fichero_movido.txt");
            if (ficheroOrigen.renameTo(ficheroDestino))
                System.out.println("El fichero se movió correctamente");
            else
                System.out.println("El fichero no pudo moverse");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### 2.2. Métodos útiles
| Método               | Descripción                            |
|----------------------|----------------------------------------|
| `createNewFile()`    | Crea un nuevo fichero                  |
| `delete()`           | Elimina el fichero o directorio        |
| `mkdirs()`           | Crea directorio(s)                     |
| `getName()`          | Devuelve nombre                        |
| `getPath()`          | Devuelve ruta relativa                 |
| `getAbsolutePath()`  | Ruta absoluta                          |
| `exists()`           | Comprueba si existe                    |
| `renameTo()`   | Mueve/renombra un fichero              |
| `canRead()`/`canWrite()` | Permisos de lectura/escritura       |
| `listFiles()`        | Array con los ficheros directorio       |

---

## 3. Formas de acceso

### Acceso secuencial
Recorre el fichero **byte a byte** o **carácter a carácter**.

#### Con bytes → `FileInputStream` y `FileOutputStream`
```java
import java.io.FileInputStream;

public class LeerBytes {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("imagen.png")) {
            int b;
            while ((b = fis.read()) != -1) {
                System.out.print(b + " "); // imprime valores binarios
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

```java
import java.io.FileOutputStream;

public class EscribirBytes {
    public static void main(String[] args) {
        try {
            String cadena = "Esto es una prueba de escritura";
            //Convertimos la cadena en un array de bytes
            byte[] arrayBytes = cadena.getBytes();
            
            FileOutputStream output = new FileOutputStream(pathEscritura);
            output.write(arrayBytes);
            output.close();
            System.out.println("\nFichero escrito");  
        
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```


#### Con caracteres → `FileReader` y `FileWritter`
```java
import java.io.FileReader;

public class LeerTexto {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("texto.txt")) {
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char)c);
            }
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

```java
import java.io.FileWriter;

public class LeerTexto {
    public static void main(String[] args) {
        try {
            {
            FileWriter fw = new FileWriter(pathEscritura);
            fw.write("Esto es un ejemplo de escritura");
            fw.close(); // Cierra el escritor
            }
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### Acceso aleatorio → `RandomAccessFile`
Permite **leer y escribir en posiciones concretas** del fichero.

```java
import java.io.RandomAccessFile;

public class Aleatorio {
    public static void main(String[] args) {
        try {
            RandomAccessFile file = new RandomAccessFile("data.dat", "rw"); 
            //El método seek posicionamos el puntero
            file.seek(5);
            //Nos devuelve la posicion
            long filePointer = file.getFilePointer();
            //Leemos un byte en esa posicion
            int unByte = file.read();

            System.out.println((char)unByte);
            System.out.println(filePointer);
            file.write(68);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

---

## 6. Operaciones con Buffer
Los buffers almacenan datos temporalmente en **memoria** → mejoran rendimiento (más rápido que en disco)

Clases:
- `BufferedReader`, `BufferedWriter`
- `BufferedInputStream`, `BufferedOutputStream`


[Ejemplo7.java](./Ejemplos/Ejemplo7.java)

---


## Recursos

📺 [Vídeo: Escritura con FileOutputStream](https://bit.ly/2U3CBQX)  
📺 [Vídeo: RandomAccessFile read](https://bit.ly/2MqSY66)  
- [Documentación oficial Java IO](https://docs.oracle.com/javase/8/docs/api/?java/io)  


