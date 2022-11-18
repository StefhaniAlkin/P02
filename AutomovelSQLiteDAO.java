package data;

import model.Automovel;
import model.Caminhao;
import model.Proprietario;
import model.Veiculo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutomovelSQLiteDAO implements AutomovelDAO{

    @Override
    public void salvar(Automovel automovel) {
        String sql = "INSERT INTO automovel values (?,?)";
        try(PreparedStatement stmt=ConnectionFactory.criaStatement(sql)) {
            stmt.setInt(1, automovel.getIdVeic());
            stmt.setInt(1, automovel.getNumeroPassageiros());
            stmt.setInt(2, automovel.getNumeroPassageiros());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Automovel automovel) {
        String sql = "UPDATE automovel SET numeroPortas=?, numeroPassageiros=?WHERE idVeic=?";
        try(PreparedStatement stmt=ConnectionFactory.criaStatement(sql)) {
            stmt.setInt(1, automovel.getNumeroPortas());
            stmt.setInt(2, automovel.getNumeroPassageiros());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editar(Automovel automovel) {

    }

    @Override
    public void apagar(Automovel automovel) {
        String sql = "DELETE FROM automovel WHERE idVeic=?";
        try(PreparedStatement stmt=ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,automovel.getIdVeic());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Automovel buscar(int id) {
        Automovel a = null;
        String sql = "SELECT * FROM cargo WHERE idVeic=?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                a = new Automovel(rs.getInt("idVeic"),
                        rs.getString("placa"), rs.getString("marca"), rs.getObject("proprietario"), rs.getInt("numeroPortas"), rs.getInt("numeroPassageiros"));
            }

            //    public Automovel(int idVeic, String placa, String marca, Proprietario proprietario, int numeroPortas, int numeroPassageiros) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    @Override
    public List<Automovel> buscarTodos() {
        String sql = "SELECT * FROM automovel";
        List<Automovel> listaAutomovel = new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Automovel a = new Automovel(rs.getInt("numeroPortas"),
                        rs.getInt("numeroPassageiros"));
                listaAutomovel.add(a);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAutomovel;

    }
}
