package id.ac.ipb.dspacemobileapps.core;

import android.net.Uri;
import android.os.AsyncTask;

import com.googlecode.openbeans.BeanInfo;
import com.googlecode.openbeans.Introspector;
import com.googlecode.openbeans.PropertyDescriptor;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.AsyncHttpResponse;
import com.koushikdutta.async.http.Multimap;
import com.koushikdutta.async.http.body.MultipartFormDataBody;
import com.koushikdutta.async.http.body.UrlEncodedFormBody;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Hanif Affandi Hartanto on 7/17/2015.
 */
public abstract class SherinaCode {
    public static final String PARAM_FILE = "FILE_";
    public static final String BASIC = "BASIC";
    public static final String MULTIPART = "MULTIPART";

    private String type = BASIC;
    private Request httpRequest;

    public void cancelRq(boolean mayInterruptIfRunning) {
        if (this.httpRequest != null)
            this.httpRequest.cancel(mayInterruptIfRunning);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Request getHttpRequest() {
        return httpRequest;
    }

    public void setHttpRequest(Request httpRequest) {
        this.httpRequest = httpRequest;
    }

    public class Request extends AsyncTask<HashMap<String, String>, Void, Void> {
        private String url;
        private String method;
        private SherinaCode callback;

        public Request(SherinaCode sherinaCode, String url) {
            this.callback = sherinaCode;
            this.url = url;
            this.method = "GET";
        }

        public Request(SherinaCode sherinaCode, String url, String method) {
            this.callback = sherinaCode;
            this.url = url;
            this.method = method;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        @Override
        protected Void doInBackground(HashMap<String, String>... params) {
            AsyncHttpRequest asyncHttpRequest = new AsyncHttpRequest(
                    Uri.parse(url), method);

            // untuk saat ini, hanya untuk result yang JSON aja.
            asyncHttpRequest.addHeader("Accept", "text/json");
            asyncHttpRequest.addHeader("content-type", "application/json");

            if (params[0] != null) {
                Iterator<Map.Entry<String, String>> it = params[0].entrySet()
                        .iterator();
                if (type.equals(MULTIPART)) {
                    MultipartFormDataBody body = new MultipartFormDataBody();
                    while (it.hasNext()) {
                        @SuppressWarnings("rawtypes")
                        Map.Entry pair = (Map.Entry) it.next();
                        boolean bol = false;
                        if (pair.getKey().toString().length() > 5) {
                            if (pair.getKey().toString().substring(0, 5)
                                    .equals(PARAM_FILE))
                                bol = true;
                        }
                        if (bol) {
                            body.addFilePart(pair.getKey().toString(),
                                    new File(pair.getValue().toString()));
                        } else {
                            body.addStringPart(pair.getKey().toString(), pair
                                    .getValue().toString());

                        }
                    }
                    asyncHttpRequest.setBody(body);
                } else if(type.equals(BASIC)){
                    Multimap pairs = new Multimap();
                    while (it.hasNext()) {
                        Map.Entry pair = (Map.Entry) it.next();
                        pairs.add(pair.getKey()
                                .toString(), pair.getValue().toString());
                    }
                    UrlEncodedFormBody body = new UrlEncodedFormBody(pairs);
                    asyncHttpRequest.setBody(body);
                }
            }
            AsyncHttpClient.getDefaultInstance().executeString(
                    asyncHttpRequest, new AsyncHttpClient.StringCallback() {
                        @Override
                        public void onConnect(AsyncHttpResponse response) {
                            super.onConnect(response);
                            ((OnWebService) callback).onConnect(response);
                        }

                        @Override
                        public void onProgress(AsyncHttpResponse response, long downloaded, long total) {
                            super.onProgress(response, downloaded, total);
                            ((OnWebService) callback).onProgress(response, downloaded, total);
                        }

                        @Override
                        public void onCompleted(Exception exception,
                                                AsyncHttpResponse param, String data) {
                            ((OnWebService) callback).onCompleted(exception, param, data);
                        }

                    });
            return null;
        }
    }

    public static HashMap<String, String> introspect(Object obj)
            throws Exception {
        HashMap<String, String> result = new HashMap<String, String>();
        BeanInfo info = Introspector.getBeanInfo(obj.getClass());
        for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
            Method reader = pd.getReadMethod();
            if (reader != null) {
                if (reader.invoke(obj) != null) {
                    result.put(pd.getName(), reader.invoke(obj).toString());
                }
            }
        }
        return result;
    }
}
