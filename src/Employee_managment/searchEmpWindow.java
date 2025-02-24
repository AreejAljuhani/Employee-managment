package Employee_managment;

import static Employee_managment.InsertEmpWindow.recordSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class searchEmpWindow extends JFrame {

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

    public searchEmpWindow() {
        icon = Toolkit.getDefaultToolkit().getImage("images/logo.png");
        setIconImage(icon);
        setTitle("Search employee");
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
                recordSystem.searchEmployee(Integer.parseInt(empID.getText()));
            }
        });

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

        continueButton = new JButton("Search");
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
