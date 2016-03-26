package com.exam.service.manage;

public interface LogService {
	public void insertLog(String log_type, String desc, Integer op_id, String op_real_name);

}
