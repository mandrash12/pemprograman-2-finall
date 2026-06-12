<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${empty mobil ? 'Tambah' : 'Edit'} Mobil — RentalKu</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
</head>
<body class="form-page">
    <!-- Navbar -->
    <nav class="navbar">
        <div class="nav-brand">🚗 Rental<span class="gradient-text">Ku</span></div>
        <div class="nav-user">
            <span>Halo, <strong>${sessionScope.user.namaLengkap}</strong></span>
            <a href="login?action=logout" class="btn-logout">Logout</a>
        </div>
    </nav>

    <div class="container">
        <div class="form-card">
            <div class="form-header">
                <h1>${empty mobil ? '➕ Tambah Mobil Baru' : '✏️ Edit Data Mobil'}</h1>
                <a href="dashboard" class="btn-back">← Kembali</a>
            </div>

            <form method="post" action="mobil-form">
                <c:if test="${not empty mobil}">
                    <input type="hidden" name="id" value="${mobil.id}">
                </c:if>

                <div class="form-grid">
                    <div class="form-group">
                        <label for="nama">Nama Mobil</label>
                        <input type="text" id="nama" name="nama" value="${mobil.nama}"
                               placeholder="cth: Avanza G" required>
                    </div>
                    <div class="form-group">
                        <label for="merk">Merk</label>
                        <input type="text" id="merk" name="merk" value="${mobil.merk}"
                               placeholder="cth: Toyota" required>
                    </div>
                    <div class="form-group">
                        <label for="tahun">Tahun</label>
                        <input type="number" id="tahun" name="tahun" value="${mobil.tahun != 0 ? mobil.tahun : ''}"
                               placeholder="cth: 2023" required min="2000" max="2030">
                    </div>
                    <div class="form-group">
                        <label for="warna">Warna</label>
                        <input type="text" id="warna" name="warna" value="${mobil.warna}"
                               placeholder="cth: Putih" required>
                    </div>
                    <div class="form-group">
                        <label for="hargaSewaPerHari">Harga Sewa / Hari (Rp)</label>
                        <input type="number" id="hargaSewaPerHari" name="hargaSewaPerHari"
                               value="${mobil.hargaSewaPerHari != 0 ? mobil.hargaSewaPerHari : ''}"
                               placeholder="cth: 350000" required min="0" step="1000">
                    </div>
                    <div class="form-group">
                        <label for="status">Status</label>
                        <select id="status" name="status" required>
                            <option value="Tersedia" ${mobil.status == 'Tersedia' ? 'selected' : ''}>Tersedia</option>
                            <option value="Disewa" ${mobil.status == 'Disewa' ? 'selected' : ''}>Disewa</option>
                        </select>
                    </div>
                    <div class="form-group full-width">
                        <label for="gambarUrl">URL Gambar</label>
                        <input type="url" id="gambarUrl" name="gambarUrl" value="${mobil.gambarUrl}"
                               placeholder="https://example.com/gambar-mobil.jpg">
                    </div>
                </div>

                <button type="submit" class="btn-submit">
                    ${empty mobil ? '+ Tambah Mobil' : '💾 Simpan Perubahan'}
                </button>
            </form>
        </div>
    </div>
</body>
</html>
