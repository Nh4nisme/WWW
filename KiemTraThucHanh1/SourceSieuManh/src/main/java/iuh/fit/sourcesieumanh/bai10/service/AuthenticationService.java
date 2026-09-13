package iuh.fit.sourcesieumanh.bai10.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthenticationService {
    public boolean authenticate(String u, String p) {
        return "student".equals(u) && "123456".equals(p);
    }
}
