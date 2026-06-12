-- ============================================
-- Script Inisialisasi Database Rental Mobil
-- ============================================

CREATE DATABASE IF NOT EXISTS rental_mobil
    DEFAULT CHARACTER SET utf8mb4
    DEFAULT COLLATE utf8mb4_unicode_ci;

USE rental_mobil;

-- Tabel Users
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    nama_lengkap VARCHAR(100) NOT NULL,
    role VARCHAR(20) DEFAULT 'admin',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

-- Tabel Mobil
CREATE TABLE IF NOT EXISTS mobil (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nama VARCHAR(100) NOT NULL,
    merk VARCHAR(50) NOT NULL,
    tahun INT NOT NULL,
    warna VARCHAR(30) NOT NULL,
    harga_sewa_per_hari DECIMAL(12,2) NOT NULL,
    status ENUM('Tersedia', 'Disewa') DEFAULT 'Tersedia',
    gambar_url VARCHAR(500),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

-- ============================================
-- Data Awal
-- ============================================

-- Admin default (username: admin, password: admin123)
INSERT INTO users (username, password, nama_lengkap, role) VALUES
('admin', 'admin123', 'Administrator', 'admin')
ON DUPLICATE KEY UPDATE username = username;

-- Sample data mobil
INSERT INTO mobil (nama, merk, tahun, warna, harga_sewa_per_hari, status, gambar_url) VALUES
('Avanza G',       'Toyota',    2023, 'Putih',   350000, 'Tersedia', 'https://images.unsplash.com/photo-1553440569-bcc63803a83d?w=400&h=280&fit=crop'),
('Xenia R Sporty', 'Daihatsu',  2022, 'Silver',  300000, 'Tersedia', 'https://images.unsplash.com/photo-1494976388531-d1058494cdd8?w=400&h=280&fit=crop'),
('Brio RS',        'Honda',     2023, 'Merah',   280000, 'Disewa',   'https://images.unsplash.com/photo-1502877338535-766e1452684a?w=400&h=280&fit=crop'),
('Ertiga GX',      'Suzuki',    2023, 'Hitam',   400000, 'Tersedia', 'https://images.unsplash.com/photo-1549317661-bd32c8ce0afa?w=400&h=280&fit=crop'),
('Innova Reborn',  'Toyota',    2022, 'Abu-abu', 500000, 'Disewa',   'https://images.unsplash.com/photo-1583121274602-3e2820c69888?w=400&h=280&fit=crop'),
('Jazz RS',        'Honda',     2021, 'Biru',    320000, 'Tersedia', 'https://images.unsplash.com/photo-1542362567-b07e54358753?w=400&h=280&fit=crop');
