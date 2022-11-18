package data;

import model.Caminhao;

import java.util.List;

public interface CaminhaoDAO extends DAO<Caminhao> {
    void salvar (Caminhao caminhao);
    void atualizar (Caminhao caminhao);
    void editar (Caminhao caminhao);
    void apagar (Caminhao caminhao);
    Caminhao buscar (int id);
    List<Caminhao> buscarTodos();
}
