package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class doRegistration_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      beans.registration reg = null;
      synchronized (session) {
        reg = (beans.registration) _jspx_page_context.getAttribute("reg", PageContext.SESSION_SCOPE);
        if (reg == null){
          reg = new beans.registration();
          _jspx_page_context.setAttribute("reg", reg, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\n');
      out.write('\n');
      beans.errormessage errorReg = null;
      synchronized (session) {
        errorReg = (beans.errormessage) _jspx_page_context.getAttribute("errorReg", PageContext.SESSION_SCOPE);
        if (errorReg == null){
          errorReg = new beans.errormessage();
          _jspx_page_context.setAttribute("errorReg", errorReg, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"stile/stile.css\">\n");
      out.write("        <title>Registering user</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Sto elaborando</h1>\n");
      out.write("        ");

            //prendo tutti i dati della registrazione dalla pagina registrazione.jsp
            reg.setNome(request.getParameter("nomeUtente"));
            reg.setCognome(request.getParameter("cognomeUtente"));
            reg.setUsername(request.getParameter("usernameUtente"));
            reg.setPassword(request.getParameter("passwordUtente"));

            if (reg.isUsernameValid()) {
                reg.registerUser();
                response.sendRedirect("index.jsp");
            } else {
                errorReg.setMessage("Username non valido");
                response.sendRedirect("registrazione.jsp");
            }

        
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
