<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="row" ng-if="postMain != null">
	<div class="col-lg-12 post-all" >
		<div class="row">
			<div class="col-lg-12 post-title">
				<span>{{postMain.title}}</span>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12 post-address" >
				<span>{{postMain.addressNumber}}, {{postMain.addressStreet}}, {{postMain.addressCity}}-{{postMain.addressProvince}}</span>
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
				<div ng-switch="locale">
					<div ng-switch-when="en"><span>{{postMain.contentEn}}</span></div>
					<div ng-switch-when="fr"><span>{{postMain.contentFr}}</span></div>
					<div ng-switch-when="pt"><span>{{postMain.contentPt}}</span></div>
				</div>
			</div>
		</div>
		<div class="row pics-group">
			<div ng-repeat="pic in postMain.pics" class="col-lg-3 post-pic-div" data-toggle="modal" data-target="#picModalCenter">
				<img ng-src="{{pic}}" class="post-pic-img" width="100%" height="20%" ng-click="showPhoto($index)">
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12 icons-group">
				<div class="icons-unit">
					<span class="post-icons" data-toggle="tooltip" title="Visitors" onmouseenter="$(this).tooltip('show')"><i class="far fa-eye"></i></span>
					<span>{{postMain.visitors}}</span>
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
					<a href="{{postMain.website}}" target="_blank" data-toggle="tooltip" title="Web Site" onmouseenter="$(this).tooltip('show')">
						<span class="post-icons" style="color: Black;" ><i class="fas fa-laptop"></i></span>
					</a>
				</div>
				<div class="icons-unit">
					<a href="{{postMain.addressOpen}}" target="_blank" data-toggle="tooltip" title="Maps" onmouseenter="$(this).tooltip('show')">
						<span class="post-icons" style="color: #3c763d;" ><i class="fas fa-map-marked-alt"></i></span>
					</a>
				</div>				
			</div>
		</div>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="picModalCenter" style="top: 50;right: 0;bottom: 0;left:-250;" tabindex="-1" role="dialog" aria-labelledby="picModalCenter" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered" role="document">
	    <div class="modal-content" style="width: 900px">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
		   <div class="slider">
		        <!-- enumerate all photos -->
		        <img ng-repeat="photo in postMain.pics" class="slide" ng-swipe-right="showPrev()" ng-swipe-left="showNext()" ng-show="isActive($index)" ng-src="{{photo}}" />
		        <!-- prev / next controls -->
		        <a class="arrow prev" href="#" ng-click="showPrev()"></a>
		        <a class="arrow next" href="#" ng-click="showNext()"></a>
		        <!-- extra navigation controls -->
		        <ul class="nav-album">
		            <li ng-repeat="photo in postMain.pics" ng-class="{'active':isActive($index)}">
		                <img src="{{photo}}" ng-click="showPhoto($index);" class="small-pic"/>
		            </li>
		        </ul>
		   	</div>
	      </div>
	    </div>
	  </div>
	</div>
</div>