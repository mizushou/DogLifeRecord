package ciccc.java.model;

import java.util.ArrayList;

public class Dog {

    private String name;
    private int age;
    private ArrayList<Todo> toDoList;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
        this.toDoList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Todo> getToDoList() {
        return toDoList;
    }

    public void setToDoList(ArrayList<Todo> toDoList) {
        this.toDoList = toDoList;
    }

    @Override
    public String toString() {
        return "Dog [ name=" + this.name + " age=" + this.age + " ]";
    }
}
