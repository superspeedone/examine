package com.exam.action.manage;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.annotation.Resource;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;
import com.exam.bean.base.PageView;
import com.exam.bean.manage.ManageOpBasic;
import com.exam.service.manage.AcountService;
import com.opensymphony.xwork2.ActionSupport;

@Controller("userManageAciton")
public class UserManageAciton extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private InputStream responseMsg;
	private String login_name;
	private String real_name;
	private String password;
	private String op_type;
	//按姓名查询
	private String qname="";
	//按分类查询
	private String qmanager="N";  //查询管理员
	private String qteacher="N";   //查询教师
	private String qstudent="N";  //查询学生
	private int page=1;
	private int id;
	
	@Resource(name="acountServiceImpl")
	private AcountService acountService;
    
	/**
	 * 用户查询
	 */
	@Override
	public String execute() {
		StringBuffer jpql = new StringBuffer("o.is_active=?1");
		List<Object> params = new ArrayList<Object>();
		params.add("Y");
		if(!qname.trim().equals("")){
			jpql.append(" and o.real_name like ?"+ (params.size()+1));
			params.add("%"+ qname+ "%");
		}
		//分类查询
		if(qmanager.equals("Y")){
			jpql.append(" and o.op_type = ?"+ (params.size()+1));
			params.add("0");
		}else if(qteacher.equals("Y")){
			jpql.append(" and o.op_type = ?"+ (params.size()+1));
			params.add("1");
		}else if(qstudent.equals("Y")){
			jpql.append(" and o.op_type = ?"+ (params.size()+1));
			params.add("2");
		}
		PageView<ManageOpBasic> pageView = new PageView<ManageOpBasic>(6, getPage());
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("real_name", "asc");
		pageView.setQueryResult(acountService.getScrollData(pageView.getFirstResult(), 
				pageView.getMaxresult(), jpql.toString(), params.toArray(), orderby));
		if((pageView.getCurrentpage()>pageView.getTotalpage()) && (pageView.getTotalpage()>0)){
			pageView = new PageView<ManageOpBasic>(6, 1);
			pageView.setQueryResult(acountService.getScrollData(pageView.getFirstResult(), 
			pageView.getMaxresult(), jpql.toString(), params.toArray(), orderby));
		}
		ServletActionContext.getRequest().setAttribute("pageView", pageView);
		ServletActionContext.getRequest().setAttribute("qmanager", qmanager);
		ServletActionContext.getRequest().setAttribute("qteacher", qteacher);
		ServletActionContext.getRequest().setAttribute("qstudent", qstudent);
		return "list";
	}
	
	/**
	 * 用户删除
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		try {
			acountService.delete(this.id);
			this.setResponseMsg(new ByteArrayInputStream("{\"message\":\"success\"}".toString()
					.getBytes("utf-8")));
		} catch (Exception e) {
			this.setResponseMsg(new ByteArrayInputStream("{\"message\":\"falure\"}".toString()
					.getBytes("utf-8")));
			e.printStackTrace();
		}
		return "delete";
	}
	
	/**
	 * 用户添加界面
	 * @return
	 */
	public String addUI(){
		return "addPage";
	}
	
	/**
	 * 用户添加
	 * @return
	 */
	public String add() throws Exception {
		ManageOpBasic manageOpBasic = new ManageOpBasic();
		manageOpBasic.setLogin_name(this.login_name);
		manageOpBasic.setReal_name(this.real_name);
		manageOpBasic.setPassword(this.password);
		manageOpBasic.setOp_type(this.op_type);
		acountService.save(manageOpBasic);
        ServletActionContext.getRequest().setAttribute("message", "添加成功");
		return "addPage";
	}
	
	/**
	 * 用户更新界面
	 * @return
	 */
	public String editUI(){
		ManageOpBasic manageOpBasic = acountService.find(this.id);
		this.setLogin_name(manageOpBasic.getLogin_name());
		this.setReal_name(manageOpBasic.getReal_name());
		this.setPassword(manageOpBasic.getPassword());
		this.setOp_type(manageOpBasic.getOp_type());
		return "editPage";
	}
	
	/**
	 * 用户更新
	 * @return
	 */
	public String edit(){
		System.out.println(this.id);
		ManageOpBasic manageOpBasic = acountService.find(this.id);
		manageOpBasic.setLogin_name(this.login_name);
		manageOpBasic.setReal_name(this.real_name);
		manageOpBasic.setPassword(this.password);
		manageOpBasic.setOp_type(this.op_type);
		acountService.update(manageOpBasic);
		 ServletActionContext.getRequest().setAttribute("message", "修改成功");
		return "editPage";
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page < 1 ? 1 : page;
	}

	public InputStream getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(InputStream responseMsg) {
		this.responseMsg = responseMsg;
	}

	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}

	public String getReal_name() {
		return real_name;
	}

	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOp_type() {
		return op_type;
	}

	public void setOp_type(String op_type) {
		this.op_type = op_type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQname() {
		return qname;
	}

	public void setQname(String qname) {
		this.qname = qname;
	}

	public String getQmanager() {
		return qmanager;
	}

	public void setQmanager(String qmanager) {
		this.qmanager = qmanager;
	}

	public String getQteacher() {
		return qteacher;
	}

	public void setQteacher(String qteacher) {
		this.qteacher = qteacher;
	}

	public String getQstudent() {
		return qstudent;
	}

	public void setQstudent(String qstudent) {
		this.qstudent = qstudent;
	}
	
}
