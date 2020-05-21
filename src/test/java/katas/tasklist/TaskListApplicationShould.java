package katas.tasklist;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public final class TaskListApplicationShould {

    @Mock private BufferedReader in;
    @Mock private PrintWriter out;
    private TaskList taskList;

    @Before
    public void setup() {
        taskList = new TaskList(in, out);
    }

    @Test
    public void
    show_how_to_setup_a_deadline() throws Exception {
        when(in.readLine()).thenReturn("help").thenReturn("quit");

        taskList.run();

        verify(out, times(1)).println("  deadline <task ID> <due date>");
    }

    @Test
    public void
    add_a_deadline_to_existing_task_when_specified() throws Exception {
        when(in.readLine()).
                thenReturn("add project cats").
                thenReturn("add task cats Eat more fish.").
                thenReturn("add task cats Destroy all humans.").
                thenReturn("deadline 1 2020-02-21").
                thenReturn("show").
                thenReturn("quit");

        taskList.run();

        verify(out, atLeastOnce()).println("[ ] 1: Eat more fish. due: 2020-02-21");
    }

    @Test
    public void
    show_tasks_due_today() throws Exception {
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        when(in.readLine()).
                thenReturn("add project cats").
                thenReturn("add task cats Eat more fish.").
                thenReturn("add task cats Destroy all humans.").
                thenReturn("deadline 2 " + today).
                thenReturn("today").
                thenReturn("quit");

        taskList.run();

        verify(out, atLeastOnce()).println("[ ] 2: Destroy all humans. due: " + today);
    }

}
