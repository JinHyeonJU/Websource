<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="/book1/view/searchPro.jsp" method="post">
	<div class="form-row">
		<div class="form-group col-6">
			<select name="criteria" id="criteria">
				<option value="code" selected>코드</option>
				<option value="writer">작가</option>
			</select>
			</div>
		<div class="form-group col-6">
			<input type="text" class="form-control" name="keyword" id="keyword" required/>
		</div>
		<div>
			<button type="submit" class="btn btn-primary">입력</button>
			<button type="reset" class="btn btn-secondary">취소</button>
		</div>
	</div>
</form>