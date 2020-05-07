package ConnectJDBC.Dao;

import ConnectJDBC.Model.Circle;
import ConnectJDBC.Model.Triangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Component
public class JdbcDaoImpl {

   // @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate ;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private SimpleJdbcTemplate simpleJdbcTemplate;

   /*  public Circle getCircle(int circleId) {
        Connection connection = null;
        try {
         //   String driver = "com.mysql.cj.jdbc.Driver";
          //  Class.forName(driver).newInstance();
            //String url = "jdbc:mysql://localhost:3306/circle";
           // String userName = "root";
           // String password = "shruti@123";
            //connection = DriverManager.getConnection(url, userName, password);
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * from circledata where circle_id = ?");
            ps.setInt(1, circleId);
            Circle circle = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                circle = new Circle(circleId, rs.getString("name"));
            }
            rs.close();
            ps.close();
            return circle;
        } catch (Exception e) {
             throw new RuntimeException(e);
        } finally {
            try {
                 connection.close();
            } catch (SQLException e) {

            }
        }
    }*/
    public int getCircleCount(){
        String sql = "select count(*) from circledata";
        return jdbcTemplate.queryForInt(sql);
    }
    public String getCircleName(int circleId){
        String sql = "select name  from circledata where circle_id = ?";
        return jdbcTemplate.queryForObject(sql,new Object[]{circleId},String.class);
    }
    public Circle getCircleForId(int circleId){
        String sql = "select * from circledata where circle_id = ?";
        return jdbcTemplate.queryForObject(sql,new Object[]{circleId},new CircleMapper());
    }
    public List<Circle> getAllCircle(){
          String sql = "select * from circledata";
          return jdbcTemplate.query(sql,new CircleMapper());
    }
   /* public void insertCircle(Circle circle){
        String sql = "insert into circledata (circle_id,name) value (?,?)";
        jdbcTemplate.update(sql,new Object[]{circle.getId(),circle.getName()});
    }*/
    public void insertCircle(Circle circle){
        String sql = "insert into circledata (circle_id,name) value (:id,:name)";
        SqlParameterSource namedPrameter = new MapSqlParameterSource("id",circle.getId())
                .addValue("name",circle.getName());
        namedParameterJdbcTemplate.update(sql,namedPrameter);
    }
    public void createTriangleTable(){
        String sql = "CREATE TABLE  TRIANGLE (TRIANGLE_ID INTEGER , NAME VARCHAR(50))";
        jdbcTemplate.execute(sql);
    }
    public void insertTriangle(Triangle triangle){
        String sql = "insert into triangle (triangle_id,name) value (?,?)";
        jdbcTemplate.update(sql,new Object[]{triangle.getId(),triangle.getName()});
    }

    private static final class CircleMapper implements RowMapper<Circle>{
        public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Circle circle = new Circle();
            circle.setId(resultSet.getInt("circle_id"));
            circle.setName(resultSet.getString("name"));
            return circle;
        }
    }
   @Autowired
    public void setDataSource(DataSource dataSource) {
       // this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }
    public DataSource getDataSource() {
        return dataSource;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return namedParameterJdbcTemplate;
    }

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public SimpleJdbcTemplate getSimpleJdbcTemplate() {
        return simpleJdbcTemplate;
    }

    public void setSimpleJdbcTemplate(SimpleJdbcTemplate simpleJdbcTemplate) {
        this.simpleJdbcTemplate = simpleJdbcTemplate;
    }
}
