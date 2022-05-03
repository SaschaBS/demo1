package com.example.demo.service;

import com.example.demo.model.Post;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;
import rx.Observable;
import rx.subjects.BehaviorSubject;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final List<Post> postList = new ArrayList<>();

    private final BehaviorSubject<List<Post>> postSubject = BehaviorSubject.create();

    private final Observable<List<Post>> postSubjectObservable = postSubject.asObservable();


    public void createPost() {
        Faker faker = new Faker();
        this.postList.add(new Post(faker.number().digit(), faker.starTrek().character(), faker.starTrek().location()));

        this.postSubject.onNext(this.postList);
    }


    public Observable<List<Post>> getPostSubjectObservable() {
        return postSubjectObservable;
    }
}
