package com.exam.action.manage;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.exam.bean.base.PageView;
import com.exam.bean.manage.OpBasic;
import com.exam.service.manage.OpManageService;
import com.exam.utils.Tools;
import com.exam.vo.manage.OpVO;
import com.opensymphony.xwork2.ActionSupport;

@Controller("opManageAciton")
public class OpManageAciton extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private InputStream responseMsg;
	private int page=1;
	private int offset=0;
	private int maxrows=10;
	//要操作的人员序号（数据库中ID字段）
	private int id;
	//排序参数
	private String sort;
	private String sortOrder;
	//查询参数
	private String real_name;
	private String qm = "N"; // 查询管理员
	private String qt = "N"; // 查询教师
	private String qs = "N"; // 查询学生
	//保存或修改用户使用
	private OpVO opVO = new OpVO();
	
	@Resource(name="opManageServiceImpl")
	private OpManageService opManageService;
	
	/**
	 * 跳转用户查询界面
	 */
	@Override
	public String execute() throws Exception {
		return "listUI";
	}
    
	/**
	 * 用户查询 
	 * @throws Exception 
	 */
	public String query() throws Exception {
		StringBuffer jpql = new StringBuffer("o.is_active=?1");
		List<Object> params = new ArrayList<Object>();
		params.add("Y");
		//按姓名查询
		if(real_name!=null && real_name.length() > 0) {
			jpql.append(" and o.real_name like ?"+ (params.size()+1));
			params.add("%"+ real_name+ "%");
		}
		//分类查询
		if(qm.equals("Y")){
			jpql.append(" and o.op_type = ?"+ (params.size()+1));
			params.add("0");
		}else if(qt.equals("Y")){
			jpql.append(" and o.op_type = ?"+ (params.size()+1));
			params.add("1");
		}else if(qs.equals("Y")){
			jpql.append(" and o.op_type = ?"+ (params.size()+1));
			params.add("2");
		}
		//分页
		PageView<OpBasic> pageView = new PageView<OpBasic>(maxrows, page);
		//排序
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if (sort != null && sort.length() > 0){
			orderby.put(sort, sortOrder);
		}else {
			orderby.put("login_name", "asc");
		}
		//获取分页数据
		pageView.setQueryResult(opManageService.getScrollData(pageView.getFirstResult(), 
				pageView.getMaxresult(), jpql.toString(), params.toArray(), orderby));
		//将获取到的人员数据转换成bootstrap table使用的JSON格式
		List<OpBasic> opList = pageView.getRecords();
		JSONArray opData=new JSONArray();
		JSONObject jo=null;
		for (int i = 0; i < opList.size(); i++) {
			OpBasic op = opList.get(i);
			if(op == null) { continue; }
			jo=new JSONObject();
			jo.put("rownum", offset + i +1);
			jo.put("id", op.getId());
			jo.put("login_name", op.getLogin_name());
			jo.put("real_name", op.getReal_name());
			if(op.getOp_type().equals("0")){
				jo.put("op_type", "管理员");
			} else if(op.getOp_type().equals("1")) {
				jo.put("op_type", "教师");
			} else if(op.getOp_type().equals("2")) {
				jo.put("op_type", "学生");
			} else {
				jo.put("op_type", "-");
			}
			jo.put("create_time", Tools.dateToString(op.getCreate_time()));
			opData.add(jo);	
		}
		JSONObject dataObj=new JSONObject();
		dataObj.put("rows", opData);
		dataObj.put("total",pageView.getTotalrecord());
		try {
			System.out.println(dataObj.toString());
			this.setResponseMsg(new ByteArrayInputStream(dataObj.toString().getBytes("utf-8")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	
	/**
	 * 用户删除
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		try {
			opManageService.delete(getId());
			this.setResponseMsg(new ByteArrayInputStream("{\"eMessage\":\"success\"}".toString()
					.getBytes("utf-8")));
		} catch (Exception e) {
			this.setResponseMsg(new ByteArrayInputStream("{\"eMessage\":\"failed\"}".toString()
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
		return "addUI";
	}
	
	/**
	 * 用户添加
	 * @return
	 */
	public String add() throws Exception {
		OpBasic manageOpBasic = new OpBasic();
		manageOpBasic.setLogin_name(opVO.getLogin_name());
		manageOpBasic.setReal_name(opVO.getReal_name());
		manageOpBasic.setPassword(opVO.getPassword());
		manageOpBasic.setOp_type(opVO.getOp_type());
		opManageService.save(manageOpBasic);
        ServletActionContext.getRequest().setAttribute("eMessage", "添加成功");
		return "addUI";
	}
	
	/**
	 * 用户更新界面
	 * @return
	 */
	public String editUI(){
		OpBasic manageOpBasic = opManageService.find(getId());
		opVO.setLogin_name(manageOpBasic.getLogin_name());
		opVO.setReal_name(manageOpBasic.getReal_name());
		opVO.setPassword(manageOpBasic.getPassword());
		opVO.setOp_type(manageOpBasic.getOp_type());
		return "editUI";
	}
	
	/**
	 * 用户更新
	 * @return
	 */
	public String edit(){
		OpBasic manageOpBasic = opManageService.find(opVO.getId());
		manageOpBasic.setLogin_name(opVO.getLogin_name());
		manageOpBasic.setReal_name(opVO.getReal_name());
		manageOpBasic.setPassword(opVO.getPassword());
		manageOpBasic.setOp_type(opVO.getOp_type());
		opManageService.update(manageOpBasic);
		 ServletActionContext.getRequest().setAttribute("eMessage", "修改成功");
		return "editUI";
	}
	
	public InputStream getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(InputStream responseMsg) {
		this.responseMsg = responseMsg;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getMaxrows() {
		return maxrows;
	}

	public void setMaxrows(int maxrows) {
		this.maxrows = maxrows;
	}
	
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReal_name() {
		return real_name;
	}

	public String getQm() {
		return qm;
	}

	public void setQm(String qm) {
		this.qm = qm;
	}

	public String getQt() {
		return qt;
	}

	public void setQt(String qt) {
		this.qt = qt;
	}

	public String getQs() {
		return qs;
	}

	public void setQs(String qs) {
		this.qs = qs;
	}

	public void setReal_name(String real_name) {
		try {
			this.real_name = new String(real_name.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public OpVO getOpVO() {
		return opVO;
	}

	public void setOpVO(OpVO opVO) {
		this.opVO = opVO;
	}

}
