package com.tva.bigbellyblog;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.bson.types.ObjectId;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.tva.bigbellyblog.configuration.ApplicationConfig;
import com.tva.bigbellyblog.model.Address;
import com.tva.bigbellyblog.model.Comment;
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

  // @Test
  public void testInsertPost() {
    assertThat(postService, instanceOf(PostServiceImpl.class));

    for (int x = 1; x < 9; x++) {
      int value = x * -10;
      Calendar today = Calendar.getInstance();
      today.add(Calendar.DATE, value);

      Post post = new Post();
      post.setTitle("Test " + value);
      post.setRestaurantName("Test " + value);
      post.setContentEn("Les " + value + " Brasseurs llzbvlfbvlifbvidufvifbv alfivblaifbvlaihfvliahflvhafd vlhadflvh alifhvaliufhvliuahdf vuhafdlvuihafd en");
      post.setContentFr("Les " + value + " Brasseurs llzbvlfbvlifbvidufvifbv alfivblaifbvlaihfvliahflvhafd vlhadflvh alifhvaliufhvliuahdf vuhafdlvuihafd fr");
      post.setContentPt("Les " + value + " Brasseurs llzbvlfbvlifbvidufvifbv alfivblaifbvlaihfvliahflvhafd vlhadflvh alifhvaliufhvliuahdf vuhafdlvuihafd pt");
      post.setFacebook("https://www.facebook.com/3brasseurspteclaire/");
      post.setWebsite("https://les3brasseurs.ca/");
      post.setTripadvisor("https://www.tripadvisor.ca/Restaurant_Review-g155032-d785745-Reviews-Les_3_Brasseurs-Montreal_Quebec.html");
      post.setLike(88);
      post.setDislike(1);
      post.setPostDate(today.getTime());
      post.setRate(5);
      post.setVisitors(2500);
      post.setPics(Arrays.asList("123321", "1233322", "33212333"));

      post.setComments(Arrays.asList(new Comment(ObjectId.get().toString(), "Rodolfo Alquezar", "rodolfotva@gmail.com", "lalalalalalalallelele", true, true)));
      post.setAddress(Arrays.asList(new Address("9999", "Sainte-Catherine Test,", "Downtown", "Montreal", "QC", "", "1233211222")));

      postService.addPost(post);

    }


    assertEquals(0, 0);
  }


}
