package kr.hhplus.be.server.infra.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {

}
