package ramannada.github.com.demodependencyinjection.data.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import ramannada.github.com.demodependencyinjection.data.entity.Article;

/**
 * Created by ramannada on 1/21/2018.
 */

public class ArticleResponse {
    @SerializedName("current_page")
    private int currentPage;
    @SerializedName("data")
    private List<Article> articles;
    @SerializedName("from")
    private int from;
    @SerializedName("last_page")
    private int lastPage;
    @SerializedName("next_page_url")
    private String nextPageUrl;
    @SerializedName("path")
    private String path;
    @SerializedName("per_page")
    private int perPage;
    @SerializedName("prev_page_url")
    private String prevPageUrl;
    @SerializedName("to")
    private int to;
    @SerializedName("total")
    private int total;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public String getPrevPageUrl() {
        return prevPageUrl;
    }

    public void setPrevPageUrl(String prevPageUrl) {
        this.prevPageUrl = prevPageUrl;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
