package util;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSONUtil {
	public static String toJson(Object bean){
		//Object->JSONObject
		JSONObject jsonObject=JSONObject.fromObject(bean);
		//JSONObject->String
		return jsonObject.toString();
	}
	public static Object toBean(String json,Class beanClass){
		//String->JSONObject
		JSONObject jsonObject=JSONObject.fromObject(json);
		//JSONObject->Object
		return JSONObject.toBean(jsonObject, beanClass);
	}
	
	public static String toJson(List list){
		JSONArray jsonArray=JSONArray.fromObject(list);
		return jsonArray.toString();
	}
	
	public static List toList(String json,Class beanClass){
		JSONArray jsonArray=JSONArray.fromObject(json);
		return JSONArray.toList(jsonArray,beanClass);
	}
	
	
}
