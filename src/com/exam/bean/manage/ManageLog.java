package com.exam.bean.manage;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 操作日志
 * @author yww
 */

@Entity(name = "t_manage_log")
public class ManageLog implements Serializable {
	private static final long serialVersionUID = 4831369720275252656L;

	private Integer id;  
	private String log_type;  //日志类型
	private String log_desc;  //描述
	private Date create_time; 
	private Integer op_id;  //操作员ID
	private String op_real_name;   //操作员姓名

	public ManageLog() {
	};

	public ManageLog(String log_type, String log_desc, Date create_time,
			Integer op_id, String op_real_name) {
		super();
		this.log_type = log_type;
		this.log_desc = log_desc;
		this.create_time = create_time;
		this.op_id = op_id;
		this.op_real_name = op_real_name;
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 1, nullable = false)
	public String getLog_type() {
		return log_type;
	}

	public void setLog_type(String log_type) {
		this.log_type = log_type;
	}

	@Column(length = 500)
	public String getlog_desc() {
		return log_desc;
	}

	public void setlog_desc(String log_desc) {
		this.log_desc = log_desc;
	}

	@Column(nullable = false)
	public Integer getOp_id() {
		return op_id;
	}

	public void setOp_id(Integer op_id) {
		this.op_id = op_id;
	}

	@Column(length = 30, nullable = false)
	public String getOp_real_name() {
		return op_real_name;
	}

	public void setOp_real_name(String op_real_name) {
		this.op_real_name = op_real_name;
	}

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

}
