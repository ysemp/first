package net.member.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberInsertAction implements Action{

	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberInsertAction execute()");
		//한글처리
				request.setCharacterEncoding("utf-8");
				//자바빈  MemberBean mb 객체 생성
				MemberBean mb=new MemberBean();
				// set호출 <= 폼 파라미터 가져와서 저장 
				mb.setMember_id(request.getParameter("member_id"));
				mb.setMember_pass(request.getParameter("member_pass"));
				mb.setMember_name(request.getParameter("member_name"));
				mb.setMember_tel(request.getParameter("member_tel"));
				mb.setGenre_code(Integer.parseInt(request.getParameter("genre_code")));
				mb.setMan_grade(request.getParameter("man_grade"));
				//MemberDAO mdao 객체 생성
				MemberDAO mdao=new MemberDAO();
				// insertMember(자바빈 변수) 호출
				mdao.insertMember(mb);
				
				// ActionForward forward 객체 생성
				ActionForward forward=new ActionForward();
				//이동 정보저장   ./MemberLogin.me  
				// localhost:8080/Model2/MemberLogin.me  
				forward.setPath("./MemberInsert.me");
				forward.setRedirect(true);
				return forward;
		
	}

}
