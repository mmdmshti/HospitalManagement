import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class HospitalManagementGUI {
    private JFrame frame;
    private  JTextField textFieldId;
    private  JTextField textFieldName;
    private  JTextField textFieldAge;
    static String name;
    static int age;
    static String name1;
    static int id1;
    static int id;

    public HospitalManagementGUI() {
        frame = new JFrame("list");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLayout(null);


        JLabel label = new JLabel("choose: ");
        label.setBounds(50 , 20 , 100 , 30);
        frame.add(label);

        String[] actions = {"Save", "Update", "Delete"};
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
                name = textFieldName.getText();
                age = Integer.parseInt(textFieldAge.getText());
                j.saveDoctor();
                JOptionPane.showMessageDialog(frame, "Doctor saved successfully.");
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
                id1 = Integer.parseInt(textFieldId.getText());
                name1 = textFieldName.getText();
                j2.updateDoctorName();
                JOptionPane.showMessageDialog(frame, "Doctor's name updated successfully.");
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
                id = Integer.parseInt(textFieldId.getText());
                j3.deleteDOC();
                JOptionPane.showMessageDialog(frame, "Doctor has been deleted successfully.");
            }
        });
        frame.setVisible(true);

    }
}




