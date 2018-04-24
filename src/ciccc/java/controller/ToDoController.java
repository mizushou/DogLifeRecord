package ciccc.java.controller;

import ciccc.java.model.Todo;

import java.util.*;

public class ToDoController {

    public static final int LAST_ID = 100;

    private HashMap<Integer, Todo> toDoTable;
    private Set<Integer> toDoIds;

    public ToDoController() {
        this.toDoTable = new HashMap<>();
        this.toDoIds = new HashSet<>();
    }

    public void addTodo(Todo todo) {
        int id = createId();
        this.toDoTable.put(id, todo);
    }

    public void display() {
        Set<Integer> keys = toDoTable.keySet();
        for (int key : keys) {
            System.out.println("id=" + key + " | " + toDoTable.get(key));
        }
    }

    public int createId() {
        boolean notAbvailable = false;
        Random random = new Random();
        int number = -1;

        if(toDoIds.size() <= LAST_ID) {
            do{
                number = random.nextInt(LAST_ID) + 1;
                notAbvailable = toDoIds.contains(number);
            } while (notAbvailable);
        }
        return number;
    }

    public HashMap<Integer, Todo> getToDoTable() {
        return toDoTable;
    }

    public void setToDoTable(HashMap<Integer, Todo> toDoTable) {
        this.toDoTable = toDoTable;
    }
}
