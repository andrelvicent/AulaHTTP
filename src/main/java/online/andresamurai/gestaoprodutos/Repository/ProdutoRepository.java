package online.andresamurai.gestaoprodutos.Repository;

import online.andresamurai.gestaoprodutos.Models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Produto findById(long id);
}
