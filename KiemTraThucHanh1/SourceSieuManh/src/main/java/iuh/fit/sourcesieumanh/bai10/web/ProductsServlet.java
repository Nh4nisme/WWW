package iuh.fit.sourcesieumanh.bai10.web;

import iuh.fit.sourcesieumanh.bai10.service.ProductCatalog;
import iuh.fit.sourcesieumanh.bai10.session.UserSession;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/bai10/products")
public class ProductsServlet extends HttpServlet {

    @Inject
    private ProductCatalog productCatalog;

    @Inject
    private UserSession userSession;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (!userSession.isLoggedIn()) {
            resp.sendRedirect(req.getContextPath() + "/bai10/login");
            return;
        }
        req.setAttribute("products", productCatalog.findAll());
        req.setAttribute("userSession", userSession);
        req.getRequestDispatcher("/WEB-INF/bai10/views/products.jsp").forward(req, resp);
    }
}
