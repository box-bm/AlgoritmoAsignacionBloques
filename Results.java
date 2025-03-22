import java.util.List;

public class Results {
    int assignedProcesses;
    int totalProcesses;
    int freeMemory;
    String algorithm;

    Results(List<Process> procs, List<Block> memory) {
        assignedProcesses = countAssignedProcesses(procs);
        totalProcesses = procs.size();
        freeMemory = getFreeMemory(memory);
        this.algorithm = "";
    }

    Results(List<Process> procs, List<Block> memory, String algorithm) {
        assignedProcesses = countAssignedProcesses(procs);
        totalProcesses = procs.size();
        freeMemory = getFreeMemory(memory);
        this.algorithm = algorithm;
    }

    // Contar procesos asignados
    int countAssignedProcesses(List<Process> procs) {
        int assigned = 0;
        for (Process p : procs) {
            if (p.assignedBlock != -1) {
                assigned++;
            }
        }
        return assigned;
    }

    // Obtiene el total de memoria libre
    int getFreeMemory(List<Block> memory) {
        int freeMemory = 0;
        for (int i = 0; i < memory.size(); i++) {
            freeMemory += memory.get(i).size;
        }

        return freeMemory;
    }
}
