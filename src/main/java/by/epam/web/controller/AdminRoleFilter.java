package by.epam.web.controller;

import by.epam.web.entity.CommandResult;
import by.epam.web.enums.Role;
import by.epam.web.enums.Url;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminRoleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        String userActive = (String)session.getAttribute("active");
        String command = request.getParameter("command");
        if (userActive!=null && userActive.equals("ban")){
            request.getRequestDispatcher(Url.BAN_PAGE.getUrl()).forward(request, servletResponse);
        }
//        if (session.getAttribute("role") == null || !session.getAttribute("role").equals(Role.ADMIN.toString())) {

        else if (command == null || (!command.equals("login") && session.getAttribute("role") == null)) {
            request.getRequestDispatcher(Url.LOGIN_PAGE.getUrl()).forward(request, servletResponse);
        } else {
            filterChain.doFilter(request, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
