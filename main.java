import com.sun.tools.javac.Main;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        ShowList();
    }

    static void ShowList() {
        Scanner input = new Scanner(System.in);
        Doctor doctor = new Doctor();
        Nurse nurse = new Nurse();
        Patient patient = new Patient();
        Editor editor = new Editor();
        System.out.println("""
                1- add Doctor
                2- add Nurse
                3- add Patient
                4- Editor
                5- Docs
                6- Nurses
                7- Patients""");


        System.out.println("choose one option? ");
        int a = input.nextInt();
        if(a == 1){
            doctor.addDoc();
            ShowList();
        }
        if(a == 2){
            nurse.addNurse();
        }
        if(a == 3){
            patient.addPatient();
        }
        if(a == 4){
            editor.Edit();
        }
        if(a == 5){
            for(Doctor d : Doctor.Doctors){
                System.out.println(d.name + " " + d.age + " " + d.DocId +"\n");
            }
        }
        if(a == 6){
            for(Nurse n : Nurse.Nurses){
                System.out.println(n.name + " " + n.NurseId + " " + n.age +"\n");
            }

        }
        if(a == 7){
            for(Patient p : Patient.Patients){
                System.out.println(p.name + " " + p.NationalCode + " " + p.age + " " +p.doctor + " " + p.statue +"\n");
            }
            ShowList();

        }
}
}
