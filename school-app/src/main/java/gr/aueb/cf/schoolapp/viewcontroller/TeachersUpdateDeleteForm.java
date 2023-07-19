//package gr.aueb.cf.schoolapp.viewcontroller;
//
//import gr.aueb.cf.schoolapp.Main;
//import gr.aueb.cf.schoolapp.dao.ITeacherDAO;
//import gr.aueb.cf.schoolapp.dao.TeacherDAOImpl;
//import gr.aueb.cf.schoolapp.dao.exceptions.TeacherDAOException;
//import gr.aueb.cf.schoolapp.dto.TeacherUpdateDTO;
//import gr.aueb.cf.schoolapp.model.Teacher;
//import gr.aueb.cf.schoolapp.service.ITeacherService;
//import gr.aueb.cf.schoolapp.service.TeacherServiceImpl;
//import gr.aueb.cf.schoolapp.service.exceptions.TeacherNotFoundException;
//
//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import java.net.URL;
//import java.util.List;
//import java.util.Objects;
//
//public class TeachersUpdateDeleteForm extends JFrame {
//	private JPanel contentPane;
//	private JTextField idTxt;
//	private JTextField firstnameTxt;
//	private JTextField lastnameTxt;
//
//	private JTextField cityTxt;
//
//	private JTextField specialityTxt;
//	private JButton deleteBtn;
//	private JButton updateBtn;
//	private JButton nextBtn;
//	private JButton previousBtn;
//
//	ITeacherDAO dao = new TeacherDAOImpl();
//	ITeacherService teacherService = new TeacherServiceImpl(dao);
//
//	private List<Teacher> teachers;
//	private int listPosition;
//	private int listSize;
//
//	public TeachersUpdateDeleteForm() {
//		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//		URL url = classLoader.getResource("eduv2.png");
//		setIconImage(Toolkit.getDefaultToolkit().getImage(url));
//
//		addWindowListener(new WindowAdapter() {
//			public void windowActivated(WindowEvent e) {
//				setTitle("Ενημέρωση/Απαλοιφή");
//				try {
//					teachers = teacherService.getTeachersByLastname(Main.getTeacherSearchForm().getLastname());
//
//					listSize = teachers.size();
//					if (listSize == 0) {																					// Issues Not Able to fix yet
//						JOptionPane.showMessageDialog(null, "No Teachers Found", "Info", JOptionPane.ERROR_MESSAGE);
//						Main.getTeacherSearchForm().setEnabled(true);
//						Main.getTeachersUpdateDeleteForm().setVisible(false);
//						return;
//					}
//					int listPosition = 0;
//					idTxt.setText(Integer.toString(teachers.get(listPosition).getId()));
//					firstnameTxt.setText(teachers.get(listPosition).getFirstname());
//					lastnameTxt.setText(teachers.get(listPosition).getLastname());
//				} catch (TeacherDAOException e1) {
//					String message = e1.getMessage();
//					JOptionPane.showMessageDialog(null, message, "Error in getting teachers", JOptionPane.ERROR_MESSAGE);
//				}
//			}
//		});
//
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setLocationRelativeTo(null);
//
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//
//		JLabel idLbl = new JLabel("ID");
//		idLbl.setBounds(65, 35, 76, 14);
//		contentPane.add(idLbl);
//
//		idTxt = new JTextField();
//		idTxt.setForeground(new Color(128, 0, 0));
//		idTxt.setFont(new Font("Tahoma", Font.BOLD, 14));
//		idTxt.setBounds(151, 32, 144, 20);
//		contentPane.add(idTxt);
//		idTxt.setColumns(10);
//
//		JLabel nameLbl = new JLabel("Firstname");
//		nameLbl.setBounds(65, 75, 76, 14);
//		contentPane.add(nameLbl);
//
//		firstnameTxt = new JTextField();
//		firstnameTxt.setBounds(151, 72, 144, 20);
//		contentPane.add(firstnameTxt);
//		firstnameTxt.setColumns(10);
//
//
//		JLabel lastnameLbl = new JLabel("Lastname");
//		lastnameLbl.setBounds(65, 102, 76, 14);
//		contentPane.add(lastnameLbl);
//
//		lastnameTxt = new JTextField();
//		lastnameTxt.setBounds(151, 102, 144, 20);
//		contentPane.add(lastnameTxt);
//		lastnameTxt.setColumns(10);
//
//
//		JLabel cityLbl = new JLabel("City");
//		cityLbl.setBounds(65, 132, 76, 14);
//		contentPane.add(cityLbl);
//
//		cityTxt = new JTextField();
//		cityTxt.setBounds(151, 132, 144, 20);
//		contentPane.add(cityTxt);
//		cityTxt.setColumns(10);
//
//		JLabel specialityLbl = new JLabel("Speciality");
//		specialityLbl.setBounds(65, 162, 76, 14);
//		contentPane.add(specialityLbl);
//
//		specialityTxt = new JTextField();
//		specialityTxt.setBounds(151, 162, 144, 20);
//		contentPane.add(specialityTxt);
//		specialityTxt.setColumns(10);
//
//
//		JButton deleteBtn = new JButton("Delete");
//		deleteBtn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					int response;
//					String idStr = idTxt.getText();
//					int id = Integer.parseInt(idStr);
//
//					response = JOptionPane.showConfirmDialog (null, "Είστε σίγουρος;",
//							"Warning", JOptionPane.YES_NO_OPTION);
//
//					if (response == JOptionPane.YES_OPTION){
//						teacherService.deleteTeacher(id);
//						JOptionPane.showMessageDialog (null, "Teacher was deleted successfully",
//								"DELETE", JOptionPane.INFORMATION_MESSAGE);
//					}
//				} catch (TeacherDAOException | TeacherNotFoundException e1) {
//					String message = e1.getMessage();
//					JOptionPane.showMessageDialog (null, message, "DELETE", JOptionPane.ERROR_MESSAGE);
//				}
//			}
//		});
//		deleteBtn.setForeground(Color.BLUE);
//		deleteBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
//		deleteBtn.setBounds(320, 160, 89, 23);
//		contentPane.add(deleteBtn);
//
//		JButton updateBtn = new JButton("Update");
//		updateBtn.setForeground(new Color(0, 0, 255));
//		updateBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
//		updateBtn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String id = idTxt.getText().trim();
//				String lastname = lastnameTxt.getText().trim();
//				String firstname = firstnameTxt.getText().trim();
//
//				if (lastname.equals("") || firstname.equals("") || id.equals("")) {
//					JOptionPane.showMessageDialog(null, "Not valid input", "UPDATE ERROR", JOptionPane.ERROR_MESSAGE);
//					return;
//				}
//
//				try {
//					TeacherUpdateDTO teacherDTO = new TeacherUpdateDTO();
//					teacherDTO.setId(Integer.parseInt(id));
//					teacherDTO.setFirstname(firstname);
//					teacherDTO.setLastname(lastname);
//
//					Teacher teacher = teacherService.updateTeacher(teacherDTO);
//					JOptionPane.showMessageDialog(null, "Teacher with id " + teacher.getId()
//							+ " was updated", "UPDATE", JOptionPane.PLAIN_MESSAGE);
//				} catch (TeacherDAOException | TeacherNotFoundException e1) {
//					String message = e1.getMessage();
//					JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
//				}
//			}
//		});
//		updateBtn.setBounds(320, 194, 89, 23);
//		contentPane.add(updateBtn);
//
//		nextBtn = new JButton("");
//		nextBtn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (listPosition <= listSize - 2) {
//					listPosition++;
//					idTxt.setText(String.format("%s", teachers.get(listPosition).getId()));
//					lastnameTxt.setText(teachers.get(listPosition).getLastname());
//					firstnameTxt.setText(teachers.get(listPosition).getFirstname());
//				}
//			}
//		});
//		nextBtn.setForeground(Color.BLUE);
//		nextBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
//		nextBtn.setIcon(new ImageIcon(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("Next_track.png"))));
//		nextBtn.setBounds(310, 110, 100, 30);
//		contentPane.add(nextBtn);
//
//		previousBtn = new JButton("");
//		previousBtn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (listPosition > 0) {
//					listPosition--;
//					idTxt.setText(String.format("%s", teachers.get(listPosition).getId()));
//					lastnameTxt.setText(teachers.get(listPosition).getLastname());
//					firstnameTxt.setText(teachers.get(listPosition).getFirstname());
//				}
//			}
//		});
//		previousBtn.setForeground(Color.BLUE);
//		previousBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
//		previousBtn.setIcon(new ImageIcon(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("Previous_record.png"))));
//		previousBtn.setBounds(310, 70, 100, 30);
//		contentPane.add(previousBtn);
//	}
//
//	private void nextTeacher() {
//		if (listPosition < listSize - 1) {
//			listPosition++;
//			idTxt.setText(Integer.toString(teachers.get(listPosition).getId()));
//			firstnameTxt.setText(teachers.get(listPosition).getLastname());
//		}
//	}
//
//	private void previousTeacher() {
//		if (listPosition > 0) {
//			listPosition--;
//			idTxt.setText(Integer.toString(teachers.get(listPosition).getId()));
//			firstnameTxt.setText(teachers.get(listPosition).getLastname());
//		}
//	}
//}



package gr.aueb.cf.schoolapp.viewcontroller;

import gr.aueb.cf.schoolapp.Main;
import gr.aueb.cf.schoolapp.dao.ITeacherDAO;
import gr.aueb.cf.schoolapp.dao.TeacherDAOImpl;
import gr.aueb.cf.schoolapp.dao.exceptions.TeacherDAOException;
import gr.aueb.cf.schoolapp.dto.TeacherUpdateDTO;
import gr.aueb.cf.schoolapp.model.Teacher;
import gr.aueb.cf.schoolapp.service.ITeacherService;
import gr.aueb.cf.schoolapp.service.TeacherServiceImpl;
import gr.aueb.cf.schoolapp.service.exceptions.TeacherNotFoundException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.List;
import java.util.Objects;

public class TeachersUpdateDeleteForm extends JFrame {
	private JPanel contentPane;
	private JTextField idTxt;
	private JTextField firstnameTxt;
	private JTextField lastnameTxt;
	private JTextField cityTxt;
	private JTextField specialityTxt;
	private JButton deleteBtn;
	private JButton updateBtn;
	private JButton nextBtn;
	private JButton previousBtn;

	private ITeacherDAO dao = new TeacherDAOImpl();
	private ITeacherService teacherService = new TeacherServiceImpl(dao);

	private List<Teacher> teachers;
	private int listPosition;
	private int listSize;

	public TeachersUpdateDeleteForm() {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		URL url = classLoader.getResource("eduv2.png");
		setIconImage(Toolkit.getDefaultToolkit().getImage(url));

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				setTitle("Ενημέρωση/Απαλοιφή");
				try {
					teachers = teacherService.getTeachersByLastname(Main.getTeacherSearchForm().getLastname());
					listSize = teachers.size();
					if (listSize == 0) {
						JOptionPane.showMessageDialog(null, "No Teachers Found", "Info", JOptionPane.ERROR_MESSAGE);
						Main.getTeacherSearchForm().setEnabled(true);
						Main.getTeachersUpdateDeleteForm().setVisible(false);
						return;
					}
					listPosition = 0;
					idTxt.setText(Integer.toString(teachers.get(listPosition).getId()));
					firstnameTxt.setText(teachers.get(listPosition).getFirstname());
					lastnameTxt.setText(teachers.get(listPosition).getLastname());
				} catch (TeacherDAOException e1) {
					String message = e1.getMessage();
					JOptionPane.showMessageDialog(null, message, "Error in getting teachers", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel idLbl = new JLabel("ID");
		idLbl.setBounds(65, 35, 76, 14);
		contentPane.add(idLbl);

		idTxt = new JTextField();
		idTxt.setForeground(new Color(128, 0, 0));
		idTxt.setFont(new Font("Tahoma", Font.BOLD, 14));
		idTxt.setBounds(151, 32, 144, 20);
		contentPane.add(idTxt);
		idTxt.setColumns(10);

		JLabel nameLbl = new JLabel("Firstname");
		nameLbl.setBounds(65, 75, 76, 14);
		contentPane.add(nameLbl);

		firstnameTxt = new JTextField();
		firstnameTxt.setBounds(151, 72, 144, 20);
		contentPane.add(firstnameTxt);
		firstnameTxt.setColumns(10);

		JLabel lastnameLbl = new JLabel("Lastname");
		lastnameLbl.setBounds(65, 102, 76, 14);
		contentPane.add(lastnameLbl);

		lastnameTxt = new JTextField();
		lastnameTxt.setBounds(151, 102, 144, 20);
		contentPane.add(lastnameTxt);
		lastnameTxt.setColumns(10);

		JLabel cityLbl = new JLabel("City");
		cityLbl.setBounds(65, 132, 76, 14);
		contentPane.add(cityLbl);

		cityTxt = new JTextField();
		cityTxt.setBounds(151, 132, 144, 20);
		contentPane.add(cityTxt);
		cityTxt.setColumns(10);

		JLabel specialityLbl = new JLabel("Speciality");
		specialityLbl.setBounds(65, 162, 76, 14);
		contentPane.add(specialityLbl);

		specialityTxt = new JTextField();
		specialityTxt.setBounds(151, 162, 144, 20);
		contentPane.add(specialityTxt);
		specialityTxt.setColumns(10);

		deleteBtn = new JButton("Delete");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int response;
					String idStr = idTxt.getText();
					int id = Integer.parseInt(idStr);

					response = JOptionPane.showConfirmDialog(null, "Είστε σίγουρος;", "Warning", JOptionPane.YES_NO_OPTION);

					if (response == JOptionPane.YES_OPTION) {
						teacherService.deleteTeacher(id);
						JOptionPane.showMessageDialog(null, "Teacher was deleted successfully", "DELETE", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (TeacherDAOException | TeacherNotFoundException e1) {
					String message = e1.getMessage();
					JOptionPane.showMessageDialog(null, message, "DELETE", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		deleteBtn.setForeground(Color.BLUE);
		deleteBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		deleteBtn.setBounds(320, 160, 89, 23);
		contentPane.add(deleteBtn);

		updateBtn = new JButton("Update");
		updateBtn.setForeground(new Color(0, 0, 255));
		updateBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idTxt.getText().trim();
				String lastname = lastnameTxt.getText().trim();
				String firstname = firstnameTxt.getText().trim();

				if (lastname.equals("") || firstname.equals("") || id.equals("")) {
					JOptionPane.showMessageDialog(null, "Not valid input", "UPDATE ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}

				try {
					TeacherUpdateDTO teacherDTO = new TeacherUpdateDTO();
					teacherDTO.setId(Integer.parseInt(id));
					teacherDTO.setFirstname(firstname);
					teacherDTO.setLastname(lastname);

					Teacher teacher = teacherService.updateTeacher(teacherDTO);
					JOptionPane.showMessageDialog(null, "Teacher with id " + teacher.getId() + " was updated", "UPDATE", JOptionPane.PLAIN_MESSAGE);
				} catch (TeacherDAOException | TeacherNotFoundException e1) {
					String message = e1.getMessage();
					JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		updateBtn.setBounds(320, 194, 89, 23);
		contentPane.add(updateBtn);

		nextBtn = new JButton("");
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listPosition <= listSize - 2) {
					listPosition++;
					idTxt.setText(String.valueOf(teachers.get(listPosition).getId()));
					lastnameTxt.setText(teachers.get(listPosition).getLastname());
					firstnameTxt.setText(teachers.get(listPosition).getFirstname());
				}
			}
		});
		nextBtn.setForeground(Color.BLUE);
		nextBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		nextBtn.setIcon(new ImageIcon(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("Next_track.png"))));
		nextBtn.setBounds(310, 110, 100, 30);
		contentPane.add(nextBtn);

		previousBtn = new JButton("");
		previousBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listPosition > 0) {
					listPosition--;
					idTxt.setText(String.valueOf(teachers.get(listPosition).getId()));
					lastnameTxt.setText(teachers.get(listPosition).getLastname());
					firstnameTxt.setText(teachers.get(listPosition).getFirstname());
				}
			}
		});
		previousBtn.setForeground(Color.BLUE);
		previousBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		previousBtn.setIcon(new ImageIcon(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("Previous_record.png"))));
		previousBtn.setBounds(310, 70, 100, 30);
		contentPane.add(previousBtn);
	}

	private void nextTeacher() {
		if (listPosition < listSize - 1) {
			listPosition++;
			idTxt.setText(String.valueOf(teachers.get(listPosition).getId()));
			lastnameTxt.setText(teachers.get(listPosition).getLastname());
			firstnameTxt.setText(teachers.get(listPosition).getFirstname());
		}
	}

	private void previousTeacher() {
		if (listPosition > 0) {
			listPosition--;
			idTxt.setText(String.valueOf(teachers.get(listPosition).getId()));
			lastnameTxt.setText(teachers.get(listPosition).getLastname());
			firstnameTxt.setText(teachers.get(listPosition).getFirstname());
		}
	}
}
