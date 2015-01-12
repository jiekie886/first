package com.example.zabbent;

import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.UnsupportedEncodingException;  
import java.io.OutputStream;        
import java.net.HttpURLConnection;  
import java.net.MalformedURLException;  
import java.net.URL;  
import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
//import android.app.Activity;
 
       
    public class zabbix_info extends Activity implements Runnable {
    	
  //  	private ListView l_hostlist;

    	//@Override
       // protected void onCreate(Bundle savedInstanceState) {
       //     super.onCreate(savedInstanceState);
       //     setContentView(R.layout.activity_main);
            //b_showhost = (Button)findViewById(R.id.host);
            //Button b_setting = (Button)findViewById(R.id.setting);
   //         l_hostlist = (ListView)findViewById(R.id.hostlist);
         //   new Thread(runnable).start();
           // StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
           // StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().detectLeakedClosableObjects().penaltyLog().penaltyDeath().build());
    	//}
       // @Override
      //  public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
      //      getMenuInflater().inflate(R.menu.main, menu);
      //      return true;
      //  }

   //     public void showhost(View view){
   // 		l_hostlist.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,getData()));
   //     }	
    	
        public Button button;  
        public LinearLayout my_layout;  
        @SuppressLint("HandlerLeak") public Handler mHandler=new Handler()  
        {  
            public void handleMessage(Message msg)  
            {  
                switch(msg.what)  
                {  
                case 1:  
                    //button.setText(R.string.host); 
                    //button.setBackgroundColor(TRIM_MEMORY_BACKGROUND);
                    my_layout.addView(button);
                    break;  
                default:  
                    break;            
                }  
                my_layout.invalidate();  
                super.handleMessage(msg);  
            }  
        };  
          
        /** Called when the activity is first created. */  
        @Override  
        public void onCreate(Bundle savedInstanceState)  
        {  
            super.onCreate(savedInstanceState);  
            setContentView(R.layout.activity_main);  
              
            button=(Button)findViewById(R.id.host);  
            my_layout=(LinearLayout)findViewById(R.id.hostlist);  
            button.setOnClickListener(button_listener);

            Thread thread=new Thread(this);  
            thread.start();  
        }  
    	private Button.OnClickListener button_listener = new Button.OnClickListener(){ 
    		
   		 public void onClick(View v){
   			 Intent intent = new Intent();      
   			 intent.setClass(zabbix_info.this,MainActivity.class);
   			 startActivity(intent);
   		 }
   	};
        @Override  
        public void run()  
        {  
            Log.e("ok", "111111111");  
            // TODO Auto-generated method stub  
            Message message=new Message();  
            message.what=1;  
            mHandler.sendMessage(message);  
        }  

            public static final String auth_url = "http://203.195.141.56/zabbix/api_jsonrpc.php";  
         //   public static final String ADD_URL = "http://192.168.4.97:35357/v2.0/tokens";  
         //   Runnable runnable = new Runnable(){
         //   	@Override
         //   	 public void run() {
         //   		get_info();
         //   	}
         //   };
            public static String appadd()  {  
                HttpURLConnection connection=null; 
                StringBuffer sb = null;
                try {  
                     //创建连接  
                     URL url = new URL(auth_url);  
                     connection = (HttpURLConnection) url.openConnection();  
                       
          
                     //设置http连接属性  
                       
                     connection.setDoOutput(true);  
                     connection.setDoInput(true);  
                     connection.setRequestMethod("POST"); // 可以根据需要 提交 GET、POST、DELETE、INPUT等http提供的功能  
                     connection.setUseCaches(false);  
                     connection.setInstanceFollowRedirects(true);  
                       
                     //设置http头 消息  
                     connection.setRequestProperty("Content-Type","application/json");  //设定 请求格式 json，也可以设定xml格式的  
                     //connection.setRequestProperty("Content-Type", "text/xml");   //设定 请求格式 xml，  
                     connection.setRequestProperty("Accept","application/json");//设定响应的信息的格式为 json，也可以设定xml格式的  
        //             connection.setRequestProperty("X-Auth-Token","xx");  //特定http服务器需要的信息，根据服务器所需要求添加  
                     connection.connect();  
           
                     //添加 请求内容  
                       
                    JSONObject user = new JSONObject();    
                    user.put("user", "diwei");  
                    user.put("password ", "huahuakeji");  
          
                    //构建嵌套的 json数据  
                      
                    JSONObject obj = new JSONObject(); 
                    obj.put("jsonrpc", "2.0");  
                    obj.put("method", "user.login");  
                    obj.put("params",user);  
                    obj.put("id", "1");
                    
                    
                    OutputStream out = connection.getOutputStream();                          
                    out.write(obj.toString().getBytes());  
                    out.flush();  
                    //out.close();  
           
        //            读取响应  
                     BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));  
                     String lines;  
                     sb = new StringBuffer("");  
                     while ((lines = reader.readLine()) != null) {  
                         lines = new String(lines.getBytes(), "utf-8");  
                         sb.append(lines);  
                     }  
                     //System.out.println(sb);  
                     //reader.close();  
        ////              断开连接  
                     connection.disconnect();  
                 } catch (MalformedURLException e) {  
                     // TODO Auto-generated catch block  
                     e.printStackTrace();  
                 } catch (UnsupportedEncodingException e) {  
                     // TODO Auto-generated catch block  
                     e.printStackTrace();  
                 } catch (IOException e) {  
                     // TODO Auto-generated catch block  
                     e.printStackTrace();  
                 }  
                return sb.toString();
            }  
          
           
           // public static void main(String[] args) throws JSONException{  
           //      appadd();  
           //  }  
       // 	private String getData()
       // 	{
       //         String data = appadd();
              //  List<String> data = new ArrayList<String>();
              //  data.add(appadd());
      //          return data;
       //     }

            public static List<String>  get_info()  {
            	//Thread get = new Thread(appadd());
            	//get.start();
            	String reponse = appadd();
            	JSONArray jsonArray = JSONArray.fromObject(reponse);
            	//Object[] obj=getJsonToArray(jsonArray);
            	//for(int i=0;i<obj.length;i++){
            	//	System.out.println(obj[i]);
            	//}
            	//JSONArray  json  = JSONArray(reponse.);
            	//AUTH = json.getString("result");
            	//return reponse;
            	//jsonToList(jsonArray);
            //}
            //private static List<Object> jsonToList(JSONArray jsonArr)throws JSONException {
                List<String> jsonToMapList = new ArrayList<String>();
               // jsonToMapList = jsonArray.toList(jsonArray);
                for (int i = 0; i < jsonArray.size(); i++) {
                	Object object = jsonArray.get(i);
                        jsonToMapList.add(object.toString());
                }
                return jsonToMapList;
            }
           

      //      	public void run(){
      //      		get_info();
      //     	}
            
       //     	public static void main(String[] args){
      //      		zabbix_info info = new zabbix_info();
      //      		info.start();
       //     	}

    }
