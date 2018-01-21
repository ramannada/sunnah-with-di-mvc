package ramannada.github.com.demodependencyinjection.model;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import ramannada.github.com.demodependencyinjection.data.api.ListArticle;

/**
 * Created by ramannada on 1/18/2018.
 */

public class VolleyManager {
    public static final String URL = "http://api.sunnah.id/";
    public static final String URL_LIST_ARTICLE = URL + "article";


    private RequestQueue requestQueue;
    private ImageLoader imageLoader;
    private RequestCompletedListener requestCompletedListener;



    public VolleyManager(RequestQueue requestQueue, RequestCompletedListener requestCompletedListener) {
        this.requestQueue = requestQueue;
        this.requestCompletedListener = requestCompletedListener;
    }

    public void addToRequestQueu(Request request, String tag) {
        request.setTag(tag);
        requestQueue.add(request);
    }

    public void addToRequestQueu(Request request) {
        requestQueue.add(request);
    }

    public void cancelAllRequest(Object req) {
        if (requestQueue != null) {
            requestQueue.cancelAll(req);
        }
    }


    public void stringRequest(int httpMethod, String url, final String requestName) {
        StringRequest stringRequest = new StringRequest(httpMethod, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        requestCompletedListener.onRequestCompleted(requestName, true, response, null);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("error ", error.getMessage() );
                    }
                }
        );

        addToRequestQueu(stringRequest);
    }

    public void objectRequest(int httpMethod, String url, final String requestName) {
        JsonObjectRequest objectRequest = new JsonObjectRequest(httpMethod, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        requestCompletedListener.onRequestCompleted(requestName, true, response, null);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("error ", error.getMessage() );
                    }
                }
        );

        addToRequestQueu(objectRequest);
    }

    public interface RequestCompletedListener {
        void onRequestCompleted(String requestName, boolean status,
                                String response, String errorMessage);

        void onRequestCompleted(String requestName, boolean status,
                                JSONObject response, String errorMessage);
    }
}
