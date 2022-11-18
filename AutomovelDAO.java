package data;

import model.Automovel;

import java.util.List;

public interface AutomovelDAO extends DAO<Automovel> {
    void salvar (Automovel automovel);
    void atualizar (Automovel automovel);
    void editar (Automovel automovel);
    void apagar (Automovel automovel);
    Automovel buscar (int id);
    List<Automovel> buscarTodos();
}
