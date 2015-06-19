package com.app.idea.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


public class IdeaDTO {
    private long id;
    @NotNull(message = "error.title.notnull")
    @Size(min = 1, max = 30, message = "error.title.size")
    private String title;

    @Size(max = 100, message = "error.description.size")
    private String description;

    private Date createdAt;

    public IdeaDTO(){

    }

    public IdeaDTO(long id, Date createdAt, String description, String title) {
        this.id = id;
        this.createdAt = createdAt;
        this.description = description;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
