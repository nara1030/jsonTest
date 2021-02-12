package hje.ex.json.emp.dto;

public class EmployeeDto {
	private String deptCd;
	private String empCd;
	private String empNm;
	
	public String getDeptCd() {
		return deptCd;
	}
	public void setDeptCd(String deptCd) {
		this.deptCd = deptCd;
	}
	public String getEmpCd() {
		return empCd;
	}
	public void setEmpCd(String empCd) {
		this.empCd = empCd;
	}
	public String getEmpNm() {
		return empNm;
	}
	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}
	@Override
	public String toString() {
		return "EmployeeDto [deptCd: " + deptCd + ", empCd: " + empCd + ", empNm: " + empNm + "]";
	}
}
