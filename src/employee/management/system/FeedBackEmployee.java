
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FeedBackEmployee extends JFrame implements ActionListener {
    
    JButton submit, back;
    JTextField tffeedback, tfempname, tfempid;
    JComboBox cbeducation;
    
    FeedBackEmployee(){
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Feedback.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);
        
        JLabel heading = new JLabel("Employee 360 Degree Feedback Portal");
        heading.setBounds(530, 20, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 21));
        image.add(heading);
        
        JLabel labelEmpoloyeeID = new JLabel("Empolyee ID");
        labelEmpoloyeeID.setBounds(400, 100, 150, 30);
        labelEmpoloyeeID.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labelEmpoloyeeID);
        
        tfempid = new JTextField();
        tfempid.setBounds(520, 100, 150, 30);
        add(tfempid);
        
        JLabel labelEmpoloyeeName = new JLabel("Empolyee Name");
        labelEmpoloyeeName.setBounds(750, 100, 150, 30);
        labelEmpoloyeeName.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labelEmpoloyeeName);
        
        tfempname = new JTextField();
        tfempname.setBounds(900, 100, 150, 30);
        add(tfempname);
        
        JLabel labeleRating = new JLabel("Performance Rating");
        labeleRating.setBounds(750, 200, 150, 30);
        labeleRating.setFont(new Font("serif", Font.PLAIN, 20));
        image.add(labeleRating);
        
        String courses[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(900, 200, 150, 30);
        image.add(cbeducation);
        
        
        tffeedback = new JTextField();
        tffeedback.setBounds(520, 300, 400, 200);
        add(tffeedback);
        
        submit = new JButton("Submit FeedBack");
        submit.setBounds(510, 550, 150, 40);
        submit.addActionListener(this);
        image.add(submit);
        
        back = new JButton("Back");
        back.setBounds(800, 550, 150, 40);
        back.addActionListener(this);
        image.add(back);
        
        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit) {
            String FeedBack = tffeedback.getText();
            String empname = tfempname.getText();
            String empid = tfempid.getText();
            String Rating = (String) cbeducation.getSelectedItem();
            
             try {
                Conn conn = new Conn();
                String query = "insert into feedback values('"+empid+"', '"+empname+"', '"+FeedBack+"', '"+Rating+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            
        } else {
            setVisible(false);
            new Home();
        }
        
    }
    
    
    public static void main(String[] args){
        new FeedBackEmployee();
    }
    
}
