package com.exam.action.manage;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
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
	private int page=1;
	private int id;
	
	@Resource(name="acountServiceImpl")
	private AcountService acountService;
    
	/**
	 * 用户查询
	 */
	@Override
	public String execute() {
		PageView<ManageOpBasic> pageView = new PageView<ManageOpBasic>(6, getPage());
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("real_name", "asc");
		pageView.setQueryResult(acountService.getScrollData(pageView.getFirstResult(), 
				pageView.getMaxresult(), orderby));
		ServletActionContext.getRequest().setAttribute("pageView", pageView);
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
	
}
