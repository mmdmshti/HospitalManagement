import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Patient {
    String name;
    int age;
    int NationalCode;
    Doctor doctor;
    int statue;
    Room room;
    Doctor D;
    int x = 0;
    static List<Patient> Patients = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    public Patient(){}
    public Patient(String name , int age , int NationalCode , Doctor doctor , int statue ){
        this.name = name;
        this.age = age;
        this.NationalCode = NationalCode;
        this.doctor = doctor;
        this.statue = statue;
        this.room = null;
        Room room1 = new Room();
        room1.assigner();

    }
    void addPatient(){
        Patients.add(new Patient(getName() , getAge() , getNationalCode() , getDoctor() , getStatue()));
        main.ShowList();
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
        System.out.println("please enter patient national code: ");
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

            main.ShowList();
        }
        return D;
    }

    int getStatue(){
        System.out.println("please enter the Patient status: (1-3) ");
        int statue = input.nextInt();
        if(statue>3 || statue<1){
            getStatue();
        }
        return statue;
    }

    //setters
    void setName(int nationalCode){
        for(Patient patient : Patients){
            if(patient.NationalCode == nationalCode){
                System.out.println("please enter the new name: ");
                patient.name = input.next();

                main.ShowList();
            }
        }
        System.out.println("patient not found!");

        main.ShowList();


    }
    void setAge(int nationalCode){
        for(Patient patient : Patients){
            if(patient.NationalCode == nationalCode){
                System.out.println("please enter the new age: ");
                patient.age = input.nextInt();

                main.ShowList();
            }
        }
        System.out.println("patient not found!");

        main.ShowList();


    }
    void setNationalCode(int nationalCode){
        for(Patient patient : Patients){
            if(patient.NationalCode == nationalCode){
                System.out.println("please enter the new National Code: ");
                patient.NationalCode = input.nextInt();

                main.ShowList();
            }
        }
        System.out.println("patient not found!");

        main.ShowList();

    }
    void setDoctor(int nationalCode){
        for(Patient patient : Patients){
            if(patient.NationalCode == nationalCode){
                System.out.println("please enter the new doc id: ");
                int id = input.nextInt();
                for(Doctor D : Doctor.Doctors){
                    if(D.DocId == id){
                        patient.doctor = D;
                        System.out.println("Done");
                    }
                }

                main.ShowList();
            }
        }
        System.out.println("patient not found!");

        main.ShowList();
    }
    void setStatue(int nationalCode){
        for(Patient patient : Patients){
            if(patient.NationalCode == nationalCode){
                System.out.println("please enter the statue (1-3)");
                int statue = input.nextInt();
                if(statue>3 || statue < 1){
                    System.out.println("wrong");

                    main.ShowList();
                }
                else {
                    patient.statue =statue;

                    main.ShowList();
                }
            }
        }
        System.out.println("patient not found!");

        main.ShowList();

    }
    void setRoom(int nationalCode){
        System.out.println("Room Number: ");
        int RN = input.nextInt();
        for(Patient p : Patients){
            for(Room r : Room.Rooms) {
                if (p.NationalCode == nationalCode && r.RoomNumber == RN) {
                    p.room.statue = true;
                    p.room = r;
                    r.statue = false;
                    Room room1 = new Room();
                    room1.assigner();
                }
            }
        }
        System.out.println("something went wrong");
        main.ShowList();
    }



}
