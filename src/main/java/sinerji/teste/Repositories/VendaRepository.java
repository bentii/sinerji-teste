package sinerji.teste.Repositories;

import sinerji.teste.Models.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Integer> {
}