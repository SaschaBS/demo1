package com.example.demo.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.model.Post;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    private final Post post;

    public Query() {
        this.post = new Post("1", "bla", "foo");
    }

    public List<Post> getRecentPosts(int count, int offset) {
        return List.of(this.post);
    }

    public List<Post> allPosts() {
        return List.of(this.post);
    }

}