package junit.test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.exam.bean.base.PageView;
import com.exam.bean.base.QueryResult;
import com.exam.bean.manage.OpBasic;
import com.exam.bean.student.Sex;
import com.exam.service.manage.OpManageService;
import com.exam.service.manage.LogService;
import com.exam.utils.MD5;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationcontext.xml")
public class ManageTest {
	@Resource(name="acountServiceImpl")
	private OpManageService acountService;
	@Resource(name="logServiceImpl")
	private LogService logService;
	private String qname="张飞";

	@Test
	public void query() {
		StringBuffer jpql = new StringBuffer("o.is_active=?1");
		List<Object> params = new ArrayList<Object>();
		params.add("Y");
		if(!qname.trim().equals("")){
			jpql.append(" and o.real_name like ?"+ (params.size()+1));
			params.add("%"+ qname+ "%");
		}
		PageView<OpBasic> pageView = new PageView<OpBasic>(6, 1);
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("real_name", "asc");
		pageView.setQueryResult(acountService.getScrollData(pageView.getFirstResult(), 
				pageView.getMaxresult(), jpql.toString(), params.toArray(), orderby));
		
		for (OpBasic s  : pageView.getRecords()) {
			System.out.println("******************"+s.getLogin_name());
		}
	}
	
	@Test
	public void save() {
		OpBasic manageOpBasic;
		for (int i = 0; i < 30; i++) {
			manageOpBasic = new OpBasic();
			manageOpBasic.setLogin_name("admin"+(i+50));
			manageOpBasic.setPassword(MD5.MD5Encode("11111111"));
			manageOpBasic.setReal_name("测试"+(i+50));
			manageOpBasic.setOp_type("0");
			acountService.save(manageOpBasic);
		}
	}
	
	@Test
	public void delete() {
		acountService.delete(1);
	}
	
	@Test
	public void testEnum(){
		System.out.println(Sex.MAN.getName());
	}

	@Test
	public void log(){
		logService.insertLog("0", "登陆成功，当前用户：孙悟空", 01, "孙悟空");
	}

}
