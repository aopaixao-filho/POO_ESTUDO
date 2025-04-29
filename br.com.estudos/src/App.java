import database.CategoriaDAO;
import database.FornecedorDAO;
import database.ProdutoDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.Categoria;
import model.Fornecedor;
import model.Produto;

public class App {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://192.168.40.128:15432/postgres", "postgres", "alexandre26");
             Scanner scanner = new Scanner(System.in)) {

            FornecedorDAO fornecedorDAO = new FornecedorDAO();
            ProdutoDAO produtoDAO = new ProdutoDAO();
            CategoriaDAO categoriaDAO = new CategoriaDAO();

            while (true) {
                System.out.println("\n=== MENU ===");
                System.out.println("1. Inserir Fornecedor");
                System.out.println("2. Inserir Produto");
                System.out.println("3. Inserir Categoria");
                System.out.println("4. Listar Fornecedores");
                System.out.println("5. Listar Produtos");
                System.out.println("6. Listar Categorias");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        inserirFornecedor(scanner, fornecedorDAO, conn);
                        break;
                    case 2:
                        inserirProduto(scanner, produtoDAO, categoriaDAO, conn);
                        break;
                    case 3:
                        inserirCategoria(scanner, categoriaDAO, conn);
                        break;
                    case 4:
                        listarFornecedores(fornecedorDAO, conn);
                        break;
                    case 5:
                        listarProdutos(produtoDAO, conn);
                        break;
                    case 6:
                        listarCategorias(categoriaDAO, conn);
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        return;
                    default:
                        System.out.println("Opção inválida!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void inserirProduto(Scanner scanner, ProdutoDAO produtoDAO, CategoriaDAO categoriaDAO, Connection conn) throws Exception {
        System.out.println("\n=== Inserir Produto ===");
        System.out.print("Nome do Produto: ");
        String nomeProduto = scanner.nextLine();
        System.out.print("SKU: ");
        String sku = scanner.nextLine();
        System.out.print("ID da Categoria: ");
        int categoriaId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("ID do Fornecedor: ");
        long fornecedorid = scanner.nextLong();
        scanner.nextLine();

        Categoria categoria = categoriaDAO.buscarCategoriaPorId(conn, categoriaId);
        if (categoria == null) {
            System.out.println("Categoria não encontrada!");
            return;
        }

        Produto produto = new Produto();
        produto.setNome_produto(nomeProduto);
        produto.setSku(sku);
        produto.setCategoria(categoria);
        produto.setId_fornecedor(fornecedorid);
        produtoDAO.inserirProduto(conn, produto);
        System.out.println("Produto inserido com sucesso!");
    }

    private static void listarProdutos(ProdutoDAO produtoDAO, Connection conn) throws Exception {
        System.out.println("\n=== Listar Produtos ===");
        List<Produto> produtos = produtoDAO.listarProdutos(conn);
        for (Produto produto : produtos) {
            System.out.println("Produto: " + produto.getNome_produto() + ", SKU: " + produto.getSku() +
                               ", Categoria: " + produto.getCategoria().getnome_categoria());
        }
    }

    private static void inserirFornecedor(Scanner scanner, FornecedorDAO fornecedorDAO, Connection conn) throws Exception {
        System.out.println("\n=== Inserir Fornecedor ===");
        System.out.print("Tipo: ");
        String tipo = scanner.nextLine();
        System.out.print("Razão Social: ");
        String razaoSocial = scanner.nextLine();
        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();
        System.out.print("UF: ");
        String uf = scanner.nextLine();
        System.out.print("telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Nome Fantasia: ");
        String nomeFantasia = scanner.nextLine();
        System.out.print("Status Situacao: ");
        String statusSituacao = scanner.nextLine();
        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();
        System.out.print("Logradouro: ");
        String Logradouro = scanner.nextLine();
        System.out.print("Numero: ");
        String numero = scanner.nextLine();
        System.out.print("Complemento: ");
        String complemento = scanner.nextLine();
        System.out.print("CEP: ");
        String cep = scanner.nextLine();
        System.out.print("Municipio: ");
        String municipio = scanner.nextLine();
        System.out.print("Data Abertura (formato dd/MM/yyyy): ");
        String dataAberturaStr = scanner.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataAbertura = sdf.parse(dataAberturaStr);

        Fornecedor fornecedor = new Fornecedor(tipo, razaoSocial, cnpj, uf, telefone, email, nomeFantasia, statusSituacao, bairro, Logradouro, numero, complemento, cep, municipio, dataAbertura);
        fornecedorDAO.inserirFornecedor(conn, fornecedor);
        System.out.println("Fornecedor inserido com sucesso!");
    }

    private static void inserirCategoria(Scanner scanner, CategoriaDAO categoriaDAO, Connection conn) throws Exception {
        System.out.println("\n=== Inserir Categoria ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("id: ");
        int id = scanner.nextInt();

        Categoria categoria = new Categoria();
        categoria.setnome_categoria(nome);
        categoria.setid_categoria(id);
        categoriaDAO.inserirCategoria(conn, categoria);
        System.out.println("Categoria inserida com sucesso!");
    }

    private static void listarFornecedores(FornecedorDAO fornecedorDAO, Connection conn) throws Exception {
        System.out.println("\n=== Listar Fornecedores ===");
        List<Fornecedor> fornecedores = fornecedorDAO.listarFornecedores(conn);
        for (Fornecedor fornecedor : fornecedores) {
            System.out.println(fornecedor);
        }
    }

    private static void listarCategorias(CategoriaDAO categoriaDAO, Connection conn) throws Exception {
        System.out.println("\n=== Listar Categorias ===");
        List<Categoria> categorias = categoriaDAO.listarCategorias(conn);
        for (Categoria categoria : categorias) {
            System.out.println(categoria);
        }
    }
}