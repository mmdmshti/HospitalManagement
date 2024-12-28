import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Nurse implements A{

    String name;
    int age;
    int NurseId;
    static List<Nurse> Nurses = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    public Nurse(String name , int age){
        this.name = name;
        this.age = age;
        this.NurseId = generateID();

    }
    void addNurse(){
        Nurses.add(new Nurse(getName() , getAge()));

    }
    String getName(){
        System.out.println("enter nurse's name: ");
        return input.next();

    }
    int getAge(){
        System.out.println("enter nurse's age: ");
        return input.nextInt();

    }

    @Override
    public int generateID() {
        Random random = new Random();
        return random.nextInt(101);

    }
}
