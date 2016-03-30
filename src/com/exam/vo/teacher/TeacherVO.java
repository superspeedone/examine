package com.exam.vo.teacher;

import java.util.Date;

public class TeacherVO {
	// 保存数据
	private Integer id;
	private String teacher_code;
	private String name;
	private String sex; // '0:男 1:女 2:未知 4:不确定'
	private String id_no; // 身份证
	private String face;
	private Date birthday;
	private String mobile;
	private String email;
	private String reserve1;
	private String reserve2;
	private String reserve3;
	private String reserve4;
	// 操作人员信息
	private Integer op_id; // 操作员ID
	private String op_real_name; // 操作员姓名

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTeacher_code() {
		return teacher_code;
	}

	public void setTeacher_code(String teacher_code) {
		this.teacher_code = teacher_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getId_no() {
		return id_no;
	}

	public void setId_no(String id_no) {
		this.id_no = id_no;
	}

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReserve1() {
		return reserve1;
	}

	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}

	public String getReserve2() {
		return reserve2;
	}

	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}

	public String getReserve3() {
		return reserve3;
	}

	public void setReserve3(String reserve3) {
		this.reserve3 = reserve3;
	}

	public String getReserve4() {
		return reserve4;
	}

	public void setReserve4(String reserve4) {
		this.reserve4 = reserve4;
	}

	public Integer getOp_id() {
		return op_id;
	}

	public void setOp_id(Integer op_id) {
		this.op_id = op_id;
	}

	public String getOp_real_name() {
		return op_real_name;
	}

	public void setOp_real_name(String op_real_name) {
		this.op_real_name = op_real_name;
	}

}
