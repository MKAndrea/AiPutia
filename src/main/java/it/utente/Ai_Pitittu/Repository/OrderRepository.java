package it.utente.Ai_Pitittu.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.utente.Ai_Pitittu.Model.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
