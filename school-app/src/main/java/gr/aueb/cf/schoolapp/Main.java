package gr.aueb.cf.schoolapp;


import gr.aueb.cf.schoolapp.viewcontroller.*;
import java.awt.*;

public class Main {
    private static Login loginForm;
    private static AdminMenu adminMenu;
    private static TeachersMenu teachersMenu;
    private static TeacherSearchForm teacherSearchForm;
    private static TeachersUpdateDeleteForm teachersUpdateDeleteForm;
    private static AdminInsertTeachersForm adminInsertTeachersForm;



    private static AdminInsertCitiesForm adminInsertCitiesForm;
    private static CityUpdateDeleteForm  cityUpdateDeleteForm;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    loginForm = new Login();
                    loginForm.setVisible(true);

                    adminMenu = new AdminMenu();
                    adminMenu.setVisible(false);

                    teachersMenu = new TeachersMenu();
                    teachersMenu.setVisible(false);

                    adminInsertCitiesForm = new AdminInsertCitiesForm();
                    adminInsertCitiesForm.setVisible(false);

                    teacherSearchForm = new TeacherSearchForm();
                    teacherSearchForm.setVisible(false);

                    teachersUpdateDeleteForm = new TeachersUpdateDeleteForm();
                    teachersUpdateDeleteForm.setVisible(false);

                    adminInsertTeachersForm = new AdminInsertTeachersForm();
                    adminInsertTeachersForm.setVisible(false);

                    cityUpdateDeleteForm = new CityUpdateDeleteForm();
                    cityUpdateDeleteForm.setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static AdminMenu getAdminMenu() {
        return adminMenu;
    }

    public static TeachersMenu getTeachersMenu() {
        return teachersMenu;
    }

    public static TeacherSearchForm getTeacherSearchForm() { return teacherSearchForm;}

    public static AdminInsertCitiesForm getAdminInsertCitiesForm() {
        return adminInsertCitiesForm;
    }

    public static Login getLoginForm() {
        return loginForm;
    }

    public static TeachersUpdateDeleteForm getTeachersUpdateDeleteForm() {
        return teachersUpdateDeleteForm;
    }

    public static AdminInsertTeachersForm getAdminInsertTeachersForm() {
        return adminInsertTeachersForm;
    }

    public static  CityUpdateDeleteForm getCityUpdateDeleteForm() {
        return  cityUpdateDeleteForm;
    }
}
