import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import net.miginfocom.swing.MigLayout;

public class ContohLayoutConstraint {
public static void main(String[] args) {

try {
        UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
        System.err.println("Gagal mengatur Look and Feel: " + e.getMessage());
        }
JFrame frame = new JFrame("Contoh MigLayout dengan Constraint");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setPreferredSize(new Dimension(500, 400));

String layoutConstraints = "fill, insets 20, hidemode 3";

JPanel panel = new JPanel(new MigLayout(layoutConstraints));

JButton button1 = new JButton("Button 1");
    JButton button2 = new JButton("Button 2");
    JButton button3 = new JButton("Button 3");

    panel.add(button1, "w 100, h 50, center, growx");
    panel.add(button2, "w 100, h 50, wrap, center, growx");
    panel.add(button3, "w 100, h 50, span 2, growx, wrap");
    JLabel statusLabel = new JLabel("Button 2 terlihat");
    panel.add(statusLabel, "span 2, align center, gaptop 20");

    button1.addActionListener(e -> {
        boolean isVisible = button2.isVisible();
            button2.setVisible(!isVisible);
            if (isVisible) {
                statusLabel.setText("Button 2 disembunyikan (Ruang kosong dilipat)");
            } else {
                statusLabel.setText("Button 2 terlihat");
                
            }
        });

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}