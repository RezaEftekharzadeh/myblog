package com.springboot.blog.Builder;

import com.springboot.blog.entity.Comment;
import com.springboot.blog.entity.Post;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Data
public class PostBuilder {
    private long id;
    private String title;
    private String description;
    private String content;

    public PostBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public PostBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public PostBuilder setContent(String content) {
        this.content = content;
        return this;
    }


    public Post build(){
        return Post.builder()
                .title(title)
                .description(description)
                .content(content)
                .build();
    }
}
