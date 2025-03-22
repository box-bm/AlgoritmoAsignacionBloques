import java.util.*;

public class MemoryAllocation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bloques de memoria
        // Se solicita al usuario el número de bloques de memoria y sus tamaños
        System.out.print("Ingrese el número de bloques de memoria: ");
        int blockCount = scanner.nextInt();
        List<Block> originalBlocks = new ArrayList<>();
        System.out.println("Ingrese los tamaños de los bloques:");

        // Agregamos los bloques de memoria
        for (int i = 0; i < blockCount; i++) {
            originalBlocks.add(new Block(scanner.nextInt()));
        }

        // Procesos
        // Se solicita al usuario el número de procesos y sus tamaños
        System.out.print("\nIngrese el número de procesos: ");
        int processCount = scanner.nextInt();
        List<Process> originalProcesses = new ArrayList<>();
        System.out.println("Ingrese los tamaños de los procesos:");

        // Agregamos los procesos
        for (int i = 0; i < processCount; i++) {
            originalProcesses.add(new Process(scanner.nextInt()));
        }

        // Cerramos el scanner para optimizar el codigo.
        scanner.close();

        // Presentacion de resultados
        System.out.println("\n--- Primer Ajuste ---");
        Results firstFit = Algorithm.firstFit(originalBlocks, originalProcesses);

        System.out.println("\n--- Mejor Ajuste ---");
        Results bestFit = Algorithm.bestFit(originalBlocks, originalProcesses);

        System.out.println("\n--- Peor Ajuste ---");
        Results worstFit = Algorithm.worstFit(originalBlocks, originalProcesses);

        System.out.println("\n--- Proximo Ajuste ---");
        Results nextFit = Algorithm.nextFit(originalBlocks, originalProcesses);

        // Comparacion de resultados
        Utils.CompareResults(Arrays.asList(firstFit, bestFit, worstFit, nextFit));
    }

}
