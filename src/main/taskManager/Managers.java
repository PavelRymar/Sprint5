package taskManager;

public class Managers {
    TaskManager manager;
    static HistoryManager historyManager;

    public TaskManager getDefault() {
        return manager = new InMemoryTaskManager();
    }
    static HistoryManager getDefaultHistory() {
        return historyManager = new InMemoryHistoryManager();
    }
}
