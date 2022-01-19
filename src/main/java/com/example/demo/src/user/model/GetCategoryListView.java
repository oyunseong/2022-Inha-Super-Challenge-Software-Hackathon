package com.example.demo.src.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GetCategoryListView {
    private List<GetCategory> drama;
    private List<GetCategory> movie;
    private List<GetCategory> music;
    private List<GetCategory> food;
}
