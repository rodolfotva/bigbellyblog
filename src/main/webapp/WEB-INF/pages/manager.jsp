<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="row" style="padding-top:50px">
	<div class="col-lg-12 most-recent" >
		<h3><spring:message code="page.manager.addpost.title" /></h3>
	</div>
</div>

<div class="row">
<div class="col-lg-1"></div>
	<div class="col-lg-11">
	  <form name="formPost" class="simple-form" ng-submit="savePostLink();">
	  	<div class="form-group">
		    <label for="restaurantName" class=form-post-label><spring:message code="page.manager.post.restaurantName" /></label> 
		    <input type="text" id="restaurantName" class="form-control form-post-input" ng-model="postAdd.restaurantName" required />

		    <div class="row">
		    	<div class="col-lg-6">
				    <label for="postWebsite" class=form-post-label><spring:message code="page.manager.post.website" /></label>  
				    <input type="text" id="postWebsite" class="form-control form-post-input" ng-model="postAdd.website" required />
		    	</div>
		    	<div class="col-lg-6">
				    <label for="postTripadvisor" class=form-post-label><spring:message code="page.manager.post.tripadvisor" /></label>  
				    <input type="text" id="postTripadvisor" class="form-control form-post-input" ng-model="postAdd.tripadvisor" required />
			    </div>
		    </div>		    
		    
		    <div class="row">
		    	<div class="col-lg-6">
				    <label for="postFacebook" class=form-post-label><spring:message code="page.manager.post.facebook" /></label>  
				    <input type="text" id="postFacebook" class="form-control form-post-input" ng-model="postAdd.facebook" required />
		    	</div>
		    	<div class="col-lg-6">
				    <label for="postRate" class=form-post-label><spring:message code="page.manager.post.rate" /></label> 
				    <select id="postRate" class="form-control form-post-input"  ng-model="postAdd.rate" required >
				      <option>1</option>
				      <option>1.5</option>
				      <option>2</option>
				      <option>2.5</option>
				      <option>3</option>
				      <option>3.5</option>
				      <option>4</option>
				      <option>4.5</option>
				      <option>5</option>
		    		</select> 
			    </div>
		    </div>	
    		
		   	<label for="postPic1" class=form-post-label><spring:message code="page.manager.post.pic1" /></label>  
		    <input type="text" id="postPic1" class="form-control form-post-input" ng-model="postAdd.pics[0]" required />
		    
		    <label for="postPic2" class=form-post-label><spring:message code="page.manager.post.pic2" /></label>  
		    <input type="text" id="postPic2" class="form-control form-post-input" ng-model="postAdd.pics[1]" required />
		    
		    <label for="postPic3" class=form-post-label><spring:message code="page.manager.post.pic3" /></label>  
		    <input type="text" id="postPic3" class="form-control form-post-input" ng-model="postAdd.pics[2]" required />
		    
		    <label for="postPic4" class=form-post-label><spring:message code="page.manager.post.pic4" /></label>  
		    <input type="text" id="postPic4" class="form-control form-post-input" ng-model="postAdd.pics[3]" required />
		    
		    <div class="row">
		    	<div class="col-lg-3">
				    <label for="postNumber" class=form-post-label><spring:message code="page.manager.post.number" /></label>  
				    <input type="text" id="postNumber" class="form-control form-post-input" ng-model="postAdd.address.number" required />
		    	</div>
		    	<div class="col-lg-5">
				    <label for="postStreet" class=form-post-label><spring:message code="page.manager.post.street" /></label>  
				    <input type="text" id="postStreet" class="form-control form-post-input" ng-model="postAdd.address.street" required />
			    </div>
			    <div class="col-lg-4">
				    <label for="postNeighborhood" class=form-post-label><spring:message code="page.manager.post.neighborhood" /></label>  
				    <input type="text" id="postNeighborhood" class="form-control form-post-input" ng-model="postAdd.address.neighborhood" required />
			    </div>
		    </div>

		    <div class="row">
		    	<div class="col-lg-6">
				    <label for="postCity" class=form-post-label><spring:message code="page.manager.post.city" /></label> 
				    <input type="text" id="postCity" class="form-control form-post-input" ng-model="postAdd.address.city" required />
		    	</div>
		    	<div class="col-lg-6">
				    <label for="postProvince" class=form-post-label><spring:message code="page.manager.post.province" /></label>  
				    <input type="text" id="postProvince" class="form-control form-post-input" ng-model="postAdd.address.province" required />
			    </div>
		    </div>
		    
		    <label for="postBody" class=form-post-label><spring:message code="page.manager.post.body" /></label>  
		    <textarea id="contentEn" class="form-control form-post-input" ng-model="postAdd.contentEn" rows="10" required /></textarea>
		    		    
		    <div class="form-post-save">
			    <input type="submit" value="submit" ng-disabled="formPost.$invalid"/>
		    </div>
		    
	    </div>
	  </form>		
	</div>
</div>