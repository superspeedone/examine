package com.exam.bean.question;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "t_question_topic_basic")
public class QuestionTopic implements Serializable {
	private static final long serialVersionUID = 8278500501753646644L;

	private Integer id;
	private String topic_name;
	private String topic_type; // '0:单选题 1:多选题 2:判断题 3:填空题 4:问答题'
	private String topic_tags;
	private Integer course_id;
	private String course_name;
	private String topic_desc; // 65535
	private String remark;
	private String reserve1;
	private String reserve2;
	private String reserve3;
	private String answer_desc; // 65535
	private Integer up_topic_id;
	private Date create_time;
	private String is_random; // '0:否 1:是'
	private String is_share; // '0:否 1:是'
	private String topic_level; // '0:超级简单 1:简单 2:正常 3:有难度 4:很难'
	private Integer op_id;
	private String op_real_name;
	private String is_active="0"; // '0:有效 1:无效';
	private Integer pra_up_topic_id; // '如果本题是实务I综合题的一部分，则用此关联'

	@Id @GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length=100,nullable=false)
	public String getTopic_name() {
		return topic_name;
	}

	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}

	@Column(length=2,nullable=false)
	public String getTopic_type() {
		return topic_type;
	}

	public void setTopic_type(String topic_type) {
		this.topic_type = topic_type;
	}

	@Column(length=100)
	public String getTopic_tags() {
		return topic_tags;
	}

	public void setTopic_tags(String topic_tags) {
		this.topic_tags = topic_tags;
	}

	@Column(nullable=true)
	public Integer getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}

	@Column(length=50)
	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	@Column(length=65535)
	public String getTopic_desc() {
		return topic_desc;
	}

	public void setTopic_desc(String topic_desc) {
		this.topic_desc = topic_desc;
	}

	@Column(length=100)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(length=100)
	public String getReserve1() {
		return reserve1;
	}

	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}

	@Column(length=100)
	public String getReserve2() {
		return reserve2;
	}

	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}

	@Column(length=100)
	public String getReserve3() {
		return reserve3;
	}

	public void setReserve3(String reserve3) {
		this.reserve3 = reserve3;
	}

	@Column(length=65535)
	public String getAnswer_desc() {
		return answer_desc;
	}

	public void setAnswer_desc(String answer_desc) {
		this.answer_desc = answer_desc;
	}

	@Column(nullable=false)
	public Integer getUp_topic_id() {
		return up_topic_id;
	}

	public void setUp_topic_id(Integer up_topic_id) {
		this.up_topic_id = up_topic_id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	@Column(length=1,nullable=false)
	public String getIs_random() {
		return is_random;
	}

	public void setIs_random(String is_random) {
		this.is_random = is_random;
	}

	@Column(length=1,nullable=false)
	public String getIs_share() {
		return is_share;
	}

	public void setIs_share(String is_share) {
		this.is_share = is_share;
	}

	@Column(length=1)
	public String getTopic_level() {
		return topic_level;
	}

	public void setTopic_level(String topic_level) {
		this.topic_level = topic_level;
	}

	@Column(nullable=true)
	public Integer getOp_id() {
		return op_id;
	}

	public void setOp_id(Integer op_id) {
		this.op_id = op_id;
	}

	@Column(length=30)
	public String getOp_real_name() {
		return op_real_name;
	}

	public void setOp_real_name(String op_real_name) {
		this.op_real_name = op_real_name;
	}

	@Column(length=1,nullable=false)
	public String getIs_active() {
		return is_active;
	}

	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}

	@Column(nullable=false)
	public Integer getPra_up_topic_id() {
		return pra_up_topic_id;
	}

	public void setPra_up_topic_id(Integer pra_up_topic_id) {
		this.pra_up_topic_id = pra_up_topic_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		QuestionTopic other = (QuestionTopic) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
