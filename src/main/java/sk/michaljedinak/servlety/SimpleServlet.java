package sk.michaljedinak.servlety;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet( urlPatterns =  { "/simpleservlet" , "/newservlet"} )
public class SimpleServlet extends  HttpServlet {

      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String name = req.getParameter("name");
            String surname = req.getParameter("surname");
            PrintWriter out = resp.getWriter();            
            out.println("<!DOCTYPE html> <html><body>");
            out.print("<h2>Som v Simple Servlet </h2>");
            out.println("<br>");
            out.printf("name : %s",name);
            out.println("<br>");
            out.printf("surname : %s",surname);


            HttpSession session = req.getSession();
            ServletContext context = req.getServletContext();
            if( name !=null && !name.isEmpty() ){
                  session.setAttribute("storedname", name);
                  context.setAttribute("contextstoredname", name);
            }
            out.println("<br>");
            out.printf("storedname : %s",session.getAttribute("storedname"));

            out.println("<br>");
            out.printf("contextstoredname : %s",context.getAttribute("contextstoredname"));
           
            String filterAtribut =(String) req.getSession().getAttribute("filterAtribute") ;
            out.println("<br>");
            out.printf("filterAtribut : %s",filterAtribut);

            String contextAtribut =(String) req.getServletContext().getAttribute("filter") ;
            out.println("<br>");
            out.printf("contextAtribut : %s",contextAtribut);


            out.println("</body></html>");
      }

      @Override
      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String name = req.getParameter("name");
            String page = req.getParameter("page");
            String surname = req.getParameter("surname");
            String gender = req.getParameter("genders");
            String country = req.getParameter("country");
            String[] animal = req.getParameterValues("animals");//pri option multi
          //  resp.sendRedirect(String.format("simplesrvlet?name=%s&page=%s",name ,page));
    
            PrintWriter out = resp.getWriter();
            out.println("<!DOCTYPE html> <html><body>");
            out.println("<br>");
            out.printf("name : %s",name);
            out.println("<br>");
            out.printf("surname : %s ",surname);
            out.println("<br>");
            out.printf("gender :%s", gender);
            out.println("<br>");
            out.printf("country :%s", country);
            out.println("<br>");
            out.printf("name : %s ",page);
            out.println("<br>");
            for(int i = 0;i<animal.length;i++){
                  String gap =" ";
                  out.printf("  %s ", gap + animal[i] + ";\n");                 
            }

            out.println("</body></html>");
      }
      
}
