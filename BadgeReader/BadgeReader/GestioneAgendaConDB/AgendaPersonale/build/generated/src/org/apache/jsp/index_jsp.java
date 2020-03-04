package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      beans.login log = null;
      synchronized (session) {
        log = (beans.login) _jspx_page_context.getAttribute("log", PageContext.SESSION_SCOPE);
        if (log == null){
          log = new beans.login();
          _jspx_page_context.setAttribute("log", log, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\n');
      out.write('\n');
      beans.errormessage errorLog = null;
      synchronized (session) {
        errorLog = (beans.errormessage) _jspx_page_context.getAttribute("errorLog", PageContext.SESSION_SCOPE);
        if (errorLog == null){
          errorLog = new beans.errormessage();
          _jspx_page_context.setAttribute("errorLog", errorLog, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"stile/stile.css\" />\n");
      out.write("        <title>Login</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Inserisci le tue credenziali!</h1>\n");
      out.write("        <form action=\"doLogin.jsp\" >\n");
      out.write("            <p> username: <input type=\"text\"  name=\"username\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${log.username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"> </p>\n");
      out.write("            <p> password: <input type=\"password\"  name=\"password\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${log.password}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"> </p>\n");
      out.write("            <p> <button type=\"submit\" value=\"login\">login</button></p>\n");
      out.write("        </form>\n");
      out.write("        <div class=\"errormessage\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${errorLog.message}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\n");
      out.write("        <a href=\"registrazione.jsp\">registrati subito!</a>\n");
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
