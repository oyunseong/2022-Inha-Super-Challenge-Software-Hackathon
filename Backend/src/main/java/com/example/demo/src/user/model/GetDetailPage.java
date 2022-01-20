package com.example.demo.src.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GetDetailPage {
    private String koreaTitle;
    private String englishTitle;
    private String imageUrl;
    private String englishExplain;
    private String movieUrl;
    private List<GetReview>  review;
    private List<GetMainPage> movie;
}
