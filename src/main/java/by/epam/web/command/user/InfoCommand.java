package by.epam.web.command.user;

import by.epam.web.command.Command;
import by.epam.web.entity.CommandResult;
import by.epam.web.enums.Url;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InfoCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        if (session.getAttribute("id")!=null) {
            return CommandResult.forward(Url.INFO_PAGE);
        }
        else {
            return CommandResult.forward(Url.LOGIN_CMD);
        }
    }
}