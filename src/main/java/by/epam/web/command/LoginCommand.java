package by.epam.web.command;

import by.epam.web.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        LoginService service = new LoginService();
        boolean valid = service.login(login,password);
        if (valid){
            return "/WEB-INF/view/main.jsp";
        } else {
            request.setAttribute("errorMessage", "Invalid creeds");
            return "/login.jsp";
        }


    }
}
