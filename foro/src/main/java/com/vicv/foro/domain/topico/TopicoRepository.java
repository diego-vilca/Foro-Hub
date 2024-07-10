package com.vicv.foro.domain.topico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Optional<Topico> findById(Long id);
    Optional<List<Topico>> findByTitulo(String titulo);
}
