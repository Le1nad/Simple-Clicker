import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Shop extends JFrame {

    public static int clicksPower = 1;
    public static int autoClick = 0;
    private static int clickPowerPriceIncrease = 10;
    private static int autoClickPriceIncrease = 50;

    private JButton addClickPower;
    private JButton addAutoClick;

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public Shop() {
        setTitle("Clicks Shop");
        setVisible(false);
        setResizable(false);
        setBounds((screenSize.width/2)+50, (screenSize.height/2)+50, screenSize.width/6, screenSize.height/8);

        addClickPower = new JButton("Add Click Power (+1) for " + clickPowerPriceIncrease + " clicks");
        addAutoClick = new JButton("Add Auto-Click (+1/sec) for " + autoClickPriceIncrease + " clicks");

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.add(addClickPower);
        add(buttonsPanel);
        buttonsPanel.add(addAutoClick);
        add(buttonsPanel);

        clickUpgradeAdder();
    }

    private void clickUpgradeAdder() {
        addClickPower.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel panel = new Panel();

                if (panel.clicks >= clickPowerPriceIncrease) {
                    panel.clicks = panel.clicks - clickPowerPriceIncrease;

                    clickPowerPriceIncrease = clickPowerPriceIncrease + 10;
                    clicksPower++;

                    addClickPower.setText("Add Click Power (+1) for " + clickPowerPriceIncrease + " clicks");
                } else {
                    String message = "";
                    message += "Not enough Clicks!";
                    JOptionPane.showMessageDialog(null, message, "Something wrong", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        addAutoClick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel panel = new Panel();
                if (panel.clicks >= autoClickPriceIncrease) {
                    panel.clicks = panel.clicks - autoClickPriceIncrease;

                    autoClickPriceIncrease = autoClickPriceIncrease + 50;
                    autoClick = autoClick + 1;

                    System.out.println("Auto-Click added: " + autoClick);

                    addAutoClick.setText("Add Click Power (+1) for " + autoClickPriceIncrease + " clicks");
                } else {
                    String message = "";
                    message += "Not enough Clicks!";
                    JOptionPane.showMessageDialog(null, message, "Something wrong", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
}
