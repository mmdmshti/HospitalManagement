import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Nurse extends Person implements A {
    JDBCDemo J = new JDBCDemo();
    String name;
    int age;
    int NurseId;

    Scanner input = new Scanner(System.in);
    public Nurse(){}

    public Nurse(String name , int age , int NurseID){
        this.name = name;
        this.age = age;
        this.NurseId = NurseID;
    }
    @Override
    public int generateID() {
        Random random = new Random();
        return random.nextInt(101);

    }
}
