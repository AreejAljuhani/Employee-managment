package Employee_managment;

// Needed imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomeWindow extends JFrame {

    private JLabel title;
    private JLabel title1;

    private JButton startButton;

    private ImageIcon image;
    private ImageIcon menuIcon;
    private ImageIcon exitIcon;
    private ImageIcon helpIcon;
    private ImageIcon feedbackIcon;
    private Image icon;

    private JMenuBar menuBar;
    private JMenu optionMenu;
    private JMenuItem exitItem;
    private JMenuItem helpItem;
    private JMenuItem feedbackItem;

    private ImageIcon backgroundImage;
    private JLabel backgroundLabel;

    public WelcomeWindow() throws Exception {

        icon = Toolkit.getDefaultToolkit().getImage("images/logo.png");
        setIconImage(icon);

        backgroundImage = new ImageIcon("images/main_page.jpg");
        Image dabImage = backgroundImage.getImage();
        Image modImage = dabImage.getScaledInstance(420, 650, Image.SCALE_SMOOTH);
        backgroundImage = new ImageIcon(modImage);

        backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setLayout(null);
        setContentPane(backgroundLabel);

        setTitle("Employee Record Management System");
        setSize(420, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BuildComponents();
        buildMenu();

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuWindow f2 = new menuWindow();
                setVisible(false);
                f2.setVisible(true);
            }
        });

        try {
            UIManager.put("nimbusSelection", Color.decode("#04EC89"));
            UIManager.put("nimbusFocus", Color.decode("#04EC89"));
            UIManager.put("nimbusBase", Color.decode("#04EC89"));
            UIManager.put("nimbusBlueGrey", Color.LIGHT_GRAY);
            UIManager.put("nimbusSelectionBackground", Color.decode("#04EC89"));
            UIManager.put("TextField.background", new Color (0,0,0,0));
            
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception ex) {
            System.out.println("An error occurred : " + ex.getMessage());
        }
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void BuildComponents() {

        Font font1 = new Font("Metropolis", Font.BOLD, 20);
        Font font2 = new Font("Metropolis", Font.PLAIN, 20);
        Color textColor = Color.white;
        Color buttonBackgroundColor = Color.decode("#04EC89");

        title = new JLabel("Employee record management", SwingConstants.CENTER);
        title.setFont(font1);
        title.setBounds(60, 270, 300, 40);
        title.setForeground(textColor);

        title1 = new JLabel("system", SwingConstants.CENTER);
        title1.setFont(font1);
        title1.setBounds(58, 290, 300, 40);
        title1.setForeground(textColor);

        startButton = new JButton("START");
        startButton.setFont(font2);
        startButton.setBackground(buttonBackgroundColor);
        startButton.setForeground(Color.BLACK);
        startButton.setPreferredSize(new Dimension(170, 50));
        startButton.setBounds(58, 400, 300, 40);

        add(title);
        add(title1);
        add(startButton);
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
