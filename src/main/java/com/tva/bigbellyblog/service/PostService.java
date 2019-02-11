package com.tva.bigbellyblog.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

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

	public Post changeLike(String objectId, int value);

	public Post changeDislike(String objectId, int value);

	public Post changeVisitorNumber(String objectId, int value);

	public boolean addComment(String objectId, Comment comment);

	public boolean updateComment(String objectId, Comment comment);

	public List<Post> getPaginationPosts(int ini, int fin, String sortBy, Direction direction);

	public Post findByPostId(String postId);

	public boolean savePost(Post post);

}
