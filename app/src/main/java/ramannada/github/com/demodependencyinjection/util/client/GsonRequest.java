package ramannada.github.com.demodependencyinjection.util.client;


import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by ramannada on 1/18/2018.
 */

public class GsonRequest<T> extends Request<T> {
    private final Map<String, String> headers;
    private final Response.Listener<T> listener;
    private final Class<T> tClass;
    private Gson gson = new Gson();

    public GsonRequest(int method, String url, Response.ErrorListener listener,
                       Map<String, String> headers, Response.Listener listener1, Class<T> tClass) {
        super(method, url, listener);
        this.headers = headers;
        this.listener = listener1;
        this.tClass = tClass;
    }

    @Override
    protected Response parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(
                    response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(
                    gson.fromJson(json, tClass),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(T response) {
        listener.onResponse(response);
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return headers  != null ? headers : super.getHeaders();
    }
}
