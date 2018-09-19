package entity;

import java.sql.Date;
//import java.util.Date;

public class defectsEntity {
	private int iddefects;
	private String pro_line;
	private String def_category;
	private String def_detail;
	private String pro_class;
	private String machine_type;
	private String part_num;
	private Date def_date;
	


	public defectsEntity(){};
	
	public defectsEntity(int iddefects, String pro_line, String def_category, String def_detail, String pro_class,
			String machine_type, String part_num, Date def_date) {
		super();
		this.iddefects = iddefects;
		this.pro_line = pro_line;
		this.def_category = def_category;
		this.def_detail = def_detail;
		this.pro_class = pro_class;
		this.machine_type = machine_type;
		this.part_num = part_num;
		this.def_date = def_date;

	}

	public Date getDef_date() {
		return def_date;
	}

	public void setDef_date(Date def_date) {
		this.def_date = def_date;
	}

	public int getIddefects() {
		return iddefects;
	}

	public void setIddefects(int iddefects) {
		this.iddefects = iddefects;
	}

	public String getPro_line() {
		return pro_line;
	}

	public void setPro_line(String pro_line) {
		this.pro_line = pro_line;
	}

	public String getDef_category() {
		return def_category;
	}

	public void setDef_category(String def_category) {
		this.def_category = def_category;
	}

	public String getDef_detail() {
		return def_detail;
	}

	public void setDef_detail(String def_detail) {
		this.def_detail = def_detail;
	}

	public String getPro_class() {
		return pro_class;
	}

	public void setPro_class(String pro_class) {
		this.pro_class = pro_class;
	}

	public String getMachine_type() {
		return machine_type;
	}

	public void setMachine_type(String machine_type) {
		this.machine_type = machine_type;
	}

	public String getPart_num() {
		return part_num;
	}

	public void setPart_num(String part_num) {
		this.part_num = part_num;
	}
}
