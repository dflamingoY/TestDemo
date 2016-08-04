package com.smoothframe.http;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import java.util.Map;

/**
 * 网络请求类
 * Created by Onlydyf on 2015/8/10.
 */
public class HttpHelper {
    private Context context;
    private ImageLoader loader;
    private RequestQueue queue;

    private String baseUrl = "";

    /**
     * 构造方法
     *
     * @param context 上下文
     */
    public HttpHelper(Context context) {
        this.context = context;
        if (queue == null) {
            this.queue = Volley.newRequestQueue(this.context);
        }
    }

    /**
     * 图片
     *
     * @return
     */
    public ImageLoader getImageLoader() {
        if (loader == null) {
            this.loader = new ImageLoader(queue, new ImgCache());
        }
        return loader;
    }

    /**
     * 错误监听
     */
    public Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError volleyError) {
            Toast.makeText(context, VolleyErrorHelper.getMessage(volleyError), Toast.LENGTH_SHORT).show();
        }
    };


    public void NetObject(int requestType, String url, Map<String, String> params, Class clazz, Response.Listener listener, Response.ErrorListener nowErrorListener) {
        FastObjectRequest request;
        try{
            request = new FastObjectRequest(requestType, url, params, clazz, listener, nowErrorListener);
            queue.add(request);
       }catch(Exception e){
            e.printStackTrace();
       }
    }

    public void NetArray(String url, Map<String, String> params, Class clazz, Response.Listener listener, Response.ErrorListener nowErrorListener) {
     try{
         FastArrayRequest request = new FastArrayRequest(url, params, clazz, listener, nowErrorListener);
         queue.add(request);
     }catch (Exception e){e.printStackTrace();}
    }

    public void NetMap(String url, Map<String, String> params, Response.Listener listener, Response.ErrorListener nowErrorListener) {
        try{
            FastMapRequest request = new FastMapRequest(url, params, listener, nowErrorListener);
            queue.add(request);
        }catch (Exception e){e.printStackTrace();}
    }


    public void NetObject(int requestType, String url, Map<String, String> params, Class clazz, Response.Listener listener) {
        try{
            FastObjectRequest request = new FastObjectRequest(requestType, url, params, clazz, listener, errorListener);
            queue.add(request);
        }catch (Exception e){e.printStackTrace();}
    }

    public void NetArray(String url, Map<String, String> params, Class clazz, Response.Listener listener) {
        try{
            FastArrayRequest request = new FastArrayRequest(url, params, clazz, listener, errorListener);
            queue.add(request);
        }catch (Exception e){e.printStackTrace();}
    }

    public void NetMap(String url, Map<String, String> params, Response.Listener listener) {
        try{
            FastMapRequest request = new FastMapRequest(url, params, listener, errorListener);
            queue.add(request);
        }catch (Exception e){e.printStackTrace();}
    }

    public void stop() {
        queue.stop();
    }

    public void start() {
        queue.start();
    }

    //清除当前activity的请求队列。
    public void cancelAll() {
        queue.cancelAll(context);
    }


    public void special(Request request) {
        queue.add(request);
    }

}