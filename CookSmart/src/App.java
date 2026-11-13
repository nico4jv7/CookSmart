import java.util.*;

public class App {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        System.out.println("=== BIENVENIDO A COOKSMART (TU DESPENSA INTELIGENTE) ===");

       // 1. Catálogo global de ingredientes diferenciados (máximo 1 en común por receta)
        Ingrediente arroz = new Ingrediente("arroz", "Grano", "gramos");
        Ingrediente pollo = new Ingrediente("pollo", "Proteína", "gramos");
        Ingrediente zanahoria = new Ingrediente("zanahoria", "Verdura", "gramos");

        Ingrediente platano = new Ingrediente("platano", "Fruta/Verdura", "unidad");
        Ingrediente queso = new Ingrediente("queso", "Lácteo", "gramos");
        Ingrediente mantequilla = new Ingrediente("mantequilla", "Grasa", "gramos");

        Ingrediente huevo = new Ingrediente("huevo", "Proteína", "unidad");
        Ingrediente tomate = new Ingrediente("tomate", "Verdura", "gramos");
        Ingrediente cebolla = new Ingrediente("cebolla", "Verdura", "gramos");
        Ingrediente arepa = new Ingrediente("arepa", "Panadería", "unidad");

        Ingrediente atun = new Ingrediente("atun", "Proteína", "lata");
        Ingrediente pasta = new Ingrediente("pasta", "Grano", "gramos");
        Ingrediente maiz = new Ingrediente("maiz", "Verdura", "gramos");

        Ingrediente carne = new Ingrediente("carne", "Proteína", "gramos");
        Ingrediente papa = new Ingrediente("papa", "Tubérculo", "gramos");
        Ingrediente ensalada = new Ingrediente("ensalada", "Verdura", "gramos");

        // 2. Inicializamos la despensa del usuario
        Despensa miDespensa = new Despensa();

        // 3. Registro por consola
        System.out.println("\n--- REGISTRA TU DESPENSA ---");
        System.out.println("Ingredientes disponibles: arroz, pollo, zanahoria, platano, queso, mantequilla, huevo, tomate, cebolla, arepa, atun, pasta, maiz, carne, papa, ensalada.");
        System.out.println("Escribe el nombre del ingrediente que tienes (o escribe 'salir' para terminar):");

        while (true) {
            System.out.print(" > Ingrediente: ");
            String entrada = scanner.nextLine();

            if (entrada.equals("salir")) {
                break;
            }

            // Validaciones directas de cada ingrediente
            if (entrada.equals("arroz")) { miDespensa.agregar(arroz); System.out.println("   [✓] 'arroz' agregado."); }
            else if (entrada.equals("pollo")) { miDespensa.agregar(pollo); System.out.println("   [✓] 'pollo' agregado."); }
            else if (entrada.equals("zanahoria")) { miDespensa.agregar(zanahoria); System.out.println("   [✓] 'zanahoria' agregado."); }
            else if (entrada.equals("platano")) { miDespensa.agregar(platano); System.out.println("   [✓] 'platano' agregado."); }
            else if (entrada.equals("queso")) { miDespensa.agregar(queso); System.out.println("   [✓] 'queso' agregado."); }
            else if (entrada.equals("mantequilla")) { miDespensa.agregar(mantequilla); System.out.println("   [✓] 'mantequilla' agregado."); }
            else if (entrada.equals("huevo")) { miDespensa.agregar(huevo); System.out.println("   [✓] 'huevo' agregado."); }
            else if (entrada.equals("tomate")) { miDespensa.agregar(tomate); System.out.println("   [✓] 'tomate' agregado."); }
            else if (entrada.equals("cebolla")) { miDespensa.agregar(cebolla); System.out.println("   [✓] 'cebolla' agregado."); }
            else if (entrada.equals("arepa")) { miDespensa.agregar(arepa); System.out.println("   [✓] 'arepa' agregado."); }
            else if (entrada.equals("atun")) { miDespensa.agregar(atun); System.out.println("   [✓] 'atun' agregado."); }
            else if (entrada.equals("pasta")) { miDespensa.agregar(pasta); System.out.println("   [✓] 'pasta' agregado."); }
            else if (entrada.equals("maiz")) { miDespensa.agregar(maiz); System.out.println("   [✓] 'maiz' agregado."); }
            else if (entrada.equals("carne")) { miDespensa.agregar(carne); System.out.println("   [✓] 'carne' agregado."); }
            else if (entrada.equals("papa")) { miDespensa.agregar(papa); System.out.println("   [✓] 'papa' agregado."); }
            else if (entrada.equals("ensalada")) { miDespensa.agregar(ensalada); System.out.println("   [✓] 'ensalada' agregado."); }
            else {
                System.out.println("   [X] Ingrediente no reconocido. Intenta con otro.");
            }
        }

        // 4. Creamos el Buscador y el catálogo de recetas totalmente independientes
        BuscadorRecetas buscador = new BuscadorRecetas();

        // Receta 1: Arroz con Pollo
        List<Ingrediente> ing1 = new ArrayList<>();
        ing1.add(arroz); ing1.add(pollo); ing1.add(zanahoria);
        List<String> pasos1 = new ArrayList<>();
        pasos1.add("Cocinar el arroz con la zanahoria picada.");
        pasos1.add("Desmenuzar el pollo cocinado.");
        pasos1.add("Mezclar todo en una sola olla.");
        buscador.agregarReceta(new Receta("Arroz con Pollo", ing1, pasos1));

        // Receta 2: Patacones con Queso
        List<Ingrediente> ing2 = new ArrayList<>();
        ing2.add(platano); ing2.add(queso); ing2.add(mantequilla);
        List<String> pasos2 = new ArrayList<>();
        pasos2.add("Freír las rodajas de plátano verde.");
        pasos2.add("Aplanar y untar un toque de mantequilla.");
        pasos2.add("Cubrir con queso rallado fundido.");
        buscador.agregarReceta(new Receta("Patacones con Queso", ing2, pasos2));

        // Receta 3: Huevos Pericos con Arepa
        List<Ingrediente> ing3 = new ArrayList<>();
        ing3.add(huevo); ing3.add(tomate); ing3.add(cebolla); ing3.add(arepa);
        List<String> pasos3 = new ArrayList<>();
        pasos3.add("Asar la arepa a la parrilla.");
        pasos3.add("Sofreír el tomate y la cebolla picados.");
        pasos3.add("Agregar los huevos revueltos y servir sobre la arepa.");
        buscador.agregarReceta(new Receta("Huevos Pericos con Arepa", ing3, pasos3));

        // Receta 4: Pasta con Atún y Maíz
        List<Ingrediente> ing4 = new ArrayList<>();
        ing4.add(atun); ing4.add(pasta); ing4.add(maiz);
        List<String> pasos4 = new ArrayList<>();
        pasos4.add("Poner a cocinar la pasta en agua con sal.");
        pasos4.add("Escurrir y mezclar con el atún y los granos de maíz.");
        pasos4.add("Servir frío o tibio.");
        buscador.agregarReceta(new Receta("Pasta con Atún", ing4, pasos4));

        // Receta 5: Carne Asada con Papa
        List<Ingrediente> ing5 = new ArrayList<>();
        ing5.add(carne); ing5.add(papa); ing5.add(ensalada);
        List<String> pasos5 = new ArrayList<>();
        pasos5.add("Asar la carne en la plancha al punto deseado.");
        pasos5.add("Cocinar o freír las papas en cascos.");
        pasos5.add("Acompañar con la porción de ensalada fresca.");
        buscador.agregarReceta(new Receta("Carne Asada con Papa", ing5, pasos5));

        // 5. Ranking ordenado de mayor a menor coincidencia
        List<String> sugerencias = buscador.buscarYRecomendar(miDespensa);

        System.out.println("\n--- RANKING DE RECETAS RECOMENDADAS ---");
        if (sugerencias.isEmpty()) {
            System.out.println("No hay recetas disponibles con los ingredientes que registraste.");
        } else {
            // Iteramos usando los dos puntos (:)
            for (String sugerencia : sugerencias) {
                System.out.println(" 🍳 " + sugerencia);
            }
        }

        // 6. Selección de detalle
        System.out.println("\n¿Qué receta te gustaría preparar para ver sus ingredientes faltantes y su paso a paso?");
        System.out.println("Escribe el nombre exacto de la receta (o escribe 'ninguna' para salir):");
        System.out.print(" > Receta elegida: ");
        String seleccion = scanner.nextLine();

        if (!seleccion.equalsIgnoreCase("ninguna")) {
            Receta recetaSeleccionada = buscador.obtenerRecetaPorNombre(seleccion);

            if (recetaSeleccionada != null) {
                System.out.println("\n========================================");
                System.out.println(" RECETA: " + recetaSeleccionada.getNombre());
                System.out.println("========================================");
                
                double pct = recetaSeleccionada.calcularCoincidencia(miDespensa);
                System.out.println("Coincidencia con tu despensa: " + pct + "%");
                
                List<String> faltantes = recetaSeleccionada.obtenerIngredientesFaltantes(miDespensa);
                if (faltantes.isEmpty()) {
                    System.out.println(" ¡Tienes el 100% de los ingredientes! Puedes cocinarlo ya mismo.");
                } else {
                    System.out.println(" 🛒 Ingredientes que te faltan por comprar:");
                    // Iteramos con los dos puntos (:)
                    for (String f : faltantes) {
                        System.out.println("    - " + f);
                    }
                }

                System.out.println("\n PASO A PASO:");
                List<String> pasosReceta = recetaSeleccionada.getPasos();
                for (int i = 0; i < pasosReceta.size(); i++) {
                    System.out.println("    " + (i + 1) + ". " + pasosReceta.get(i));
                }
                System.out.println("========================================");
            } else {
                System.out.println("[X] No se encontró ninguna receta con ese nombre.");
            }
        }

        System.out.println("\n¡Gracias por usar CookSmart!");
        scanner.close();
    }
}