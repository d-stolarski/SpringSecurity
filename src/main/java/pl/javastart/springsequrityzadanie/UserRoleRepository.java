package pl.javastart.springsequrityzadanie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository <UserRole, Long> {
}
