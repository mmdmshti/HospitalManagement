import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Room {
    JDBCDemo J = new JDBCDemo();
    Scanner input = new Scanner(System.in);
    static List<Room> Rooms = new ArrayList<>();
    int RoomNumber;
    String RoomType;

    public Room(){};
    public Room(int roomNumber, String roomType) {
        this.RoomNumber = roomNumber;
        this.RoomType = roomType;

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