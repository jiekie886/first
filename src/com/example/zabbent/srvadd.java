package com.example.zabbent;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class srvadd extends Activity{
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addserver);
        
        Button add_srv = (Button)findViewById(R.id.add_add);
        add_srv.setOnClickListener(add_listener);
        Button cancel_srv = (Button)findViewById(R.id.add_cancel);
        cancel_srv.setOnClickListener(cancel_listener);
		//SharedPreferences login_info = getSharedPreferences("loginfo",Activity.MODE_PRIVATE);
		//SharedPreferences.Editor editor = login_info.edit();
		//editor.putString("user", "Karl");
		//editor.putString("habit", "sleep");
		//editor.commit();
		//Toast.makeText(this, "save ok" ,Toast.LENGTH_LONG).show(); 
       

    }
	private Button.OnClickListener cancel_listener = new Button.OnClickListener(){ 

  		 public void onClick(View v){
  			 Intent intent = new Intent();      
  			 intent.setClass(srvadd.this,setmenus.class);
  			 startActivity(intent);
  		 }
  	};
	private Button.OnClickListener add_listener = new Button.OnClickListener(){ 

 		 public void onClick(View v){
 			EditText srv_user = (EditText)findViewById(R.id.srvuser_input);
 	        EditText srv_pass = (EditText)findViewById(R.id.srvpass_input);
 	        //EditText srv_url = (EditText)findViewById(R.id.srvurl_input);
 	        String user = srv_user.getText().toString();
 	        String pass = srv_pass.getText().toString();
 	        //String url = srv_url.getText().toString();
 	        String url = "http://203.195.141.56/zabbix/api_jsonrpc.php";
 	        //save
 	        SharedPreferences login_info = getSharedPreferences("loginfo",MODE_APPEND);
 	      	SharedPreferences.Editor editor = login_info.edit();
 	      	editor.putString("user", user);
 	      	editor.putString("pass", pass);
 	      	editor.putString("url", url);
 	      	editor.commit();
 	      	//Toast.makeText(this, "save OK" ,Toast.LENGTH_LONG).show(); 
 	      	
 			 Intent intent = new Intent();      
 			 intent.setClass(srvadd.this,setmenus.class);
 			 startActivity(intent);
 		 }
 	};
}
