package junit.test;

import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.exam.bean.base.QueryResult;
import com.exam.bean.manage.ManageOpBasic;
import com.exam.bean.student.Sex;
import com.exam.service.manage.AcountService;
import com.exam.utils.MD5;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationcontext.xml")
public class ManageTest {
	@Resource(name="acountServiceImpl")
	private AcountService acountService;

	@Test
	public void query() {
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("real_name", "desc");
		QueryResult<ManageOpBasic> queryResult = acountService.getScrollData(0, 6, orderby);
		List<ManageOpBasic> manageOpBasicsList = queryResult.getResultlist();
		for (int i = 0; i < manageOpBasicsList.size(); i++) {
			System.out.println("------"+manageOpBasicsList.get(i).getReal_name());
		}
	}
	
	@Test
	public void save() {
		ManageOpBasic manageOpBasic;
		for (int i = 0; i < 30; i++) {
			manageOpBasic = new ManageOpBasic();
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


}
