<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard — RentalKu</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
</head>
<body class="dashboard">
    <!-- Navbar -->
    <nav class="navbar">
        <div class="nav-brand">🚗 Rental<span class="gradient-text">Ku</span></div>
        <div class="nav-user">
            <span>Halo, <strong>${sessionScope.user.namaLengkap}</strong></span>
            <a href="login?action=logout" class="btn-logout">Logout</a>
        </div>
    </nav>

    <div class="container">
        <!-- Page Header -->
        <div class="page-header">
            <h1>Daftar Mobil</h1>
            <a href="mobil-form" class="btn-add">+ Tambah Mobil</a>
        </div>

        <!-- Stats -->
        <div class="stats-row">
            <div class="stat-card">
                <span class="stat-icon">🚙</span>
                <div class="stat-number">${totalMobil}</div>
                <div class="stat-label">Total Mobil</div>
            </div>
            <div class="stat-card">
                <span class="stat-icon">✅</span>
                <div class="stat-number">${totalTersedia}</div>
                <div class="stat-label">Tersedia</div>
            </div>
            <div class="stat-card">
                <span class="stat-icon">📋</span>
                <div class="stat-number">${totalDisewa}</div>
                <div class="stat-label">Sedang Disewa</div>
            </div>
        </div>

        <!-- Table -->
        <div class="table-container">
            <table>
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Gambar</th>
                        <th>Mobil</th>
                        <th>Tahun</th>
                        <th>Warna</th>
                        <th>Harga Sewa/Hari</th>
                        <th>Status</th>
                        <th>Aksi</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${mobilList}" var="mobil" varStatus="loop">
                        <tr>
                            <td>${loop.index + 1}</td>
                            <td>
                                <img class="car-img" src="${mobil.gambarUrl}" alt="${mobil.nama}"
                                     onerror="this.style.display='none'">
                            </td>
                            <td>
                                <div class="car-info">
                                    <div class="car-name">${mobil.nama}</div>
                                    <div class="car-merk">${mobil.merk}</div>
                                </div>
                            </td>
                            <td>${mobil.tahun}</td>
                            <td>${mobil.warna}</td>
                            <td>
                                <span class="price">Rp <fmt:formatNumber value="${mobil.hargaSewaPerHari}" pattern="#,###"/></span>
                            </td>
                            <td>
                                <span class="badge ${mobil.status == 'Tersedia' ? 'badge-tersedia' : 'badge-disewa'}">
                                    ${mobil.status}
                                </span>
                            </td>
                            <td>
                                <div class="action-buttons">
                                    <a href="mobil-form?id=${mobil.id}" class="btn-edit">✏️ Edit</a>
                                    <a href="mobil-delete?id=${mobil.id}" class="btn-delete"
                                       onclick="return confirm('Yakin ingin menghapus ${mobil.nama}?')">
                                        🗑️ Hapus
                                    </a>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty mobilList}">
                        <tr>
                            <td colspan="8">
                                <div class="empty-state">
                                    <span class="empty-icon">🚫</span>
                                    <p>Belum ada data mobil</p>
                                </div>
                            </td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
