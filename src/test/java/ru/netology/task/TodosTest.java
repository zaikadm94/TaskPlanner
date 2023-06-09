package ru.netology.task;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodosTest {


    SimpleTask simpleTask = new SimpleTask(5, "НетоБанк");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    Todos todos = new Todos();


    @BeforeEach
    public void setup() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
    }

    @Test
    public void shouldAddThreeTaskOfDifferentType() {
        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void addTwoTask() {
        Task[] expected = {simpleTask, meeting};
        Task[] actual = todos.search("НетоБанк");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void addOneTask() {
        Task[] expected = {epic};
        Task[] actual = todos.search("Хлеб");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchQueryIfNotExist() {
        Task[] expected = {};
        Task[] actual = todos.search("яблоко");

        Assertions.assertArrayEquals(expected, actual);
    }

}
