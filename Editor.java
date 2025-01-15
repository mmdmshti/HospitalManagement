import java.util.Scanner;

public class Editor {
    JDBCDemo J = new JDBCDemo();
    Scanner input = new Scanner(System.in);
    Doctor doctor = new Doctor();
    Nurse nurse = new Nurse();
    Patient patient = new Patient();
    main main = new main();

    int getID() {
        int a = 0;
        try {
            System.out.println("please enter the ID: ");
            a = input.nextInt();
        } catch (Exception e) {
            main.ShowList();
        }
        return a;
    }
    int getRoomNumber() {
        int a = 0;
        try {
            System.out.println("please enter the roomNumber: ");
            a = input.nextInt();
        } catch (Exception e) {
            main.ShowList();
        }
        return a;


    }
    int getNationalCode(){
        int a = 0;
        try {
            System.out.println("please enter the NationalCode: ");
            a = input.nextInt();
        }catch (Exception e){
            main.ShowList();
        }
        return a;
    }
    void Edit() {
        System.out.println("""
                1. update Doctor name
                2. update nurse name
                3. update patient name
                4. update patient's room
                5. Delete Doctor
                6. Delete Nurse
                7. Delete Patient
                8. Delete Room             
                               
                """);
        System.out.println("choose one option");
        int a = input.nextInt();
        if(a == 1){
            int id = getID();
            System.out.println("please enter new name: ");
            String newName = input.next();
            J.updateDoctorName();
        }
        if(a == 2){
            int id = getID();
            System.out.println("please enter new name: ");
            String newName = input.next();
            J.updateNurseName(id ,newName );
        }
        if(a == 3){
            int nc = getNationalCode();
            System.out.println("please enter new name: ");
            String newName = input.next();
            J.updatePatientName(nc ,newName);

        }
        if(a == 4){
            int nc = getNationalCode();
            System.out.println("enter the new room number");
            int rn = input.nextInt();
            for(int l : JDBCDemo.Rooms){
                if(l == rn){
                    J.updatePatientRoomNumber(nc ,rn );
                }
            }
            main.ShowList();
        }

        if(a == 5){
            int id = getID();
            J.deleteDOC();
        }
        if(a == 6){
            int id = getID();
            J.deleteNurse(id);
        }
        if(a == 7){
            int nationalCode = getNationalCode();
            J.deletePatient(nationalCode);
        }
        if(a == 8){
            int roomnumber = getRoomNumber();
            J.deleteRoom(roomnumber);
        }

    }
}
