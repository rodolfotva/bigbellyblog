package com.tva.bigbellyblog.service;

import java.util.List;

import com.tva.bigbellyblog.model.Comment;
import com.tva.bigbellyblog.model.Post;

public interface PostService {

  public void addPost(Post post);

  public Post updatePost(Post post);

  public void deletePost(String objectId);

  public Post findByObjectId(String objectId);

  public List<Post> getAllPost();

  public Post findLastPost();

  public List<Post> getLimitPosts(int limit);

  public boolean changeLike(String objectId, int value);

  public boolean changeDislike(String objectId, int value);

  public boolean changeVisitorNumber(String objectId, int value);

  public boolean addComment(String objectId, Comment comment);

  public boolean updateComment(String objectId, Comment comment);

}
