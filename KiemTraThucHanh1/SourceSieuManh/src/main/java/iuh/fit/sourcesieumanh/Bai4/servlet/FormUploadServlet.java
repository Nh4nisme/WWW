package iuh.fit.sourcesieumanh.Bai4.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/processFormUpload")
@MultipartConfig(
        fileSizeThreshold = 1024*1024,
        maxFileSize = 1024*1024*10,
        maxRequestSize = 1024*1024*15
)
public class FormUploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String[] hobbies = req.getParameterValues("hobbies"); // mảng vì checkbox
        String country = req.getParameter("country");
        String birthDate = req.getParameter("birthDate");

        // Lấy và lưu file
        Part filePart = req.getPart("profilePic");
        String fileName = filePart.getSubmittedFileName();
        String uploadPath = System.getProperty("user.home") + File.separator + "uploads";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();
        if (fileName != null && !fileName.isEmpty()) {
            filePart.write(uploadPath + File.separator + fileName);
        }

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<h2>Form Data Received:</h2>");
        out.println("Name: " + name + "<br>");
        out.println("Password: " + password + "<br>");
        out.println("Gender: " + gender + "<br>");
        out.println("Hobbies: " + (hobbies != null ? String.join(", ", hobbies) : "None") + "<br>");
        out.println("Country: " + country + "<br>");
        out.println("Birth Date: " + birthDate + "<br>");
        out.println("Uploaded File: " + (fileName != null ? fileName : "No file"));
    }
}
