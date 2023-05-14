package io.github.ydkd.fossspringcore.domain;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {
    
    private Integer total;
    
    private List<T> list;
}
