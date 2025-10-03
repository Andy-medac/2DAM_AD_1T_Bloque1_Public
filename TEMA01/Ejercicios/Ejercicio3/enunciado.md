# 📄 Proyecto: Formulario de Matriculación de Alumnos

## 🎯 Enunciado

Diseña un programa o aplicación que simule un formulario de matriculación de alumnos, similar al que se muestra a continuación:

> **[Formulario.jpeg]**  
> *(Imagen referencial del formulario: contiene campos de texto, botones, selección de género, etc.)*

---

## 🧾 Campos del Formulario

El formulario debe incluir los siguientes campos:

- **Nombre y Apellidos:**  
  Campo de texto para que el estudiante ingrese su nombre completo.

- **Email:**  
  Campo de texto para ingresar la dirección de correo electrónico.

- **Fecha de Nacimiento:**  
  Campo para seleccionar la fecha de nacimiento.

- **Género:**  
  Dos opciones de selección para que el estudiante elija su género:  
  - Masculino  
  - Femenino

- **Titulación de Acceso:**  
  Menú desplegable con las siguientes opciones (u otras similares):
  - FP Grado Medio
  - FP Grado Superior
  - Bachillerato

- **Observaciones:**  
  Campo de texto donde el estudiante puede escribir cualquier comentario o información adicional que considere importante.

- **Botones:**
  - `Guardar`
  - `Imprimir`

---

## ⚙️ Funcionalidades Clave

### 💾 Guardar

- El usuario ingresa la información solicitada en el formulario.
- La información se almacena en variables (o estructuras de datos si se prefiere).

### 🖨️ Imprimir

- Los datos que se guardaron previamente en las variables se escriben en un fichero llamado `matricula.txt`.
- El contenido del archivo debe tener un **formato legible y ordenado**, por ejemplo:

  ```text
  ----- Formulario de Matriculación -----
  Nombre y Apellidos: Juan Pérez García
  Email: juan.perez@gmail.com
  Fecha de Nacimiento: 12/04/2005
  Género: Masculino
  Titulación de Acceso: FP Grado Medio
  Observaciones:
  Interesado en horario de tarde.

  Fecha de impresión: 24/09/2025 16:35
  ---------------------------------------
