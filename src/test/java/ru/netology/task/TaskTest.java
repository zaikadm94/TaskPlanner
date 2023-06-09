package ru.netology.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {


    @Test
    public void TrueOrFalseMeetingTest() {
        Meeting meeting = new Meeting(
                476,
                "Добавление нового функционала",
                "Медицина плюс",
                "Понедельник, утром");
        Assertions.assertTrue(meeting.matches("Добавление"));
        Assertions.assertTrue(meeting.matches("плюс"));
        Assertions.assertTrue(meeting.matches("Добав"));
        Assertions.assertFalse(meeting.matches("НОВОГО"));
        Assertions.assertFalse(meeting.matches("утром"));
        Assertions.assertFalse(meeting.matches("Понедельник"));
        Assertions.assertFalse(meeting.matches("медицина"));
        Assertions.assertFalse(meeting.matches("Обновление"));
    }

    @Test
    public void TrueOrFalseEpicTest() {
        String[] subtasks = {"картошка", "сок", "хлеб"};
        Epic epic = new Epic(454, subtasks);
        Epic epic1 = new Epic(454, new String[]{});

        Assertions.assertTrue(epic.matches("сок"));
        Assertions.assertTrue(epic.matches("карт"));
        Assertions.assertFalse(epic.matches("булка"));
        Assertions.assertFalse(epic.matches("БУЛКА"));
        Assertions.assertFalse(epic1.matches("картошка"));
    }

    @Test
    public void TrueOrFalseSimpleTaskTest() {
        SimpleTask simpleTask = new SimpleTask(345, "День рождения");

        Assertions.assertTrue(simpleTask.matches("День рождения"));
        Assertions.assertTrue(simpleTask.matches("День"));
        Assertions.assertTrue(simpleTask.matches("рожд"));
        Assertions.assertFalse(simpleTask.matches("ДЕНЬ рождения"));
        Assertions.assertFalse(simpleTask.matches("Юбилей"));
        Assertions.assertFalse(simpleTask.matches("рождение"));

    }
}
