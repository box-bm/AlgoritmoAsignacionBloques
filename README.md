# Algoritmo de Asignacion de memoria por bloques

## Repositorio

[Github](https://github.com/box-bm/AlgoritmoAsignacionBloques)

## Descripcion

Este algoritmo simula la asignacion de memoria por bloques, en donde se le asigna un bloque de memoria a un proceso, y cuando este termina de ejecutarse, se libera el bloque de memoria.

## Requisitos

- Java Development Kit (JDK) 8 o superior instalado.
- Un entorno de desarrollo compatible con Java (opcional).

## Clases y Funcionalidades

### Clase `Memoria`

Esta clase representa la memoria principal dividida en bloques. Su funcionalidad incluye:

- Inicializar los bloques de memoria con un tamaño específico.
- Asignar un bloque de memoria a un proceso.
- Liberar un bloque de memoria cuando el proceso termina.
- Mostrar el estado actual de la memoria.

### Clase `Proceso`

Esta clase representa un proceso que requiere memoria para ejecutarse. Sus características incluyen:

- Identificador único del proceso.
- Tamaño de memoria requerido.
- Métodos para solicitar y liberar memoria.

### Clase `AdministradorMemoria`

Esta clase actúa como el controlador principal del sistema de asignación de memoria. Sus responsabilidades incluyen:

- Gestionar la asignación y liberación de bloques de memoria.
- Mantener un registro de los procesos activos y los bloques asignados.
- Implementar estrategias de asignación como "First Fit", "Best Fit" o "Worst Fit".

## Ejecucion

1. Clona este repositorio en tu máquina local.
2. Asegúrate de tener el JDK 8 o superior instalado.
3. Compila y ejecuta el archivo principal del proyecto para simular la asignación de memoria.

## Ejemplo de Uso

```bash
javac MemoryAllocation.java
java MemoryAllocation
```

El programa solicitará información sobre los procesos y mostrará cómo se asignan y liberan los bloques de memoria.

## Notas

Este proyecto es una simulación educativa y no está diseñado para ser utilizado en sistemas de producción.
