import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Panel extends JFrame {
    public static int clicks = 0;

    public JLabel countClicks;
    private JButton addClicks;
    private JButton clicksShop;

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public Panel() {
        super("Simple Clicker 1.1.1");
        setBounds(screenSize.width/2, screenSize.height/2, screenSize.width/6, screenSize.height/12);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        countClicks = new JLabel("Clicks: " + clicks);
        addClicks = new JButton("Click me!");
        clicksShop = new JButton("Shop");

        JPanel buttonsPanel = new JPanel(new FlowLayout());
        add(countClicks, BorderLayout.NORTH);

        buttonsPanel.add(addClicks);
        buttonsPanel.add(clicksShop);
        add(buttonsPanel, BorderLayout.SOUTH);

        ScheduledExecutorService countUpdater = Executors.newSingleThreadScheduledExecutor();
        countUpdater.scheduleWithFixedDelay(() -> {
            SwingUtilities.invokeLater(() -> countClicks.setText("Clicks: " + clicks));
        }, 0, 1, TimeUnit.MILLISECONDS);

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Shop shop = new Shop();
                clicks = clicks + shop.autoClick;
            }
        }, 0, 1, TimeUnit.SECONDS);

        clickAction();
    }

    private void clickAction() {
        addClicks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Shop shop = new Shop();
                clicks = clicks + shop.clicksPower;
            }
        });

        clicksShop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Shop shop = new Shop();
                shop.setVisible(true);
            }
        });
    }
}
