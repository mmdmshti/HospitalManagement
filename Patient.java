import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Patient {
    String name;
    int age;
    int NationalCode;
    Doctor doctor;
    Doctor D;
    int x = 0;
    static List<Patient> Patients = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    public Patient(String name , int age , int NationalCode , Doctor doctor){
        this.name = name;
        this.age = age;
        this.NationalCode = NationalCode;
        this.doctor = doctor;
    }
    void addPatient(){
        Patients.add(new Patient(getName() , getAge() , getNationalCode() , getDoctor()));
    }
    String getName(){
        System.out.println("please enter patient name: ");
        return input.next();
    }
    int getAge(){
        System.out.println("please enter patient age: ");
        return input.nextInt();
    }
    int getNationalCode(){
        System.out.println("please enter patient name: ");
        return input.nextInt();
    }
    Doctor getDoctor(){
        System.out.println("Doctor id: ");
        int DocID = input.nextInt();
        for(Doctor D : Doctor.Doctors){
            if(D.DocId == DocID){
                this.D = D;
                x = 1;
            }
        }
        if(x == 0){
            System.out.println("Doctor not found!");
            main main = new main();
            main.ShowList();
        }
        return D;
    }




}
