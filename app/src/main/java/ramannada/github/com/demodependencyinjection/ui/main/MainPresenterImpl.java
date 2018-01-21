package ramannada.github.com.demodependencyinjection.ui.main;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.Collection;

import ramannada.github.com.demodependencyinjection.data.api.ListArticle;
import ramannada.github.com.demodependencyinjection.model.VolleyManager;

/**
 * Created by ramannada on 1/19/2018.
 */

public class MainPresenterImpl implements MainPresenter {
    private MainView mainView;
    private ItemInteractor itemInteractor;
    private Gson gson;
    private VolleyManager volleyManager;
    private VolleyManager.RequestCompletedListener requestCompletedListener =
            new VolleyManager.RequestCompletedListener() {
                @Override
                public void onRequestCompleted(String requestName, boolean status,
                                               String response, String errorMessage) {
                    mainView.hideProgress();
                    if (status) {

                        ListArticle getAllArticleResponse =
                                gson.fromJson(response,
                                        new TypeToken<ListArticle>(){}.getType());
                        mainView.setItem(getAllArticleResponse.getData().getArticles().getArticles());
                        Log.d("size", String.valueOf(getAllArticleResponse.getData().getArticles().getArticles().size()));
                    }
                }

                @Override
                public void onRequestCompleted(String requestName, boolean status,
                                               JSONObject response, String errorMessage) {
                    if (status) {

                        ListArticle getAllArticleResponse =
                                gson.fromJson(response.toString(),
                                        new TypeToken<ListArticle>(){}.getType());
                        mainView.setItem(getAllArticleResponse.getData().getArticles().getArticles());
                        Log.d("size", String.valueOf(getAllArticleResponse.getData().getArticles().getArticles().size()));
                    }
                }
            };

    public MainPresenterImpl(MainView mainView, ItemInteractor itemInteractor,
                             RequestQueue requestQueue, Gson gson) {
        this.mainView = mainView;
        this.itemInteractor = itemInteractor;
        this.gson = gson;
        this.volleyManager = new VolleyManager(requestQueue, requestCompletedListener);
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onItemClicked() {

    }

    @Override
    public void getData() {
        volleyManager.objectRequest(Request.Method.GET, VolleyManager.URL_LIST_ARTICLE, null);
    }


}
