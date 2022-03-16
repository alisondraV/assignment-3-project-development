package web;

import Util.EmployeeHandler;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "EmployeeController", value = "/employee-controller")
public class EmployeeController extends HttpServlet {
    private final EmployeeHandler empHandler;
    private static final String EMP_SIGNUP = "/signup.jsp";
    private static final String EMP_LOGIN = "/login.jsp";
    private static final String EMP_SUCCESS = "/success.jsp";

    public EmployeeController() throws ClassNotFoundException {
        super();
        empHandler = new EmployeeHandler();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pageName = request.getParameter("pageName");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String forward = "";

        if (empHandler != null) {
            if (pageName.equals("signup")) {
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String emailAddress = request.getParameter("emailAddress");
                Date hireDate = Date.valueOf(request.getParameter("hireDate"));

                if (empHandler.findByEmployeeName(request.getParameter("userName"))) {
                    forward = EMP_SIGNUP;
                    RequestDispatcher view = request.getRequestDispatcher(forward);
                    view.forward(request, response);
                    return;
                }
                empHandler.save(userName, password, firstName, lastName, emailAddress, hireDate);
                forward = EMP_LOGIN;
            } else if (pageName.equals("login")) {
                boolean result = empHandler.findByLogin(userName, password);
                if (result) {
                    forward = EMP_SUCCESS;
                } else {
                    String message = "User does not exist";
                    request.setAttribute("message", message);
                    forward = EMP_LOGIN;
                }
            }
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
}
