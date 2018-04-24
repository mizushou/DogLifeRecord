package ciccc.java.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;

public class Todo {

    private String title;
    private String content;
    private int importance;
    private HashMap<LocalDate, Boolean> checkList;

    public Todo(String title, String content, int importance) {
        this.title = title;
        this.content = content;
        this.importance = importance;
        this.checkList = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Todo [ name=" + this.title + " age=" + this.content + " importance=" + this.importance + " ]";
    }

    public HashMap<LocalDate, Boolean> getCheckList() {
        return checkList;
    }

    public void setCheckList(HashMap<LocalDate, Boolean> checkList) {
        this.checkList = checkList;
    }
}
