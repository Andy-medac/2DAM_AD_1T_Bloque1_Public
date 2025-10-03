## Extracción de datos usando clases de análisis de flujos

**Objetivo**  
Practicar el análisis de flujos de datos en Java utilizando las clases vistas hasta ahora (`LineNumberReader`, `StreamTokenizer`, etc.) para analizar un archivo de texto y contar cuántas palabras y cuántos números hay en cada línea.

### Instrucciones

1. Crea un archivo de texto llamado **`entrada.txt`** que contenga líneas con una combinación de palabras y números. Por ejemplo:

   ```text
   Hola 123 Mundo
   Prueba 45.67 de texto
   12345
   ```

2. Escribe un programa en Java que lea el archivo y cuente cuántas palabras y cuántos números hay en cada línea.
   Utiliza las clases de análisis de flujos (p. ej., LineNumberReader para leer línea por línea y StreamTokenizer para diferenciar palabras y números).

   Muestra el resultado en la terminal con el siguiente formato (ajustando los valores a lo que obtengas):

   ```text
   Línea 1: Hola 123 Mundo
   Palabras: 2, Números: 1

   Línea 2: Prueba 45.67 de texto
   Palabras: 3, Números: 1

   Línea 3: 12345
   Palabras: 0, Números: 1
   ```