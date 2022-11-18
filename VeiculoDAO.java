package data;

import model.Veiculo;

import java.util.List;

public interface VeiculoDAO extends DAO<Veiculo> {
    void salvar (Veiculo veiculo);
    void atualizar (Veiculo veiculo);
    void editar (Veiculo veiculo);
    void apagar (Veiculo veiculo);
    Veiculo buscar (int id);
    List<Veiculo> buscarTodos();

}
