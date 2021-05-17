package session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// WebSessionをクリアするためのサーブレット。
@WebServlet("/SessionOut")
public class SessionOut extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public SessionOut() {
    super();
  }
  // メソッドGET方式で要請すれば呼ばれる関数。
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // WebSessionからTestSessionキーのデータを初期化する。
    request.getSession().setAttribute("TestSession", null);
    // Web応答は「Session Clear」にする。
    response.getWriter().append("Session Clear ");
  }
  // メソッドPOST方式でも要請すれば呼ばれる関数。処理はGETと同じ。
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}