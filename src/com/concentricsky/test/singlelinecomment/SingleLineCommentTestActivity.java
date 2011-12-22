// Copyright 2011 Concentric Sky, Inc. All Rights Reserved.
// http://www.concentricsky.com
// This code may not be used without permission.

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
        
        //enable js
        webView.getSettings().setJavaScriptEnabled(true);
        
        //this code causes: Uncaught SyntaxError: Unexpected end of input at file:///android_asset/html/:1
        
	        //Comment out line 37: "(function() {//comment})()" +
	        //Uncomment line 38: "//comment" +
        	//note that the error is gone.
        
        webView.loadDataWithBaseURL("file:///android_asset/html/", 
        		"<html>" +
        		"<head>" +
        			"<script type=\"text/javascript\">" +
	        			"(function() {//comment})()" +
//	        			"//comment" +
        			"</script>" +
        		"</head>" +
        		"<body>hi</body>" +
        		"</html>", 
        		"text/html", "utf-8", null);

        
        setContentView(webView);
    }
    
}