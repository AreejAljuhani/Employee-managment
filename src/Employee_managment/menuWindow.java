package Employee_managment;

import static Employee_managment.InsertEmpWindow.recordSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class menuWindow extends JFrame {

    private JButton insertButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton showButton;
    private JButton searchButton;
    private JButton updateSalaryButton;

    private JLabel backgroundLabel;
    private JLabel welcomeLabel;

    private ImageIcon backgroundImage;
    private ImageIcon menuIcon;
    private ImageIcon welcomeIcon;
    private ImageIcon exitIcon;
    private ImageIcon helpIcon;
    private ImageIcon feedbackIcon;
    private Image icon;

    private JMenuBar menuBar;
    private JMenu optionMenu;
    private JMenuItem exitItem;
    private JMenuItem helpItem;
    private JMenuItem feedbackItem;

    public menuWindow() {
        icon = Toolkit.getDefaultToolkit().getImage("images/logo.png");
        setIconImage(icon);

        setTitle("Employee Record Management System");
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

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InsertEmpWindow f4 = new InsertEmpWindow();
                setVisible(false);
                f4.setVisible(true);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteEmpWindow f5 = new deleteEmpWindow();
                setVisible(false);
                f5.setVisible(true);
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateEmpWindow f6 = new updateEmpWindow();
                setVisible(false);
                f6.setVisible(true);
            }
        });

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDetailsEmpWindow f7 = new showDetailsEmpWindow();
                setVisible(false);
                f7.setVisible(true);
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchEmpWindow f8 = new searchEmpWindow();
                setVisible(false);
                f8.setVisible(true);
            }
        });

        updateSalaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateEmpSalaryWindow f9 = new updateEmpSalaryWindow();
                setVisible(false);
                f9.setVisible(true);
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void BuildComponents() {
        Font font = new Font("Metropolis", Font.BOLD, 18);
        Font font1 = new Font("Metropolis", Font.PLAIN, 18);
        Color textColor1 = Color.white;
        Color textColor2 = Color.BLACK;
        Color buttonBackgroundColor = Color.decode("#04EC89");

        welcomeIcon = new ImageIcon("images/person_icon.png");
        Image dabImage = welcomeIcon.getImage();
        Image modImage = dabImage.getScaledInstance(30, 27, Image.SCALE_SMOOTH);
        welcomeIcon = new ImageIcon(modImage);

        welcomeLabel = new JLabel("Welcome manager", welcomeIcon, SwingConstants.CENTER);
        welcomeLabel.setFont(font);
        welcomeLabel.setForeground(textColor1);
        welcomeLabel.setBounds(100, 120, 200, 40);

        insertButton = new JButton("Insert employee record");
        insertButton.setFont(font1);
        insertButton.setBackground(buttonBackgroundColor);
        insertButton.setForeground(textColor2);
        insertButton.setPreferredSize(new Dimension(240, 60));
        insertButton.setBounds(87, 200, 240, 40);

        deleteButton = new JButton("Delete employee record");
        deleteButton.setFont(font1);
        deleteButton.setBackground(buttonBackgroundColor);
        deleteButton.setForeground(textColor2);
        deleteButton.setPreferredSize(new Dimension(240, 60));
        deleteButton.setBounds(87, 250, 240, 40);

        updateButton = new JButton("Update employee record");
        updateButton.setFont(font1);
        updateButton.setBackground(buttonBackgroundColor);
        updateButton.setForeground(textColor2);
        updateButton.setPreferredSize(new Dimension(240, 60));
        updateButton.setBounds(87, 300, 240, 40);

        showButton = new JButton("Show employee details");
        showButton.setFont(font1);
        showButton.setBackground(buttonBackgroundColor);
        showButton.setForeground(textColor2);
        showButton.setPreferredSize(new Dimension(240, 60));
        showButton.setBounds(87, 350, 240, 40);

        searchButton = new JButton("Search an employee");
        searchButton.setFont(font1);
        searchButton.setBackground(buttonBackgroundColor);
        searchButton.setForeground(textColor2);
        searchButton.setPreferredSize(new Dimension(240, 60));
        searchButton.setBounds(87, 400, 240, 40);

        updateSalaryButton = new JButton("Update employee salary");
        updateSalaryButton.setFont(font1);
        updateSalaryButton.setBackground(buttonBackgroundColor);
        updateSalaryButton.setForeground(textColor2);
        updateSalaryButton.setPreferredSize(new Dimension(240, 60));
        updateSalaryButton.setBounds(87, 450, 240, 40);

        add(welcomeLabel);
        add(insertButton);
        add(deleteButton);
        add(updateButton);
        add(showButton);
        add(searchButton);
        add(updateSalaryButton);
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
                recordSystem.printLinkedList();
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
        Image dabImage3 = feedbackIcon.getImage();// To change image size
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
