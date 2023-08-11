//package com.qing.common.utils;
//
//import com.alibaba.fastjson.JSONObject;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.HttpStatus;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.util.EntityUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.net.ssl.*;
//import javax.servlet.http.HttpServletRequest;
//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.net.URLConnection;
//import java.security.SecureRandom;
//import java.security.cert.CertificateException;
//import java.security.cert.X509Certificate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
///**
// * @Author: he
// * @Description:
// *
// */
//public class HttpUtils {
//
//	private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);
//
//
//	/**
//	 * post请求-json参数
//	 */
//	public static String postHttp(String url, JSONObject jsonParm) {
//		return postHttp(url, new StringEntity(jsonParm.toString(), "UTF-8"));
//	}
//
//
//	/**
//	 * post请求
//	 */
//	private static String postHttp(String url, HttpEntity formEntity) {
//		CloseableHttpClient client = null;
//		HttpPost post = null;
//		String result = "";
//		try {
//			client = HttpClients.createDefault();
//			post = new HttpPost(url);
//			List<NameValuePair> params = new ArrayList<NameValuePair>();
//			post.setEntity(formEntity);
//			HttpResponse resp = client.execute(post);
//			HttpEntity entity = resp.getEntity();
//			result = EntityUtils.toString(entity, "UTF-8");
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (post != null) {
//				post.releaseConnection();
//			}
//			if (client != null) {
//				try {
//					client.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return result;
//	}
//
//	/**
//	 * 发起post请求
//	 *
//	 * @param url
//	 * @param params
//	 * @return
//	 */
//	public static String doHttpClientPost(String url, Map<String, String> params) {
//		CloseableHttpResponse response = null;
//		CloseableHttpClient httpClient = HttpClients.createDefault();
//		String rst = null;
//		try {
//			// 创建一个post对象
//			List<NameValuePair> ps = buildPostParams(params);
//			HttpPost post = new HttpPost(url);
//			logger.info("請求信息地址：{}，打印：{}", url, ps);
//			post.setEntity(new UrlEncodedFormEntity(ps, "UTF-8"));
//			// 执行post请求
//			response = httpClient.execute(post);
//			if (response.getStatusLine().getStatusCode() == 200) {// 网关调用成功
//				rst = inputStreamToStr(response.getEntity().getContent(), "UTF-8");
//				logger.info("=======================================");
//				logger.info(String.format("httpClient Post调用结果：%s", rst));
//				logger.info("=======================================");
//			}
//		} catch (Exception e) {
//			logger.info("=======================================");
//			logger.info(String.format("httpClient Post 请求失败：{}", e));
//			logger.info("=======================================");
//		} finally {
//			try {
//				if (null != response){
//					response.close();
//				}
//				if (null != httpClient){
//					httpClient.close();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		return rst;
//	}
//
//	/**
//	 * json request
//	 *
//	 * @param url
//	 * @param json
//	 * @return
//	 */
//	public static String doPost(String url, String json) {
//		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
//		HttpPost post = new HttpPost(url);
//		HttpGet get = new HttpGet(url);
//
//		String response = null;
//		try {
//			StringEntity s = new StringEntity(json,"UTF-8");
////			s.setContentEncoding("UTF-8");
//			// 发送json数据需要设置contentType
//			s.setContentType("application/json");
//			post.setEntity(s);
//			HttpResponse res = httpclient.execute(post);
//			if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//				response = EntityUtils.toString(res.getEntity());// 返回json格式：
//			}
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//		return response;
//	}
//
//	/**
//	 * 组合map参数
//	 *
//	 * @param params
//	 * @return
//	 */
//	private static List<NameValuePair> buildPostParams(Map<String, String> params) {
//		if (params == null || params.size() == 0){
//			return null;
//		}
//		List<NameValuePair> results = new ArrayList<NameValuePair>();
//
//		for (Map.Entry<String, String> entry : params.entrySet()) {
//			String key = entry.getKey();
//			String value = entry.getValue();
//			results.add(new BasicNameValuePair(key, value));
//		}
//
//		return results;
//	}
//
//	/**
//	 * 根据请求的输入流获取请求参数
//	 *
//	 * @param is
//	 * @param charset
//	 * @return
//	 * @throws IOException
//	 */
//	private static String inputStreamToStr(InputStream is, String charset) throws IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(is, "ISO-8859-1"));
//		StringBuffer buffer = new StringBuffer();
//		String line = "";
//		while ((line = in.readLine()) != null) {
//			buffer.append(line);
//		}
//		return new String(buffer.toString().getBytes("ISO-8859-1"), charset);
//	}
//
//	/**
//	 * 根据请求获取请求IP
//	 *
//	 * @param request
//	 * @return
//	 */
//	public static String getIp(HttpServletRequest request) {
//		String ip = request.getHeader("X-Forwarded-For");
//		if (!ip.isEmpty() && !"unKnown".equalsIgnoreCase(ip)) {
//			// 多次反向代理后会有多个ip值，第一个ip才是真实ip
//			int index = ip.indexOf(",");
//			if (index != -1) {
//				return ip.substring(0, index);
//			} else {
//				return ip;
//			}
//		}
//		ip = request.getHeader("X-Real-IP");
//		if (!ip.isEmpty() && !"unKnown".equalsIgnoreCase(ip)) {
//			return ip;
//		}
//		return request.getRemoteAddr();
//	}
//
//
//	public static String doPostToJson(String urlPath, String Json) {
//
//		String result = "";
//		BufferedReader reader = null;
//		HttpURLConnection conn = null;
//		try {
//			trustAllHosts();
//			URL url = new URL(urlPath);
//			if (url.getProtocol().toLowerCase().equals("https")) {
//				HttpsURLConnection httpsConn = (HttpsURLConnection) url.openConnection();
//				httpsConn.setHostnameVerifier(DO_NOT_VERIFY);
//				conn = httpsConn;
//			}
//			else {
//				conn = (HttpURLConnection) url.openConnection();
//			}
//
//			conn.setRequestMethod("POST");
//			conn.setDoOutput(true);
//			conn.setDoInput(true);
//			conn.setUseCaches(false);
//			conn.setRequestProperty("Connection", "Keep-Alive");
//			conn.setRequestProperty("Charset", "UTF-8");
//			conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
//			// conn.setRequestProperty("accept","*/*");
//			conn.setRequestProperty("accept", "application/json");
//			if (Json != null) {
//				byte[] writebytes = Json.getBytes();
//				conn.setRequestProperty("Content-Length", String.valueOf(writebytes.length));
//				OutputStream outwritestream = conn.getOutputStream();
//				outwritestream.write(Json.getBytes());
//				outwritestream.flush();
//				outwritestream.close();
//			}
//			System.out.println(conn.getResponseMessage());
//			if (conn.getResponseCode() == 200) {
//				reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
//				result = reader.readLine();
//			}
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			if (reader != null) {
//				try {
//					reader.close();
//				}
//				catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return result;
//	}
//
//	final static HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier()
//	{
//		public boolean verify(String arg0, SSLSession arg1) {
//			return true;
//		}
//	};
//
//	public static void trustAllHosts() {
//		TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager()
//		{
//
//			@Override
//			public X509Certificate[] getAcceptedIssuers() {
//				return new X509Certificate[] {};
//			}
//
//			@Override
//			public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
//
//			}
//
//			@Override
//			public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
//
//			}
//		}
//
//		};
//
//		try {
//			SSLContext sc = SSLContext.getInstance("TLS");
//			sc.init(null, trustAllCerts, new SecureRandom());
//			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	/**
//	 * 向指定URL发送GET方法的请求
//	 *
//	 * @param url
//	 *   发送请求的URL
//	 * @param param
//	 *   请求参数，请求参数应该是 name=value&name1=value1 的形式。
//	 * @return URL 所代表远程资源的响应结果
//	 */
//	public static String sendGet(String url, String param) {
//		String result = "";
//		BufferedReader in = null;
//		try {
//			String urlNameString = url + "?" + param;
//			URL realUrl = new URL(urlNameString);
//			// 打开和URL之间的连接
//			URLConnection connection = realUrl.openConnection();
//			// 设置通用的请求属性
//			connection.setRequestProperty("accept", "*/*");
//			connection.setRequestProperty("connection", "Keep-Alive");
//			connection.setRequestProperty("user-agent",
//					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//			// 建立实际的连接
//			connection.connect();
//			// 获取所有响应头字段
//			// Map<String, List<String>> map = connection.getHeaderFields();
//			// 定义 BufferedReader输入流来读取URL的响应
//			in = new BufferedReader(new InputStreamReader(
//					connection.getInputStream()));
//			String line;
//			while ((line = in.readLine()) != null) {
//				result += line;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		// 使用finally块来关闭输入流
//		finally {
//			try {
//				if (in != null) {
//					in.close();
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return result;
//	}
//
//
//
//
//
//}
