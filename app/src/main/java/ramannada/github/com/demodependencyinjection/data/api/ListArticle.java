package ramannada.github.com.demodependencyinjection.data.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ramannada on 1/21/2018.
 */

public class ListArticle {
    @SerializedName("status")
    private int status;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private Data data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
