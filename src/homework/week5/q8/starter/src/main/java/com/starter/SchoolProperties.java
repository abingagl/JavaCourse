package com.starter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

/**
 * @author ：zhang
 * @title ：TODO
 * @date ：created in 2021/07/28
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "school")
public class SchoolProperties {
    private List<Integer> studentIds;
    private List<String> studentNames;
    private List<Integer> klassIds;
    private List<String> klassNames;
    private List<Map<String, Integer>> studentOfKlass;
}
