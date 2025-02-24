package Employee_managment;

import static Employee_managment.InsertEmpWindow.recordSystem;
import static Employee_managment.updateEmpWindow.idTemp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class updateEmpWindow extends JFrame {

    public static int idTemp;

    private JLabel ID;
    private JLabel message;

    private JButton continueButton;
    private JButton backButton;

    public static JTextField empID;

    private ImageIcon menuIcon;
    private ImageIcon exitIcon;
    private ImageIcon helpIcon;
    private ImageIcon feedbackIcon;
    private ImageIcon backIcon;
    private Image icon;

    private JMenuBar menuBar;
    private JMenu optionMenu;
    private JMenuItem exitItem;
    private JMenuItem helpItem;
    private JMenuItem feedbackItem;

    private JLabel backgroundLabel;
    private ImageIcon backgroundImage;

    ImageIcon errorIcon = new ImageIcon("images/wrong_icon.png");

    public updateEmpWindow() {
        icon = Toolkit.getDefaultToolkit().getImage("images/logo.png");
        setIconImage(icon);
        setTitle("Update employee");
        setSize(420, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backgroundImage = new ImageIcon("images/page.jpg");
        Image dabImage = backgroundImage.getImage();
        Image modImage = dabImage.getScaledInstance(420, 650, Image.SCALE_SMOOTH);
        backgroundImage = new ImageIcon(modImage);

        backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setLayout(null);
        setContentPane(backgroundLabel);

        BuildComponents();
        buildMenu();

        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Employee temp = recordSystem.smartSearchRecord(Integer.parseInt(empID.getText()));
                idTemp = Integer.parseInt(empID.getText());

                if (temp == null) {
                    JOptionPane.showMessageDialog(null, "Employee record with id " + empID.getText() + " was not found", "", JOptionPane.INFORMATION_MESSAGE, errorIcon);
                } else {
                    updateEmpInfoWindow f3 = new updateEmpInfoWindow();
                    setVisible(false);
                    f3.setVisible(true);
                }
            }
        }
        );

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuWindow f3 = new menuWindow();
                setVisible(false);
                f3.setVisible(true);
            }
        });
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void BuildComponents() {
        Font font = new Font("Metropolis", Font.BOLD, 16);
        Color textColor = Color.white;
        Color backgroundColor = Color.decode("#7F5F6F9");
        Color buttonBackgroundColor = Color.decode("#04EC89");

        backIcon = new ImageIcon("images/back_icon.png");
        Image dabImageBack = backIcon.getImage();
        Image modImageBack = dabImageBack.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        backIcon = new ImageIcon(modImageBack);

        ID = new JLabel("Employee ID:");
        ID.setForeground(textColor);
        ID.setFont(font);
        ID.setBounds(50, 150, 240, 40);

        empID = new JTextField(15);
        empID.setBounds(160, 155, 170, 25);
        empID.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#04EC89")));
        empID.setCaretColor(Color.WHITE);
        empID.setForeground(Color.LIGHT_GRAY);
        empID.setFont(font);

        continueButton = new JButton("Update");
        continueButton.setFont(font);
        continueButton.setForeground(Color.DARK_GRAY);
        continueButton.setBackground(buttonBackgroundColor);
        continueButton.setPreferredSize(new Dimension(170, 50));
        continueButton.setBounds(150, 200, 100, 40);

        backButton = new JButton(backIcon);
        backButton.setPreferredSize(new Dimension(170, 50));
        backButton.setBounds(30, 60, 30, 30);
        backButton.setOpaque(false);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);

        message = new JLabel("", SwingConstants.CENTER);
        message.setForeground(Color.RED);
        message.setFont(font);
        message.setBounds(30, 180, 240, 40);

        Image dabImage1 = errorIcon.getImage();
        Image modImage1 = dabImage1.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        errorIcon = new ImageIcon(modImage1);

        add(ID);
        add(empID);
        add(continueButton);
        add(backButton);
        add(message);

    }

    public void buildMenu() {
        menuBar = new JMenuBar();
        menuIcon = new ImageIcon("images/optionMenu.png");
        Image dabImage = menuIcon.getImage();
        Image modImage = dabImage.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        menuIcon = new ImageIcon(modImage);

        optionMenu = new JMenu();
        optionMenu.setIcon(menuIcon);
        optionMenu.setMnemonic(KeyEvent.VK_O);
        optionMenu.setForeground(Color.gray);

        exitIcon = new ImageIcon("images/exitIcon.png");
        Image dabImage1 = exitIcon.getImage();
        Image modImage1 = dabImage1.getScaledInstance(13, 13, Image.SCALE_SMOOTH);
        exitIcon = new ImageIcon(modImage1);

        exitItem = new JMenuItem(" Exit");
        exitItem.setIcon(exitIcon);
        exitItem.setMnemonic(KeyEvent.VK_X);
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        helpIcon = new ImageIcon("images/helpIcon.png");
        Image dabImage2 = helpIcon.getImage();
        Image modImage2 = dabImage2.getScaledInstance(13, 13, Image.SCALE_SMOOTH);
        helpIcon = new ImageIcon(modImage2);

        helpItem = new JMenuItem(" Help");
        helpItem.setIcon(helpIcon);
        helpItem.setMnemonic(KeyEvent.VK_H);
        helpItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Contact : admin@erms.com");
            }
        });

        feedbackIcon = new ImageIcon("images/feedbackIcon.png");
        Image dabImage3 = feedbackIcon.getImage();
        Image modImage3 = dabImage3.getScaledInstance(13, 13, Image.SCALE_SMOOTH);
        feedbackIcon = new ImageIcon(modImage3);

        feedbackItem = new JMenuItem(" Feedback");
        feedbackItem.setIcon(feedbackIcon);
        feedbackItem.setMnemonic(KeyEvent.VK_F);
        feedbackItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showInputDialog(null, "Write your feedback", "Feedback", JOptionPane.PLAIN_MESSAGE);
            }
        });

        optionMenu.add(exitItem);
        optionMenu.add(helpItem);
        optionMenu.add(feedbackItem);
        menuBar.add(optionMenu);
        setJMenuBar(menuBar);
    }
}

class updateEmpInfoWindow extends JFrame {

    private JLabel name;
    private JLabel firstDay;
    private JLabel phoneNumber;
    private JLabel address;
    private JLabel workHours;
    private JLabel salary;
    private JLabel errorMessage;

    private JButton continueButton;
    private JButton backButton;

    public static JTextField empName;
    public static JTextField empFirstDay;
    public static JTextField empPhoneNumber;
    public static JTextField empAddress;
    public static JTextField empWorkHours;
    public static JTextField empSalary;

    private ImageIcon menuIcon;
    private ImageIcon exitIcon;
    private ImageIcon helpIcon;
    private ImageIcon feedbackIcon;
    private ImageIcon backIcon;
    private Image icon;

    private JMenuBar menuBar;
    private JMenu optionMenu;
    private JMenuItem exitItem;
    private JMenuItem helpItem;
    private JMenuItem feedbackItem;

    private JLabel backgroundLabel;
    private ImageIcon backgroundImage;

    ImageIcon validIcon = new ImageIcon("images/checkmark_icon.png");

    public updateEmpInfoWindow() {
        icon = Toolkit.getDefaultToolkit().getImage("images/logo.png");
        setIconImage(icon);
        setTitle("Personal Information");
        setSize(420, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backgroundImage = new ImageIcon("images/page.jpg");
        Image dabImage = backgroundImage.getImage();
        Image modImage = dabImage.getScaledInstance(420, 650, Image.SCALE_SMOOTH);
        backgroundImage = new ImageIcon(modImage);

        backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setLayout(null);
        setContentPane(backgroundLabel);

        BuildComponents();
        buildMenu();

        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!empName.getText().isEmpty()) {
                    recordSystem.updateEmployeeRecordName(empName.getText(), idTemp);
                }

                if (!empFirstDay.getText().isEmpty()) {
                    recordSystem.updateEmployeeRecordFirstDay(empFirstDay.getText(), idTemp);
                }

                if (!empPhoneNumber.getText().isEmpty()) {
                    if (validatePhone()) {
                        recordSystem.updateEmployeeRecordPhoneNum(empPhoneNumber.getText(), idTemp);
                    } else {
                        return;
                    }

                }

                if (!empAddress.getText().isEmpty()) {
                    recordSystem.updateEmployeeRecordAddress(empAddress.getText(), idTemp);
                }

                if (!empWorkHours.getText().isEmpty()) {
                    if (validateWorkHours() && checkWorkHours()) {
                        recordSystem.updateEmployeeRecordWorkHours(Integer.parseInt(empWorkHours.getText()), idTemp);
                    } else {
                        return;
                    }

                }

                if (!empSalary.getText().isEmpty()) {
                    if (validateSalary()) {
                        recordSystem.updateEmployeeRecordSalary(Double.parseDouble(empSalary.getText()), idTemp);
                    } else {
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "Employee record have benn updated successfully in the system", "", JOptionPane.INFORMATION_MESSAGE, validIcon);

            }
        });
        backButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuWindow f3 = new menuWindow();
                setVisible(false);
                f3.setVisible(true);
            }
        }
        );

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void BuildComponents() {

        Font font = new Font("Metropolis", Font.BOLD, 16);
        Color textColor = Color.white;
        Color buttonBackgroundColor = Color.decode("#04EC89");

        backIcon = new ImageIcon("images/back_icon.png");
        Image dabImageBack = backIcon.getImage();
        Image modImageBack = dabImageBack.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        backIcon = new ImageIcon(modImageBack);

        name = new JLabel("Name");
        name.setForeground(textColor);
        name.setFont(font);
        name.setBounds(30, 150, 240, 40);

        firstDay = new JLabel("FIrst day");
        firstDay.setForeground(textColor);
        firstDay.setFont(font);
        firstDay.setBounds(30, 210, 240, 40);

        phoneNumber = new JLabel("Phone number");
        phoneNumber.setForeground(textColor);
        phoneNumber.setFont(font);
        phoneNumber.setBounds(30, 270, 240, 40);

        address = new JLabel("Address");
        address.setForeground(textColor);
        address.setFont(font);
        address.setBounds(30, 330, 240, 40);

        workHours = new JLabel("Work hours");
        workHours.setForeground(textColor);
        workHours.setFont(font);
        workHours.setBounds(30, 390, 240, 40);

        salary = new JLabel("Salary");
        salary.setForeground(textColor);
        salary.setFont(font);
        salary.setBounds(30, 450, 240, 40);

        empName = new JTextField(15);
        empName.setBounds(150, 155, 170, 25);
        empName.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#04EC89")));
        empName.setCaretColor(Color.WHITE);
        empName.setForeground(Color.LIGHT_GRAY);
        empName.setFont(font);

        empFirstDay = new JTextField(15);
        empFirstDay.setBounds(150, 215, 170, 25);
        empFirstDay.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#04EC89")));
        empFirstDay.setCaretColor(Color.WHITE);
        empFirstDay.setForeground(Color.LIGHT_GRAY);
        empFirstDay.setFont(font);

        empPhoneNumber = new JTextField(15);
        empPhoneNumber.setBounds(150, 275, 170, 25);
        empPhoneNumber.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#04EC89")));
        empPhoneNumber.setCaretColor(Color.WHITE);
        empPhoneNumber.setForeground(Color.LIGHT_GRAY);
        empPhoneNumber.setFont(font);

        empAddress = new JTextField(15);
        empAddress.setBounds(150, 335, 170, 25);
        empAddress.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#04EC89")));
        empAddress.setCaretColor(Color.WHITE);
        empAddress.setForeground(Color.LIGHT_GRAY);
        empAddress.setFont(font);

        empWorkHours = new JTextField(15);
        empWorkHours.setBounds(150, 395, 170, 25);
        empWorkHours.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#04EC89")));
        empWorkHours.setCaretColor(Color.WHITE);
        empWorkHours.setForeground(Color.LIGHT_GRAY);
        empWorkHours.setFont(font);

        empSalary = new JTextField(15);
        empSalary.setBounds(150, 455, 170, 25);
        empSalary.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#04EC89")));
        empSalary.setCaretColor(Color.WHITE);
        empSalary.setForeground(Color.LIGHT_GRAY);
        empSalary.setFont(font);

        continueButton = new JButton("Update");
        continueButton.setFont(font);
        continueButton.setForeground(Color.DARK_GRAY);
        continueButton.setBackground(buttonBackgroundColor);
        continueButton.setPreferredSize(new Dimension(170, 50));
        continueButton.setBounds(150, 540, 100, 40);

        backButton = new JButton(backIcon);
        backButton.setPreferredSize(new Dimension(170, 50));
        backButton.setBounds(30, 60, 30, 30);
        backButton.setOpaque(false);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);

        errorMessage = new JLabel("", SwingConstants.CENTER);
        errorMessage.setForeground(Color.RED);
        errorMessage.setFont(font);
        errorMessage.setBounds(68, 590, 270, 25);

        Image dabImage = validIcon.getImage();
        Image modImage = dabImage.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        validIcon = new ImageIcon(modImage);

        add(name);
        add(firstDay);
        add(phoneNumber);
        add(address);
        add(workHours);
        add(salary);
        add(empName);
        add(empFirstDay);
        add(empPhoneNumber);
        add(empAddress);
        add(empWorkHours);
        add(empSalary);
        add(continueButton);
        add(backButton);
        add(errorMessage);

    }

    public boolean validatePhone() {
        if (!isNumeric(empPhoneNumber.getText())) {
            errorMessage.setText("The Phone number must be a number ");
            return false;
        }
        errorMessage.setText("");
        return true;
    }

    public boolean validateWorkHours() {
        if (!isNumericDouble(empWorkHours.getText())) {
            errorMessage.setText("The work hours must be a number ");
            return false;
        }
        errorMessage.setText("");
        return true;
    }

    public boolean validateSalary() {
        if (!isNumericDouble(empSalary.getText())) {
            errorMessage.setText("The salary must be a number ");
            return false;
        }
        errorMessage.setText("");
        return true;
    }

    public boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isNumericDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean checkWorkHours() {
        double e = Double.parseDouble(empWorkHours.getText());
        if (e < 32) {
            errorMessage.setText("Work hours must be at least 32");
            return false;
        }
        errorMessage.setText("");
        return true;
    }

    public void buildMenu() {
        menuBar = new JMenuBar();
        menuIcon = new ImageIcon("images/optionMenu.png");
        Image dabImage = menuIcon.getImage();
        Image modImage = dabImage.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        menuIcon = new ImageIcon(modImage);

        optionMenu = new JMenu();
        optionMenu.setIcon(menuIcon);
        optionMenu.setMnemonic(KeyEvent.VK_O);
        optionMenu.setForeground(Color.gray);

        exitIcon = new ImageIcon("images/exitIcon.png");
        Image dabImage1 = exitIcon.getImage();
        Image modImage1 = dabImage1.getScaledInstance(13, 13, Image.SCALE_SMOOTH);
        exitIcon = new ImageIcon(modImage1);

        exitItem = new JMenuItem(" Exit");
        exitItem.setIcon(exitIcon);
        exitItem.setMnemonic(KeyEvent.VK_X);
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        helpIcon = new ImageIcon("images/helpIcon.png");
        Image dabImage2 = helpIcon.getImage();
        Image modImage2 = dabImage2.getScaledInstance(13, 13, Image.SCALE_SMOOTH);
        helpIcon = new ImageIcon(modImage2);

        helpItem = new JMenuItem(" Help");
        helpItem.setIcon(helpIcon);
        helpItem.setMnemonic(KeyEvent.VK_H);
        helpItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Contact : admin@erms.com");
            }
        });

        feedbackIcon = new ImageIcon("images/feedbackIcon.png");
        Image dabImage3 = feedbackIcon.getImage();
        Image modImage3 = dabImage3.getScaledInstance(13, 13, Image.SCALE_SMOOTH);
        feedbackIcon = new ImageIcon(modImage3);

        feedbackItem = new JMenuItem(" Feedback");
        feedbackItem.setIcon(feedbackIcon);
        feedbackItem.setMnemonic(KeyEvent.VK_F);
        feedbackItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showInputDialog(null, "Write your feedback", "Feedback", JOptionPane.PLAIN_MESSAGE);
            }
        });

        optionMenu.add(exitItem);
        optionMenu.add(helpItem);
        optionMenu.add(feedbackItem);
        menuBar.add(optionMenu);
        setJMenuBar(menuBar);
    }
}
