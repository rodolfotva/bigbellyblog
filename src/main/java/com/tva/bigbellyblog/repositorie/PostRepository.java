package com.tva.bigbellyblog.repositorie;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tva.bigbellyblog.model.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	@Query("{'resName':?0}")
	List<Post> findByName(String resName);

	@Query("{'postDate' : { '$gt' : ?0 }}")
	List<Post> findGtPostDate(Date postDate);

	@Query("{ 'rate' : {$lt: 10 } }")
	List<Post> getLimitPosts(Pageable pageable);

	@Query("{'postId':?0}")
	Post findByPostId(String postId);

}
