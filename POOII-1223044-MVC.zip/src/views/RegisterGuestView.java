package views;

import controllers.RegisterGuestController;
import javax.swing.*;
import java.awt.*;
import models.Guest;

public class RegisterGuestView extends JPanel {

    private RegisterGuestController controller;

    private JTextField tfName;
    private JTextField tfPhoneNumber;
    private JRadioButton rbMale, rbFemale;
    private JComboBox<String> cbDay, cbMonth, cbYear;
    private JTextField tfAddress;
    private JCheckBox cbTerms;
    private JButton btnRegister, btnReset;
    private ButtonGroup genderGroup;

    public RegisterGuestView(RegisterGuestController controller) {
        this.controller = controller;
        initializeUI();
    }

    private void initializeUI() {
        setLayout(null);

        // Labels
        JLabel lblName = new JLabel("Ingrese Nombre:");
        lblName.setBounds(30, 20, 150, 20);
        add(lblName);

        JLabel lblPhoneNumber = new JLabel("Ingrese número celular:");
        lblPhoneNumber.setBounds(30, 60, 150, 20);
        add(lblPhoneNumber);

        JLabel lblGender = new JLabel("Género:");
        lblGender.setBounds(30, 100, 150, 20);
        add(lblGender);

        JLabel lblBirthDate = new JLabel("Fecha de Nacimiento:");
        lblBirthDate.setBounds(30, 140, 150, 20);
        add(lblBirthDate);

        JLabel lblAddress = new JLabel("Dirección:");
        lblAddress.setBounds(30, 180, 150, 20);
        add(lblAddress);

        JLabel lblTerms = new JLabel("Acepta Términos y Condiciones");
        lblTerms.setBounds(30, 220, 200, 20);
        add(lblTerms);

        // Input fields
        tfName = new JTextField();
        tfName.setBounds(190, 20, 200, 20);
        add(tfName);

        tfPhoneNumber = new JTextField();
        tfPhoneNumber.setBounds(190, 60, 200, 20);
        add(tfPhoneNumber);

        // Gender Radio Buttons
        rbMale = new JRadioButton("Masculino");
        rbMale.setBounds(190, 100, 100, 20);
        rbFemale = new JRadioButton("Femenino");
        rbFemale.setBounds(300, 100, 100, 20);

        genderGroup = new ButtonGroup();
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);
        add(rbMale);
        add(rbFemale);

        // ComboBox para la fecha de nacimiento
        cbDay = new JComboBox<>(getDays());
        cbDay.setBounds(190, 140, 50, 20);
        cbMonth = new JComboBox<>(getMonths());
        cbMonth.setBounds(250, 140, 70, 20);
        cbYear = new JComboBox<>(getYears());
        cbYear.setBounds(330, 140, 60, 20);
        add(cbDay);
        add(cbMonth);
        add(cbYear);

        tfAddress = new JTextField();
        tfAddress.setBounds(190, 180, 200, 20);
        add(tfAddress);

        cbTerms = new JCheckBox();
        cbTerms.setBounds(230, 220, 20, 20);
        add(cbTerms);

        // Botones
        btnRegister = new JButton("Registrar");
        btnRegister.setBounds(190, 260, 100, 30);
        add(btnRegister);

        btnReset = new JButton("Resetear");
        btnReset.setBounds(300, 260, 100, 30);
        add(btnReset);

        // Action listeners
        btnRegister.addActionListener(e -> {
            if (validateFields()) {
                String birthDate = cbDay.getSelectedItem() + "/" + cbMonth.getSelectedItem() + "/" + cbYear.getSelectedItem();
                controller.registerGuest(
                        new Guest(
                                tfName.getText(),
                                tfPhoneNumber.getText(),
                                rbMale.isSelected() ? "Masculino" : "Femenino",
                                birthDate,
                                tfAddress.getText(),
                                cbTerms.isSelected()
                        )
                );
            }
        });

        btnReset.addActionListener(e -> resetFields());
    }

    private boolean validateFields() {
        if (tfName.getText().isEmpty() || tfPhoneNumber.getText().isEmpty()
                || (!rbMale.isSelected() && !rbFemale.isSelected())
                || tfAddress.getText().isEmpty() || !cbTerms.isSelected()) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos y acepte los términos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void resetFields() {
        tfName.setText("");
        tfPhoneNumber.setText("");
        genderGroup.clearSelection();
        cbDay.setSelectedIndex(0);
        cbMonth.setSelectedIndex(0);
        cbYear.setSelectedIndex(0);
        tfAddress.setText("");
        cbTerms.setSelected(false);
    }

    private String[] getDays() {
        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) {
            days[i - 1] = String.valueOf(i);
        }
        return days;
    }

    private String[] getMonths() {
        return new String[]{"Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"};
    }

    private String[] getYears() {
        String[] years = new String[50];
        int currentYear = 2023;
        for (int i = 0; i < 50; i++) {
            years[i] = String.valueOf(currentYear - i);
        }
        return years;
    }
}
