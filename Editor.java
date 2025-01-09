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
                1. Change Doctor Name
                2. Change Doctor Age
                3. Change Nurse Name
                4. Change Nurse Age
                5. Change Patient Name
                6. Change Patient Age
                7. Change Patient NationalCode
                8. Change Patients Doctor
                9. Change patients room
                10. Change patient statue
                11. Change roomNumber
                12. Change roomType
                13. Delete Doctor
                14. Delete Nurse
                15. Delete Patient
                16. Delete Room             
                               
                """);
        System.out.println("choose one option");
        int a = input.nextInt();
        if(a == 1){
            doctor.setName(getID());
        }
        if(a == 2){
            doctor.setAge(getID());
        }
        if (a == 3){
            nurse.setName(getID());
        }
        if(a == 4){
            nurse.setAge(getID());
        }
        if(a == 5){
            patient.setName(getNationalCode());
        }
        if(a == 6){
            patient.setAge(getNationalCode());
        }
        if(a == 7){
            patient.setNationalCode(getNationalCode());
        }
        if (a == 8){
            patient.setDoctor(getNationalCode());
        }
        if(a == 9){
            patient.setRoom(getNationalCode());
        }
        if(a == 10){
            patient.setStatue(getNationalCode());
        }
        if(a == 13){
            int id = getID();
            J.deleteDOC(id);
        }
        if(a == 14){
            int id = getID();
            J.deleteNurse(id);
        }
        if(a == 15){
            int nationalCode = getNationalCode();
            J.deletePatient(nationalCode);
        }
        if(a == 16){
            int roomnumber = getRoomNumber();
            J.deleteRoom(roomnumber);
        }

    }
}
