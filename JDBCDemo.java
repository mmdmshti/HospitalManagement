import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo {
    static List<Integer> Rooms = new ArrayList<>();




        private static final String URL = "jdbc:mysql://localhost:3306/project";
        private static final String USER = "root";
        private static final String PASSWORD = "138013831390";

            private Connection connect() throws SQLException {
                return DriverManager.getConnection(URL, USER, PASSWORD);
            }
            public void saveDoctor() {
                Doctor doctor = new Doctor();
                String query = "INSERT INTO Doctors (name, age, DocID) VALUES (?, ?, ?)";
                try (Connection conn = connect();
                     PreparedStatement pstmt = conn.prepareStatement(query)) {
                    pstmt.setString(1, doctor.getName() );
                    pstmt.setInt(2, doctor.getAge());
                    pstmt.setInt(3, doctor.generateID());
                    pstmt.executeUpdate();
                } catch (SQLException e) {
                    main.ShowList();
                }
            }
            void deleteDOC(int DocID){
                String query = "DELETE FROM Doctors WHERE DocID = ?";
                try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)){
                    pstmt.setInt(1,DocID );
                    pstmt.executeUpdate();
                    main.ShowList();
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }
    public void getAllDoctors() {
        String query = "SELECT * FROM Doctors";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                int DocID = rs.getInt("DocID");
                System.out.println("name: " + name + ", age: " + age + ", DocID: " + DocID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

            public void saveNurse() {
                Nurse nurse = new Nurse();
                String query = "INSERT INTO Nurses (name, age, NurseID) VALUES (?, ?, ?)";
                try (Connection conn = connect();
                     PreparedStatement pstmt = conn.prepareStatement(query)) {
                    pstmt.setString(1, nurse.getName());
                    pstmt.setInt(2, nurse.getAge());
                    pstmt.setInt(3, nurse.generateID());
                    pstmt.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            public void deleteNurse(int NurseID) {
                String query = "DELETE FROM Nurses WHERE NurseID = ?";
                try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)){
                    pstmt.setInt(1, NurseID);
                    pstmt.executeUpdate();
                    main.ShowList();
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }
    public void getAllNurses() {
        String query = "SELECT * FROM Doctors";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                int DocID = rs.getInt("NurseID");
                System.out.println("name: " + name + ", age: " + age + ", NurseID: " + DocID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void saveRoom() {
                Doctor doctor = new Doctor();
        Room room = new Room();
        String query = "INSERT INTO Rooms (RoomNumber, type) VALUES (? , ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1,doctor.generateID());
            pstmt.setString(2,room.getRoomType());
            RoomList();
            pstmt.executeUpdate();
        } catch (SQLException e) {
            main.ShowList();
        }
        main.ShowList();
    }
    public void RoomList(){
        String query = "SELECT * FROM Rooms";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int RN = rs.getInt("RoomNumber");
                Rooms.add(RN);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    void deleteRoom(int RoomNumber){
        String query = "DELETE FROM Rooms WHERE RoomNumber = ?";
        try (Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(query)){
            pstmt.setInt(1, RoomNumber);
            pstmt.executeUpdate();
            main.ShowList();
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    public void savePatient() {
        Patient patient = new Patient();
        String query = "INSERT INTO Patients(name, age, NationalCode, RoomNumber) VALUES (?, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, patient.getName());
            pstmt.setInt(2, patient.getAge());
            pstmt.setInt(3, patient.getNationalCode());
            pstmt.setInt(4, patient.getRoomNumber());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            main.ShowList();
        }

    }
    void deletePatient(int NationalCode){
        String query = "DELETE FROM Patients WHERE NationalCode = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)){
            pstmt.setInt(1, NationalCode);
            pstmt.executeUpdate();
            main.ShowList();
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }


    public void getAllPatients() {
        String query = "SELECT * FROM Patients";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                int NationalCode = rs.getInt("NationalCode");
                int RoomNumber = rs.getInt("RoomNumber");
                System.out.println("name: " + name + ", age: " + age + ", NationalCode: " + NationalCode + ", RoomNumber: " + RoomNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }




