package com.quora.searchService.search;

import lombok.Data;

import java.util.List;

@Data
public class SearchDTO {
    private List<String> fields;
    private String searchTerm;
}
