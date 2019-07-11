package cn.itcast.action;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.apache.struts2.ServletActionContext;
import sun.misc.BASE64Encoder;
import com.opensymphony.xwork2.ActionSupport;
public class SimpleDownLoad2Action  extends ActionSupport{
	private String filename; // 代表下载文件的名称
	private String contentType; // 下载文件的MimeType
	/**
	 * 获取文件的名称
	 */
	public String getFilename() throws IOException {
		return encodeDownloadFilename(filename,ServletActionContext.getRequest().getHeader("User-Agent"));
	}
	public void setFilename(String filename) throws UnsupportedEncodingException{
		System.out.println("文件名字:"+filename);
		this.filename = filename;
	}
	public String getContentType() {
		return  ServletActionContext.getServletContext().getMimeType(filename);
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	//定义了返回InputStream的方法，该方法作为被下载文件的入口
	public InputStream getDownloadFile2() throws IOException{
		String filepath = "/upload/"+filename;
		return ServletActionContext.getServletContext()
			   .getResourceAsStream(filepath);
	}
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String encodeDownloadFilename(String name, String agent) throws IOException {
	if (agent.contains("Firefox")) {        // 火狐浏览器
	 name = "=?UTF-8?B?"+ new BASE64Encoder().encode(name.getBytes("utf-8")) + "?=";
	 System.out.println("火狐解码:"+name);
	} else {                                // IE及其他浏览器
		System.out.println("其他浏览器解码:"+name);
		name = URLEncoder.encode(name, "utf-8");
	}
		return name;
	}
}
