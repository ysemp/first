package net.member.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MemberDAO {
	Connection con=null;
	String sql="";
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	private Connection getConnection() throws Exception{		
		Context init=new InitialContext();
		DataSource ds=(DataSource)init.lookup("java:comp/env/jdbc/orcl");
		con=ds.getConnection();
		return con;
	}

	
	public void insertMember(MemberBean mb){
		//자바 예외처리 코드
		 Connection con=null;
		 String sql="";
		 PreparedStatement pstmt=null;
		try {
			//예외가 발생할것같은 코드-> 디비연결
			//1단계 드라이버로더	//2단계 디비연결 //연결정보를 저장하는 내장객체
			con=getConnection();
			 //3단계 sql insert 만들어서 실행 내장객체
			 //Statement PreparedStatement CallableStatement
			 sql="insert into member(member_id,member_pass,member_name,member_tel,Genre_code,man_grade) values(?,?,?,?,?,?)";
			 pstmt=con.prepareStatement(sql);
			 //?값 넣기
			 pstmt.setString(1,mb.getMember_id()); 
			 pstmt.setString(2,mb.getMember_pass()); 
			 pstmt.setString(3,mb.getMember_name()); 
			 pstmt.setString(4,mb.getMember_tel());
			 pstmt.setInt(5,mb.getGenre_code());
			 pstmt.setString(6,mb.getMan_grade());
			 //4단계 sql 실행   insert,update,delete
			 pstmt.executeUpdate();
			 	//"회원가입성공"   loginForm.jsp 이동
		} catch (Exception e) {
			// Exception이 예외를 잡아서 처리->예외발생 메시지 출력
			e.printStackTrace();
		}finally{
			//예외가 발생하던지 안하던지 상관없이 마무리작업수행
			//객체생성 -> 종료  닫기 기억장소 정리
			if(pstmt!=null)
				try{pstmt.close();}catch(SQLException ex){}
			if(con!=null)
				try{con.close();}catch(SQLException ex){}
		}
		
	}
	//userCheck(id,pass)
		public int userCheck(String member_id,String member_pass){
			int check=-1;
			Connection con=null;
			PreparedStatement pstmt=null;
			String sql="";
			ResultSet rs=null;
			try {
				//1단계 드라이버로더
				//2단계 디비연결
				con=getConnection();
				//3단계 sql 조건 id에 해당하는 회원정보를 가져오기
				sql="select * from member where id=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,member_id);
				//4단계 결과저장 <= 실행
				rs=pstmt.executeQuery();
				//5단계 결과를 첫행으로 이동 데이터 있으면
				//     비밀번호 비교 맞으면 check=1
				//               틀리면 check=0
				//                   없으면 check=-1 "아이디없음"
				if(rs.next()){
					//아이디있음
					if(member_pass.equals(rs.getString("member_pass"))){
						check=1;//비밀번호 맞음 세션값생성
					}else{
						check=0;//비밀번호 틀림
					}
				}else{
					check=-1;//아이디없음
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				//마무리  //기억장소 회수
				if(rs!=null)
					try{rs.close();}catch(SQLException ex){}
				if(pstmt!=null)
					try{pstmt.close();}catch(SQLException ex){}
				if(con!=null)
					try{con.close();}catch(SQLException ex){}
			}
			return check;
		}
		// idCheck(id) 중복체크 함수()
		 public int idCheck(String member_id){
			 Connection con=null;
			 PreparedStatement pstmt=null;
			 String sql="";
			 ResultSet rs=null;
			 int check = 0;
			 
			 try {
				 // 1,2 디비연결
				 con=getConnection();
				// 3 sql member의 모든 정보 가져오기 조건 id = 일치하면
				 sql="select * from member where id=?";
				 pstmt=con.prepareStatement(sql);
				 pstmt.setString(1,member_id);
				// 4 rs <= 실행 저장
				 rs=pstmt.executeQuery();
				 if(rs.next()){
						//아이디있음
						if(member_id.equals(rs.getString("member_id"))){
							check=1;//
						}else{
							check=0;//
						}
				 }
				 
				 
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//마무리  //기억장소 회수
				if(rs!=null)
					try{rs.close();}catch(SQLException ex){}
				if(pstmt!=null)
					try{pstmt.close();}catch(SQLException ex){}
				if(con!=null)
					try{con.close();}catch(SQLException ex){}
			}
			 return check;
			 
		 }

}
