package it.utente.Ai_Pitittu.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="cart")
public class Order {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private long id;
		@ManyToOne
	    @JoinColumn(name = "id_user" ,nullable = false)
	    private User user;
	  @Column(name = "created_at",nullable = false)
	    private LocalDateTime created_at;
	  @Column(name = "payed",nullable = false)
	    private Boolean payed;
	  @Column(name = "payment_at")
	    private LocalDateTime payment_at;
	  @Column(name = "payment_code",unique=true)
	    private String payment_code;
	  @Column(name = "closed")
	    private Boolean closed;
}
