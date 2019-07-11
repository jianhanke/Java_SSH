package cn.itcast.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport {
	private static final long serialVersionUID=1L;
	private File file;
	private String fileFileName;
	private String fileContentType;
	
	
	public File getFile() {
		return file;
	}


	public void setFile(File file) {
		this.file = file;
	}


	public String getFileFileName() {
		return fileFileName;
	}


	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}


	public String getFileContentType() {
		return fileContentType;
	}


	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String execute()throws Exception{
		InputStream is=new FileInputStream(file);
		String uploadPath=ServletActionContext.getServletContext().getRealPath("/upload");
		
		File realFile=new File(uploadPath);
		if(!realFile.exists()) {
			realFile.mkdirs();
		}
		
		File toFile=new File(uploadPath,this.getFileFileName());
		OutputStream os=new FileOutputStream(toFile);
		byte[] buffer=new byte[1024];
		int length=0;
		while(-1!=(length=is.read(buffer,0,buffer.length)) ) {
			os.write(buffer);
		}
		is.close();
		os.close();
		return SUCCESS;
		
	}
	
}
