package com.exam.bean.teacher;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 教师信息
 * 
 * @author yww
 */

@Entity(name = "t_teacher_basic")
public class TeacherBasic implements Serializable {
	private static final long serialVersionUID = -1243165628609016138L;

	private Integer id;
	private String teacher_code;
	private String name;
	private String sex = "2"; // '0:男 1:女 2:未知 4:不确定'
	private String id_no; // 身份证
	private String face;
	private Date birthday;
	private String mobile;
	private String email;
	private String status = "0"; // '0:正常 1:已激活登录 2:注销'
	private String reserve1;
	private String reserve2;
	private String reserve3;
	private String reserve4;
	private Date create_time;
	private Integer op_id; // 操作员ID
	private String op_real_name; // 操作员姓名
	private String is_active = "0"; // '0:有效 1:无效'

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 30, nullable = false)
	public String getTeacher_code() {
		return teacher_code;
	}

	public void setTeacher_code(String teacher_code) {
		this.teacher_code = teacher_code;
	}

	@Column(length = 30, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 1, nullable = false)
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(length = 30)
	public String getId_no() {
		return id_no;
	}

	public void setId_no(String id_no) {
		this.id_no = id_no;
	}

	@Column(length = 100)
	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = true)
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(length = 20)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(length = 50)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 1)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(length = 50)
	public String getReserve1() {
		return reserve1;
	}

	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}

	@Column(length = 50)
	public String getReserve2() {
		return reserve2;
	}

	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}

	@Column(length = 50)
	public String getReserve3() {
		return reserve3;
	}

	public void setReserve3(String reserve3) {
		this.reserve3 = reserve3;
	}

	@Column(length = 50)
	public String getReserve4() {
		return reserve4;
	}

	public void setReserve4(String reserve4) {
		this.reserve4 = reserve4;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	@Column(nullable = true)
	public Integer getOp_id() {
		return op_id;
	}

	public void setOp_id(Integer op_id) {
		this.op_id = op_id;
	}

	@Column(length = 30)
	public String getOp_real_name() {
		return op_real_name;
	}

	public void setOp_real_name(String op_real_name) {
		this.op_real_name = op_real_name;
	}

	@Column(length = 1, nullable = false)
	public String getIs_active() {
		return is_active;
	}

	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((teacher_code == null) ? 0 : teacher_code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeacherBasic other = (TeacherBasic) obj;
		if (teacher_code == null) {
			if (other.teacher_code != null)
				return false;
		} else if (!teacher_code.equals(other.teacher_code))
			return false;
		return true;
	}

}
