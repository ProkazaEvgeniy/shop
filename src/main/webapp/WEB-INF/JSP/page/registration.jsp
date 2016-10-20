<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="row">
	<div class="panel panel-default">
		<div class="panel-heading text-centr">Registration (Регистрация)</div>
		<div class="panel-body">
			<form action="/registration" method="post">
				<div class="form-group">
					<label>Name (Ваше имя)</label> 
					<input name="name" class="form-control" placeholder="Your Name">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Email (Ваш email)</label> 
					<input name="email" type="email" class="form-control" id="exampleInputEmail" placeholder="Your Email">
				</div>
				<%--
				<div class="form-group">
					<label for="exampleInputFile">Select a file to an avatar (выбрать файл для аватара)</label> 
					<input type="file" id="exampleInputFile" name="avatarUrl">
				</div>
				 --%>
				<div class="text-center">
					<button type="submit" class="btn btn-default">Submit (Отправить)</button>
				</div>
			</form>
		</div>
	</div>
</div>
