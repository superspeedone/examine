package com.exam.service.manage.impl;

import java.util.Date;
import org.springframework.stereotype.Service;
import com.exam.bean.manage.ManageLog;
import com.exam.service.base.DaoSupport;
import com.exam.service.manage.LogService;

@Service("logServiceImpl")
public class LogServiceImpl extends DaoSupport<ManageLog> implements LogService {

	@Override
	public void insertLog(String log_type, String desc, Integer op_id, String op_real_name) {
		ManageLog manageLog = new ManageLog(log_type, desc, new Date(), op_id,
				op_real_name);
		save(manageLog);
	}

}
