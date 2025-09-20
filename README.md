# 🏭 Patrón Abstract Factory + Adapter - Entrada y Salida de Datos

Juan Sebastian Diaz 20232020071
Felipe Gil Laverde - 20232020081
Juan Esteban Cañon Solorza - 20232020078

Este proyecto implementa el **patrón de diseño Abstract Factory** para crear medios de entrada y salida de datos, permitiendo elegir entre dos entornos:  

- **Consola** (entrada por teclado, salida en consola).  
- **Interfaz gráfica** con **JOptionPane** (entrada y salida en ventanas emergentes).  

Además, se incluyen **adaptadores** para transformar cualquier tipo de dato al formato requerido por las entradas y salidas creadas.  

---

## 📌 Objetivo
- Permitir que el cliente decida qué medio de **entrada** y **salida** utilizar.  
- Abstraer la creación de objetos mediante el patrón **Abstract Factory**.  
- Convertir datos de diferentes tipos con ayuda de un **Adapter**.  

---

## 🗂️ Estructura del proyecto

### **Diagrama UML**
El sistema sigue la siguiente arquitectura:  

<img width="907" height="673" alt="Adapter" src="https://github.com/user-attachments/assets/8cc8c858-5c52-4e1e-89f5-dbe35f5e46ed" />



### **Componentes principales**

#### 🔹 Interfaces
- **`FabricaInterfaz`** → declara los métodos `crearEntrada()` y `crearSalida()`.  
- **`Entrada`** → declara el método `pedir()`.  
- **`Salida`** → declara el método `mostrar()`.  

#### 🔹 Fábricas concretas
- **`InterfazConsola`** → crea `EntradaConsola` y `SalidaConsola`.  
- **`InterfazGraph`** → crea `EntradaJo` y `SalidaJo`.  

#### 🔹 Productos concretos
- **Entrada**  
  - `EntradaConsola`: pide datos por consola.  
  - `EntradaJo`: pide datos mediante `JOptionPane`.  
- **Salida**  
  - `SalidaConsola`: muestra resultados en consola.  
  - `SalidaJo`: muestra resultados en `JOptionPane`.  

#### 🔹 Adaptador
- **`Adaptador`**  
  - Convierte cadenas de texto en listas de enteros ASCII.  
  - Maneja la conversión de datos a distintos tipos según sea necesario.  

#### 🔹 Cliente
- **`ConvertidorData`**  
  - Clase principal que:  
    1. Pregunta al usuario qué interfaz desea (consola o gráfica).  
    2. Utiliza la fábrica correspondiente.  
    3. Recibe datos mediante la entrada.  
    4. Procesa los datos con el adaptador.  
    5. Los muestra usando la salida seleccionada.  

---

## 🛠️ Ejemplo de uso

### Entrada / salida en consola
```text
Seleccione interfaz: 
1. Consola 
2. Gráfica
> 1
Ingrese texto: Hola
Salida: [72, 111, 108, 97]
