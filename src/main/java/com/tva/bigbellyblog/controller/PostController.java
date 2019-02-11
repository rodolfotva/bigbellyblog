package com.tva.bigbellyblog.controller;

import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tva.bigbellyblog.model.Post;
import com.tva.bigbellyblog.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostService service;

	private static final Logger logger = LogManager.getLogger(PostController.class.getName());

	public PostController() {
		logger.info("Initializing Post Controller");
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Post>> listHomePost() {
		logger.info("listHomePost ResponseEntity");
		List<Post> postLst = service.getLimitPosts(6);

		if (Objects.isNull(postLst) || postLst.isEmpty()) {
			return new ResponseEntity<List<Post>>(HttpStatus.NO_CONTENT);
		}

		logger.info("Posts found: " + postLst.size());
		return new ResponseEntity<List<Post>>(postLst, HttpStatus.OK);

	}

	@RequestMapping(value = "/alpha", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Post>> listPostByAlpha() {
		logger.info("listPostByAlpha ResponseEntity");
		List<Post> postLst = service.getLimitPosts(10);
		postLst.stream().sorted((v1, v2) -> v1.getRestaurantName().compareTo(v2.getRestaurantName()));

		if (Objects.isNull(postLst) || postLst.isEmpty()) {
			return new ResponseEntity<List<Post>>(HttpStatus.NO_CONTENT);
		}

		logger.info("Posts found: " + postLst.size());
		return new ResponseEntity<List<Post>>(postLst, HttpStatus.OK);

	}

	@RequestMapping(value = "/{limit}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Post>> listLimitPost(@PathVariable("limit") int limit) {
		logger.info("listLimitPost ResponseEntity");
		List<Post> postLst = service.getLimitPosts(limit);

		if (Objects.isNull(postLst) || postLst.isEmpty()) {
			return new ResponseEntity<List<Post>>(HttpStatus.NO_CONTENT);
		}

		logger.info("Posts found: " + postLst.size());
		return new ResponseEntity<List<Post>>(postLst, HttpStatus.OK);

	}

	@RequestMapping(value = "/like/{like}/{postId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Post> likePost(@PathVariable("like") int like, @PathVariable("postId") String postId) {
		logger.info("likePost ResponseEntity");
		Post post = service.changeLike(postId, like);

		if (Objects.isNull(post)) {
			return new ResponseEntity<Post>(HttpStatus.NO_CONTENT);
		}

		logger.info("Like OK: " + post.getLike());
		return new ResponseEntity<Post>(post, HttpStatus.OK);

	}

	@RequestMapping(value = "/dislike/{unlike}/{postId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Post> dislikePost(@PathVariable("unlike") int unlike, @PathVariable("postId") String postId) {
		logger.info("dislike ResponseEntity");
		Post post = service.changeDislike(postId, unlike);

		if (Objects.isNull(post)) {
			return new ResponseEntity<Post>(HttpStatus.NO_CONTENT);
		}

		logger.info("Dislike OK: " + post.getDislike());
		return new ResponseEntity<Post>(post, HttpStatus.OK);

	}

	@RequestMapping(value = "/addVisitor/{value}/{postId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Post> addVisitor(@PathVariable("value") int value, @PathVariable("postId") String postId) {
		logger.info("addVisitor ResponseEntity");
		Post post = service.changeVisitorNumber(postId, value);

		if (Objects.isNull(post)) {
			return new ResponseEntity<Post>(HttpStatus.NO_CONTENT);
		}

		logger.info("Visitor OK: " + post.getVisitors());
		return new ResponseEntity<Post>(post, HttpStatus.OK);
	}

	@RequestMapping(value = "/pagination/{page}/{dataPerPage}/{sortBy}/{asc}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Post>> pagination(@PathVariable("page") int page, @PathVariable("dataPerPage") int dataPerPage, @PathVariable("sortBy") String sortBy,
			@PathVariable("asc") boolean asc) {

		logger.info("pagination ResponseEntity");

		Direction direction = asc ? Sort.Direction.ASC : Sort.Direction.DESC;
		List<Post> postLst = service.getPaginationPosts(page - 1, dataPerPage, sortBy, direction);

		if (Objects.isNull(postLst) || postLst.isEmpty()) {
			return new ResponseEntity<List<Post>>(HttpStatus.NO_CONTENT);
		}

		logger.info("Posts found: " + postLst.size());
		return new ResponseEntity<List<Post>>(postLst, HttpStatus.OK);

	}

	@RequestMapping(value = "/savePost", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> savePost(@RequestBody Post post) {

		logger.info("savePost ResponseEntity");

		// Boolean saveOk = service.savePost(post);
		Boolean saveOk = true;

		if (saveOk) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}

		logger.info("Posts save: " + saveOk);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

}
