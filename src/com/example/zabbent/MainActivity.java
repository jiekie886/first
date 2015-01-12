package com.example.zabbent;


import java.util.ArrayList;
import java.util.List;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
//import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {
	//private Button  b_showhost = null;
	private ListView l_hostlist;

	@Override
	
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //b_showhost = (Button)findViewById(R.id.host);
        //Button b_setting = (Button)findViewById(R.id.setting);
        l_hostlist = (ListView)findViewById(R.id.hostlist);
        Button set_srv = (Button)findViewById(R.id.setting);
        set_srv.setOnClickListener(button_listener);

    }


	private Button.OnClickListener button_listener = new Button.OnClickListener(){ 
		
		 public void onClick(View v){
			 Intent intent = new Intent();      
			 intent.setClass(MainActivity.this,setmenus.class);
			 startActivity(intent);
		 }
	};
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void showhost(View view) //throws JSONException 
    {
    	//zabbix_info.get_info();
        l_hostlist.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,getData1()));
      
    	//b_showhost.setBackgroundColor(0);
    	//return "hello";
    }
    public void showgraphics(View view)
    {
    	
    	l_hostlist.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,getData2()));
        
    	//b_showhost.setBackgroundColor(0);
    	//return "hello";
    }
    public void showscreen(View view)
    {
    	
    	l_hostlist.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,getData3()));
        
    	//b_showhost.setBackgroundColor(0);
    	//return "hello";
    }

	private  List<String>  getData1() 
	{
		//zabbix_info info = new zabbix_info();
		//info.start();
        //String data = zabbix_info.get_info();
        //List<String> datas = JSONObject.getNames(data);
        //data.add(zabbix_info.appadd().toString());
        //return datas;
		//DoSomething  info = new DoSomething(zabbix_info.get_info());
		//Thread  info = new Thread(zabbix_info.get_info());
	//	return zabbix_info.start();
        List<String> data = new ArrayList<String>();
        data.add("host");
        return data;
    }
	private List<String> getData2()
	{
        
        List<String> data = new ArrayList<String>();
        data.add("test2");
        return data;
    }
	private List<String> getData3()
	{
        
        List<String> data = new ArrayList<String>();
        data.add("test3");
        return data;
    }


}