package com.example.springbootblogapplication2.config;

import com.example.springbootblogapplication2.models.Post;
import com.example.springbootblogapplication2.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private PostService postService;

    public SeedData(PostService postService) {
        this.postService = postService;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Post> post = postService.getAll();

        if (post.size() == 0) {
            Post post1 = new Post();
            post1.setTitle("title of post 1");
            post1.setBody("This is the body of post 1");

            Post post2 = new Post();
            post2.setTitle("title of post 2");
            post2.setBody("This is the body of post 2");

            postService.save(post1);
            postService.save(post2);
        }
    }
}
