import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class FirstRecordDisplay extends JFrame implements ActionListener {
    // UI Components
    JTextField txtRno, txtSname, txtPer;
    JButton btnFetch;
    JLabel lblRno, lblSname, lblPer;

    public FirstRecordDisplay() {
        // Setup Frame
        setTitle("Student Record Fetcher");
        setSize(300, 250);
        setLayout(new GridLayout(4, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize Components
        lblRno = new JLabel(" Roll No:");
        txtRno = new JTextField();
        
        lblSname = new JLabel(" Student Name:");
        txtSname = new JTextField();
        
        lblPer = new JLabel(" Percentage:");
        txtPer = new JTextField();
        
        btnFetch = new JButton("Fetch First Record");
        btnFetch.addActionListener(this);

        // Add to Frame
        add(lblRno);   add(txtRno);
        add(lblSname); add(txtSname);
        add(lblPer);   add(txtPer);
        add(new JLabel("")); // Empty spacer
        add(btnFetch);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Database Connection Details
        String url = "jdbc:mysql://localhost:3306/your_db_name";
        String user = "root";
        String password = "your_password";

        // SQL Query to get the first record based on Roll Number
        String query = "SELECT rno, sname, per FROM student ORDER BY rno LIMIT 1";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                // Set data into TextFields
                txtRno.setText(String.valueOf(rs.getInt("rno")));
                txtSname.setText(rs.getString("sname"));
                txtPer.setText(String.valueOf(rs.getDouble("per")));
            } else {
                JOptionPane.showMessageDialog(this, "No records found in table!");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FirstRecordDisplay();
    }
}

/*CREATE TABLE student (rno INT, sname VARCHAR(50), per DOUBLE);
INSERT INTO student VALUES (1, 'John Doe', 85.5);
Run: Compile with javac FirstRecordDisplay.java and run with java FirstRecordDisplay*/
