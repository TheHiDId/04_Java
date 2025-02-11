package section03.dto;

import java.io.Serializable;
import java.util.Objects;

/* [Marker Interface]
 * 어떤 역할이나 기능의 대상임을 표시하는 인터페이스
 * 
 * [Serializable Interface]
 * 직렬화의 대상임을 명시하는 인터페이스
 */

public class Member implements Serializable {
	/**
	 * 직렬화된 객체가 Member인지 확인하는 용도의 식별번호
	 */
	private static final long serialVersionUID = 1234567890L;
	
	private String id;
	private String pw;
	private String name;
	
	public Member() {
		
	}
	
	public Member(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "멤버 [아이디: " + id + ", 비밀번호: " + pw + ", 이름: " + name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, pw);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(pw, other.pw);
	}
}
