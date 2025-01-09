import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Doctor implements A{
    String name;
    int age;
    int DocId;
    static List<Doctor> Doctors = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public Doctor(){}

    public Doctor(String name , int age){
        this.name = name;
        this.age = age;
        this.DocId = generateID();

    }
    void addDoc(){
        Doctors.add(new Doctor(getName() , getAge()));
        main.ShowList();
    }
    String getName(){
        System.out.println("Doctors name: ");
        return input.next();
    }
    int getAge(){
        System.out.println("Doctors age: ");
        return input.nextInt();
    }
    void setName(int id){

        for(Doctor D : Doctors){
            if(id == D.DocId){
                System.out.println("new name: ");
                D.name = input.next();

                main.ShowList();
            }
        }
        System.out.println("doctor not found");

        main.ShowList();
    }
    void setAge(int id){
        for(Doctor D : Doctors){
            if(id == D.DocId){
                System.out.println("new age: ");
                D.age = input.nextInt();

                main.ShowList();
            }
        }
        System.out.println("doctor not found");

        main.ShowList();

    }


    @Override
    public int generateID() {
        Random random = new Random();
        return random.nextInt(101);

    }
}
