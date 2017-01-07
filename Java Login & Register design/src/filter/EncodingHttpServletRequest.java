package filter;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncodingHttpServletRequest extends HttpServletRequestWrapper{
	private HttpServletRequest request;
	public EncodingHttpServletRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	@Override
	public String getParameter(String name) {
		String value = request.getParameter(name);
		try {
			if(value!=null && "".equals(value)){
					value = new String(value.getBytes("iso-8859-1"),"utf-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return value;
	}
	@Override
	public Map<String, String[]> getParameterMap() {
		Map<String, String[]> parameterMap = request.getParameterMap();
		Map<String, String[]> map = new HashMap<String, String[]>();
		for (Entry<String, String[]> entry : parameterMap.entrySet()) {
			String[] value = entry.getValue();
			String[] newValue = new String[value.length];
			int i = 0;
			for (String string : value) {
				try {
					string = new String(string.getBytes("iso-8859-1"), "utf-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				newValue[i++] = string;
			}
			map.put(entry.getKey(), newValue);
		}
		return map;
	}
}
