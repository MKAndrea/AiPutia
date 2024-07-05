package it.utente.Ai_Pitittu.Model;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column(name="id")
	private long id;
	@Column(name="username",unique=true,nullable=false)
	private String username;
	@Column(name="password",nullable=false)
	private String password;
	@Column(name="email",unique=true,nullable=false)
	private String email;
	@Column(name="firstname",nullable=false)
	private String firstname;
	@Column(name="lastname",nullable=false)
	private String lastname;
	@Column(name="phonenumber",unique=true,nullable=false)
	private String phonenumber;
	@Column(name="deleted")
	private LocalDateTime deleted;
}
