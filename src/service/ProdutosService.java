public class ProdutosService {

    public void cadastrar(ProdutosDTO produto){

        ProdutosDAO dao = new ProdutosDAO();

        dao.cadastrarProduto(produto);

    }

}