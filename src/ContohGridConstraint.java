import java.awt.Dimension;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class ContohGridConstraint {
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Grid Constraints Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(420, 220));

        String colConstraints = "[80px][grow, fill]";
        String rowConstraints = "[30px][30px][40px][30px]";

        JPanel panel = new JPanel(new MigLayout(
                "fill, insets 15, gapy 10",
                colConstraints,
                rowConstraints
        ));

        // Username
        panel.add(new JLabel("Username:"));
        panel.add(new JTextField(), "growx, wrap");

        // Password
        panel.add(new JLabel("Password:"));
        panel.add(new JPasswordField(), "growx, gaptop 4, wrap");

        // Button Save
        panel.add(new JButton("Save"), "span 2, growx, gaptop 10, wrap");

        // Footer text
        panel.add(new JLabel("copyright 2024"), "gaptop 10");

        // Help button (kanan)
        panel.add(new JButton("Help"), "w 80!, right, gaptop 10, wrap");

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
