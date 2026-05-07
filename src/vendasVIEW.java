import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class vendasVIEW extends JFrame {

    private final JTable tabelaVendas;
    private final JButton btnVoltar;

    public vendasVIEW() {
        setTitle("Vendas");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        tabelaVendas = new JTable();
        btnVoltar = new JButton("Voltar");

        tabelaVendas.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Nome", "Valor", "Status"}
        ));

        add(new JScrollPane(tabelaVendas), BorderLayout.CENTER);
        add(btnVoltar, BorderLayout.SOUTH);

        btnVoltar.addActionListener(e -> dispose());

        listarVendas();
    }
// commit atividade 3
    // - -
    private void listarVendas() {
        try {
            ProdutosDAO produtosdao = new ProdutosDAO();

            DefaultTableModel model = (DefaultTableModel) tabelaVendas.getModel();
            model.setRowCount(0);

            ArrayList<ProdutosDTO> listagem = produtosdao.listarProdutosVendidos();

            for (int i = 0; i < listagem.size(); i++) {
                model.addRow(new Object[]{
                    listagem.get(i).getId(),
                    listagem.get(i).getNome(),
                    listagem.get(i).getValor(),
                    listagem.get(i).getStatus()
                });
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao listar vendas: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new vendasVIEW().setVisible(true));
    }
}