package com.example.project.dto.response.map;


import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class ApiKeywordSearch {


    public List<Document> documentsList;



    public Meta meta;

    public static class Document {

    }

    @Getter
    public static class Meta {
        private boolean is_end;


        private Long total_count;
    }





}
