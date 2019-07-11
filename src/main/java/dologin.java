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
//        super.doGet(req, resp);
    }

    // add a button to invalidate the session (i.e log out)

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc = this.getServletContext();
        PrintWriter out = resp.getWriter();
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        String email = req.getParameter("email");
        if(email.equals("me@islam") && password.equals("pass")){
            session.setAttribute("name", "LoggedIn");
            out.print("Login Successfully \n");
            Enumeration<String> sessionAttriubtes = session.getAttributeNames();
            String name;
            Object value;
            while(sessionAttriubtes.hasMoreElements()){
                name = sessionAttriubtes.nextElement();
                value = session.getAttribute(name);
                out.print("NAME "+name+" value "+value);
            }
        }else{
            out.print("<html><head><title>Login</title></head><body>");
            out.print("<p style=\"color: red\">Login Failed </p>");//using: "+email+" and pass "+password+"
            out.print("</body></html>");
        }
    }
}
