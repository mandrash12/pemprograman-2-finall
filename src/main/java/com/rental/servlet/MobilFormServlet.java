package com.rental.servlet;

import com.rental.dao.MobilDAO;
import com.rental.model.Mobil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/mobil-form")
public class MobilFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login");
            return;
        }

        String idParam = request.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            int id = Integer.parseInt(idParam);
            Mobil mobil = new MobilDAO().getMobilById(id);
            request.setAttribute("mobil", mobil);
        }

        request.getRequestDispatcher("/mobil-form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login");
            return;
        }

        String id = request.getParameter("id");
        String nama = request.getParameter("nama");
        String merk = request.getParameter("merk");
        int tahun = Integer.parseInt(request.getParameter("tahun"));
        String warna = request.getParameter("warna");
        double hargaSewaPerHari = Double.parseDouble(request.getParameter("hargaSewaPerHari"));
        String status = request.getParameter("status");
        String gambarUrl = request.getParameter("gambarUrl");

        Mobil mobil = new Mobil();
        mobil.setNama(nama);
        mobil.setMerk(merk);
        mobil.setTahun(tahun);
        mobil.setWarna(warna);
        mobil.setHargaSewaPerHari(hargaSewaPerHari);
        mobil.setStatus(status);
        mobil.setGambarUrl(gambarUrl);

        MobilDAO dao = new MobilDAO();
        if (id != null && !id.isEmpty()) {
            mobil.setId(Integer.parseInt(id));
            dao.updateMobil(mobil);
        } else {
            dao.insertMobil(mobil);
        }

        response.sendRedirect("dashboard");
    }
}
