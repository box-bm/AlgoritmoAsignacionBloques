import java.util.ArrayList;
import java.util.List;

public class Utils {
    // Funciones auxiliares
    // Clonar bloques, permite mantener los bloques originales
    static List<Block> cloneBlocks(List<Block> original) {
        List<Block> clone = new ArrayList<>();
        for (Block b : original) {
            clone.add(new Block(b.originalSize));
        }
        return clone;
    }

    // Clonar procesos, permite mantener los procesos originales
    static List<Process> cloneProcesses(List<Process> original) {
        List<Process> clone = new ArrayList<>();
        for (Process p : original) {
            clone.add(new Process(p.size));
        }
        return clone;
    }

    // Imprimir resultados de la asignación de memoria
    static void printResults(List<Process> procs, List<Block> memory) {
        printAssignedProcesses(procs);
        System.out.println("Bloques restantes:");
        // Imprimir bloques restantes
        for (int i = 0; i < memory.size(); i++) {
            System.out.printf("Bloque %d: %d\n", i + 1, memory.get(i).size);
        }

        Results results = new Results(procs, memory);

        // Imprimir cantidad de procesos asignados
        System.out.printf("Procesos asignados: %d/%d\n", results.assignedProcesses, procs.size());
        System.out.printf("Memoria libre restante: %d\n", results.freeMemory);
    }

    // Imprimir procesos asignados
    static void printAssignedProcesses(List<Process> procs) {
        for (int i = 0; i < procs.size(); i++) {
            Process p = procs.get(i);

            // Al estar en bloque -1, significa que no se asignó
            if (p.assignedBlock != -1) {
                System.out.printf("Proceso %d (tam: %d) asignado al bloque %d\n", i + 1, p.size, p.assignedBlock + 1);
            } else {
                System.out.printf("Proceso %d (tam: %d) no asignado\n", i + 1, p.size);
            }
        }
    }

    static void CompareResults(List<Results> results) {
        Results bestResult = null;

        for (Results result : results) {
            if (bestResult == null ||
                    result.assignedProcesses > bestResult.assignedProcesses ||
                    (result.assignedProcesses == bestResult.assignedProcesses
                            && result.freeMemory < bestResult.freeMemory)) {
                bestResult = result;
            }
        }

        if (bestResult != null) {
            System.out.println("\n--- Mejor resultado ---");
            System.out.printf("\nMejor resultado: %s", bestResult.algorithm);
            System.out.printf("\nProcesos asignados: %d", bestResult.assignedProcesses);
            System.out.printf("\nMemoria libre restante: %d", bestResult.freeMemory);
        }
    }
}
