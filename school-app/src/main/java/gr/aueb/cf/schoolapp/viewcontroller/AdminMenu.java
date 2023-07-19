package gr.aueb.cf.schoolapp.viewcontroller;

import gr.aueb.cf.schoolapp.Main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMenu extends JFrame {
    private static final long serialVersionUID = 123456;
    private JPanel contentPane;

    public AdminMenu() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(AdminMenu.class.getResource("/resources/eduv2.png")));
        setTitle("Admin Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 410, 505);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              //  Main.getAdminInsertTeachersForm().setVisible(true);
                Main.getTeachersMenu().setVisible(true);
                //Main.getAdminMenu().setEnabled(false);
                Main.getTeachersUpdateDeleteForm().setVisible(false);
            }
        });
        btnNewButton.setBounds(32, 67, 40, 40);
        contentPane.add(btnNewButton);

        JLabel lblNewLabel = new JLabel("Εκπαιδευτές");
        lblNewLabel.setForeground(new Color(128, 64, 0));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel.setBounds(82, 73, 86, 29);
        contentPane.add(lblNewLabel);

        JButton btnCityManagement = new JButton("");
        btnCityManagement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.getAdminInsertCitiesForm().setVisible(true);
                Main.getAdminMenu().setEnabled(false);
            }
        });
        btnCityManagement.setBounds(32, 124, 40, 40);
        contentPane.add(btnCityManagement);

        JLabel lblCityManagement = new JLabel("Πόλεις");
        lblCityManagement.setForeground(new Color(128, 64, 0));
        lblCityManagement.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCityManagement.setBounds(82, 130, 86, 29);
        contentPane.add(lblCityManagement);

        JButton btnStudent = new JButton("");
        btnStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Student form visibility code here
            }
        });
        btnStudent.setBounds(32, 181, 40, 40);
        contentPane.add(btnStudent);

        JLabel lblStudent = new JLabel("Εκπαιδευόμενοι");
        lblStudent.setForeground(new Color(128, 64, 0));
        lblStudent.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblStudent.setBounds(82, 187, 117, 29);
        contentPane.add(lblStudent);

        JButton btnNewButton_1_1 = new JButton("");
        btnNewButton_1_1.setBounds(32, 238, 40, 40);
        contentPane.add(btnNewButton_1_1);

        JLabel lblNewLabel_1_1 = new JLabel("Χρήστες");
        lblNewLabel_1_1.setForeground(new Color(128, 64, 0));
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1.setBounds(82, 244, 70, 29);
        contentPane.add(lblNewLabel_1_1);

        JButton btnNewButton_1_1_1_1 = new JButton("");
        btnNewButton_1_1_1_1.setBounds(32, 295, 40, 40);
        contentPane.add(btnNewButton_1_1_1_1);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("Ειδικότητες");
        lblNewLabel_1_1_1_1.setForeground(new Color(128, 64, 0));
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1_1_1.setBounds(82, 301, 86, 29);
        contentPane.add(lblNewLabel_1_1_1_1);

        JSeparator separator = new JSeparator();
        separator.setBounds(32, 388, 270, 1);
        contentPane.add(separator);

        JButton btnNewButton_2 = new JButton("Close App");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnNewButton_2.setForeground(new Color(0, 0, 255));
        btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnNewButton_2.setBounds(204, 417, 103, 40);
        contentPane.add(btnNewButton_2);

        JButton btnNewButton_4 = new JButton("");
        btnNewButton_4.setBounds(32, 11, 40, 40);
        contentPane.add(btnNewButton_4);

        JLabel lblNewLabel_2 = new JLabel("Συναντήσεις");
        lblNewLabel_2.setForeground(new Color(128, 64, 0));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2.setBounds(82, 17, 86, 29);
        contentPane.add(lblNewLabel_2);
    }
}





