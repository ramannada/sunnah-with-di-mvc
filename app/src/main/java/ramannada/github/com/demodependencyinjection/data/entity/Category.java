package ramannada.github.com.demodependencyinjection.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ramannada on 1/21/2018.
 */

public class Category {
    @SerializedName("id")
    private Long id;
    @SerializedName("category")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
