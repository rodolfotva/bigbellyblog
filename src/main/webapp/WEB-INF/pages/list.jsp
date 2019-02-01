<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="row" ng-if="postMain">
	<div class="col-lg-12 post-all" >
		<div class="row">
			<div class="col-lg-12 post-title">
				<span>{{postMain.title}}</span>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12 post-address" ng-if="postMain.address[0]">
				<span>{{postMain.address[0].number}}, {{postMain.address[0].street}}, {{postMain.address[0].city}}-{{postMain.address[0].province}}</span>
			</div>
		</div>		
		<div class="row">
			<div class="col-lg-12 post-date">
				<span>{{postMain.postDate | date}}</span>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12 post-stars">
				<span ng-repeat="star in rateCalculation(postMain.rate) track by $index" class="{{star}} rate-checked"></span>
			</div>
		</div>		
		<div class="row">
			<div class="col-lg-12 post-content" >
				<span>{{postMain.contentEn}}</span>
			</div>
		</div>
		<div class="row pics-group">
			<div ng-repeat="pic in postMain.pics" class="col-lg-3" >
				<img ng-src="{{pic}}" class="post-pic">
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12 icons-group">
				<div class="icons-unit">
					<span class="post-icons" data-toggle="tooltip" title="Visitors" onmouseenter="$(this).tooltip('show')"><i class="far fa-eye"></i></span>
					<span>{{postMain.visitors}}</span>
				</div>			
				<div class="icons-unit">
					<a href="#" onClick="blablabla()" >
						<span class="post-icons" data-toggle="tooltip" title="Unlike" onmouseenter="$(this).tooltip('show')"><i class="far fa-thumbs-down"></i></span>
					</a>			
					<span>{{postMain.dislike}}</span>
				</div>
				<div class="icons-unit">
					<a href="#" onClick="blablabla()" >
						<span class="post-icons" data-toggle="tooltip" title="Like" onmouseenter="$(this).tooltip('show')"><i class="far fa-thumbs-up"></i></span>
					</a>			
					<span>{{postMain.like}}</span>
				</div>
				<div class="icons-unit">
					<a href="{{postMain.facebook}}" target="_blank" >
						<span class="post-icons" data-toggle="tooltip" title="Facebook" onmouseenter="$(this).tooltip('show')"><i class="fab fa-facebook-square"></i></span>
					</a>
				</div>
				<div class="icons-unit">
					<a href="{{postMain.tripadvisor}}" target="_blank" >
						<span class="post-icons" style="color: Green;" data-toggle="tooltip" title="Trip Advisor" onmouseenter="$(this).tooltip('show')"><i class="fab fa-tripadvisor"></i></span>
					</a>
				</div>
				<div class="icons-unit">
					<a href="{{postMain.facebook}}" target="_blank" data-toggle="tooltip" title="Web Site" onmouseenter="$(this).tooltip('show')">
						<span class="post-icons" style="color: Black;" ><i class="fas fa-laptop"></i></span>
					</a>
				</div>
			</div>
		</div>
	</div>
</div>

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