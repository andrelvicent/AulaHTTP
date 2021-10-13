package online.andresamurai.gestaoprodutos.Resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import online.andresamurai.gestaoprodutos.Models.Produto;
import online.andresamurai.gestaoprodutos.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
@Api(value = "API REST - Sistsema de gestão de produtos")
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/listar-produtos")
    @ApiOperation(value = "Retornar uma lista de produtos")
    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping("/listar-produto/{id}")
    @ApiOperation(value = "Retornar um único produto")
    public Produto listarProdutoEspecifico(@PathVariable(value = "id") long id){
        return produtoRepository.findById(id);
    }

    @ApiOperation(value = "Salvar produto")
    @PostMapping("/salvar-produto")
    public Produto salvarProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @ApiOperation(value = "Deletar um produto")
    @DeleteMapping("/deletar-produto")
    public void deletarProduto(@RequestBody Produto produto){
        produtoRepository.delete(produto);
    }

    @ApiOperation(value = "Alterar um produto")
    @PutMapping("/alterar-produto")
    public Produto atualizarProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }
}
