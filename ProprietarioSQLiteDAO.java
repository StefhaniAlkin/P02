package data;

import model.Proprietario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProprietarioSQLiteDAO implements ProprietarioDAO{

    @Override
    public void salvar(Proprietario proprietario) {
        String sql = "INSERT INTO proprietario values (?,?,?)";
        try(PreparedStatement stmt=ConnectionFactory.criaStatement(sql)) {
            stmt.setInt(1, proprietario.getIdProp());
            stmt.setString(2, proprietario.getNome());
            stmt.setString(3, proprietario.getCpf());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Proprietario proprietario) {
        String sql = "UPDATE proprietario SET idProp=?, nome=?, cpf=?, WHERE idProp=?";
        try(PreparedStatement stmt=ConnectionFactory.criaStatement(sql)) {
            stmt.setInt(1, proprietario.getIdProp());
            stmt.setString(2, proprietario.getNome());
            stmt.setString(3, proprietario.getCpf());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void editar(Proprietario proprietario) {

    }

    @Override
    public void apagar(Proprietario proprietario) {
        String sql = "DELETE FROM proprietario WHERE idProp=?";
        try(PreparedStatement stmt=ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1, proprietario.getIdProp());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Proprietario buscar(int id) {
        Proprietario p = null;
        String sql = "SELECT * FROM cargo WHERE idProp=?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                p = new Proprietario(rs.getInt("idProp"),
                        rs.getString("nome"), rs.getString("cpf"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;

    }

    @Override
    public List<Proprietario> buscarTodos() {
        String sql = "SELECT * FROM proprietario";
        List<Proprietario> listaProprietario = new ArrayList<>();
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Proprietario p = new Proprietario(rs.getInt("idProp"),
                        rs.getString("nome"), rs.getString("cpf"));
                listaProprietario.add(p);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listaProprietario;
    }
}
