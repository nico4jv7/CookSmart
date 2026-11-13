🍳 CookSmart: Tu Despensa Inteligente

Asistente de cocina en Java basado en Tablas Hash y Algoritmos de Coincidencia para la reducción del desperdicio de alimentos en el hogar.

🌍 Propósito del Proyecto

El desperdicio de alimentos es una crisis global. Informes del PNUMA (2024) revelan que el 60 % de los alimentos desperdiciados provienen de los hogares, impulsados principalmente por la falta de planificación y el desconocimiento de cómo aprovechar los insumos disponibles antes de su vencimiento.

CookSmart nace para resolver este problema cotidiano fuera de la ingeniería: en lugar de sugerir qué comprar, el sistema parte estrictamente de lo que ya tienes en casa, ayudándote a elegir la mejor opción de cocina de forma inmediata, minimizando pérdidas y optimizando tus recursos.

📐 Estructura y Arquitectura del Proyecto (POO)

El sistema está diseñado bajo los principios de Programación Orientada a Objetos (POO), garantizando bajo acoplamiento y alta cohesión a través de 5 clases principales:

Ingrediente: Modela los insumos básicos (nombre, categoría y unidad de medida).

Despensa: Administra el inventario actual del usuario utilizando un HashMap<String, Ingrediente>, logrando consultas y altas en tiempo constante promedio $\mathcal{O}(1)$.

Receta: Agrupa un plato, sus pasos de preparación y sus ingredientes requeridos. Calcula el porcentaje de coincidencia con la despensa y determina qué insumos hacen falta.

BuscadorRecetas: Aloja el catálogo global de platos, evalúa el inventario del usuario y genera un ranking ordenado de mayor a menor coincidencia.

Main: Controla la interacción con el usuario mediante Scanner, registrando la despensa por consola y mostrando el paso a paso detallado.

📊 Diagrama de Arquitectura (Esquema en Bloques)

       [ Consola / Scanner ] (Interacción del Usuario)
                 │
                 ▼
       ┌───────────────────┐
       │     Main.java     │ ◄─── Controla el flujo y menú
       └─────────┬─────────┘
                 │
       ┌─────────┴────────────────────────┐
       ▼                                  ▼
┌──────────────┐                 ┌───────────────────┐
│   Despensa   │                 │  BuscadorRecetas  │
│  (HashMap)   │                 │  (Catálogo Global)│
└──────┬───────┘                 └─────────┬─────────┘
       │ (Consulta O(1))                   │
       └──────────────────┬────────────────┘
                          ▼
                 ┌───────────────────┐
                 │     Receta        │ ──► [Ingredientes Requeridos]
                 │                   │ ──► [Porcentaje & Faltantes]
                 └───────────────────┘ ──► [Paso a Paso]


🚀 Funcionalidades Principales

Inventario Dinámico con HashMap: Registro interactivo de insumos por consola que valida existencias en tiempo constante promedio $\mathcal{O}(1)$.

Ranking Inteligente de Mayor a Menor: Evalúa el catálogo de recetas y ordena automáticamente los platos priorizando aquellos donde el usuario posee la mayor cantidad (o el 100%) de los ingredientes.

Control de Faltantes para Comprar: Analiza qué elementos de la receta ya están en la despensa y cuáles faltan, guiando al usuario en sus compras.

Paso a Paso Detallado: Permite consultar la preparación exacta del plato seleccionado de forma limpia y organizada.

⚙️ Instrucciones de Compilación y Ejecución (VS Code)

Para compilar y ejecutar el proyecto de forma manual desde la terminal integrada de Visual Studio Code en macOS o cualquier sistema:

Abre tu carpeta del proyecto en VS Code.

Abre la terminal integrada (Terminal > New Terminal).

Compila todos los archivos fuente de Java ubicados en la carpeta src:

javac *.java


Ejecuta el programa principal:

java Main


Desarrollado como proyecto académico de Estructuras de Datos — Programación Orientada a Objetos en Java.
