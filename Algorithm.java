import java.util.List;

public class Algorithm {

    // Algoritmo primer ajuste
    static Results firstFit(List<Block> blocks, List<Process> processes) {
        List<Block> memory = Utils.cloneBlocks(blocks);
        List<Process> procs = Utils.cloneProcesses(processes);

        for (Process p : procs) {
            for (int j = 0; j < memory.size(); j++) {
                if (memory.get(j).size >= p.size) {
                    p.assignedBlock = j;
                    memory.get(j).size -= p.size;
                    break;
                }
            }
        }

        Utils.printResults(procs, memory);
        return new Results(procs, memory, "Primer Ajuste");
    }

    // Algoritmo mejor ajuste
    static Results bestFit(List<Block> blocks, List<Process> processes) {
        List<Block> memory = Utils.cloneBlocks(blocks);
        List<Process> procs = Utils.cloneProcesses(processes);

        for (Process p : procs) {
            int index = -1, min = Integer.MAX_VALUE;
            for (int j = 0; j < memory.size(); j++) {
                if (memory.get(j).size >= p.size && memory.get(j).size < min) {
                    min = memory.get(j).size;
                    index = j;
                }
            }
            if (index != -1) {
                p.assignedBlock = index;
                memory.get(index).size -= p.size;
            }
        }

        Utils.printResults(procs, memory);
        return new Results(procs, memory, "Mejor Ajuste");
    }

    // Algoritmo peor ajuste
    static Results worstFit(List<Block> blocks, List<Process> processes) {
        List<Block> memory = Utils.cloneBlocks(blocks);
        List<Process> procs = Utils.cloneProcesses(processes);

        for (Process p : procs) {
            int index = -1, max = -1;
            for (int j = 0; j < memory.size(); j++) {
                if (memory.get(j).size >= p.size && memory.get(j).size > max) {
                    max = memory.get(j).size;
                    index = j;
                }
            }
            if (index != -1) {
                p.assignedBlock = index;
                memory.get(index).size -= p.size;
            }
        }

        Utils.printResults(procs, memory);
        return new Results(procs, memory, "Peor Ajuste");
    }

    // Algoritmo siguiente ajuste
    static Results nextFit(List<Block> blocks, List<Process> processes) {
        List<Block> memory = Utils.cloneBlocks(blocks);
        List<Process> procs = Utils.cloneProcesses(processes);
        int lastIndex = 0;

        for (Process p : procs) {
            int count = 0;
            int j = lastIndex;
            boolean assigned = false;
            while (count < memory.size()) {
                if (memory.get(j).size >= p.size) {
                    // Asignar proceso al bloque
                    p.assignedBlock = j;

                    // Actualizar tamaño del bloque
                    memory.get(j).size -= p.size;

                    // Actualizar último índice asignado
                    lastIndex = (j + 1) % memory.size();

                    // Indicamos que fue asignado
                    assigned = true;
                    break;
                }
                // donde J el residuo de la division de j+1 entre el tamaño de la memoria
                j = (j + 1) % memory.size();

                // Incrementar contador
                count++;
            }

            // Si no se asignó, se asigna a -1
            if (!assigned) {
                p.assignedBlock = -1;
            }
        }

        Utils.printResults(procs, memory);
        return new Results(procs, memory, "Proximo Ajuste");
    }
}
