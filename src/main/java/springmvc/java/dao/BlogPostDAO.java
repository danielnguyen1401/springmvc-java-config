package springmvc.java.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import springmvc.java.domain.BlogPost;
import springmvc.java.domain.User;

public interface BlogPostDAO extends CrudRepository<BlogPost, Long> {

	List<BlogPost> findAllBlogPostByUserAndTitleContaining(User user, String title);

	List<BlogPost> findAllBlogPostByUserAndDraft(User user, boolean draft);
}
