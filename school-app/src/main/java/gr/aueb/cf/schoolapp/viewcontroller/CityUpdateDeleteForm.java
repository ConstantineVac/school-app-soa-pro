package gr.aueb.cf.schoolapp.viewcontroller;

import gr.aueb.cf.schoolapp.model.City;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CityUpdateDeleteForm extends JFrame {
    private JPanel contentPane;
    private JTextField idTxt;
    private JTextField nameTxt;
    private JTextField countryTxt;
    private JButton deleteBtn;
    private JButton updateBtn;
    private JButton nextBtn;
    private JButton previousBtn;

    private List<City> cities;
    private int listPosition;
    private int listSize;

    public CityUpdateDeleteForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel idLbl = new JLabel("Id");
        idLbl.setBounds(65, 35, 76, 14);
        contentPane.add(idLbl);

        idTxt = new JTextField();
        idTxt.setBounds(151, 32, 144, 20);
        contentPane.add(idTxt);
        idTxt.setColumns(10);

        JLabel nameLbl = new JLabel("Name");
        nameLbl.setBounds(65, 75, 76, 14);
        contentPane.add(nameLbl);

        nameTxt = new JTextField();
        nameTxt.setBounds(151, 72, 144, 20);
        contentPane.add(nameTxt);
        nameTxt.setColumns(10);


        deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(320, 160, 89, 23);
        contentPane.add(deleteBtn);

        updateBtn = new JButton("Update");
        updateBtn.setBounds(320, 194, 89, 23);
        contentPane.add(updateBtn);

        nextBtn = new JButton("Next");
        nextBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nextCity();
            }
        });
        nextBtn.setForeground(Color.BLUE);
        nextBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
        nextBtn.setBounds(310, 110, 100, 30);
        contentPane.add(nextBtn);

        previousBtn = new JButton("Previous");
        previousBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                previousCity();
            }
        });
        previousBtn.setForeground(Color.BLUE);
        previousBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
        previousBtn.setBounds(310, 70, 100, 30);
        contentPane.add(previousBtn);
    }

    private void nextCity() {
        if (listPosition < listSize - 1) {
            listPosition++;
            idTxt.setText(Integer.toString(cities.get(listPosition).getId()));
            nameTxt.setText(cities.get(listPosition).getName());

        }
    }

    private void previousCity() {
        if (listPosition > 0) {
            listPosition--;
            idTxt.setText(Integer.toString(cities.get(listPosition).getId()));
            nameTxt.setText(cities.get(listPosition).getName());
        }
    }
}
