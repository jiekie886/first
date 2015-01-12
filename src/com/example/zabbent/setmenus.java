package com.example.zabbent;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class setmenus extends Activity{
	 private ListView listserver;
	 
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setmenu);
        //
        listserver = (ListView)findViewById(R.id.listserver);

        //Button add_srv = (Button)findViewById(R.id.setting);
        //add_srv.setOnClickListener(button_listener);
        Button set_add_srv = (Button)findViewById(R.id.set_addserver);
        set_add_srv.setOnClickListener(set_add_listener);
        Button set_back_srv = (Button)findViewById(R.id.set_bak);
        set_back_srv.setOnClickListener(set_bak_listener);
    	listserver.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,getData()));

	}

        //
    //public void listsrv(View vs){
   //     	listserver.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,getData()));
     //   }
	
	private List<String> getData(){
		 
		SharedPreferences srvname = getSharedPreferences("loginfo",0); 
		String srv_name = srvname.getString("user","" );
		//
        List<String> datas = new ArrayList<String>();
       // datas.clear();
       // int size = srvname.getInt("user", 0);
       // for(int i=0;i<size;i++){
        datas.add(srv_name);
       // }
        return datas;
    };
    private Button.OnClickListener set_add_listener = new Button.OnClickListener(){ 
   		 public void onClick(View v){
   			 Intent intent = new Intent();      
   			 intent.setClass(setmenus.this,srvadd.class);
   			 startActivity(intent);
   		 }
   	};
	private Button.OnClickListener set_bak_listener = new Button.OnClickListener(){ 
  		 public void onClick(View v){
  			 Intent intent = new Intent();      
  			 intent.setClass(setmenus.this,MainActivity.class);
  			 startActivity(intent);
  		 }
  	};

}
