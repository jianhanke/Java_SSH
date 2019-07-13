package cn.itcast.manytomany;
import java.util.HashSet;
import java.util.Set;

public class Course {
	private Integer id; //课程id
	private String cname; // 课程名称
	//使用set集合关联学生类
	private Set<Student> students = new HashSet<Student>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	
	
	
}
