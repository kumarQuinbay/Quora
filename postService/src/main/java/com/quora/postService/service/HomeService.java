package com.quora.postService.service;

import com.quora.postService.Entity.Home;

public interface HomeService {
    public Home save(Home home);
    public Home get(String id);
    public Home update(Home home);
    public void delete(String id);
}
