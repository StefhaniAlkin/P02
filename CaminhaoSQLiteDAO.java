package data;

import model.Automovel;
import model.Caminhao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CaminhaoSQLiteDAO implements CaminhaoDAO{
    @Override
    public void salvar(Caminhao caminhao) {
        String sql = "INSERT INTO caminhao values (?,?)";
        try(PreparedStatement stmt=ConnectionFactory.criaStatement(sql)) {
            stmt.setDouble(1, caminhao.getCargaMaxima());
            stmt.setDouble(2, caminhao.getComprimento());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Caminhao caminhao) {
        String sql = "UPDATE caminhao SET cargaMaxima=?, comprimento=? WHERE idVeic=?";
        try(PreparedStatement stmt=ConnectionFactory.criaStatement(sql)) {
            stmt.setDouble(1, caminhao.getCargaMaxima());
            stmt.setDouble(2, caminhao.getComprimento());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editar(Caminhao caminhao) {

    }

    @Override
    public void apagar(Caminhao caminhao) {
        String sql = "DELETE FROM caminhao WHERE idVeic=?";
        try(PreparedStatement stmt=ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,caminhao.getIdVeic());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Caminhao buscar(int id) {
        Caminhao c = null;
        String sql = "SELECT * FROM caminhao WHERE idVeic=?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                c = new Caminhao(rs.getDouble("cargaMaxima"),
                        rs.getDouble("comprimento"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;

    }

    @Override
    public List<Caminhao> buscarTodos() {
        String sql = "SELECT * FROM caminhao";
        List<Caminhao> listaCaminhao = new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Caminhao c = new Caminhao(rs.getDouble("cargaMaxima"),
                        rs.getDouble("comprimento"));
                listaCaminhao.add(c);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCaminhao;
    }
}
