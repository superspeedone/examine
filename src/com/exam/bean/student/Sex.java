package com.exam.bean.student;

public enum Sex {
	MAN {
		public String getName() {
			return "男";
		}
	},
	WOMEN {
		public String getName() {
			return "女";
		}
	};
	public abstract String getName();

}
