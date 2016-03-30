package com.exam.action.manage;

import java.io.InputStream;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.exam.service.teacher.TeacherManageService;
import com.exam.vo.teacher.TeacherVO;
import com.opensymphony.xwork2.ActionSupport;

@Controller("teacherManageAction")
public class TeacherManageAction extends ActionSupport {
	private static final long serialVersionUID = -5051279241748248334L;
	private InputStream responseMsg;
	private int page = 1;
	private int offset = 0;
	private int maxrows = 10;
	// 排序参数
	private String sort;
	private String sortOrder;
	// 查询参数
	private String real_name;
	// 保存数据VO
	private TeacherVO teacherVO = new TeacherVO();

	@Resource(name = "teacherManageServiceImpl")
	private TeacherManageService teacherManageService;

	/**
	 * 跳转用户查询界面
	 */
	@Override
	public String execute() throws Exception {
		return "listUI";
	}
	
	public String query(){
		return "list";
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

	public String getReal_name() {
		return real_name;
	}

	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}

	public TeacherVO getTeacherVO() {
		return teacherVO;
	}

	public void setTeacherVO(TeacherVO teacherVO) {
		this.teacherVO = teacherVO;
	}

}
