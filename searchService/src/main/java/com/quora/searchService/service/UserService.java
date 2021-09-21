package com.quora.searchService.service;

import com.quora.searchService.document.User;
import com.quora.searchService.search.SearchDTO;

import java.util.List;

public interface UserService {
    public User get(String email);
    public User save(User user);
    public User update(User user);
    public void delete(String email);
    public List<User> search(SearchDTO searchDTO);
}
