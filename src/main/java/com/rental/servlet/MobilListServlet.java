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
import java.util.List;

@WebServlet("/dashboard")
public class MobilListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login");
            return;
        }

        MobilDAO dao = new MobilDAO();
        List<Mobil> mobilList = dao.getAllMobil();
        int totalMobil = dao.countMobil();
        int totalTersedia = dao.countByStatus("Tersedia");
        int totalDisewa = dao.countByStatus("Disewa");

        request.setAttribute("mobilList", mobilList);
        request.setAttribute("totalMobil", totalMobil);
        request.setAttribute("totalTersedia", totalTersedia);
        request.setAttribute("totalDisewa", totalDisewa);

        request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
    }
}
