package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sec01.ex01.MemberDAO;
import sec01.ex01.MemberVO;

// @WebServlet("/member")
public class MemberServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        sec01.ex01.MemberDAO dao = new MemberDAO();
        List<sec01.ex01.MemberVO> list = dao.listMembers();

        out.print("<html><body>");
        out.print("<table  border=1><tr align='center' bgcolor='lightgreen'>");
        out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td></tr>");

        for (int i = 0; i < list.size(); i++) {
            sec01.ex01.MemberVO memberVO = (MemberVO) list.get(i);
            String id = memberVO.getId();
            String pwd = memberVO.getPwd();
            String name = memberVO.getName();
            String email = memberVO.getEmail();
            Date joinDate = memberVO.getJoinDate();
            out.print("<tr><td>" + id + "</td><td>" +
                pwd + "</td><td>" +
                name + "</td><td>" +
                email + "</td><td>" +
                joinDate + "</td></tr>");
        }
        out.print("</table></body></html>");
    }
}