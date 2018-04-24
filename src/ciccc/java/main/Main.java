package ciccc.java.main;

import ciccc.java.model.Dog;
import ciccc.java.controller.DogController;
import ciccc.java.controller.ToDoController;
import ciccc.java.model.Todo;
import ciccc.java.view.InputReader;

import java.util.HashMap;


public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void run() {

        boolean flag = false;
        DogController dogCtrl = new DogController();
        ToDoController todoCtrl = new ToDoController();

        while (flag == false) {

            System.out.println();
            System.out.println("-------------");
            System.out.println("Select option");
            System.out.println("-------------");
            System.out.println("1 : Add dog");
            System.out.println("2 : Display dogs table");
            System.out.println("3 : Add todo");
            System.out.println("4 : Display ToDo table");
            System.out.println("5 : Assign ToDo");
            System.out.println("6 : Display dog's ToDo list");
            System.out.println("7 : Check ToDo");
            System.out.println("8 : Display check list");
            System.out.println("0 : Exit");

            InputReader input = new InputReader();
            int option = input.getIntInput();

            switch (option) {
                case 1:
                    System.out.println("Input Dog's name");
                    String name = input.getStringInput();

                    System.out.println("Input Dog's age");
                    int age = input.getIntInput();

                    dogCtrl.addDog(new Dog(name, age));
                    break;
                case 2:
                    dogCtrl.displayDogs();
                    break;
                case 3:
                    System.out.println("Input todo's titles");
                    String title = input.getStringInput();

                    System.out.println("Input todo's contents");
                    String content = input.getStringInput();

                    System.out.println("Input todo's importance");
                    int importance = input.getIntInput();

                    todoCtrl.addTodo(new Todo(title, content, importance));
                    break;
                case 4:
                    todoCtrl.display();
                    break;
                case 5: {
                    System.out.println("Input Dog's ID");
                    int dogId = input.getIntInput();
                    HashMap<Integer, Dog> dogTable = dogCtrl.getDogTable();

                    System.out.println("Input ToDo's ID");
                    int toDoId = input.getIntInput();
                    HashMap<Integer, Todo> toDoTable = todoCtrl.getToDoTable();

                    if (dogTable.containsKey(dogId) && toDoTable.containsKey(toDoId)) {
                        dogTable.get(dogId).getToDoList().add(toDoTable.get(toDoId));
                    }
                    break;
                }
                case 6: {
                    System.out.println("Input Dog's ID");
                    int dogId = input.getIntInput();
                    HashMap<Integer, Dog> dogTable = dogCtrl.getDogTable();
                    if (dogTable.containsKey(dogId)) {
                        dogCtrl.displayDogToDoList(dogId);
                    }
                    break;
                }
                case 7: {
                    System.out.println("Input Dog's ID");
                    int dogId = input.getIntInput();
                    HashMap<Integer, Dog> dogTable = dogCtrl.getDogTable();
                    if (dogTable.containsKey(dogId)) {
                        dogCtrl.displayDogToDoList(dogId);
                    }
                    System.out.println("Check ToDo");
                    int toDoIndex = input.getIntInput();
                    dogCtrl.checkToDo(dogId, toDoIndex);
                    break;
                }
                case 8: {
                    System.out.println("Input Dog's ID");
                    int dogId = input.getIntInput();
                    HashMap<Integer, Dog> dogTable = dogCtrl.getDogTable();
                    if (dogTable.containsKey(dogId)) {
                        dogCtrl.displayDogToDoList(dogId);
                    }
                    System.out.println("Select ToDo index");
                    int toDoIndex = input.getIntInput();
                    dogCtrl.displayCheckList(dogId, toDoIndex);
                    break;
                }
                case 0:
                    flag = true;
                    break;
            }
        }

    }


}
