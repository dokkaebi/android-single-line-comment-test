package com.concentricsky.test.singlelinecomment;

import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class SingleLineCommentTestActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        WebView webView = new WebView(this);
        
        //set a chrome client to get console log output
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadDataWithBaseURL("file:///android_asset/html/", 
        		"<html>" +
        		"<head>" +
        			"<script type=\"text/javascript\">" +
	        			"(function() {//comment})()" +
	        			"//comment" +
        			"</script>" +
        		"</head>" +
        		"<body>hi</body>" +
        		"</html>", 
        		"text/html", "utf-8", null);

        
        setContentView(webView);
    }
    
}