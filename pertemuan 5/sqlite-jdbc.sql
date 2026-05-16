-- Membuat database jika belum ada
IF DB_ID('Latihan4') IS NULL
    CREATE DATABASE Latihan4;

USE Latihan4;

-- Hapus tabel jika sudah ada
IF OBJECT_ID('Buku', 'U') IS NOT NULL
    DROP TABLE Buku;

-- Membuat tabel + primary key
CREATE TABLE Buku (
    KodeBuku NCHAR(5) NOT NULL,
    JudulBuku NCHAR(100),
    Pengarang NCHAR(35),
    Penerbit NCHAR(35),
    TahunTerbit NCHAR(4),
    JmlBuku INT,
    CONSTRAINT PK_Buku PRIMARY KEY (KodeBuku)
);

-- Tambah kolom ISBN
ALTER TABLE Buku
ADD ISBN NCHAR(30);

-- Tambah kolom Status + constraint
ALTER TABLE Buku
ADD Status INT CONSTRAINT CK_Status CHECK (Status IN (0,1));

-- Contoh data
 KodeBuku NCHAR(5) NOT NULL,
    JudulBuku NCHAR(100),
    Pengarang NCHAR(35),
    Penerbit NCHAR(35),
    TahunTerbit NCHAR(4),
    JmlBuku INT,
    CONSTRAINT PK_Buku PRIMARY KEY (KodeBuku)
	);
SELECT * FROM Buku;