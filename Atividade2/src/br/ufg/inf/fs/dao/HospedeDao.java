package br.ufg.inf.fs.dao;

import br.ufg.inf.fs.entities.Hospede;
import br.ufg.inf.fs.exceptions.HospedeException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospedeDao {
    Connection conn;

    public HospedeDao (Connection conn){
        this.conn = conn;
    }

    public List<Hospede> findAll() throws HospedeException{
        List<Hospede> retorno = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement st = null;
        try {
            String sql = "SELECT id_hospede, nm_hospede, dt_nascimento, cpf FROM db_hotel.tb_hospede ";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                Hospede hospede = new Hospede(
                        rs.getInt("id_hospede"),
                        rs.getString("nm_hospede"),
                        rs.getDate("dt_nascimento").toLocalDate(),
                        rs.getInt("cpf"));

                retorno.add(hospede);
            }
        }catch (SQLException e) {
            throw new HospedeException("Erro no banco de dados: "+e.getMessage());
        }finally {
            DB.closeStatment(st);
            DB.closeResultSet(rs);
        }
        return retorno;
    }

    public Hospede findById(Integer id) throws HospedeException{

        Hospede retorno = new Hospede();
        ResultSet rs = null;
        PreparedStatement st = null;
        try {
            String sql = "SELECT id_hospede, nm_hospede, dt_nascimento, cpf FROM db_hotel.tb_hospede WHERE id_hospede = " +id;
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                retorno = new Hospede(
                        rs.getInt("id_hospede"),
                        rs.getString("nm_hospede"),
                        rs.getDate("dt_nascimento").toLocalDate(),
                        rs.getInt("cpf"));
            }
        }catch (SQLException e) {
            throw new HospedeException("Erro no banco de dados: "+e.getMessage());
        }finally {
            DB.closeStatment(st);
            DB.closeResultSet(rs);
        }
        return retorno;
    }

    public Hospede insert(Hospede hospede) throws HospedeException {

        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(" "
                            + "INSERT INTO tb_hospede "
                            + "(nm_hospede, dt_nascimento, cpf) "
                            + "VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            st.setString(1, hospede.getNmHospede());
            st.setDate(2, Date.valueOf(hospede.getDtNascimento()));
            st.setInt(3, hospede.getCpf());
            int rowsAffected = st.executeUpdate();
            if(rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()) {
                    hospede.setIdHospede(rs.getInt(1));
                }
            }else {
                throw new HospedeException("A��o inesperada! Nenhuma linha foi inserida.");
            }
        }
        catch (SQLException e) {
            throw new HospedeException("Erro no banco de dados: "+e.getMessage());
        }finally {
            DB.closeStatment(st);
        }
        return hospede;
    }

    public Hospede update(Hospede hospede) throws HospedeException {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(" "
                    + "UPDATE tb_hospede "
                    + "SET nm_hospede = ?, dt_nascimento = ?, cpf = ? "
                    + "WHERE id_hospede = ? ");

            st.setString(1, hospede.getNmHospede());
            st.setDate(2, Date.valueOf(hospede.getDtNascimento()));
            st.setInt(3, hospede.getCpf());
            st.setInt(4, hospede.getIdHospede());
            st.executeUpdate();
        }
        catch (SQLException e) {
            throw new HospedeException("Erro no banco de dados: "+e.getMessage());
        }finally {
            DB.closeStatment(st);
        }
        return hospede;
    }


    public void delete(Integer id) throws HospedeException {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "DELETE FROM tb_hospede WHERE id_hospede = ?");
            st.setInt(1, id);
            st.executeUpdate();
        }
        catch (SQLException e) {
            throw new HospedeException("Erro no banco de dados: "+e.getMessage());
        }
        finally {
            DB.closeStatment(st);
        }
    }
}
