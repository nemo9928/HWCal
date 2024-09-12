<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="bean.*" %>
<jsp:useBean id="msg" scope="request" class="java.lang.String" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./design.css">
<title>時給計算機</title>
</head>
<body>
	<h1>時給計算機</h1><hr>
	<div class="msgArea">メッセージ:<strong><%= msg%></strong></div><br>
	<div class="main">
		<div class="mainLeft">
		<form action="?" method="post">
			<input type= "submit" name="enterprise" value="企業検索" formaction="/HWCal/search"><br><br></a>
			
				
				月収:<% double mWage = 0;%>
					 <% if(request.getAttribute("mWage") != null) mWage = (double)request.getAttribute("mWage"); %>
					 <input type="number" name="mWage" value="<%= mWage%>">/万円<br>
				休日:<%double holiday = 0;%>
					 <%if(request.getAttribute("holiday") != null) holiday = (double)request.getAttribute("holiday"); %>
					 <input type="number" name="holiday" value="<%= holiday%>">/日（年）<br>
				賞与:<%double bonus = 0;%>
					 <%if(request.getAttribute("bonus") != null) bonus = (double)request.getAttribute("bonus"); %>
					 <input type="number" name="bonus" value="<%= bonus%>">/ヵ月<br>
				手当:<input type="number" name="allowance" value="0.0">/万円（月)<br>
				通勤:<input type="number" name="workTime" value="0.0">/時間(往復)<br>
				<input type="submit" name="btn" value="計算する" formaction="/HWCal/calculate">
			</form>
		</div>
		<div class="mainRight">
			使い方<hr>
			企業検索を押すと企業一覧が表示。<br>
			企業を選択すると月収、休日、賞与が自動入力される。<br><br>
			
			月収を記入(例 20.0)<br>
			年間休日数を記入(例 120)<br>
			賞与を記入(例 4.2)<br>
			月額手当を記入(例 5.0)<br>
			往復通勤時間を記入(例 1.5)<br>
			計算するボタンをおすことで時給が表示されます。
		</div>
	</div>
	<div class="footer">
		<a href="https://github.com/nemo9928"><!--github icon-->
			<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" width="50" height="50"><path d="M8 0c4.42 0 8 3.58 8 8a8.013 8.013 0 0 1-5.45 7.59c-.4.08-.55-.17-.55-.38 0-.27.01-1.13.01-2.2 0-.75-.25-1.23-.54-1.48 1.78-.2 3.65-.88 3.65-3.95 0-.88-.31-1.59-.82-2.15.08-.2.36-1.02-.08-2.12 0 0-.67-.22-2.2.82-.64-.18-1.32-.27-2-.27-.68 0-1.36.09-2 .27-1.53-1.03-2.2-.82-2.2-.82-.44 1.1-.16 1.92-.08 2.12-.51.56-.82 1.28-.82 2.15 0 3.06 1.86 3.75 3.64 3.95-.23.2-.44.55-.51 1.07-.46.21-1.61.55-2.33-.66-.15-.24-.6-.83-1.23-.82-.67.01-.27.38.01.53.34.19.73.9.82 1.13.16.45.68 1.31 2.69.94 0 .67.01 1.3.01 1.49 0 .21-.15.45-.55.38A7.995 7.995 0 0 1 0 8c0-4.42 3.58-8 8-8Z"></path></svg>
		</a><br>
		<small>© </small>
	</div>
</body>
</html>