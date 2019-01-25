package com.tva.bigbellyblog.service;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tva.bigbellyblog.model.Comment;
import com.tva.bigbellyblog.model.Post;
import com.tva.bigbellyblog.repositorie.PostRepository;

@Service("postService")
@Transactional
public class PostServiceImpl implements PostService {

  private static final Logger logger = LogManager.getLogger(PostServiceImpl.class.getName());

  @Autowired
  private PostRepository postRepo;

  @Override
  public void addPost(Post post) {
    logger.info("Adding post: " + post.getTitle());
    postRepo.insert(post);
  }

  @Override
  public void deletePost(String objectId) {
    logger.info("Deleting post: " + objectId);
    postRepo.deleteById(objectId);
  }

  @Override
  public List<Post> getAllPost() {
    return postRepo.findAll();
  }

  @Override
  public List<Post> getLimitPosts(int limit) {
    return postRepo.getLimitPosts(PageRequest.of(0, limit, new Sort(Sort.Direction.DESC, "postDate")));
  }

  @Override
  public Post findByObjectId(String objectId) {
    return postRepo.findById(objectId).get();
  }


  @Override
  public Post findLastPost() {
    Calendar today = Calendar.getInstance();
    today.add(Calendar.DATE, -30);

    List<Post> postLst = postRepo.findGtPostDate(today.getTime());
    if (Objects.nonNull(postLst) && postLst.size() > 0) {
      return postLst.get(0);
    } else {
      today.add(Calendar.DATE, 30);
      postLst = postRepo.findGtPostDate(today.getTime());
      if (Objects.nonNull(postLst) && postLst.size() > 0) {
        return postLst.get(0);
      }
    }

    return null;
  }

  @Override
  public boolean changeLike(String objectId, int value) {
    Post post = postRepo.findById(objectId).get();
    if (Objects.nonNull(post)) {
      post.setLike(post.getLike() + value);
      postRepo.save(post);
      return true;
    }
    return false;
  }

  @Override
  public boolean changeDislike(String objectId, int value) {
    Post post = postRepo.findById(objectId).get();
    if (Objects.nonNull(post)) {
      post.setLike(post.getLike() + value);
      postRepo.save(post);
      return true;
    }
    return false;
  }

  @Override
  public boolean changeVisitorNumber(String objectId, int value) {
    Post post = postRepo.findById(objectId).get();
    if (Objects.nonNull(post)) {
      post.setLike(post.getLike() + value);
      postRepo.save(post);
      return true;
    }
    return false;
  }

  @Override
  public Post updatePost(Post post) {
    postRepo.save(post);
    return post;
  }

  @Override
  public boolean addComment(String objectId, Comment comment) {
    try {
      Post post = postRepo.findById(objectId).get();
      post.getComments().add(comment);
      postRepo.save(post);
      return true;
    } catch (Exception ex) {
      logger.error("Error to add coment into post: " + objectId);
      return false;
    }
  }

  @Override
  public boolean updateComment(String objectId, Comment comment) {
    try {
      return true;
    } catch (Exception ex) {
      logger.error("Error to update coment into post: " + objectId);
      return false;
    }
  }

  @Override
  public List<Post> getPaginationPosts(int ini, int fin, String sortBy, Direction direction) {
    return postRepo.getLimitPosts(PageRequest.of(ini, fin, new Sort(direction, sortBy)));
  }

}
