import taskManager.Managers;
import taskManager.TaskManager;
import taskType.EpicTask;
import taskType.SingleTask;
import taskType.SubTask;
import taskType.Task;
import util.Status;

public class Main {
    public static void main(String[] args) {

        Managers managers = new Managers();
        TaskManager inMemoryTaskManager = managers.getDefault();

        Task task1 = new SingleTask("SingleTask1", "description1");
        Task task2 = new SingleTask("SingleTask2", "description2");

        inMemoryTaskManager.saveSingleTask(task1);
        inMemoryTaskManager.saveSingleTask(task2);
        System.out.println(inMemoryTaskManager.getAllSingleTask());

        Task epicTask1 = new EpicTask("EpicTask1", "epic1 descr");
        Task epicTask2 = new EpicTask("EpicTask2", "epic2 descr");
        inMemoryTaskManager.saveEpicTask(epicTask1);
        inMemoryTaskManager.saveEpicTask(epicTask2);


        SubTask subTask1 = new SubTask("SubTask1", "des1", 3);
        SubTask subTask2 = new SubTask("SubTask2", "des2", 3);
        SubTask subTask3 = new SubTask("SubTask3", "des3", 4);

        inMemoryTaskManager.saveSubTask(subTask1);
        inMemoryTaskManager.saveSubTask(subTask2);
        inMemoryTaskManager.saveSubTask(subTask3);


        System.out.println("Все подзадачи:");
        System.out.println(inMemoryTaskManager.getAllSubtaskTask());
        System.out.println("Все ЭПИКИ:");
        System.out.println(inMemoryTaskManager.getAllEpicTask());

        task1.setStatus(Status.DONE);
        //System.out.println(inMemoryTaskManager.getSingleTaskById(task1.getId()));

        subTask1.setStatus(Status.DONE);
        inMemoryTaskManager.updateSubTask(subTask1);

        System.out.println("Обновили ЭПИК после обновления подзадачи:");
        // System.out.println(inMemoryTaskManager.getEpicTaskById(subTask1.getEpicId()));

        System.out.println("Удалили подзадачу из Эпика:");
        inMemoryTaskManager.deleteSubTaskById(subTask3.getId());
        //System.out.println(inMemoryTaskManager.getEpicTaskById(subTask3.getEpicId()));

        System.out.println("Удалили подзадачу из ЭПИКа и пересчитали статус эпика:");
        inMemoryTaskManager.deleteSubTaskById(subTask1.getId());
        // System.out.println(inMemoryTaskManager.getEpicTaskById(subTask2.getEpicId()));
        inMemoryTaskManager.getSingleTaskById(1);
        inMemoryTaskManager.getSingleTaskById(1);
        inMemoryTaskManager.getEpicTaskById(3);
        inMemoryTaskManager.getEpicTaskById(4);
        inMemoryTaskManager.getSubTaskById(6);

        printAllTasks(inMemoryTaskManager);
    }


    private static void printAllTasks(TaskManager manager) {

        System.out.println("История:");
        for (Task task : manager.getHistory()) {
            System.out.println(task);
        }
    }
}