package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HitungNilai")

public class HitungNilai extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            int hadir = Integer.parseInt(request.getParameter("hadir"));
            int pertemuan = Integer.parseInt(request.getParameter("pertemuan"));

            double tugas = Double.parseDouble(request.getParameter("tugas"));
            double uts = Double.parseDouble(request.getParameter("uts"));
            double uas = Double.parseDouble(request.getParameter("uas"));

            double kehadiran = ((double) hadir / pertemuan) * 100;

            double nilaiAkhir =
                    (kehadiran * 0.1) +
                    (tugas * 0.2) +
                    (uts * 0.3) +
                    (uas * 0.4);

            String grade;
            String status;

            if (nilaiAkhir >= 85) {
                grade = "A";
                status = "Lulus";
            } else if (nilaiAkhir >= 75) {
                grade = "B";
                status = "Lulus";
            } else if (nilaiAkhir >= 65) {
                grade = "C";
                status = "Lulus";
            } else {
                grade = "D";
                status = "Tidak Lulus";
            }

            out.println("<html>");
            out.println("<body>");

            out.println("<h1>Menghitung Nilai</h1>");

            out.println("<table>");

            out.println("<tr>");
            out.println("<td>Jumlah hadir</td>");
            out.println("<td><input type='text' value='" + hadir + "'></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>Jumlah pertemuan</td>");
            out.println("<td><input type='text' value='" + pertemuan + "'></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>Nilai tugas</td>");
            out.println("<td><input type='text' value='" + tugas + "'></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>Nilai UTS</td>");
            out.println("<td><input type='text' value='" + uts + "'></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>Nilai UAS</td>");
            out.println("<td><input type='text' value='" + uas + "'></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>Nilai Akhir</td>");
            out.println("<td><input type='text' value='" + nilaiAkhir + "'></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>Grade</td>");
            out.println("<td><input type='text' value='" + grade + "'></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>Status</td>");
            out.println("<td><input type='text' value='" + status + "'></td>");
            out.println("</tr>");

            out.println("</table>");

            out.println("<br>");

            out.println("<input type='button' value='Kembali' onclick='history.back()'>");

            out.println("</body>");
            out.println("</html>");

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}