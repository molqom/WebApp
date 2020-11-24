package by.epam.web.command;

import by.epam.web.service.LoginService;
import by.epam.web.service.RegistrationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String repeatPassword = request.getParameter("repeat-password");

        RegistrationService service = new RegistrationService();
        boolean valid = service.registration(login,password, repeatPassword);
        if (valid){
            request.setAttribute("successMessage", "Registration is success! Now you can log in");
            return "/login.jsp";
        } else {
            request.setAttribute("errorMessage", "Invalid creeds");
            return "/registration.jsp";
        }
    }
}
