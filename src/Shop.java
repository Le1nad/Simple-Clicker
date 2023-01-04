import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Shop extends JFrame {
    public static int clicksPower = 1;

    public JButton addClickPower;

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public Shop() {
        setTitle("Clicks Shop");
        setVisible(false);
        setResizable(false);
        setBounds((screenSize.width/2)+50, (screenSize.height/2)+50, screenSize.width/6, screenSize.height/8);

        addClickPower = new JButton("Add Click Power (+1) for 10 clicks");

        JPanel buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.add(addClickPower);
        add(buttonsPanel, BorderLayout.NORTH);

        clickPowerAdder();
    }

    private void clickPowerAdder() {
        addClickPower.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Panel panel = new Panel();

                if (panel.clicks >= 10) {
                    panel.clicks = panel.clicks - 10;
                    clicksPower++;

                    panel.countUpdater();
                } else {
                    String message = "";
                    message += "Not enough Clicks!";
                    JOptionPane.showMessageDialog(null, message, "Something wrong", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
}
