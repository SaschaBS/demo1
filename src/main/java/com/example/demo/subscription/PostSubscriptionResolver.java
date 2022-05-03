package com.example.demo.subscription;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rx.Observable;
import rx.RxReactiveStreams;

import java.util.List;
import java.util.concurrent.TimeUnit;


@Component
public class PostSubscriptionResolver implements GraphQLSubscriptionResolver {


    private final PostService postService;

    public PostSubscriptionResolver(@Autowired PostService postService) {
        this.postService = postService;

        Observable.interval(10, TimeUnit.SECONDS).subscribe(x -> {
            postService.createPost();
        });
    }

    public Publisher<List<Post>> postUpdates() {
        return RxReactiveStreams.toPublisher(this.postService.getPostSubjectObservable());
    }


}
