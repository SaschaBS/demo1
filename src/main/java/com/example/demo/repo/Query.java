package com.example.demo.repo;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.model.Post;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {
    public List<Post> getRecentPosts(int count, int offset) {
        Post post = new Post("1", "bla", "foo");
        return List.of(post);
    }
}