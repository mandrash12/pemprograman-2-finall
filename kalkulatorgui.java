import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KalkulatorGUI extends JFrame {

    JLabel lblAngka1, lblAngka2, lblHasil;
    JTextField txtAngka1, txtAngka2, txtHasil;
    JButton btnTambah, btnHapus, btnExit;

    public KalkulatorGUI() {

        setTitle("suhendra-231011400983");
        setSize(400,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        lblAngka1 = new JLabel("Angka Pertama");
        lblAngka2 = new JLabel("Angka Kedua");
        lblHasil = new JLabel("Hasil");

        txtAngka1 = new JTextField(15);
        txtAngka2 = new JTextField(15);
        txtHasil = new JTextField(15);
        txtHasil.setEditable(false);

        btnTambah = new JButton("Tambah");
        btnHapus = new JButton("Hapus");
        btnExit = new JButton("Exit");

        add(lblAngka1);
        add(txtAngka1);

        add(lblAngka2);
        add(txtAngka2);

        add(lblHasil);
        add(txtHasil);

        add(btnTambah);
        add(btnHapus);
        add(btnExit);

        // Tombol Tambah
        btnTambah.addActionListener((ActionEvent e) -> {
            try {
                int a = Integer.parseInt(txtAngka1.getText());
                int b = Integer.parseInt(txtAngka2.getText());
                int hasil = a + b;
                txtHasil.setText(String.valueOf(hasil));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Masukkan angka yang benar!");
            }
        });

        // Tombol Hapus
        btnHapus.addActionListener((ActionEvent e) -> {
            txtAngka1.setText("");
            txtAngka2.setText("");
            txtHasil.setText("");
        });

        // Tombol Exit
        btnExit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
    }

    public static void main(String[] args) {
        KalkulatorGUI form = new KalkulatorGUI();
        form.setVisible(true);
    }
}