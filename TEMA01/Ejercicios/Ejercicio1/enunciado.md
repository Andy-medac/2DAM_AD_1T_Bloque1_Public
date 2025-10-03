## Caso práctico: Copiar contenido de un archivo utilizando buffers

Crea un programa en Java que permita a los usuarios copiar el contenido de un archivo de texto llamado archivo_origen.txt en otro archivo de texto llamado archivo_destino.txt, utilizando buffers para mejorar la eficiencia en la lectura y escritura de archivos.
El programa debe seguir estos pasos:

1. Abrir el archivo `archivo_origen.txt` en modo lectura.
2. Abrir el archivo `archivo_destino.txt` en modo escritura.
3. Si el archivo destino ya existe, se debe **sobrescribir su contenido**.
4. Definir un **buffer de lectura y escritura**, por ejemplo de `1024` bytes.
5. Mientras haya datos disponibles en el archivo de origen:
   - Leer un bloque de datos en el buffer de lectura.
   - Escribir ese bloque en el archivo de destino utilizando el buffer de escritura.
   - Después de escribir cada bloque, mostrar por consola un mensaje como:

     Fin copia bloque 1
     Fin copia bloque 2


6. Al finalizar la copia, añadir al final del archivo destino la siguiente cadena:
 
   Última modificación: 25-09-2023 15:04:01

7. Cerrar correctamente ambos archivos, asegurando la liberación de recursos.

8. Manejar adecuadamente las excepciones en caso de que:

   - El archivo de origen no exista.
   - Ocurra un error durante la lectura o escritura de los archivos.