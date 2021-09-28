package br.ufg.inf.fs.dao;

import br.ufg.inf.fs.entities.Hospedagem;
import br.ufg.inf.fs.entities.Hospede;
import br.ufg.inf.fs.entities.Quarto;
import br.ufg.inf.fs.exceptions.HospedagemException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospedagemDao {
    Connection conn;

    public HospedagemDao (Connection conn){
        this.conn = conn;
    }

    public List<Hospedagem> findAll() throws HospedagemException {
        List<Hospedagem> retorno = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement st = null;
        try {
            String sql = "SELECT id_hospedagem, id_quarto, id_hospede, dt_checkin, dt_checkout FROM db_hotel.tb_hospedagem ";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                Hospedagem hospedagem = new Hospedagem(
                        rs.getInt("id_hospedagem"),
                        new Quarto(rs.getInt("id_quarto"), null, null, null, null, null),
                        new Hospede(rs.getInt("id_hospede"), null, null, null),
                        rs.getDate("dt_checkin").toLocalDate(),
                        rs.getDate("dt_checkout").toLocalDate());

                retorno.add(hospedagem);
            }
        }catch (SQLException e) {
            throw new HospedagemException("Erro no banco de dados: "+e.getMessage());
        }finally {
            DB.closeStatment(st);
            DB.closeResultSet(rs);
        }
        return retorno;
    }

    public Hospedagem findById(Integer id) throws HospedagemException{

        Hospedagem retorno = new Hospedagem();
        ResultSet rs = null;
        PreparedStatement st = null;
        try {
            String sql = "SELECT id_hospedagem, id_quarto, id_hospede, dt_checkin, dt_checkout FROM db_hotel.tb_hospedagem WHERE id_hospedagem = " +id;
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                retorno = new Hospedagem(
                        rs.getInt("id_hospedagem"),
                        new Quarto(rs.getInt("id_quarto"), null, null, null, null, null),
                        new Hospede(rs.getInt("id_hospede"), null, null, null),
                        rs.getDate("dt_checkin").toLocalDate(),
                        rs.getDate("dt_checkout").toLocalDate());
            }
        }catch (SQLException e) {
            throw new HospedagemException("Erro no banco de dados: "+e.getMessage());
        }finally {
            DB.closeStatment(st);
            DB.closeResultSet(rs);
        }
        return retorno;
    }

    public Hospedagem insert(Hospedagem hospedagem) throws HospedagemException {

        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(" "
                            + "INSERT INTO tb_hospedagem "
                            + "(id_quarto, id_hospede, dt_checkin, dt_checkout) "
                            + "VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, hospedagem.getQuarto().getIdQuarto());
            st.setInt(2, hospedagem.getHospede().getIdHospede());
            st.setDate(3, Date.valueOf(hospedagem.getDtCheckin()));
            st.setDate(4, Date.valueOf(hospedagem.getDtCheckout()));
            int rowsAffected = st.executeUpdate();
            if(rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()) {
                    hospedagem.setIdHospedagem(rs.getInt(1));
                }
            }else {
                throw new HospedagemException("Ação inesperada! Nenhuma linha foi inserida.");
            }
        }
        catch (SQLException e) {
            throw new HospedagemException("Erro no banco de dados: "+e.getMessage());
        }finally {
            DB.closeStatment(st);
        }
        return hospedagem;
    }

    public Hospedagem update(Hospedagem hospedagem) throws HospedagemException {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(" "
                    + "UPDATE tb_hospedagem "
                    + "SET id_quarto = ?, id_hospede=?, dt_checkin = ?, dt_checkout = ? "
                    + "WHERE id_hospedagem = ? ");

            st.setInt(1, hospedagem.getQuarto().getIdQuarto());
            st.setInt(2, hospedagem.getHospede().getIdHospede());
            st.setDate(3, Date.valueOf(hospedagem.getDtCheckin()));
            st.setDate(4, Date.valueOf(hospedagem.getDtCheckout()));
            st.setInt(5, hospedagem.getIdHospedagem());
            st.executeUpdate();
        }
        catch (SQLException e) {
            throw new HospedagemException("Erro no banco de dados: "+e.getMessage());
        }finally {
            DB.closeStatment(st);
        }
        return hospedagem;
    }


    public void delete(Integer id) throws HospedagemException {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "DELETE FROM tb_hospedagem WHERE id_hospedagem = ?");
            st.setInt(1, id);
            st.executeUpdate();
        }
        catch (SQLException e) {
            throw new HospedagemException("Erro no banco de dados: "+e.getMessage());
        }
        finally {
            DB.closeStatment(st);
        }
    }
}
