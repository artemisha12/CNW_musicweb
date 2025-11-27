package model.dao;

import java.sql.*;
import java.util.ArrayList;
import model.bean.Artist;
import config.DBConnect;

public class ArtistDAO {

    public ArrayList<Artist> getAll() {
        ArrayList<Artist> list = new ArrayList<>();
        String sql = "SELECT * FROM artists";

        try (Connection con = DBConnect.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Artist a = new Artist();
                a.setArtistId(rs.getInt("artist_id"));
                a.setName(rs.getString("name"));
                a.setBiography(rs.getString("biography"));
                a.setBirthday(rs.getString("birthday"));
                a.setAvatar(rs.getString("avatar"));
                list.add(a);
            }

        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
    public ArrayList<Artist> searchArtists(String keyword) {
        ArrayList<Artist> list = new ArrayList<>();
        String sql = "SELECT * FROM artists WHERE name LIKE ?";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Artist a = new Artist();
                a.setArtistId(rs.getInt("artist_id"));
                a.setName(rs.getString("name"));
                a.setBiography(rs.getString("biography"));
                a.setBirthday(rs.getString("birthday"));
                a.setAvatar(rs.getString("avatar"));
                list.add(a);
            }

        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

}
