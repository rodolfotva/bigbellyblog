<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="row">
	<div ng-repeat="post in posts" class="col-lg-12" ng-if="$index == 0">
		<div class="row">
			<div class="col-lg-12 post-title">
				<span>{{post.title}}</span>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<h5><span>{{post.postDate | date}}</span></h5>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<span ng-repeat="star in rateCalculation(post.rate) track by $index" class="{{star}} rate-checked"></span>
			</div>
		</div>		
		<div class="row">
			<div class="col-lg-12 post-content" >
				<span>{{post.contentEn}}</span>
			</div>
		</div>
		<div class="row pics-group">
			<div ng-repeat="pic in post.pics" class="col-lg-3" >
				<img src="{{pic}}" height="23%" class="post-pic">
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12 icons-group">
				<div class="icons-unit">
					<span class="post-icons" data-toggle="tooltip" title="Visitors" onmouseenter="$(this).tooltip('show')"><i class="far fa-eye"></i></span>
					<span>{{post.visitors}}</span>
				</div>			
				<div class="icons-unit">
					<a href="#" onClick="blablabla()" >
						<span class="post-icons" data-toggle="tooltip" title="Unlike" onmouseenter="$(this).tooltip('show')"><i class="far fa-thumbs-down"></i></span>
					</a>			
					<span>{{post.dislike}}</span>
				</div>
				<div class="icons-unit">
					<a href="#" onClick="blablabla()" >
						<span class="post-icons" data-toggle="tooltip" title="Like" onmouseenter="$(this).tooltip('show')"><i class="far fa-thumbs-up"></i></span>
					</a>			
					<span>{{post.like}}</span>
				</div>
				<div class="icons-unit">
					<a href="{{post.facebook}}" target="_blank" >
						<span class="post-icons" data-toggle="tooltip" title="Facebook" onmouseenter="$(this).tooltip('show')"><i class="fab fa-facebook-square"></i></span>
					</a>
				</div>
				<div class="icons-unit">
					<a href="{{post.tripadvisor}}" target="_blank" >
						<span class="post-icons" style="color: Green;" data-toggle="tooltip" title="Trip Advisor" onmouseenter="$(this).tooltip('show')"><i class="fab fa-tripadvisor"></i></span>
					</a>
				</div>
				<div class="icons-unit">
					<a href="{{post.facebook}}" target="_blank" data-toggle="tooltip" title="Web Site" onmouseenter="$(this).tooltip('show')">
						<span class="post-icons" style="color: Black;" ><i class="fas fa-laptop"></i></span>
					</a>
				</div>
			</div>
		</div>
	</div>
	<div class="col-lg-12 most-recent">
		<h3>Most Recent</h3>
	</div>
	<div ng-repeat="post in posts" class="col-lg-4 recent-post" ng-if="$index != 0">
		<p><img src="{{post.pics[0]}}" class="recent-post-pic" width="100%" height="25%" ></p>
		<span>{{post.title}}</span>
	</div>
	
</div>