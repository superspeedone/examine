package com.exam.service.manage.impl;

import org.springframework.stereotype.Service;
import com.exam.bean.manage.ManageOpBasic;
import com.exam.service.base.DaoSupport;
import com.exam.service.manage.AcountService;

@Service("acountServiceImpl")
public class AcountServiceImpl extends DaoSupport<ManageOpBasic> implements AcountService{
	
}
