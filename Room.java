import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Room {
    JDBCDemo J = new JDBCDemo();
    Scanner input = new Scanner(System.in);
    static List<Room> Rooms = new ArrayList<>();

    static int RoomNumber2;
    int RoomNumber;
    String Statue;

    public Room(){};
    public Room(int roomNumber, String statue) {
        this.RoomNumber = roomNumber;
        this.Statue = statue;


    }

    void setRoomNumber(int roomNumber){
        Room.RoomNumber2 = roomNumber;
    }

    int getRoomNumber(){
        return Room.RoomNumber2;
    }
    void addRoom(){
        J.saveRoom();

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
     void assigner() {
         J.saveRoom();

    }
}