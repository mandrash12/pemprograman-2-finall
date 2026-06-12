package com.rental.dao;

import com.rental.model.Mobil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MobilDAO {

    public List<Mobil> getAllMobil() {
        List<Mobil> list = new ArrayList<>();
        String sql = "SELECT * FROM mobil ORDER BY created_at DESC";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Mobil mobil = new Mobil();
                mobil.setId(rs.getInt("id"));
                mobil.setNama(rs.getString("nama"));
                mobil.setMerk(rs.getString("merk"));
                mobil.setTahun(rs.getInt("tahun"));
                mobil.setWarna(rs.getString("warna"));
                mobil.setHargaSewaPerHari(rs.getDouble("harga_sewa_per_hari"));
                mobil.setStatus(rs.getString("status"));
                mobil.setGambarUrl(rs.getString("gambar_url"));
                mobil.setCreatedAt(rs.getString("created_at"));
                list.add(mobil);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Mobil getMobilById(int id) {
        String sql = "SELECT * FROM mobil WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Mobil mobil = new Mobil();
                    mobil.setId(rs.getInt("id"));
                    mobil.setNama(rs.getString("nama"));
                    mobil.setMerk(rs.getString("merk"));
                    mobil.setTahun(rs.getInt("tahun"));
                    mobil.setWarna(rs.getString("warna"));
                    mobil.setHargaSewaPerHari(rs.getDouble("harga_sewa_per_hari"));
                    mobil.setStatus(rs.getString("status"));
                    mobil.setGambarUrl(rs.getString("gambar_url"));
                    mobil.setCreatedAt(rs.getString("created_at"));
                    return mobil;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insertMobil(Mobil mobil) {
        String sql = "INSERT INTO mobil (nama, merk, tahun, warna, harga_sewa_per_hari, status, gambar_url) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, mobil.getNama());
            ps.setString(2, mobil.getMerk());
            ps.setInt(3, mobil.getTahun());
            ps.setString(4, mobil.getWarna());
            ps.setDouble(5, mobil.getHargaSewaPerHari());
            ps.setString(6, mobil.getStatus());
            ps.setString(7, mobil.getGambarUrl());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateMobil(Mobil mobil) {
        String sql = "UPDATE mobil SET nama=?, merk=?, tahun=?, warna=?, harga_sewa_per_hari=?, status=?, gambar_url=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, mobil.getNama());
            ps.setString(2, mobil.getMerk());
            ps.setInt(3, mobil.getTahun());
            ps.setString(4, mobil.getWarna());
            ps.setDouble(5, mobil.getHargaSewaPerHari());
            ps.setString(6, mobil.getStatus());
            ps.setString(7, mobil.getGambarUrl());
            ps.setInt(8, mobil.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteMobil(int id) {
        String sql = "DELETE FROM mobil WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int countMobil() {
        String sql = "SELECT COUNT(*) FROM mobil";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int countByStatus(String status) {
        String sql = "SELECT COUNT(*) FROM mobil WHERE status = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, status);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
