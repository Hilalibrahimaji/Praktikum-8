import java.awt.Dimension;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class ContohComponentConstraint {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Control Component Constraints");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 250));

        JPanel panel = new JPanel(new MigLayout("fill, insets 20"));

        // Username
        panel.add(new JLabel("Username:"));
        panel.add(new JTextField(), "growx, wrap");

        // Password
        panel.add(new JLabel("Password:"));
        panel.add(new JPasswordField(), "growx, wrap");

        // Divisi
        panel.add(new JLabel("Divisi:"));
        panel.add(new JComboBox<>(new String[]{"IT", "HRD", "Finance", "Marketing"}), "growx, wrap");

        // Login button
        panel.add(new JButton("Login"), "span, align center, gaptop 10");

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
