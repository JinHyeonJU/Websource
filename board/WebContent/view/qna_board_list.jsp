<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<!-- Main content -->
<section class="content">
	<div class="box box-primary">
		<div class="box-header">
			<h3 class="box-title" style="font-size:21px; font-style:bold">전체게시글</h3>
		</div>
		<div class="row">
			<div class="col-md-4"><!--글쓰기 버튼-->
				<input type="button" value="글작성" class="btn btn-success" onclick="location.href='view/qna_board_write.jsp'"/>
			</div>
			<div class="col-md-4 offset-md-4"><!--검색 들어갈 부분-->
			</div>
		</div>
		<br>
		<table class="table table-bordered">
			<tr>
				<th class='text-center' style='width:100px'>번호</th>
				<th class='text-center'>제목</th>
				<th class='text-center'>작성자</th>
				<th class='text-center'>날짜</th>
				<th class='text-center' style='width:100px'>조회수</th>
			</tr>
			<c:forEach var="vo" items="${list}">
			<tr><!-- 리스트 목록 보여주기 -->
				<td class='text-center'>${vo.bno}</td><!--번호-->
				<!-- qHitUpdate로 보내는 이유 : 새로고침으로 조회수 증가 방지 -->
				<td><a href="qHitUpdate.do?bno=${vo.bno}">${vo.title}</a></td><!--제목-->
				<td class='text-center'>${vo.name}</td><!--작성자-->
				<td class='text-center'>${vo.regdate}</td><!--날짜-->
				<td class='text-center'><span class="badge badge-pill badge-primary">${vo.readcount}</span></td>
			</tr>		
			</c:forEach>
		</table>
		<div class="container">
			<div class="row  justify-content-md-center">
				<nav aria-label="Page navigation example">
				  <ul class="pagination"><!--하단의 페이지 나누기 부분-->
					<c:if test="${info.prev}">
						<li class="page-item">
							<a href="" class="gage-link">이전</a>
						</li>
					</c:if>
					<c:forEach begin="${info.startPage}" end="${info.endPage}" var="idx">
						<c:choose>
							<c:when test="${idx==info.search.page}">
								<li class="page-ltem active"><a class="page-link">${idx}</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-ltem"><a class="page-link" href="">${idx}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${info.next}">
						<li class="page-item">
							<a href="" class="page-link">다음</a>
						</li>
					</c:if>
				  </ul>
				</nav>					
			</div>
		</div>
		<div style="height:20px"></div>
	</div>	
</section>
<%@include file="../include/footer.jsp"%>
