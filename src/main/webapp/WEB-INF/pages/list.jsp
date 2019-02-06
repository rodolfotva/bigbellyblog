<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div ng-include = "'postmain'"></div>

<div class="row" style="padding-top:50px">
	<div class="col-lg-12 most-recent" >
		<h3><spring:message code="page2.explanation" /></h3>
	</div>
</div>
		
<div class="starter-list-template">
	<div class="row">
		<div class="col-lg-12 sort-by-box">
			<spring:message code="page2.sortBy" />&nbsp;
			<select ng-model="selectedSort" ng-change="sortPostList()">
				<option value="title"><spring:message code="default.name" /></option>
				<option value="city"><spring:message code="default.city" /></option>
				<option value="postDate"><spring:message code="default.postdate" /></option>
			</select>
		</div>
	</div>

	<div class="row">
		<div class="col-lg-12 post-all" >
			<table class="table table-striped">
				<thead>
					<tr>
						<th></th>
						<th><spring:message code="default.name" /></th>
						<th><spring:message code="default.city" /></th>
						<th><spring:message code="default.postdate" /></th>
					</tr>
				</thead>
				<tbody ng-repeat="post in posts | orderBy:sortListBy:reverse">
					<tr>
						<th><p ng-click="addVisitorDir(post, 1)"><img src="<c:url value="/static/images/cutlery.png" />" height="32" width="32" /></p></td>
						<td>{{post.title}}</td>
						<td>{{post.address[0].city}}</td>
						<td>{{post.postDate | date}}</td>
					</tr>
				</tbody>		
			</table>
		</div>
	</div>
	
	<div class="row justify-content-end">
		<div class="col-lg-12 pagination-box">
			<ul class="pagination">
                <li ng-repeat="page in pages" ng-class="{active:currentPage === page}" class="li-pagination">
                    <a ng-click="fetchPagination(page, dataPerPage, sortListBy, asc)">{{page}}</a>
                </li>                
            </ul>
		</div>
	</div>
	
</div>