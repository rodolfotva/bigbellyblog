<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
  <head>  
    <title>:: Big Belly Blog ::</title>
    <meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1" />
    
    <link rel="icon" href="<c:url value="/static/images/favicon.ico" />" type="image/x-icon" >
    
    <link href="<c:url value="/static/css/bigbellyblog.css" />" rel="stylesheet">
	<link href="<c:url value="/static/css/album.css" />" rel="stylesheet">
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">    
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
  	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/v4-shims.css">
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.js"></script>    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.7.3/angular.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.7.3/angular-sanitize.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.7.3/angular-animate.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.7.3/angular-resource.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.7.3/angular-touch.min.js"></script>
    

    <script src="<c:url value="/static/js/bigbellyblog.js" />"></script>
    <script src="<c:url value="/static/js/controller/main-controller.js" />"></script>
    <script src="<c:url value="/static/js/service/main-service.js" />"></script>
    <script src="<c:url value="/static/js/directives/main-directives.js" />"></script>
    <script src="<c:url value="/static/js/filters/main-filters.js" />"></script>


  </head>
  	<body ng-app="main" class="ng-cloak">
		<div ng-controller="mainController">
			<nav class="navbar navbar-default navbar-fixed-top">
				<div class="container">
					<div class="navbar-header">
						
						<a class="navbar-brand" style="padding-top:0px" href="#"><img src="<c:url value="/static/images/BBBLogo.png" />" width="140"/></a>
					</div>
					<div class="collapse navbar-collapse">
						<ul id="navbar" class="nav navbar-nav">
							<li ng-class="{active : menu == 'post'}"><a href="#" ng-click="menuChange('post')"><spring:message code="page1.title" /></a></li>
							<li ng-class="{active : menu == 'list'}"><a href="#" ng-click="menuChange('list')"><spring:message code="page2.explanation" /></a></li>
							<li ng-class="{active : menu == 'donation'}"><a href="#" ng-click="menuChange('donation')"><spring:message code="page3.title" /></a></li>
							<li ng-if="showManagerBtn" ng-class="{active : menu == 'manager'}"><a href="#" ng-click="menuChange('manager')"><spring:message code="page.manager.title" /></a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
			              <li><a href="/bigbellyblog/en/" title="English"><img src="<c:url value="/static/images/usa.png" />" height="16" width="16" /></a></li>
			              <li><a href="/bigbellyblog/fr/" title="Fran�ais"><img src="<c:url value="/static/images/france.png" />" height="16" width="16" /></a></li>
			              <li><a href="/bigbellyblog/pt/" title="Portugues"><img src="<c:url value="/static/images/brazil.png" />" height="16" width="16" /></a></li>
            			</ul>
					</div>
				</div>
			</nav>
			
			<div class="container container_main" >
				<div ng-switch="menu">
					<div ng-switch-when="post" post-page></div>
					<div ng-switch-when="list" list-page></div>
					<div ng-switch-when="donation" donation-page></div>
					<div ng-switch-when="manager" manager-page></div>
				</div>
			</div>

			<div class="footer">
				<div class="footer-copyright text-center py-3"><spam ng-click="showManagerButton()">2019</spam> Copyright:
				  <a href="https://www.bigbellyblog.com/"> bigbellyblog.com</a>
				</div>
			</div>
		</div>	
	</body>

</html>