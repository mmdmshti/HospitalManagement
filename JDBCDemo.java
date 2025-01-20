import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo {
    static List<Room> Rooms = new ArrayList<>();
    static List<Doctor> doctors = new ArrayList<>();
    static List<Nurse> Nurses = new ArrayList<>();
    static List<Patient> Patients = new ArrayList<>();






        private static final String URL = "jdbc:mysql://localhost:3306/project";
        private static final String USER = "root";
        private static final String PASSWORD = "138013831390";

            private Connection connect() throws SQLException {
                return DriverManager.getConnection(URL, USER, PASSWORD);
            }

    public String checkAvailability() {
                Room room = new Room();
        String query = "SELECT RoomNumber FROM Rooms WHERE statue = ? AND RoomNumber = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, "true");
            pstmt.setInt(2, room.getRoomNumber());
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return "exists";
                } else {
                    return "does not exist";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "failed";
        }
    }




        public String checkDoctorExists() {
                Doctor doctor = new Doctor();
            String query = "SELECT DocID FROM Doctors WHERE DocID = ?";
            try (Connection conn = connect();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, doctor.getID());
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        return "exists";
                    } else {
                        return "does not exist";
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return "failed";
            }
        }
    public String checkNurseExists() {
        Nurse nurse = new Nurse();
        String query = "SELECT NurseID FROM Nurses WHERE NurseID = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, nurse.getID());
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return "exists";
                } else {
                    return "does not exist";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "failed";
        }
    }
    public String checkRoomExists() {
                Room room = new Room();
        String query = "SELECT RoomNumber FROM Rooms WHERE RoomNumber = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1,room.getRoomNumber() );
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return "exists";
                } else {
                    return "does not exist";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "failed";
        }
    }
    public String checkPatientExists() {
        Patient patient = new Patient();
        String query = "SELECT NationalCode FROM Patients WHERE NationalCode = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1,patient.getNationalCode());
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return "exists";
                } else {
                    return "does not exist";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "failed";
        }
    }






    public void saveDoctor() {
                Doctor doctor = new Doctor();
                HospitalManagementGUI UI = new HospitalManagementGUI();
                String query = "INSERT INTO Doctors (name, age, DocID) VALUES (?, ?, ?)";
                try (Connection conn = connect();
                     PreparedStatement pstmt = conn.prepareStatement(query)) {
                    pstmt.setString(1, doctor.getName());
                    pstmt.setInt(2, doctor.getAge());
                    pstmt.setInt(3, doctor.generateID());
                    pstmt.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            public void deleteDOC(){
                Doctor doctor = new Doctor();
                String query = "DELETE FROM Doctors WHERE DocID = ?";
                try (Connection conn = connect();
                     PreparedStatement pstmt = conn.prepareStatement(query)){
                    pstmt.setInt(1,doctor.getID() );
                    pstmt.executeUpdate();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
    public void updateDoctorName() {
                Doctor doctor = new Doctor();

        String query = "UPDATE Doctors SET name = ? WHERE DocID = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1,doctor.getName());
            pstmt.setInt(2, doctor.getID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Doctor> getAllDoctors() {
                doctors.clear();
        String query = "SELECT * FROM Doctors";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                int DocID = rs.getInt("DocID");
                doctors.add(new Doctor(name , age , DocID));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
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

            public void deleteNurse() {
                Nurse nurse = new Nurse();
                String query = "DELETE FROM Nurses WHERE NurseID = ?";
                try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)){
                    pstmt.setInt(1, nurse.getID());
                    pstmt.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }
    public void updateNurseName() {
                Nurse nurse = new Nurse();
        String query = "UPDATE Nurses SET name = ? WHERE NurseID = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nurse.getName());
            pstmt.setInt(2, nurse.getID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Nurse> getAllNurses() {
                Nurses.clear();
        String query = "SELECT * FROM Nurses";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                int NurseID = rs.getInt("NurseID");
                Nurses.add(new Nurse(name , age , NurseID));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Nurses;
    }

    //Room
    public Boolean saveRoom() {
                Room room = new Room();
        String query = "INSERT INTO Rooms (RoomNumber) VALUES (?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1,room.getRoomNumber());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    public List<Room> getAllRooms(){
        Rooms.clear();
        String query = "SELECT * FROM Rooms";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int RoomNumber = rs.getInt("RoomNumber");
                String statue = rs.getString("statue");
                Rooms.add(new Room(RoomNumber , statue));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Rooms;

            }

    void deleteRoom(){
                Room room = new Room();
        String query = "DELETE FROM Rooms WHERE RoomNumber = ?";
        try (Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(query)){
            pstmt.setInt(1, room.getRoomNumber());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    //Patient

    public String savePatient() {

        Patient patient = new Patient();
        Doctor doctor =new Doctor();
        Room room = new Room();
        String query = "INSERT INTO Patients(name, age, NationalCode, RoomNumber , DocID) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, patient.getName());
            pstmt.setInt(2, patient.getAge());
            pstmt.setInt(3, patient.getNationalCode());
            pstmt.setInt(4, room.getRoomNumber());
            pstmt.setInt(5, doctor.getID());
            pstmt.executeUpdate();
            return "true";
        } catch (SQLException e) {
            return e.getMessage();
        }

    }
    void deletePatient(){
                Patient patient = new Patient();
        String query = "DELETE FROM Patients WHERE NationalCode = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, patient.getNationalCode());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void updatePatientName(int NationalCode, String newName) {
        String query = "UPDATE Patients SET name = ? WHERE NationalCode = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, newName);
            pstmt.setInt(2, NationalCode);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updatePatientRoomNumber() {
                Room room = new Room();
                Patient patient = new Patient();
        String query = "UPDATE Patients SET RoomNumber = ? WHERE NationalCode = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, room.getRoomNumber());
            pstmt.setInt(2, patient.getNationalCode());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Patient> getAllPatients(){
        Patients.clear();
        String query = "SELECT * FROM Patients";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                int NationalCode = rs.getInt("NationalCode");
                int RoomNumber = rs.getInt("RoomNumber");
                int DocID = rs.getInt("DocID");
                Patients.add(new Patient(name , age , NationalCode , RoomNumber , DocID));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Patients;

    }
    public void updateRoomStatue(int RoomNumber) {
        String query = "UPDATE Rooms SET statue = ? WHERE RoomNumber = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1,"false" );
            pstmt.setInt(2,RoomNumber );
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateRoomStatue2(int RoomNumber) {
        String query = "UPDATE Rooms SET statue = ? WHERE RoomNumber = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1,"true" );
            pstmt.setInt(2,RoomNumber );
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    }






