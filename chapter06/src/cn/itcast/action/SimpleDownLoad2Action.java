package cn.itcast.action;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.apache.struts2.ServletActionContext;
import sun.misc.BASE64Encoder;
import com.opensymphony.xwork2.ActionSupport;
public class SimpleDownLoad2Action  extends ActionSupport{
	private String filename; // ���������ļ�������
	private String contentType; // �����ļ���MimeType
	/**
	 * ��ȡ�ļ�������
	 */
	public String getFilename() throws IOException {
		return encodeDownloadFilename(filename,ServletActionContext.getRequest().getHeader("User-Agent"));
	}
	public void setFilename(String filename) throws UnsupportedEncodingException{
		System.out.println("�ļ�����:"+filename);
		this.filename = filename;
	}
	public String getContentType() {
		return  ServletActionContext.getServletContext().getMimeType(filename);
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	//�����˷���InputStream�ķ������÷�����Ϊ�������ļ������
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
	if (agent.contains("Firefox")) {        // ��������
	 name = "=?UTF-8?B?"+ new BASE64Encoder().encode(name.getBytes("utf-8")) + "?=";
	 System.out.println("�������:"+name);
	} else {                                // IE�����������
		System.out.println("�������������:"+name);
		name = URLEncoder.encode(name, "utf-8");
	}
		return name;
	}
}
