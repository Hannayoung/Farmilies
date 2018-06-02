package com.coin.restful;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;


public class LoopChain_restFul {
	public static int id = 131;
	private static SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd");
	
	//"key":"c2","value":{"farmer":"1","location":"seoul","reward":3,"citizen":"2","when":"18/6/1","uptime":"now","fulfillment":"yet"}
	public static JSONObject invoke_contract(int key, String farmer, String location, int reward, String citizen, String when ) {
		JSONObject params = new JSONObject();
		JSONObject value = new JSONObject();
		
		try {
			params.put("key", Integer.toString(key));
			
			value.put("farmer", farmer);
			value.put("location", location);
			value.put("reward", reward);
			value.put("citizen", citizen);
			value.put("when", when);
			value.put("uptime", dayTime.format(new Date(System.currentTimeMillis())) );
			value.put("fulfillment", "yet");
			
			params.put("value", value);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return restful("transactions","invoke_contract", params, false);
	}
	
	//{"key":"c1","value":{"starting_time":"9:00","end_time": "18:00"}}
	public static JSONObject invoke_done(int key, String starting_time, String end_time) {
		JSONObject params = new JSONObject();
		JSONObject value = new JSONObject();
		
		try {
			params.put("key", Integer.toString(key));
			
			value.put("starting_time", starting_time);
			value.put("end_time", end_time);
			
			params.put("value", value);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return restful("transactions","invoke_done", params, false);
	}
	
	//{"key":"c1","value":{"who":"1","why":"no reason","uptime":"tomorrow"}}
	public static JSONObject invoke_cancel(int key, String who, String why, String uptime) {
		JSONObject params = new JSONObject();
		JSONObject value = new JSONObject();
		
		try {
			params.put("key", Integer.toString(key));
			
			value.put("who", who);
			value.put("why", why);
			value.put("uptime", uptime);
			
			params.put("value", value);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return restful("transactions","invoke_cancel", params, false);
	}
	
	//{"key":"c1"}
	public static JSONObject invoke_person(String key) {
		JSONObject params = new JSONObject();
		
		try {
			params.put("key", key);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return restful("transactions","invoke_person", params, false);
	}
	
	//{"key":"c1","value":{"rating":5}}
	public static JSONObject invoke_rating(String key, int rating) {
		JSONObject params = new JSONObject();
		
		try {
			params.put("key", key);
			params.put("rating", rating);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return restful("transactions","invoke_rating", params, false);
	}
		
	//{"key":"c1","value":{"purchase_token":"10"}}
	public static JSONObject invoke_purchase_token(String key, int purchase_token) {
		JSONObject params = new JSONObject();
		
		try {
			params.put("key", key);
			params.put("purchase_token", purchase_token);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return restful("transactions","invoke_purchase_token", params, false);
	}
	
	//{"key":"c1","value":{"spending_amount":"10"}}
	public static JSONObject invoke_spend_token(String key, int spending_amount) {
		JSONObject params = new JSONObject();
		
		try {
			params.put("key", key);
			params.put("spending_amount", spending_amount);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return restful("transactions","invoke_spend_token", params, false);
	}
	
	public static JSONObject query_contract(int key) {
		JSONObject params = new JSONObject();

		try {
			params.put("key", Integer.toString(key));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return restful("query","query_contract", params, true);
	}
	
	public static JSONObject query_person(String key) {
		JSONObject params = new JSONObject();

		try {
			params.put("key", key);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return restful("query","query_person", params, true);
	}
	
	
	private static JSONObject restful(String str, String method, JSONObject params, boolean id_int) {
		try {
			String url="http://ec2-52-69-239-126.ap-northeast-1.compute.amazonaws.com:9000/api/v1/" + str;
			URL object=new URL(url);
						
			//-H "Content-Type: application/json" -X POST -d '{"jsonrpc":"2.0","id":"13","method":"query_person","params":{"key":"1"}}'
			
			HttpURLConnection con = (HttpURLConnection) object.openConnection();
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Accept", "application/json");
			con.setRequestMethod("POST");
	
			JSONObject json   = new JSONObject();
			JSONObject key = new JSONObject();
	
			json.put("jsonrpc","2.0");
			//if(id_int)
			//	json.put("id", LoopChain_restFul.id++);
			//else
				json.put("id", String.valueOf(LoopChain_restFul.id++));
			json.put("method",method);
			json.put("params", params);
	
			OutputStream os = con.getOutputStream();
			os.write(json.toString().getBytes("UTF-8"));
			os.close();
	
			//display what returns the POST request
	
			StringBuilder sb = new StringBuilder();  
			int HttpResult = con.getResponseCode(); 
			System.out.println(con.getResponseMessage());
			if (HttpResult == HttpURLConnection.HTTP_OK) {
			    BufferedReader br = new BufferedReader(
			            new InputStreamReader(con.getInputStream(), "utf-8"));
			    String line = null;  
			    while ((line = br.readLine()) != null) {  
			        sb.append(line + "\n");  
			    }
			    br.close();
			    System.out.println("" + sb.toString());  
			} else {
			    System.out.println(con.getResponseMessage());  
			}  
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
}

