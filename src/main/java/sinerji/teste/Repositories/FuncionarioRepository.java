package sinerji.teste.Repositories;

import sinerji.teste.Models.Funcionario;
import sinerji.teste.Models.Venda;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
    @EntityGraph("Funcionario.vendasAndCargo")
    @Query("SELECT f FROM Funcionario f WHERE f.nome IN :nomes")
    List<Funcionario> findFuncionariosInfoByNomes(@Param("nomes") List<String> nomes);

    @Query("SELECT f.vendas FROM Funcionario f WHERE f.nome = :nome")
    List<Venda> findVendasByNomeFuncionario(@Param("nome") String nome);
}
