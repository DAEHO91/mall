package cafe.jjdev.mall.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
	
	// ��� ����..
    private Connection getConnection() throws ClassNotFoundException, SQLException {
    	System.out.println("DB������� MemberDao.java");
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        String jdbcDriver = "jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=euckr";
        String dbID = "root";
        String dbPW = "java0000";
        connection = DriverManager.getConnection(jdbcDriver, dbID, dbPW);
        return connection;
    }
    // ���� ��� �ڵ� �޼���ȭ
    private void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        if(resultSet != null) {
            try {resultSet.close();} catch(Exception exception){exception.printStackTrace();}
        }
        if(preparedStatement != null) {
            try {preparedStatement.close();} catch(Exception exception){exception.printStackTrace();}
        }
        if(connection != null) {
            try {connection.close();} catch(Exception exception){exception.printStackTrace();}
        }
    }

	//��� �Է� �޼���
	public int insertMember(Member member) {
		System.out.println("insertMember �޼��� ���� MemberDao.java");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            connection = this.getConnection();
            	//no �÷��� �ڵ�����
            preparedStatement = connection.prepareStatement("insert into member (id, pw, level) value (?, ?, ?)");
            preparedStatement.setString(1, member.getId());
            preparedStatement.setString(2, member.getPw());
            preparedStatement.setInt(3, member.getLevel());
	  	    
            preparedStatement.executeUpdate();
	  	    
            preparedStatement.close();
            connection.close();
	  	    
		}catch(Exception exception) {
            exception.printStackTrace();
        } finally {
            this.close(connection, preparedStatement, resultSet);
        }
        
		return 0;
	}
	
	
	//����α��� ó��
	public boolean loginMember(Member member) {
		System.out.println("loginMember �޼��� ���� MemberDao.java");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean loginResult = false; // ������ ���� ���� ����. �⺻�� false.. false ��ȯ�� ȸ����������->����
        
        try {
            connection = this.getConnection();
            preparedStatement = connection.prepareStatement("select id, level from member where id=? and pw=?");
            preparedStatement.setString(1, member.getId());
            preparedStatement.setString(2, member.getPw());
            
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()) {
            	//select ���� ������� �α��μ���,, ���ϰ� true
            	//�������� true���Ͻ� ���ǿ� �α��������� ����
            	loginResult = true;
            }
            
		}catch(Exception exception) {
            exception.printStackTrace();
        } finally {
            this.close(connection, preparedStatement, resultSet);
        }
        
        return loginResult;
	}
	
	// �� ���� ��ȸ�ϱ�
	public Member selectMember(String id) {
		System.out.println("selectMember �޼��� ���� MemberDao.java");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Member member = new Member();
		
        try {
            connection = this.getConnection();
            preparedStatement = connection.prepareStatement("select * from member where id=?");
            preparedStatement.setString(1, id);
            
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()) {
            	 member.setId(resultSet.getString("id"));
            	 member.setPw(resultSet.getString("pw"));
            	 member.setLevel(resultSet.getInt("level"));
            }
		
        }catch(Exception exception) {
            exception.printStackTrace();
        } finally {
            this.close(connection, preparedStatement, resultSet);
        }
        
		return member;
        
	}

	
}
