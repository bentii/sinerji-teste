package sinerji.teste.Repositories;

import sinerji.teste.Models.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {
}