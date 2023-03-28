import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JFrame {

    private JLabel clickCountLabel;
    private JLabel clickPowerCountLabel;
    private JLabel autoClickCountLabel;

    private JButton clickButton;
    private JButton autoClickButton;
    private JButton upgradeButton;

    private int clickPower = 1;
    private int autoClickPower = 0;
    private int clickCount = 0;
    private int upgradeCost = 10;
    private int autoClickPowerUpgradeCost = 50;

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public Game() {
        setTitle("Clicker Game 1.1.2");
        setBounds(screenSize.width/2, screenSize.height/2, screenSize.width/5, screenSize.height/5);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));

        clickCountLabel = new JLabel("Clicks: " + clickCount);
        clickPowerCountLabel = new JLabel("Click Power: " + clickPower);
        autoClickCountLabel = new JLabel("Auto Click: " + autoClickPower);
        clickButton = new JButton("Click me!");
        autoClickButton = new JButton("Added Auto click (" + autoClickPowerUpgradeCost + " clicks)");
        upgradeButton = new JButton("Upgrade Click power (" + upgradeCost + " clicks)");

        clickButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clickCount += clickPower;
                clickCountLabel.setText("Clicks: " + clickCount);
            }
        });

        autoClickButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (clickCount >= autoClickPowerUpgradeCost) {
                    clickCount -= autoClickPowerUpgradeCost;
                    autoClickPower += 1;
                    autoClickPowerUpgradeCost += 50;
                    clickCountLabel.setText("Clicks: " + clickCount);
                    autoClickCountLabel.setText("Auto Click: " + autoClickPower);
                    autoClickButton.setText("Upgrade Auto click (" + autoClickPowerUpgradeCost + " clicks)");
                }
            }
        });

        upgradeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (clickCount >= upgradeCost) {
                    clickCount -= upgradeCost;
                    clickPower += 1;
                    upgradeCost += 10;
                    clickCountLabel.setText("Clicks: " + clickCount);
                    clickPowerCountLabel.setText("Click Power: " + clickPower);
                    upgradeButton.setText("Upgrade Click power (" + upgradeCost + " clicks)");
                }
            }
        });

        panel.add(clickCountLabel);
        panel.add(clickPowerCountLabel);
        panel.add(autoClickCountLabel);
        panel.add(clickButton);
        panel.add(autoClickButton);
        panel.add(upgradeButton);
        add(panel);

        Timer autoClickTimer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clickCount += autoClickPower;
                clickCountLabel.setText("Clicks: " + clickCount);
            }
        });
        autoClickTimer.start();
    }
}