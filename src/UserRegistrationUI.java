import javax.swing.*;
import javax.swing.table.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class UserRegistrationUI extends JFrame{
    private JTextArea outputArea;

    public UserRegistrationUI(){
        setTitle("User Registration Demo using the Chain of Responsibility Design Pattern via JavaSwing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        outputArea = new JTextArea(5, 50);
        outputArea.setEditable(false);
        outputArea.setBorder(BorderFactory.createTitledBorder("Event Output"));
        JScrollPane scrollPane = new JScrollPane(outputArea);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Big font testing
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel title = new JLabel("User Registration");
        Font bigFont = new Font("Serif", Font.BOLD, 20);
        title.setFont(bigFont);
        add(title);


        // Username
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Username:"), gbc);
        JTextField usernameField = new JTextField(20);
        gbc.gridx = 1;
        add(usernameField, gbc);

        // Password
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Password:"), gbc);
        JTextField passwordField = new JTextField(20);
        gbc.gridx = 1;
        add(passwordField, gbc);

        // Email address
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Email:"), gbc);
        JTextField emailField = new JTextField(20);
        gbc.gridx = 1;
        add(emailField, gbc);

        // Phone number
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Phone number:"), gbc);
        JTextField phoneNumberField = new JTextField(20);
        gbc.gridx = 1;
        add(phoneNumberField, gbc);

        // Register button
        gbc.gridx = 0;
        gbc.gridy = 5;
        JButton registerButton = new JButton("Register");
        gbc.gridx = 1;
        add(registerButton, gbc);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame valid = new JFrame("Confirmation");
                valid.setSize(400, 300);
                valid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                valid.setLocationRelativeTo(null);

                UserRegistration user = new UserRegistration(
                        usernameField.getText(),
                        passwordField.getText(),
                        emailField.getText(),
                        phoneNumberField.getText()
                );

                try {
                    // Run the validator chain
                    Validator validatorChain = setUpValidatorChain();
                    validatorChain.validate(user);

                    // if it does work
                    JLabel passed = new JLabel("Registration passed all validations.");
                    Font bigFont = new Font("Serif", Font.BOLD, 20);
                    passed.setFont(bigFont);
                    valid.add(passed);

                    valid.setVisible(true);

                } catch (IllegalArgumentException exception) {
                    // If it fails
                    JOptionPane.showMessageDialog(null,
                            exception.getMessage(),
                            "Validation Error",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        });


    }

    public static Validator setUpValidatorChain(){
        Validator usernameValidator = new UsernameValidator();
        Validator passwordValidator = new PasswordValidator();
        Validator emailValidator = new EmailValidator();
        Validator phoneNumberValidator = new PhoneNumberValidator();

        usernameValidator.setNextValidator(passwordValidator);
        passwordValidator.setNextValidator(emailValidator);
        emailValidator.setNextValidator(phoneNumberValidator);

        return usernameValidator;
    }

    public static void main(String[] args){
        //Validator validatorChain = setUpValidatorChain();

        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            UserRegistrationUI demo = new UserRegistrationUI();
            demo.setVisible(true);
        });
    }
}
