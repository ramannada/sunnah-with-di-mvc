package ramannada.github.com.demodependencyinjection.data.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import ramannada.github.com.demodependencyinjection.data.entity.Category;

/**
 * Created by ramannada on 1/21/2018.
 */

public class Data {
    @SerializedName("categories")
    private List<Category> categories;
    @SerializedName("article")
    private ArticleResponse articles;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public ArticleResponse getArticles() {
        return articles;
    }

    public void setArticles(ArticleResponse articles) {
        this.articles = articles;
    }
}
