import java.sql.*;

public class TransactionEx {

   static {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
      } catch (ClassNotFoundException cnfe) {
         cnfe.printStackTrace();
      }
   }

   public static void main(String[] args) {
      Connection con = null;
      PreparedStatement pstmt = null; // 오라클에서 구문분석을 안함 SQL문이 바뀌면 구문 분석을 함, Statement는 구문분석을 함
      boolean success = false;

      try {
         con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");

         con.setAutoCommit(false);

         // --------------------------------------------------
         String sql = "INSERT INTO test3 VALUES('홍길동', '1111')";
         pstmt = con.prepareStatement(sql);
         pstmt.executeQuery();
         System.out.println("11111");

         sql = "INSERT INTO test3 VALUES('전우치', '2222')";
         pstmt = con.prepareStatement(sql);
         pstmt.executeQuery();
         System.out.println("22222");

         sql = "INSERT INTO test3 VALUES('손오공', '3333'"; // 없애서 에러를 유도
         pstmt = con.prepareStatement(sql);
         pstmt.executeQuery();
         System.out.println("33333");
         
         success = true;

      } catch (SQLException sqle) {
         System.out.println("Connection Error");
         sqle.printStackTrace();
      } finally {
         try {
            if (success) {
               System.out.println("44444");
               con.commit();
            } else {
               System.out.println("55555");
               con.rollback();
            }
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
         } catch (SQLException sqle) {
         }
      }
   }
}

/*
CREATE TABLE test3 (
    id VARCHAR2(10),
    password VARCHAR2(10)
);
INSERT INTO test3 VALUES ('이순신', '0000');
commit;
SELECT * FROM test3;
 */
