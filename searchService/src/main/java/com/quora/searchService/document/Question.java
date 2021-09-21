package com.quora.searchService.document;

import com.quora.searchService.document.dto.Category;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;


@Document(indexName = "question")
@Data
@Setting(settingPath = "es-config/elastic-analyzer.json")
public class Question {
    @Id
    @Field(type = FieldType.Keyword)
    String questionId;

    @Field(type = FieldType.Text, analyzer = "autocomplete_index", searchAnalyzer = "autocomplete_search")
    String questionText;

    @Field(type = FieldType.Text, analyzer = "autocomplete_index", searchAnalyzer = "autocomplete_search")
    Category category;
}
