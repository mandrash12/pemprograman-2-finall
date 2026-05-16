import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SuhendraServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Data Mahasiswa</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>DATA DIRI</h1>");
        out.println("<hr>");

        out.println("<p><b>Nama :</b> Suhendra</p>");
        out.println("<p><b>NIM :</b> 231011400983</p>");
        out.println("<p><b>Jurusan :</b> Teknik Informatika</p>");
        out.println("<p><b>Mata Kuliah :</b> Pemrograman Servlet Java</p>");

        out.println("<hr>");
        out.println("<h3>Program Servlet Berhasil Dijalankan</h3>");

        out.println("</body>");
        out.println("</html>");
    }
}