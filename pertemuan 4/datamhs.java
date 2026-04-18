import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    private JTextField txtNim, txtNama, txtNilai;
    private final JTable table;
    private DefaultTableModel model;

    public Main() {
        setTitle("Data Mahasiswa");
        setSize(750, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // LABEL
        JLabel lblNim = new JLabel("NIM:");
        lblNim.setBounds(20, 20, 100, 25);
        add(lblNim);

        JLabel lblNama = new JLabel("Nama Mahasiswa:");
        lblNama.setBounds(20, 60, 150, 25);
        add(lblNama);

        JLabel lblNilai = new JLabel("Nilai:");
        lblNilai.setBounds(20, 100, 100, 25);
        add(lblNilai);

        // TEXTFIELD
        txtNim = new JTextField();
        txtNim.setBounds(180, 20, 250, 25);
        add(txtNim);

        txtNama = new JTextField();
        txtNama.setBounds(180, 60, 250, 25);
        add(txtNama);

        txtNilai = new JTextField();
        txtNilai.setBounds(180, 100, 250, 25);
        add(txtNilai);

        // BUTTON
        JButton btnTambah = new JButton("TABEL");
        btnTambah.setBounds(460, 60, 120, 35);
        add(btnTambah);

        // TABLE
        model = new DefaultTableModel();
        model.addColumn("NIM");
        model.addColumn("Nama Mahasiswa");
        model.addColumn("Nilai");

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 150, 700, 180);
        add(scrollPane);

        // DATA DEFAULT
        model.addRow(new Object[]{
                "126835182391723",
                "mandrash CEO wirausaha",
                "11/100"
        });

        model.addRow(new Object[]{
                "231011400983",
                "suhendra",
                "0/100"
        });

        // ACTION BUTTON
        btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nim = txtNim.getText();
                String nama = txtNama.getText();
                String nilai = txtNilai.getText();

                if (nim.isEmpty() || nama.isEmpty() || nilai.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Data tidak boleh kosong!");
                } else {
                    model.addRow(new Object[]{nim, nama, nilai});

                    txtNim.setText("");
                    txtNama.setText("");
                    txtNilai.setText("");
                }
            }
        });
    }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}