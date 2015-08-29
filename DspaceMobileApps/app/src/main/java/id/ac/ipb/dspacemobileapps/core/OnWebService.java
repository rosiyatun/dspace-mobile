package id.ac.ipb.dspacemobileapps.core;

import com.koushikdutta.async.http.AsyncHttpResponse;

import java.util.HashMap;

/**
 * Created by Hanif Affandi Hartanto on 7/17/2015.
 */
public interface OnWebService {
	void onConnect(AsyncHttpResponse response);
	void onProgress(AsyncHttpResponse response, long downloaded, long total);
	void onCompleted(Exception exception, AsyncHttpResponse param, String data);
	void requestWebService(String url, HashMap<String, String> param);

}
