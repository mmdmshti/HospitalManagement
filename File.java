import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class File {

    void DocSaver(String name , int age , int id){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\txt\\AP.txt" , true))){
            writer.write("Doctor: " + name + " age: "  + age +" id: " + id + " added" + "\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void DocDelete(int id){
        JDBCDemo j = new JDBCDemo();

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\txt\\AP.txt" , true))){
            for(Doctor d : j.getAllDoctors()){
                if(d.DocId == id){
                    writer.write("Doctor: " + d.name + " age: "  + d.age +" id: " + id + " Deleted" + "\n");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    void UpdateDoc(int id){
        JDBCDemo j = new JDBCDemo();

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\txt\\AP.txt" , true))){
            for(Doctor d : j.getAllDoctors()){
                if(d.DocId == id){
                    writer.write("Doctor with ID: " + d.DocId + " Renamed to --> " + d.name + "\n");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
