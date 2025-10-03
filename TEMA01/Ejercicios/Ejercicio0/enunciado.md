# Caso práctico: Modificar datos en un archivo de texto

Crea un programa en **Java** que permita a los usuarios modificar el contenido de un archivo de texto llamado **`datos.txt`**.  
El programa debe seguir estos pasos:

1. Escribe el **abecedario** en el fichero de texto mediante `FileWriter`.
2. Abre el archivo **`datos.txt`** en modo de lectura y escritura.
3. Pide al usuario que ingrese una **posición** (un número entero) en el archivo donde desea realizar la modificación.
4. Pide al usuario que ingrese los **datos** (un carácter, como un espacio) que desea escribir en esa posición.
5. Utiliza **`RandomAccessFile`** para posicionarte en la posición especificada por el usuario y sobrescribir el contenido con los nuevos datos ingresados.
6. Cierra el archivo después de realizar la modificación.
7. Asegúrate de manejar adecuadamente las **excepciones**, en caso de que:
   - El archivo no exista.
   - La posición especificada sea inválida.
   - Ocurra algún otro error relacionado con la lectura o escritura de archivos.
