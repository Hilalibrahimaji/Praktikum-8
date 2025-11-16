import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class InventoryApp {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Inventory App v2");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(750, 430);
            frame.setLocationRelativeTo(null);

            frame.setLayout(new MigLayout("insets 18", "[grow][grow]", "[grow][]"));


            JPanel pnlInput = new JPanel(new MigLayout("wrap 2, gapy 5", "[][grow]", "[][][][][]"));
            pnlInput.setBorder(BorderFactory.createTitledBorder("Input Barang"));

            JLabel lblNama = new JLabel("Nama:");
            JTextField txtNama = new JTextField(14);

            JLabel lblQty = new JLabel("Jumlah:");
            JTextField txtQty = new JTextField(6);

            JLabel lblJenis = new JLabel("Jenis:");
            String[] jenis = {"Elektronik", "Pakaian", "Rumahan", "Lainnya"};
            JComboBox<String> cbJenis = new JComboBox<>(jenis);

            JLabel lblUrgent = new JLabel("Prioritas Kirim:");
            JCheckBox ckUrgent = new JCheckBox("Ya, Prioritas");

            JButton btnSubmit = new JButton("Simpan dan Notifikasi");

            pnlInput.add(lblNama);
            pnlInput.add(txtNama, "growx");

            pnlInput.add(lblQty);
            pnlInput.add(txtQty, "growx");

            pnlInput.add(lblJenis);
            pnlInput.add(cbJenis, "growx");

            pnlInput.add(lblUrgent);
            pnlInput.add(ckUrgent);

            pnlInput.add(btnSubmit, "span 2, right, gaptop 8");

            JPanel pnlLog = new JPanel(new MigLayout("fill, wrap 1"));
            pnlLog.setBorder(BorderFactory.createTitledBorder("Log Aktivitas Tambahan"));

            JTextArea txLog = new JTextArea(10, 20);
            txLog.setEditable(false);

            JScrollPane sp = new JScrollPane(txLog);
            pnlLog.add(sp, "grow, push");

            btnSubmit.addActionListener(e -> {

                String nama = txtNama.getText().trim();
                String qty = txtQty.getText().trim();
                String jenisSelected = cbJenis.getSelectedItem().toString();
                boolean urgent = ckUrgent.isSelected();

                if (nama.isEmpty() || qty.isEmpty()) {
                    JOptionPane.showMessageDialog(
                            frame,
                            "Nama dan jumlah harus diisi!",
                            "Peringatan",
                            JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }

                JOptionPane.showMessageDialog(
                        frame,
                        "Data berhasil disimpan.",
                        "Informasi",
                        JOptionPane.INFORMATION_MESSAGE
                );

                // Tambah log
                txLog.append("Barang: " + nama +
                            " | Jumlah: " + qty +
                            " | Jenis: " + jenisSelected +
                            " | Prioritas: " + (urgent ? "Ya" : "Tidak") +
                            "\n");

                // Reset input
                txtNama.setText("");
                txtQty.setText("");
                ckUrgent.setSelected(false);
                cbJenis.setSelectedIndex(0);
            });

            // Tambah panel ke frame
            frame.add(pnlInput, "grow");
            frame.add(pnlLog, "grow");

            frame.setVisible(true);
        });
    }
}
