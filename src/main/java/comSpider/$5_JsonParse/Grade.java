package comSpider.$5_JsonParse;

import java.util.ArrayList;

public class Grade {
    private Integer id;
    private String name;
    private ArrayList<Student> studentList;

    public Grade() {
    }

    public Grade(Integer id, String name, ArrayList<Student> studentList) {
        this.id = id;
        this.name = name;
        this.studentList = studentList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
