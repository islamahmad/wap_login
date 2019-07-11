import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        //form action is dologin & method is post
        String form = "<!DOCTYPE html> <html lang=\"en\"> <head> <meta charset=\"UTF-8\"> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\"> <title>Login Page</title></head><body><form action=\"dologin\" method=\"POST\"> <label> Email <input type=\"email\" name=\"email\" id=\"email\" value=\"me@islam\"> </label> <label> Password <input type=\"password\" name=\"password\" id=\"password\" value=\"pass\"> </label> <input type=\"submit\" value=\"Login\"> </form> </body></html>";
        //LoginSession customSession = new LoginSession(null,false);
        // those will not work because the request has been completed by the doGet before calling the doPost.
        req.getSession().setAttribute("user",null);
        out.println(form);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
