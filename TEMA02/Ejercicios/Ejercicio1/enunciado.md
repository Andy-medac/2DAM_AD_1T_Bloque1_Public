## Lectura de una línea específica de un archivo

**Objetivo**  
Practicar el uso de la clase `LineNumberReader` en Java para acceder a una línea concreta de un archivo de texto, introducida por el usuario.

### Instrucciones

1. Crea un archivo de texto llamado **`entrada.txt`** con varias líneas de contenido. Por ejemplo:  

   ```text
   Primera línea
   Segunda línea
   Tercera línea
   Cuarta línea
   ```

2. Escribe un programa en Java que:

   - Pida al usuario, mediante teclado, el número de línea que desea leer.
   - Utilice la clase LineNumberReader para posicionarse en esa línea.
   - Lea y muestre el contenido de la línea indicada en consola.
   - Si el número de línea no existe, muestre un mensaje de aviso.

   Ejemplo de ejecución:

   ```text
   Indica qué línea quieres leer: 3
   Contenido de la línea número 3:
   Tercera línea
   ```
