package fr.eni.QCM.DAL;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni.QCM.BO.Section;
import fr.eni.QCM.utils.AccesBase;

public class SectionDAO {

	static String SQL_GET_ONE_SECTION = "SELECT * FROM Section WHERE id = ?";
	static String SQL_GET_ALL_SECTION = "SELECT * FROM Section";
	static String SQL_GET_ALL_SECTION_NOT_SELECT = "SELECT * FROM Section WHERE id NOT IN (SELECT idSection FROM SecTest WHERE idTest = ?)";
	static String SQL_GET_ALL_SECTION_FOR_ID = "SELECT idSection FROM SecTest WHERE idTest = ?";
	static String SQL_UPDATE_ONE_SECTION = "UPDATE Section SET libelle = ? WHERE id = ?";
	static String SQL_INSERT_ONE_SECTION = "INSERT INTO Section (libelle,idFormateur) VALUES (?,?)";
	static String SQL_DELETE_ONE_SECTION = "DELETE FROM Section WHERE id=?";
	static String SQL_DELETE_ONE_SECTION_SELECTED = "DELETE FROM SecTest WHERE idSection=? and idTest = ?";
	static String SQL_LINK_TEST_SECTION = "INSERT INTO SecTest (idTest,idSection) VALUES (?,?)";
	
	
	public static Section getOne(int id) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Section section = null;
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_GET_ONE_SECTION);
			rqt.setInt(1, id);
			rs = rqt.executeQuery();
			
			while (rs.next()){
				section = new Section(
								rs.getInt("id"), 
								rs.getString("libelle"), 
								FormateurDAO.getOne(rs.getInt("idFormateur"))
						);
			}
			
		}catch(Exception e){
			System.out.println("FONCTION : getOne");
			System.out.println(e);
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return section;
	}
	public static ArrayList<Section> getAll() throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		ArrayList<Section> sections = new ArrayList<>();
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_GET_ALL_SECTION);
			rs = rqt.executeQuery();
			while (rs.next()){
				sections.add(new Section(
								rs.getInt("id"), 
								rs.getString("libelle"), 
								FormateurDAO.getOne(rs.getInt("idFormateur"))
						));
			}
			
		}catch(Exception e){
			System.out.println("FONCTION : getAll");
			System.out.println(e);
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return sections;
	}
	
	
	
	
	public static ArrayList<Integer> getAllForId(int id) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		ArrayList<Integer> sections = new ArrayList<>();
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_GET_ALL_SECTION_FOR_ID);
			rqt.setInt(1, id);
			rs = rqt.executeQuery();
			while (rs.next()){
				sections.add(rs.getInt("idSection"));
			}
			
		}catch(Exception e){
			System.out.println("FONCTION : getAllForId");
			System.out.println(e);
		}
		finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return sections;
	}	
	public static ArrayList<Section> getNotSelectedForId(int id) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		ArrayList<Section> sections = new ArrayList<>();
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_GET_ALL_SECTION_NOT_SELECT);
			rqt.setInt(1, id);
			rs = rqt.executeQuery();
			while (rs.next()){
				sections.add(new Section(
								rs.getInt("id"), 
								rs.getString("libelle"), 
								FormateurDAO.getOne(rs.getInt("idFormateur"))
						));
			}
			
		}catch(Exception e){
			System.out.println("FONCTION : getAll");
			System.out.println(e);
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return sections;
	}
	public static void linkTestSection(int idTest,int idSection) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		ArrayList<Integer> sections = new ArrayList<>();
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_LINK_TEST_SECTION);
			rqt.setInt(1, idTest);
			rqt.setInt(2, idSection);
			rs = rqt.executeQuery();
			
		}catch(Exception e){
			System.out.println("FONCTION : linkTestSection");
			System.out.println(e);
		}
		finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	
	
	
	public static void modifLibelle(int id,String libelle) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		ArrayList<Section> sections = new ArrayList<>();
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_UPDATE_ONE_SECTION);
			rqt.setString(1, libelle);
			rqt.setInt(2, id);
			rqt.executeQuery();
			
			
		}catch(Exception e){
			System.out.println("FONCTION : modifLibelle");
			System.out.println(e);
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		
	}
	public static void CreerSection(String libelle,int idFormateur) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		ArrayList<Section> sections = new ArrayList<>();
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_INSERT_ONE_SECTION);
			rqt.setString(1, libelle);
			rqt.setInt(2, idFormateur);
			rqt.executeQuery();
			
			
		}catch(Exception e){
			System.out.println("FONCTION : CreerSection");
			System.out.println(e);
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		
	}
	public static void deleteSection(int id) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		ArrayList<Section> sections = new ArrayList<>();
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_DELETE_ONE_SECTION);
			rqt.setInt(1, id);
			rs = rqt.executeQuery();
			
		}catch(Exception e){
			System.out.println("FONCTION : deleteSection");
			System.out.println(e);
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		
	}
	
	public static void deleteSectionSeletec(int idSection,int idTest) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		ArrayList<Section> sections = new ArrayList<>();
		try{
			cnx = AccesBase.recupererConnexionJDBC();
			rqt = cnx.prepareStatement(SQL_DELETE_ONE_SECTION_SELECTED);
			rqt.setInt(1, idSection);
			rqt.setInt(2, idTest);
			rs = rqt.executeQuery();
			
		}catch(Exception e){
			System.out.println("FONCTION : deleteSectionSeletec");
			System.out.println(e);
		}finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		
	}
	
	
}
