<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE-edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/todo.js?ver=8"></script>
</head>
<body>
	<h1>여기는 todo 리스트</h1>
	<form:form>
		<input name="todo" value="${todoone.todo}" placeholder="할일">
		<button>할일 저장</button>
		<table class="list-table">
			<thead>
				<tr>
					<th>할 일</th>
					<th>등록날짜</th>
					<th>등록시간</th>
					<th>완료날짜</th>
					<th>완료시간</th>

					<th>비고</th>
					<th>체크</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty TODOLIST}">
						<c:forEach items="${TODOLIST}" var="td">
							<tr data-seq="${td.seq}">
								<td>${td.todo}</td>
								<td>${td.sdate}</td>
								<td>${td.stime}</td>
								<td>${td.edate}</td>
								<td>${td.etime}</td>
								<c:choose>
									<c:when test="${td.done == 0 }">
										<td class="editbox">수정하기</td>
									</c:when>
									<c:otherwise>
										<td>수정불가</td>
									</c:otherwise>
								</c:choose>
								<td class="donebox"><c:choose>
										<c:when test="${td.done == 0 }">
										미완료
									</c:when>
										<c:otherwise>완료</c:otherwise>
									</c:choose></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<td>비</td>
						<td>어</td>
						<td>있</td>
						<td>어</td>
						<td>요</td>
						<td>오</td>
						<td>?</td>
					</c:otherwise>

				</c:choose>
			</tbody>
		</table>
	</form:form>
</body>
</html>