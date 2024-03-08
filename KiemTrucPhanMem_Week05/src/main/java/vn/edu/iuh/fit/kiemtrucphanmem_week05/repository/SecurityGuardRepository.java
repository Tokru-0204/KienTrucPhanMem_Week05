package vn.edu.iuh.fit.kiemtrucphanmem_week05.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.kiemtrucphanmem_week05.models.Security_Guard;

@Repository
public interface SecurityGuardRepository extends JpaRepository<Security_Guard, Long> {
    Security_Guard findByUsername(String username);

    boolean existsByUsername(String username);
}
