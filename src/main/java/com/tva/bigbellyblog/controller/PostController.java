package com.tva.bigbellyblog.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

  @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Map<String, Object>> listHomePost() {
    logger.info("listHomePost ResponseEntity");
    Map<String, Object> values = new HashMap<String, Object>();

    List<Post> postLst = service.getLimitPosts(6);
    values.put("postLst", postLst);
    String locale = LocaleContextHolder.getLocale().getLanguage();
    values.put("locale", locale);

    if (Objects.isNull(postLst) || postLst.isEmpty()) {
      return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);
    }

    logger.info("Posts found: " + postLst.size());
    return new ResponseEntity<Map<String, Object>>(values, HttpStatus.OK);

  }

  @GetMapping(value = "/alpha", produces = MediaType.APPLICATION_JSON_VALUE)
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

  @GetMapping(value = "/{limit}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Post>> listLimitPost(@PathVariable("limit") int limit) {
    logger.info("listLimitPost ResponseEntity");
    List<Post> postLst = service.getLimitPosts(limit);

    if (Objects.isNull(postLst) || postLst.isEmpty()) {
      return new ResponseEntity<List<Post>>(HttpStatus.NO_CONTENT);
    }

    logger.info("Posts found: " + postLst.size());
    return new ResponseEntity<List<Post>>(postLst, HttpStatus.OK);

  }

  @GetMapping(value = "/like/{like}/{postId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Post> likePost(@PathVariable("like") int like, @PathVariable("postId") String postId) {
    logger.info("likePost ResponseEntity");
    Post post = service.changeLike(postId, like);

    if (Objects.isNull(post)) {
      return new ResponseEntity<Post>(HttpStatus.NO_CONTENT);
    }

    logger.info("Like OK: " + post.getLike());
    return new ResponseEntity<Post>(post, HttpStatus.OK);

  }

  @GetMapping(value = "/dislike/{unlike}/{postId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Post> dislikePost(@PathVariable("unlike") int unlike, @PathVariable("postId") String postId) {
    logger.info("dislike ResponseEntity");
    Post post = service.changeDislike(postId, unlike);

    if (Objects.isNull(post)) {
      return new ResponseEntity<Post>(HttpStatus.NO_CONTENT);
    }

    logger.info("Dislike OK: " + post.getDislike());
    return new ResponseEntity<Post>(post, HttpStatus.OK);

  }

  @GetMapping(value = "/addVisitor/{value}/{postId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Map<String, Object>> addVisitor(@PathVariable("value") int value, @PathVariable("postId") String postId) {
    logger.info("addVisitor ResponseEntity");
    Map<String, Object> values = new HashMap<String, Object>();

    String locale = LocaleContextHolder.getLocale().getLanguage();
    Post post = service.changeVisitorNumber(postId, value);

    values.put("locale", locale);
    values.put("post", post);

    if (Objects.isNull(post)) {
      return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);
    }

    logger.info("Visitor OK: " + post.getVisitors());
    return new ResponseEntity<Map<String, Object>>(values, HttpStatus.OK);
  }

  @GetMapping(value = "/pagination/{page}/{dataPerPage}/{sortBy}/{asc}", produces = MediaType.APPLICATION_JSON_VALUE)
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

  @PostMapping(value = "/savePost", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Boolean> savePost(@RequestBody Post post) {

    logger.info("savePost ResponseEntity");

    post.setObjectId(new ObjectId());
    post.setPostId(post.getObjectId().toString());
    post.setLike(0);
    post.setDislike(0);
    post.setVisitors(0);
    post.setPostDate(new Date());
    post.setTitle(post.getRestaurantName());

    Boolean saveOk = service.savePost(post);

    if (saveOk) {
      return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
    }

    logger.info("Posts save: " + saveOk);
    return new ResponseEntity<Boolean>(saveOk, HttpStatus.OK);

  }

}
