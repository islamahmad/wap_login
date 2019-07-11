import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class dologin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    // add a button to invalidate the session (i.e log out)

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc = this.getServletContext();
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        if(req.getParameter("email").equals("me@islam") && req.getParameter("password").equals("pass")){
            session.setAttribute("user", new LoginSession(req.getParameter("email"),true));

            out.print("Login Successfully \n");
            String signedInUserEmail = ((LoginSession) session.getAttribute("user")).email;
//            Enumeration<String> sessionAttriubtes = session.getAttributeNames();
//            String name;
//            Object value;
//            while(sessionAttriubtes.hasMoreElements()){
//                name = sessionAttriubtes.nextElement();
//                value = session.getAttribute(name);
//                out.print("NAME "+name+" value "+value);
//            }
        }else{
            out.print("<html><head><title>Login</title></head><body>");
            out.print("<p style=\"color: red\">Login Failed </p>");//using: "+email+" and pass "+password+"
            out.print("</body></html>");
        }
    }
}
