package dto;

/*
 * DTO(Data Transfer Object): 값 전달 객체
 * 객체를 이용해서 여러값을 묶어 전달하는 용도
 */
public class StudentDTO {
	private String studentNumber;
	private String studentName;
	private char gender;
	private int htmlScore;
	private int cssScore;
	private int jsScore;
	private int javaScore;
	
	public StudentDTO(String studentNumber, String studentName, char gender) {
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.gender = gender;
	}
	
	public String getStudentNumber() {
		return studentNumber;
	}
	
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getHtmlScore() {
		return htmlScore;
	}

	public void setHtmlScore(int htmlScore) {
		this.htmlScore = htmlScore;
	}

	public int getCssScore() {
		return cssScore;
	}

	public void setCssScore(int cssScore) {
		this.cssScore = cssScore;
	}

	public int getJsScore() {
		return jsScore;
	}

	public void setJsScore(int jsScore) {
		this.jsScore = jsScore;
	}

	public int getJavaScore() {
		return javaScore;
	}

	public void setJavaScore(int javaScore) {
		this.javaScore = javaScore;
	}
	
	public String toString() {
		return String.format("[%s] %s(%c)\nHTML: %d / CSS: %d / JS: %d / Java: %d", studentNumber, studentName, gender, htmlScore, cssScore, jsScore, javaScore);
	}
}
