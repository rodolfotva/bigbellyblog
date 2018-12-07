<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="row">
	<div ng-repeat="post in posts" class="col-md-12" >
		<div class="row">
			<div class="col-md-12">
				<span>{{post.title}}</span>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<span>{{post.postDate}}</span>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<span>{{post.rate}}</span>
			</div>
		</div>		
		<div class="row">
			<div class="col-md-12">
				<span>{{post.contentEn}}</span>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">
				<span>{{post.website}}</span>
			</div>
			<div class="col-md-2">
				<span>{{post.tripadvisor}}</span>
			</div>
			<div class="col-md-2">
				<span>{{post.facebook}}</span>
			</div>
			<div class="col-md-2">
				<span>{{post.like}}</span>
			</div>
			<div class="col-md-2">
				<span>{{post.dislike}}</span>
			</div>
			<div class="col-md-2">
				<span>{{post.visitors}}</span>
			</div>
		</div>
		<br/><br/><br/>
		<div>**********************************NEXT****************************************</div>
	</div>
	
</div>