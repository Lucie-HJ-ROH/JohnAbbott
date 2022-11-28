package singletonPattern;

public class Test {
    public static void main(String[] args) {
        ConnectionPool conn1 = ConnectionPool.getInstance();
        ConnectionPool conn2 = ConnectionPool.getInstance();

        System.out.println(conn1 == conn2);
    }
}
