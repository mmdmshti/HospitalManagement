import java.util.Scanner;

public class Editor {
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
        if(a == 11){

        }

    }
}
