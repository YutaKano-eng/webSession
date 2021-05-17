package session;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// WebSessionにテストデータを格納するためのサーブレット。
@WebServlet("/SessionIn")
public class SessionIn extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public SessionIn() {
    super();
  }
  // メソッドGET方式で要請すれば呼ばれる関数。
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // Query Stringは「param」キーでデータを取得する。
    String param = request.getParameter("param");
    // データが無い場合、「hello world」に基本データに設定する。
    if (param == null || param.isEmpty()) {
      param = "hello world";
    }
    // WebSessionに「TestSession」キーでデータを格納する。
    request.getSession().setAttribute("TestSession", param);
    // Web応答は「Session In OK」にする。
    response.getWriter().append("Session In OK");
  }
  // メソッドPOST方式でも要請すれば呼ばれる関数。処理はGETと同じ。
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}