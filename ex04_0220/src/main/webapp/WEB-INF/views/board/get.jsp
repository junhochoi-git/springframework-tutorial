<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 상대 경로를 이용하여, header 포함시키기 -->
<!-- JSTL의 출력과 포맷을 적용할 수 있는 태그 라이브러리 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>
<!-- 해당 전 까지 header.jsp에 작성하고 인클루드 하는 형식으로 구현할래  -->
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Read</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Read Page</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<!-- form  -->
				<!-- 조회 하는 bno 표시 -->
				<div class="form-group">
					<label>Bno</label> <input class="form-control" name="bno"
						readonly="readonly" value='<c:out value = "${board.bno}"/>'>
				</div>
				<div class="form-group">
					<label>Title</label> <input class="form-control" name="title"
						readonly="readonly" value='<c:out value = "${board.title}"/>'>
				</div>
				<div class="form-group">
					<label>Content</label>
					<!-- content는 보여줘야하니까 -->
					<textarea class="form-control" rows="5" cols="50" name="content"
						readonly="readonly"><c:out value="${board.content}" /></textarea>
				</div>
				<div class="form-group">
					<label>Writer</label> <input class="form-control" name="writer"
						readonly="readonly" value='<c:out value = "${board.writer}"/>'>
				</div>
	
				<!-- a태그 말고 form 태그 하자 -->
				<!-- actionForm for pagination -->
				<form id="actionForm" action="/board/list" method="get">
					<input type="hidden" name="pageNum" value="${cri.pageNum}">
					<input type="hidden" name="amount" value="${cri.amount}">
					<!-- javascript에서 jQuery이용해 여기에 append 하게 됨 -->
					<input type="hidden" name="bno" value="${board.bno}">
					
					<!-- type과 키워드 추가해줘야지 modelAttribute 이용 cri.xxx -->
					<input type="hidden" name="type" value="${cri.type}">					
					<input type="hidden" name="keyword" value="${cri.keyword}">					
				</form>
				
				<!-- a태그로 -->
				<button data-oper="modify" class="btn btn-default modBtn">
					<a href="/board/modify?bno=<c:out value="${board.bno}"/>">Modify</a>
				</button>
				<button data-oper="list" class="btn btn-default listBtn">
					<a href="/board/list">List</a>
				</button>
				
				
				<!-- 0305_ modulize reply.js -->
				<script src="/resources/js/reply.js"></script>
				<script>
				/* 0305 자바 스크립트 모듈화 확인*/
				$(document).ready(function(){
					console.log(replyService);
					});
				
				</script>
				
				<!-- 자바 스크립트  -->
				<script>
					
					
									
					var actionForm=$("#actionForm");
					
					$(".listBtn").click(function(e){
						e.preventDefault();
						//find list로 갈땐 url에 bno가 굳이 필요없으니까 
						actionForm.find("input[name='bno']").remove();
						actionForm.submit();
					});

					$(".modBtn").click(function(e){
						e.preventDefault();
						//find list로 갈땐 url에 bno가 굳이 필요없으니까 
						actionForm.attr("action","/board/modify");
						actionForm.submit();
					});
				</script>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>

<!-- /.row -->
<!-- /.row -->
<!-- /.row 잘라냄 -->
<!-- page-wrapper 끝나는 곳 부터 잘라낸다 footer를 위해  -->
<%@include file="../includes/footer.jsp"%>