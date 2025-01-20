import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Doctor extends Person implements A{
    int DocId;
    String name;
    int age;
    int DocID;
    public Doctor(){};
    public Doctor(String name , int age , int DocId){
        this.name = name;
        this.age = age;
        this.DocId = DocId;
    }

    void addDoc(){
        HospitalManagementGUI UI = new HospitalManagementGUI();
        main.ShowList();
    }

    @Override
    public int generateID() {
        Random random = new Random();
        return random.nextInt(101);

    }
}
