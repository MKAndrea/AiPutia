package it.utente.Ai_Pitittu.Model;



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
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column(name="id")
	private long id;
	@Column(name="pname", nullable = false)
	private String pname;
	@Column(name="description", nullable = false)
	private String description;
	@Column(name="price", nullable = false)
	private double price;
	@ManyToOne
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;
	@Column(name="deleted")
	private Boolean deleted;
}
