package com.tva.bigbellyblog;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.tva.bigbellyblog.configuration.ApplicationConfig;
import com.tva.bigbellyblog.model.Post;
import com.tva.bigbellyblog.service.PostService;
import com.tva.bigbellyblog.service.PostServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
@WebAppConfiguration
public class DbTests {

  @Autowired
  @Qualifier("postService")
  PostService postService;


  // @Test
  public void testPostNumbers() {
    assertThat(postService, instanceOf(PostServiceImpl.class));

    List<Post> postList = postService.getAllPost();
    assertEquals(7, postList.size());
  }

  // @Test
  public void testByObjId() {
    assertThat(postService, instanceOf(PostServiceImpl.class));

    Post post = postService.findByObjectId("5c058b2badb8316a44901596");
    assertEquals("Dulce Paradise", post.getRestaurantName());
  }

  // @Test
  public void testLast() {
    assertThat(postService, instanceOf(PostServiceImpl.class));

    Post post = postService.findLastPost();
    assertEquals("Dulce Paradise", post.getRestaurantName());
  }

  // @Test
  public void testLimit() {
    assertThat(postService, instanceOf(PostServiceImpl.class));
    int limit = 3;

    List<Post> post = postService.getLimitPosts(limit);
    assertEquals(limit, post.size());
  }

  // @Test
  public void changeLike() {
    assertThat(postService, instanceOf(PostServiceImpl.class));

    Post likeOk = postService.changeLike("5c058b2badb8316a44901596", 1);
    assertEquals(true, likeOk);

    likeOk = postService.changeLike("5c058b2badb8316a44901596", -1);
    assertEquals(true, likeOk.getLike());
  }

}
