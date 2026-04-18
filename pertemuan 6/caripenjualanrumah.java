import javax.swing.*;
import java.sql.*;

public class CariDataPenjualan extends JFrame { 
    
    Connection koneksi; 

    public void prosesCari() {
        try {

            Statement st = koneksi.createStatement(); 
            
            String sql = "Select * from tabel_rumah where nama_pembeli like('%" + namaTF.getText() + "%')";
            
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                
                hargaTF.setText(rs.getString("harga")); 
                lokasiTF.setText(rs.getString("lokasi"));
            } else {
                // Menampilkan pesan jika data tidak ada [cite: 42, 43]
                JOptionPane.showMessageDialog(this, "Data tidak ada/Salah", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            // Log jika terjadi kegagalan koneksi [cite: 46]
            System.out.println("koneksi gagal " + e.toString()); 
        }
    }
}