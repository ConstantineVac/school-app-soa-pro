//package gr.aueb.cf.schoolapp.viewcontroller;
//
//import gr.aueb.cf.schoolapp.dao.ITeacherDAO;
//import gr.aueb.cf.schoolapp.dao.TeacherDAOImpl;
//import gr.aueb.cf.schoolapp.dto.TeacherInsertDTO;
//import gr.aueb.cf.schoolapp.service.ITeacherService;
//import gr.aueb.cf.schoolapp.service.TeacherServiceImpl;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JLabel;
//import java.awt.Font;
//import java.awt.Color;
//import javax.swing.JTextField;
//import javax.swing.JButton;
//import javax.swing.JOptionPane;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class AdminInsertTeachersForm extends JFrame {
//    private static final long serialVersionUID = 123456;
//    private JPanel contentPane;
//    private JTextField firstnameTxt;
//    private JTextField lastnameTxt;
//    private JTextField ssnTxt;
//    private JTextField specialityIdTxt;
//    private JTextField userIdTxt;
//    private ITeacherService teacherService;
//
//    public AdminInsertTeachersForm() {
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setBounds(100, 100, 538, 468);
//        setLocationRelativeTo(null);
//        contentPane = new JPanel();
//        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//        setContentPane(contentPane);
//        contentPane.setLayout(null);
//
//        JLabel firstnameLbl = new JLabel("Όνομα");
//        firstnameLbl.setForeground(new Color(128, 0, 0));
//        firstnameLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
//        firstnameLbl.setBounds(68, 75, 56, 17);
//        contentPane.add(firstnameLbl);
//
//        firstnameTxt = new JTextField();
//        firstnameTxt.setBounds(129, 73, 207, 20);
//        contentPane.add(firstnameTxt);
//        firstnameTxt.setColumns(10);
//
//        JLabel lastnameLbl = new JLabel("Επώνυμο");
//        lastnameLbl.setForeground(new Color(128, 0, 0));
//        lastnameLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
//        lastnameLbl.setBounds(52, 135, 72, 17);
//        contentPane.add(lastnameLbl);
//
//        lastnameTxt = new JTextField();
//        lastnameTxt.setColumns(10);
//        lastnameTxt.setBounds(129, 133, 207, 20);
//        contentPane.add(lastnameTxt);
//
//        JLabel ssnLbl = new JLabel("ΑΜ Εκπαιδευτικού");
//        ssnLbl.setForeground(new Color(128, 0, 0));
//        ssnLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
//        ssnLbl.setBounds(25, 105, 130, 17);
//        contentPane.add(ssnLbl);
//
//        ssnTxt = new JTextField();
//        ssnTxt.setColumns(10);
//        ssnTxt.setBounds(160, 103, 207, 20);
//        contentPane.add(ssnTxt);
//
//        JLabel specialityIdLbl = new JLabel("Κωδικός Ειδικότητας");
//        specialityIdLbl.setForeground(new Color(128, 0, 0));
//        specialityIdLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
//        specialityIdLbl.setBounds(9, 165, 148, 17);
//        contentPane.add(specialityIdLbl);
//
//        specialityIdTxt = new JTextField();
//        specialityIdTxt.setColumns(10);
//        specialityIdTxt.setBounds(160, 163, 207, 20);
//        contentPane.add(specialityIdTxt);
//
//        JLabel userIdLbl = new JLabel("Κωδικός Χρήστη");
//        userIdLbl.setForeground(new Color(128, 0, 0));
//        userIdLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
//        userIdLbl.setBounds(37, 195, 120, 17);
//        contentPane.add(userIdLbl);
//
//        userIdTxt = new JTextField();
//        userIdTxt.setColumns(10);
//        userIdTxt.setBounds(160, 193, 207, 20);
//        contentPane.add(userIdTxt);
//
//        JButton insertBtn = new JButton("Εισαγωγή");
//        insertBtn.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                insertTeacher();
//            }
//        });
//        insertBtn.setForeground(new Color(0, 0, 255));
//        insertBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
//        insertBtn.setBounds(129, 235, 129, 41);
//        contentPane.add(insertBtn);
//
//        JButton closeBtn = new JButton("Κλείσιμο");
//        closeBtn.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                dispose();
//            }
//        });
//        closeBtn.setForeground(Color.BLUE);
//        closeBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
//        closeBtn.setBounds(266, 235, 129, 41);
//        contentPane.add(closeBtn);
//
//        ITeacherDAO dao = new TeacherDAOImpl();
//        teacherService = new TeacherServiceImpl(dao);
//    }
//
//    private void insertTeacher() {
//        String firstname = firstnameTxt.getText().trim();
//        String lastname = lastnameTxt.getText().trim();
//        int ssn = Integer.parseInt(ssnTxt.getText().trim());
//        int specialityId = Integer.parseInt(specialityIdTxt.getText().trim());
//        int userId = Integer.parseInt(userIdTxt.getText().trim());
//
//        if (firstname.isEmpty() || lastname.isEmpty() || ssnTxt.getText().trim().isEmpty() ||
//                specialityIdTxt.getText().trim().isEmpty() || userIdTxt.getText().trim().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//
//        TeacherInsertDTO dto = new TeacherInsertDTO();
//        dto.setFirstname(firstname);
//        dto.setLastname(lastname);
//        dto.setSsn(ssn);
//        dto.setSpecialityId(specialityId);
//        dto.setUserId(userId);
//
//        try {
//            teacherService.insertTeacher(dto);
//            JOptionPane.showMessageDialog(null, "Teacher inserted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error occurred during teacher insertion.", "Error", JOptionPane.ERROR_MESSAGE);
//            e.printStackTrace();
//        }
//    }
//}
package gr.aueb.cf.schoolapp.viewcontroller;

import gr.aueb.cf.schoolapp.Main;
import gr.aueb.cf.schoolapp.dao.ITeacherDAO;
import gr.aueb.cf.schoolapp.dao.TeacherDAOImpl;
import gr.aueb.cf.schoolapp.dto.TeacherInsertDTO;
import gr.aueb.cf.schoolapp.service.ITeacherService;
import gr.aueb.cf.schoolapp.service.TeacherServiceImpl;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminInsertTeachersForm extends JFrame {

    private static final long serialVersionUID = 123456;
    private JPanel contentPane;
    private JTextField firstnameTxt;
    private JTextField lastnameTxt;
    private JTextField ssnTxt;
    private JTextField specialityIdTxt;
    private JTextField userIdTxt;
    private ITeacherService teacherService;

    public AdminInsertTeachersForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 538, 468);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel firstnameLbl = new JLabel("Όνομα");
        firstnameLbl.setForeground(new Color(128, 0, 0));
        firstnameLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
        firstnameLbl.setBounds(68, 75, 56, 17);
        contentPane.add(firstnameLbl);

        firstnameTxt = new JTextField();
        firstnameTxt.setBounds(129, 73, 207, 20);
        contentPane.add(firstnameTxt);
        firstnameTxt.setColumns(10);

        JLabel lastnameLbl = new JLabel("Επώνυμο");
        lastnameLbl.setForeground(new Color(128, 0, 0));
        lastnameLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
        lastnameLbl.setBounds(52, 135, 72, 17);
        contentPane.add(lastnameLbl);

        lastnameTxt = new JTextField();
        lastnameTxt.setColumns(10);
        lastnameTxt.setBounds(129, 133, 207, 20);
        contentPane.add(lastnameTxt);

        JLabel ssnLbl = new JLabel("ΑΜ Εκπαιδευτικού");
        ssnLbl.setForeground(new Color(128, 0, 0));
        ssnLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
        ssnLbl.setBounds(25, 105, 130, 17);
        contentPane.add(ssnLbl);

        ssnTxt = new JTextField();
        ssnTxt.setColumns(10);
        ssnTxt.setBounds(160, 103, 207, 20);
        contentPane.add(ssnTxt);

        JLabel specialityIdLbl = new JLabel("Κωδικός Ειδικότητας");
        specialityIdLbl.setForeground(new Color(128, 0, 0));
        specialityIdLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
        specialityIdLbl.setBounds(9, 165, 148, 17);
        contentPane.add(specialityIdLbl);

        specialityIdTxt = new JTextField();
        specialityIdTxt.setColumns(10);
        specialityIdTxt.setBounds(160, 163, 207, 20);
        contentPane.add(specialityIdTxt);

        JLabel userIdLbl = new JLabel("Κωδικός Χρήστη");
        userIdLbl.setForeground(new Color(128, 0, 0));
        userIdLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
        userIdLbl.setBounds(37, 195, 120, 17);
        contentPane.add(userIdLbl);

        userIdTxt = new JTextField();
        userIdTxt.setColumns(10);
        userIdTxt.setBounds(160, 193, 207, 20);
        contentPane.add(userIdTxt);

        JButton insertBtn = new JButton("Εισαγωγή");
        insertBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insertTeacher();
                Main.getAdminMenu().setVisible(true);
                AdminInsertTeachersForm.this.dispose();
            }
        });
        insertBtn.setForeground(new Color(0, 0, 255));
        insertBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
        insertBtn.setBounds(129, 235, 129, 41);
        contentPane.add(insertBtn);

        JButton closeBtn = new JButton("Κλείσιμο");
        closeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        closeBtn.setForeground(Color.BLUE);
        closeBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
        closeBtn.setBounds(266, 235, 129, 41);
        contentPane.add(closeBtn);

        ITeacherDAO dao = new TeacherDAOImpl();
        teacherService = new TeacherServiceImpl(dao);
    }


    private void insertTeacher() {
        String firstname = firstnameTxt.getText().trim();
        String lastname = lastnameTxt.getText().trim();
        int ssn = Integer.parseInt(ssnTxt.getText().trim());
        int specialityId = Integer.parseInt(specialityIdTxt.getText().trim());
        int userId = Integer.parseInt(userIdTxt.getText().trim());

        if (firstname.isEmpty() || lastname.isEmpty() || ssnTxt.getText().trim().isEmpty() ||
                specialityIdTxt.getText().trim().isEmpty() || userIdTxt.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        TeacherInsertDTO dto = new TeacherInsertDTO();
        dto.setFirstname(firstname);
        dto.setLastname(lastname);
        dto.setSsn(ssn);
        dto.setSpecialityId(specialityId);
        dto.setUserId(userId);

        try {
            teacherService.insertTeacher(dto);
            JOptionPane.showMessageDialog(null, "Teacher inserted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error occurred during teacher insertion.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}