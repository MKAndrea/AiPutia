package it.utente.Ai_Pitittu.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.utente.Ai_Pitittu.Model.User;
import jakarta.transaction.Transactional;

public interface UserRepository extends JpaRepository<User,Long> {
	 Optional<User> findByUsername(String username);
	    boolean existsByUsername(String username);
	    
//	    @Query("SELECT u FROM user u WHERE u.username = :username")
//	    User getUserByUsername(@Param("username") String username);
	    
	    @Modifying
	    @Transactional
	    @Query(value = "INSERT INTO user (id, username,password,email,firstname,lastname, phonenumber) " +
	                   "VALUES (:id, :username,:password,:email,:firstname,:lastname , :phonenumber) " +
	                   "ON DUPLICATE KEY UPDATE username = :username, password = :password, email = :email, " +
	                   "firstname = :firstname, lastname = :lastname, phonenumber = :phonenumber, "
	                   , nativeQuery = true)
	    void upsertUser(@Param("id") long id, 
	                    @Param("username") String username, 
	                    @Param("password") String password,
	                    @Param("email") String email, 
	                    @Param("firstname") String firstname, 
	                    @Param("lastname") String lastname, 
	                    @Param("phonenumber") String phonenumber
	                   );
		
}
