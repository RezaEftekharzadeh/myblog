package com.springboot.blog.Builder;

import com.springboot.blog.entity.Post;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Component
@Data
public class PostBuilder {
    private long id;

    @NotEmpty
    private String title;

    @Size(min = 10, message = "description should have minimum 10 characters")
    private String description;

    @Size(min = 10, message = "content should have minimum 10 characters")
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

    public Post build() {
        return Post.builder()
                .title(title)
                .description(description)
                .content(content)
                .build();
    }
}
