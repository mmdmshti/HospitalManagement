
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        ShowList();


    }

    static void ShowList() {
        JDBCDemo J = new JDBCDemo();
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
                7- Patients
                8- Rooms
                9- add Room
                """);


        System.out.println("choose one option? ");
        int a = input.nextInt();
        if(a == 1){
            doctor.addDoc();
            ShowList();
        }
        if(a == 2){
//            nurse.addNurse();
        }
        if(a == 3){
//            patient.addPatient();
        }
        if(a == 4){
//            editor.Edit();
        }
        if(a == 5){
        J.getAllDoctors();
        ShowList();
        }
        if(a == 6){
            J.getAllNurses();
            ShowList();

        }
        if(a == 7){
            J.getAllPatients();
            ShowList();

        }
        if(a == 8){
        }
        if(a == 9){
            Room room = new Room();
            room.addRoom();

        }
}
}
