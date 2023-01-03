import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JFrame{
    private int clicks = 0;
    private JLabel countClicks;
    private JButton addClicks;

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public Panel() {
        super("Simple Clicker 1.0.1");
        setBounds(screenSize.width/2, screenSize.height/2, screenSize.width/6, screenSize.height/12);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        countClicks = new JLabel("Clicks: " + clicks);
        addClicks = new JButton("Click me!");

        JPanel buttonsPanel = new JPanel(new FlowLayout());
        add(countClicks, BorderLayout.NORTH);

        buttonsPanel.add(addClicks);
        add(buttonsPanel, BorderLayout.SOUTH);

        clickAdder();
    }

    private void clickAdder() {
        addClicks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicks = clicks + 1;
                countUpdater();
            }
        });
    }
    private void countUpdater() {
        countClicks.setText("Clicks: " + clicks);
    }
}
