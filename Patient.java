import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class  Patient extends Person {
    JDBCDemo J = new JDBCDemo();
    String name;
    int age;
    int NationalCode;
    Doctor doctor;
    int x = 0;
    static List<Patient> Patients = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public Patient() {
    }

    public Patient(String name, int age, int NationalCode, Doctor doctor) {
        this.name = name;
        this.age = age;
        this.NationalCode = NationalCode;
        this.doctor = doctor;
        Room room1 = new Room();
        room1.assigner();
    }

    void setNationalCode(int nationalCode) {
        this.NationalCode = nationalCode;
    }

    int getNationalCode() {
        return NationalCode;
    }
}
