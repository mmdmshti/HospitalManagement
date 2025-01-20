import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class HospitalManagementGUI {
    private JFrame frame;
    private  JTextField textFieldId;
    private  JTextField textFieldName;
    private  JTextField textFieldAge;

    public HospitalManagementGUI(){
        frame = new JFrame("list");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLayout(null);


        JLabel label = new JLabel("choose: ");
        label.setBounds(50 , 20 , 100 , 30);
        frame.add(label);

        String[] actions = {"Doctor", "Nurse", "Patient", "Room"};
        JComboBox<String> comboBox = new JComboBox<>(actions);
        comboBox.setBounds(150, 20, 150, 30);
        frame.add(comboBox);

        JButton SubmitButton = new JButton("Choose");
        SubmitButton.setBounds(150,220,80,30);
        frame.add(SubmitButton);

        SubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) comboBox.getSelectedItem();

                switch (Objects.requireNonNull(selected)) {
                    case "Doctor":
                        Doctor();
                        break;
                    case "Nurse":
                        Nurse();
                        break;
                    case "Patient":
                        Delete();
                        break;
                    case "Room":
                        Room();
                        break;


                }
            }
        });

        frame.setVisible(true);



    }
    public void Doctor() {
        frame = new JFrame("list");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLayout(null);


        JLabel label = new JLabel("choose: ");
        label.setBounds(50 , 20 , 100 , 30);
        frame.add(label);

        String[] actions = {"Save", "Update", "Delete", "ShowAll"};
        JComboBox<String> comboBox = new JComboBox<>(actions);
        comboBox.setBounds(150, 20, 150, 30);
        frame.add(comboBox);

        JButton SubmitButton = new JButton("Choose");
        SubmitButton.setBounds(150,220,80,30);
        frame.add(SubmitButton);

        SubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) comboBox.getSelectedItem();

                switch (Objects.requireNonNull(selected)) {
                    case "Save":
                        Save();
                        break;
                    case "Update":
                        Update();
                        break;
                    case "Delete":
                        Delete();
                        break;
                    case "ShowAll":
                        ShowAll();
                        break;


                }
            }
        });

        frame.setVisible(true);







    }

    public void Save() {
        JDBCDemo j = new JDBCDemo();
        frame = new JFrame("SAVE");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLayout(null);


        JLabel labelName = new JLabel("Name:");
        labelName.setBounds(50, 100, 100, 30);
        frame.add(labelName);

        textFieldName = new JTextField();
        textFieldName.setBounds(150, 100, 150, 30);
        frame.add(textFieldName);

        JLabel labelAge = new JLabel("age:");
        labelAge.setBounds(50, 150, 100, 30);
        frame.add(labelAge);

        textFieldAge = new JTextField();
        textFieldAge.setBounds(150, 150, 150, 30);
        frame.add(textFieldAge);

        JButton buttonSave = new JButton("Save");
        buttonSave.setBounds(50, 200, 80, 30);
        frame.add(buttonSave);

        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Doctor doctor = new Doctor();
                    doctor.setName(textFieldName.getText());
                    doctor.setAge(Integer.parseInt(textFieldAge.getText()));
                    j.saveDoctor();
                    JOptionPane.showMessageDialog(frame, "Doctor saved successfully.");
                }catch (Exception a){
                    JOptionPane.showMessageDialog(frame, a.getMessage());

                }
            }
        });

        frame.setVisible(true);

    }
    public void Update(){
        JDBCDemo j2 = new JDBCDemo();

        frame =  new JFrame("UPDATE");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

        JLabel labelId = new JLabel("ID:");
        labelId.setBounds(50, 50, 100, 30);
        frame.add(labelId);

        textFieldId = new JTextField();
        textFieldId.setBounds(150, 50, 150, 30);
        frame.add(textFieldId);

        JLabel labelAge = new JLabel("name");
        labelAge.setBounds(50, 100, 100, 30);
        frame.add(labelAge);

        textFieldName = new JTextField();
        textFieldName.setBounds(150, 100, 150, 30);
        frame.add(textFieldName);

        JButton buttonUpdate = new JButton("Update");
        buttonUpdate.setBounds(150, 200, 80, 30);
        frame.add(buttonUpdate);


        buttonUpdate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Doctor doctor = new Doctor();
                    doctor.setID(Integer.parseInt(textFieldId.getText()));
                    doctor.setName(textFieldName.getText());
                    String result = j2.checkDoctorExists();
                    if(result.contains("exists")) {
                        j2.updateDoctorName();
                        JOptionPane.showMessageDialog(frame, "Doctor has been updated successfully.");
                    }
                    else {
                        JOptionPane.showMessageDialog(frame, "Doctor not found");
                    }
                }catch (Exception a){
                    JOptionPane.showMessageDialog(frame, a.getMessage());
                }
            }
        });
        frame.setVisible(true);

    }

    void Delete(){
        JDBCDemo j3 = new JDBCDemo();
        frame =  new JFrame("DELETE");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

        JLabel labelId = new JLabel("ID:");
        labelId.setBounds(50, 50, 100, 30);
        frame.add(labelId);

        textFieldId = new JTextField();
        textFieldId.setBounds(150, 50, 150, 30);
        frame.add(textFieldId);


        JButton buttonDelete = new JButton("DELETE");
        buttonDelete.setBounds(150, 200, 80, 30);
        frame.add(buttonDelete);


        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Doctor doctor = new Doctor();
                    doctor.setID(Integer.parseInt(textFieldId.getText()));
                    String result = j3.checkDoctorExists();
                    if(result.contains("exists")) {
                        j3.deleteDOC();
                        JOptionPane.showMessageDialog(frame, "Doctor has been deleted successfully.");
                    }
                    else {
                        JOptionPane.showMessageDialog(frame, "Doctor not found");
                    }
                }catch (Exception a){
                    JOptionPane.showMessageDialog(frame, a.getMessage());
                }
            }
        });
        frame.setVisible(true);

    }
    void ShowAll(){
        List<Doctor> Docs;
        JDBCDemo J = new JDBCDemo();
        JFrame frame = new JFrame("Show");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout()); String[] columnNames = {"name", "age", "DocID"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        model.setRowCount(0);
        Docs = J.getAllDoctors();
        for (Doctor doctor : Docs) {
            Object[] row = {doctor.name, doctor.age, doctor.DocId};
            model.addRow(row);
        }



        frame.setVisible(true);
    }
    public void Nurse() {
        frame = new JFrame("list");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLayout(null);


        JLabel label = new JLabel("choose: ");
        label.setBounds(50 , 20 , 100 , 30);
        frame.add(label);

        String[] actions = {"Save", "Update", "Delete", "ShowAll"};
        JComboBox<String> comboBox = new JComboBox<>(actions);
        comboBox.setBounds(150, 20, 150, 30);
        frame.add(comboBox);

        JButton SubmitButton = new JButton("Choose");
        SubmitButton.setBounds(150,220,80,30);
        frame.add(SubmitButton);

        SubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) comboBox.getSelectedItem();

                switch (Objects.requireNonNull(selected)) {
                    case "Save":
                        NSave();
                        break;
                    case "Update":
                        NUpdate();
                        break;
                    case "Delete":
                        NDelete();
                        break;
                    case "ShowAll":
                        NShowAll();
                        break;


                }
            }
        });

        frame.setVisible(true);







    }

    public void NSave() {
        JDBCDemo j = new JDBCDemo();
        frame = new JFrame("SAVE");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLayout(null);


        JLabel labelName = new JLabel("Name:");
        labelName.setBounds(50, 100, 100, 30);
        frame.add(labelName);

        textFieldName = new JTextField();
        textFieldName.setBounds(150, 100, 150, 30);
        frame.add(textFieldName);

        JLabel labelAge = new JLabel("age:");
        labelAge.setBounds(50, 150, 100, 30);
        frame.add(labelAge);

        textFieldAge = new JTextField();
        textFieldAge.setBounds(150, 150, 150, 30);
        frame.add(textFieldAge);

        JButton buttonSave = new JButton("Save");
        buttonSave.setBounds(50, 200, 80, 30);
        frame.add(buttonSave);

        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Nurse nurse = new Nurse();
                    nurse.setName(textFieldName.getText());
                    nurse.setAge(Integer.parseInt(textFieldAge.getText()));
                    j.saveNurse();
                    JOptionPane.showMessageDialog(frame, "Nurse saved successfully.");
                }catch (Exception a){
                    JOptionPane.showMessageDialog(frame, a.getMessage());

                }
            }
        });

        frame.setVisible(true);

    }
    public void NUpdate(){
        JDBCDemo j2 = new JDBCDemo();

        frame =  new JFrame("UPDATE");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

        JLabel labelId = new JLabel("ID:");
        labelId.setBounds(50, 50, 100, 30);
        frame.add(labelId);

        textFieldId = new JTextField();
        textFieldId.setBounds(150, 50, 150, 30);
        frame.add(textFieldId);

        JLabel labelAge = new JLabel("name");
        labelAge.setBounds(50, 100, 100, 30);
        frame.add(labelAge);

        textFieldName = new JTextField();
        textFieldName.setBounds(150, 100, 150, 30);
        frame.add(textFieldName);

        JButton buttonUpdate = new JButton("Update");
        buttonUpdate.setBounds(150, 200, 80, 30);
        frame.add(buttonUpdate);


        buttonUpdate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Nurse nurse = new Nurse();
                    nurse.setID(Integer.parseInt(textFieldId.getText()));
                    nurse.setName(textFieldName.getText());
                    String result = j2.checkNurseExists();
                    if(result.contains("exists")) {
                        j2.updateNurseName();
                        JOptionPane.showMessageDialog(frame, "Nurse's name updated successfully.");
                    }else{
                        JOptionPane.showMessageDialog(frame, "Nurse not found");
                    }
                }catch (Exception a){
                    JOptionPane.showMessageDialog(frame, a.getMessage());
                }
            }
        });
        frame.setVisible(true);

    }

    void NDelete(){
        JDBCDemo j3 = new JDBCDemo();
        frame =  new JFrame("DELETE");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

        JLabel labelId = new JLabel("ID:");
        labelId.setBounds(50, 50, 100, 30);
        frame.add(labelId);

        textFieldId = new JTextField();
        textFieldId.setBounds(150, 50, 150, 30);
        frame.add(textFieldId);


        JButton buttonDelete = new JButton("DELETE");
        buttonDelete.setBounds(150, 200, 80, 30);
        frame.add(buttonDelete);


        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Nurse nurse = new Nurse();
                    nurse.setID(Integer.parseInt(textFieldId.getText()));
                    String result = j3.checkNurseExists();
                    if(result.contains("exists")) {
                        j3.deleteNurse();
                        JOptionPane.showMessageDialog(frame, "Nurse has been deleted successfully.");
                    }
                    else {
                        JOptionPane.showMessageDialog(frame, "Nurse not found");
                    }
                }catch (Exception a){
                    JOptionPane.showMessageDialog(frame, a.getMessage());
                }
            }
        });
        frame.setVisible(true);

    }
    void NShowAll(){
        List<Nurse> Nurses;
        JDBCDemo J = new JDBCDemo();
        JFrame frame = new JFrame("Show");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout()); String[] columnNames = {"name", "age", "DocID"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        model.setRowCount(0);
        Nurses = J.getAllNurses();
        for (Nurse Nurse : Nurses) {
            Object[] row = {Nurse.name, Nurse.age, Nurse.NurseId};
            model.addRow(row);
        }
        frame.setVisible(true);
    }




    public void Room() {
        frame = new JFrame("list");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLayout(null);


        JLabel label = new JLabel("choose: ");
        label.setBounds(50 , 20 , 100 , 30);
        frame.add(label);

        String[] actions = {"Save", "Delete", "ShowAll"};
        JComboBox<String> comboBox = new JComboBox<>(actions);
        comboBox.setBounds(150, 20, 150, 30);
        frame.add(comboBox);

        JButton SubmitButton = new JButton("Choose");
        SubmitButton.setBounds(150,220,80,30);
        frame.add(SubmitButton);

        SubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) comboBox.getSelectedItem();

                switch (Objects.requireNonNull(selected)) {
                    case "Save":
                        RSave();
                        break;
                    case "Delete":
                        RDelete();
                        break;
                    case "ShowAll":
                        RShowAll();
                        break;


                }
            }
        });

        frame.setVisible(true);







    }

    public void RSave() {
        JDBCDemo j = new JDBCDemo();
        frame = new JFrame("SAVE");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLayout(null);


        JLabel labelRN = new JLabel("RoomNumber:");
        labelRN.setBounds(50, 100, 100, 30);
        frame.add(labelRN);

        JTextField textFieldRN = new JTextField();
        textFieldRN.setBounds(150, 100, 150, 30);
        frame.add(textFieldRN);


        JButton buttonSave = new JButton("Save");
        buttonSave.setBounds(50, 200, 80, 30);
        frame.add(buttonSave);

        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Room room = new Room();
                    room.setRoomNumber(Integer.parseInt(textFieldRN.getText()));
                    if(j.saveRoom()) {
                        JOptionPane.showMessageDialog(frame, "Room saved successfully");
                    }else {
                        JOptionPane.showMessageDialog(frame, "Duplicate entry " + room.getRoomNumber()+ "!!");
                    }
                } catch (Exception a) {
                    JOptionPane.showMessageDialog(frame, a.getMessage());

                }
            }
        });

        frame.setVisible(true);

    }

    void RDelete(){
        JDBCDemo j3 = new JDBCDemo();
        frame =  new JFrame("DELETE");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

        JLabel labelId = new JLabel("RoomNumber:");
        labelId.setBounds(50, 50, 100, 30);
        frame.add(labelId);

        textFieldId = new JTextField();
        textFieldId.setBounds(150, 50, 150, 30);
        frame.add(textFieldId);


        JButton buttonDelete = new JButton("DELETE");
        buttonDelete.setBounds(150, 200, 80, 30);
        frame.add(buttonDelete);


        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Room room = new Room();
                    room.setRoomNumber(Integer.parseInt(textFieldId.getText()));
                    String result = j3.checkRoomExists();
                    if(result.contains("exists")) {
                        j3.deleteRoom();
                        JOptionPane.showMessageDialog(frame, "Room has been deleted successfully.");
                    }
                    else {
                        JOptionPane.showMessageDialog(frame, "Room not found");
                    }
                }catch (Exception a){
                    JOptionPane.showMessageDialog(frame, a.getMessage());
                }
            }
        });
        frame.setVisible(true);

    }
    void RShowAll(){
        List<Room> Rooms;
        JDBCDemo J = new JDBCDemo();
        JFrame frame = new JFrame("Show");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout()); String[] columnNames = {"RoomNumber" , "statue"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        model.setRowCount(0);
        Rooms = J.getAllRooms();
        for (Room R : Rooms) {
            Object[] row = {R.RoomNumber, R.Statue};
            model.addRow(row);
        }
        frame.setVisible(true);
    }


}




