import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class  Patient extends Person {
    String name;
    int age;
    int NationalCode;
    static int NationalCode2;
    int DocID,RoomNumber;
    static int DocID2,RoomNumber2;


    public Patient() {
    }

    public Patient(String name, int age, int NationalCode, int RoomNumber , int DocID) {
        this.name = name;
        this.age = age;
        this.NationalCode = NationalCode;
        this.DocID = DocID;
        this.RoomNumber = RoomNumber;

    }

    void setNationalCode(int nationalCode) {
        Patient.NationalCode2 = nationalCode;
    }

    int getNationalCode() {
        return Patient.NationalCode2;
    }


}
