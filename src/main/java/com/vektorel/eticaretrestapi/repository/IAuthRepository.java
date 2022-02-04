package com.vektorel.eticaretrestapi.repository;

import com.vektorel.eticaretrestapi.repository.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAuthRepository extends JpaRepository<Auth,Long> {

    Optional<Auth> findByUserid(long userid);
}
