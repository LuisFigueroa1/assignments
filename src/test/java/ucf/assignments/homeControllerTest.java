package ucf.assignments;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


class homeControllerTest {

    @Test
    @DisplayName("should change a string value")
    public void createTask() {
        String label  = null;
        label = "taskTittle 1";
        Assertions.assertNotEquals( null, label);
    }

    @Test
    @DisplayName("should add a String To an array list")
    public void  addTest() {
        List<String>taskList =new ArrayList<>();
        taskList.add("Task4");
        var  length = taskList.size();
        Assertions.assertEquals( 1, length);

    }

    @Test
    @DisplayName("should remove a String from an array list")
    void deleteSelectedPushed() {
        List<String>taskList =new ArrayList<>();
        taskList.add("Task4");
        taskList.remove("Task4");
        var  length = taskList.size();
        Assertions.assertEquals( 0, length);
    }

    @Test
    @DisplayName("should set the String of an array list to a different one and compare it")
    void statusPushed() {
        List<String>taskList =new ArrayList<>();

        List<String>taskList2 =new ArrayList<>();
        taskList2.add("Task5");

        taskList.add("Task4");
        taskList.set(0, "Task5");

        Assertions.assertEquals(taskList2, taskList);

    }

    @Test
    @DisplayName("should clear an array list  and compare it")
    void deleteAllPushed() {
        List<String>taskList2 =new ArrayList<>();
        List<String>taskList =new ArrayList<>();
        taskList.add("Task1");
        taskList.add("Task2");
        taskList.add("Task3");
        taskList.add("Task4");

        taskList.clear();

        Assertions.assertEquals(taskList2, taskList);


    }

    @Test
    @DisplayName("should write (1) in  a .txt")
    void exportPushed() {

        try {
            int works = 0;
            File myObj = new File("taskTest" + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                FileWriter myWriter = new FileWriter("taskTest" + ".txt");
                myWriter.write("1");
                myWriter.close();
                works = 1;
                Assertions.assertEquals(1, works);

            } else {
                System.out.println("File already exists.");
                works = 2;
                Assertions.assertEquals(1, works);

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            int works = 0;
            Assertions.assertEquals(1, works);
        }

    }

    @Test
    @DisplayName("should read .txt and check if it content (1)")
    void importList() {
        try {
            File myObj = new File("taskTest" + ".txt");
            Scanner read = new Scanner (new File("taskTest" + ".txt"));
            String data= read.next();
            System.out.println(data);
            Assertions.assertEquals("1" , data);
            read.close();

        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}