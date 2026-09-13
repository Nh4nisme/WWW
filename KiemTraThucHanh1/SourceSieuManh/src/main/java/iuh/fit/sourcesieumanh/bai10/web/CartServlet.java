package iuh.fit.sourcesieumanh.bai10.web;

import iuh.fit.sourcesieumanh.bai10.model.Product;
import iuh.fit.sourcesieumanh.bai10.service.ProductCatalog;
import iuh.fit.sourcesieumanh.bai10.session.UserSession;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/bai10/cart/add")
public class CartServlet extends HttpServlet {

    @Inject
    private ProductCatalog productCatalog;

    @Inject
    private UserSession userSession;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        if (!userSession.isLoggedIn()) {
            resp.sendRedirect(req.getContextPath() + "/bai10/login");
            return;
        }

        try {
            long productId = Long.parseLong(req.getParameter("productId"));
            Optional<Product> optionalProduct = productCatalog.findById(productId);
            optionalProduct.ifPresent(product -> userSession.getShoppingCart().add(product));
        } catch (NumberFormatException ignored) {
            // ID không hợp lệ: bỏ qua
        }

        // PRG Pattern: tránh gửi lại request khi refresh
        resp.sendRedirect(req.getContextPath() + "/bai10/products");
    }
}