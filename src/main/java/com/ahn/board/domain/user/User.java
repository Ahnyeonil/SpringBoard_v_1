package com.ahn.board.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.ahn.board.domain.BaseTimeEntity;

@Getter
// 어느 필드에 어떤 값을 채워야하는지 명확히 알 수 있기 때문에 실수가 나지 않는다.
@Builder
@AllArgsConstructor
// Lombok 어노테이션으로 빈 생성자를 만들어준다.
@NoArgsConstructor
// 해당 클래스가 엔티티를 위한 클래스이며, 해당 클래스의 인스턴스들이 JPA로 관리되는 엔티티 객체라는 것을 의미한다. (테이블)
@Entity

// Setter가 없는 이유 - 해당 클래스의 인스턴스가 언제 어디서 변해야 하는지 코드상으로 확인이 불가함
public class User extends BaseTimeEntity {

	// Primary Key
	@Id
	// PK를 자동으로 생성
	// sequence, auto_increment
	// application.properties - use-new-id-generate-mappings: false 로 설정
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// 해당 필드가 컬럼이라는 것을 말함
	// 다양한 속성 가능
	@Column(nullable = false, length = 30, unique = true)
	private String username;
	
	@Column(nullable = false, length = 100)
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	@Column(nullable = false, length = 20)
	private String nickname;
	
	// JPA로 DB에 저장할 때 Enum 값을 어떤 형태로 저장할지 결정
	// 기본적으로 int로 저장
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;
	
	/**
	 * @param password
	 * 비밀번호 암호화 메소드
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return
	 * 권한 메소드
	 */
	public String getRoleKey() {
        return this.role.getKey();
    }
	
	/**
	 * @param password
	 * @param email
	 * @param nickname
	 * 회원수정 메소드
	 */
	public void update(String password, String email, String nickname) {
		this.password = password;
		this.email = email;
		this.nickname = nickname;
	}
}