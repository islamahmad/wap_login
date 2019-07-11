import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


public class dologin extends HttpServlet {
    Users users = new Users();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    // add a button to invalidate the session (i.e log out)

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc = this.getServletContext();
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
//        if (session.getAttribute("user") == null) {
//            out.print("session attribute (user) is null");
//        }
        if (users.users.get(email)!=null){
            out.print("User is correct"); // email entered exist in the map
            if (users.users.get(email).getPassword().equals(password)){
                out.print("User and Password are correct");
                session.setAttribute("user", new LoginSession(req.getParameter("email"),true));
                out.print("Login Successfully \n");
                String signedInUserEmail = ((LoginSession) session.getAttribute("user")).email;
                if (session.getAttribute("user") != null) {
                    out.print("inside 2nd if");
                }
            }
        }else{
            out.print("<html><head><title>Login</title></head><body>");
            out.print("<p style=\"color: red\">Login Failed </p>");//using: "+email+" and pass "+password+"
            out.print("</body></html>");
        }
    }
}
