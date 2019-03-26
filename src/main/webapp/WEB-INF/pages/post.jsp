<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="row">
	<div ng-include = "'postmain'"></div>
	
	<div class="col-lg-12 most-recent">
		<h3><spring:message code="page.manager.post.mostrecent" /></h3>
	</div>
	<div ng-repeat="post in posts" class="col-lg-4 recent-post" >
		<p><img ng-src="{{post.pics[0]}}" class="recent-post-pic" width="100%" height="20%" ng-click="addVisitorDir(post, 1)"></p>
		<span>{{post.title}}</span>
	</div>
	
</div>