import org.junit.jupiter.api.BeforeEach;
import taskManager.InMemoryTaskManager;
import taskManager.Managers;
import taskManager.TaskManager;
import taskType.EpicTask;
import taskType.SingleTask;
import taskType.SubTask;
import taskType.Task;
import util.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class InMemoryTaskManagerTest {
    Managers managers;
    private TaskManager inMemoryTaskManager;

    @BeforeEach
    public void beforeEach() {
        managers = new Managers();
        inMemoryTaskManager = managers.getDefault();

    }

    @Test
    void shouldCheckThatSameTaskAreEqual() {
        Task task1 = new Task(1, "описание задачи 1", "задача 1", Status.NEW);
        Task task2 = new Task(1, "описание задачи 1", "задача 1", Status.NEW);

        Assertions.assertEquals(task1, task2);

    }

    @Test
    void shouldCheckThatSameSubTaskAreEqual() {
        SubTask subTask1 = new SubTask("SubTask1", "des1", 3);
        SubTask subTask2 = new SubTask("SubTask1", "des1", 3);

        Assertions.assertEquals(subTask1, subTask2);
    }

    @Test
    void shouldCheckThatEpicCouldNotBePutInEpic() {

        EpicTask epicTask1 = new EpicTask("EpicTask1", "epic1 descr");
        EpicTask epicTask2 = new EpicTask("EpicTask2", "epic2 descr");

        SubTask subTask1 = new SubTask("SubTask1", "des1", 3);
        SubTask subTask2 = new SubTask("SubTask1", "des1", 3);

        Assertions.assertEquals(subTask1, subTask2);
    }

    @Test
    void shouldCheckUtilityClassReturnsInitializedAnReadyForUseManagers() {
        Managers managers = new Managers();
        Assertions.assertNotNull(managers.getDefault());
    }

    @Test
    void shouldCheckThatInMemoryManagerAddTasksAndFindThemByById() {

        Task task1 = new SingleTask("SingleTask1", "description1");
        inMemoryTaskManager.saveSingleTask(task1);
        Task task = inMemoryTaskManager.getSingleTaskById(1);
        Assertions.assertEquals(1, task.getId());
    }

    @Test
    void shouldSavePreviousVersionOfTaskAndData() {
        Task task1 = new SingleTask("SingleTask1", "description1");
        inMemoryTaskManager.saveSingleTask(task1);
        inMemoryTaskManager.getSingleTaskById(1);
        inMemoryTaskManager.getSingleTaskById(1);
        Assertions.assertEquals(2, inMemoryTaskManager.getHistory().size());
    }
}




