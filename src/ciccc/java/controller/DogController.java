package ciccc.java.controller;

import ciccc.java.model.Dog;
import ciccc.java.model.Todo;

import java.time.LocalDate;
import java.util.*;

public class DogController {

    public static final int LAST_ID = 100;

    private HashMap<Integer, Dog> dogTable;
    private Set<Integer> dogIds;

    public DogController() {
        this.dogTable = new HashMap<Integer, Dog>();
        this.dogIds = new HashSet<>();
    }

    public void addDog(Dog dog) {
        int id = createId();
        dogTable.put(id, dog);
    }

    public void displayDogs() {
        Set<Integer> keys = dogTable.keySet();
        for (int key : keys) {
            System.out.println("id=" + key + " | " + dogTable.get(key));
        }
    }

    public void displayDogToDoList(int dogsId) {
        ArrayList<Todo> toDoList = dogTable.get(dogsId).getToDoList();
        for (int i = 0; i < toDoList.size(); i++) {
            System.out.println(i + " : " + toDoList.get(i));
        }
    }

    public void checkToDo(int dogId, int toDoIndex) {
        LocalDate today = LocalDate.now();
        HashMap<LocalDate, Boolean> checkList = dogTable.get(dogId).getToDoList().get(toDoIndex).getCheckList();
        checkList.put(today, true);
    }

    public void displayCheckList(int dogId, int toDoIndex) {
        HashMap<LocalDate, Boolean> checkList = dogTable.get(dogId).getToDoList().get(toDoIndex).getCheckList();
        Set<LocalDate> keys = checkList.keySet();
        Iterator<LocalDate> it = keys.iterator();
        while (it.hasNext()) {
            LocalDate key = it.next();
            System.out.println(key + " : " + checkList.get(key));
        }
    }

    public int createId() {
        boolean notAbvailable = false;
        Random random = new Random();
        int number = -1;

        if (dogIds.size() <= LAST_ID) {
            do {
                number = random.nextInt(LAST_ID) + 1;
                notAbvailable = dogIds.contains(number);
            } while (notAbvailable);
        }
        return number;
    }

    public HashMap<Integer, Dog> getDogTable() {
        return dogTable;
    }

    public void setDogTable(HashMap<Integer, Dog> dogTable) {
        this.dogTable = dogTable;
    }
}
