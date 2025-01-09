import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Room {
    Scanner input = new Scanner(System.in);
    static List<Room> Rooms = new ArrayList<>();
    int RoomNumber;
    String RoomType;
    Boolean statue;
    Patient patient;
    public Room(){};
    public Room(int roomNumber, String roomType) {
        this.RoomNumber = roomNumber;
        this.RoomType = roomType;
        this.statue = true;
        assigner();
    }
    void addRoom(){
        Rooms.add(new Room(getRoomNumber() , getRoomType()));
        assigner();

    }
    int getRoomNumber() {
        int r = 0;
        try {
            System.out.println("please enter roomNumber");
            r = input.nextInt();

        } catch (Exception e) {
            main.ShowList();
        }

        return r;
    }
    String getRoomType(){
        String t = null;
        try{
            System.out.println("please enter Room type: ");
            t = input.next();
        }catch (Exception e){
            main.ShowList();

        }
        return t;
    }
     void assigner(){
        for(Room r : Rooms){
            for(Patient p : Patient.Patients){
                if(r.statue && p.room == null){
                    r.statue = false;
                    r.patient = p;
                    p.room = r;
                }
            }
        }
        main.ShowList();
     }


}