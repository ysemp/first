<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>WebContent/member/insertForm.jsp</h1>

<h1>회원가입</h1>
<form action="./MemberInsertAction.me" method="post" name="fr">
 
아이디 : <input type="text" name="member_id">
<input type="button" value="아이디 중복 체크" class="dup" onclick="idCheck()"><br>
비밀번호 : <input type="password" name="member_pass"><br>
비밀번호 재입력 : <input type="password" name="pass2"><br>
성명 : <input type="text" name="member_name"><br>
전화번호 : <input type="text" name="member_tel"><br>
선호 장르 : <br>
1 : <input type="radio" name="genre_code" value="1">액션<br>
2 : <input type="radio" name="genre_code" value="2">스릴러<br>
3 : <input type="radio" name="genre_code" value="3">드라마<br>
4 : <input type="radio" name="genre_code" value="4">멜로/로맨스<br>
5 : <input type="radio" name="genre_code" value="5">범죄<br>
6 : <input type="radio" name="genre_code" value="6">어드벤처<br>
7 : <input type="radio" name="genre_code" value="7">SF<br>
8 : <input type="radio" name="genre_code" value="8">성인물<br>
9 : <input type="radio" name="genre_code" value="9">가족<br>
10 : <input type="radio" name="genre_code" value="10">공포/호러<br>
11 : <input type="radio" name="genre_code" value="11">다큐멘터리<br>
12 : <input type="radio" name="genre_code" value="12">코미디<br>
13 : <input type="radio" name="genre_code" value="13">애니메이션<br>

<input type="hidden" name="man_grade" value="1"><br>
<input type="submit" value="회원가입">
</form>
</body>
</html>
