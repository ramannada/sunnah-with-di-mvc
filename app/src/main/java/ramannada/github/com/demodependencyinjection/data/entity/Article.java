package ramannada.github.com.demodependencyinjection.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ramannada on 1/21/2018.
 */

public class Article {
    @SerializedName("id")
    private Long id;
    @SerializedName("link")
    private String link;
    @SerializedName("title")
    private String title;
    @SerializedName("tags")
    private String tags;
    @SerializedName("category")
    private Long category;
    @SerializedName("content")
    private String content;
    @SerializedName("description")
    private String description;
    @SerializedName("thumbnail")
    private String thumbnail;
    @SerializedName("author")
    private String author;
    @SerializedName("published_at")
    private String publishedAt;
    @SerializedName("created_at")
    private String createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
