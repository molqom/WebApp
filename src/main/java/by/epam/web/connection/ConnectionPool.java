package by.epam.web.connection;

import by.epam.web.exception.DaoException;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static final int POOL_SIZE = 10;
    private final Queue<ProxyConnection> availableConnections;
    private final Queue<ProxyConnection> connectionsInUse;
    private static final ReentrantLock LOCKER = new ReentrantLock();
    private static ConnectionPool instance;

    private ConnectionPool() {
        availableConnections = new ArrayDeque<>(POOL_SIZE);
        connectionsInUse = new ArrayDeque<>();
        ProxyConnectionFactory proxyConnectionFactory = new ProxyConnectionFactory(this);
        for (int i = 0; i < POOL_SIZE; i++) {
            ProxyConnection proxyConnection = proxyConnectionFactory.create();
            availableConnections.offer(proxyConnection);
        }
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            LOCKER.lock();
            if (instance == null) {
                instance = new ConnectionPool();
            }
            LOCKER.unlock();
        }
        return instance;
    }

    public void returnConnection(ProxyConnection proxyConnection) {
        LOCKER.lock();
        try {
            if (connectionsInUse.contains(proxyConnection)) {
                connectionsInUse.remove(proxyConnection);
                availableConnections.offer(proxyConnection);
            }
        } finally {
            LOCKER.unlock();
        }
    }
//singlton
    public ProxyConnection getConnection() throws DaoException {
        //todo add try to check overflow connection
        ProxyConnection connection = availableConnections.poll();
        connectionsInUse.offer(connection);
        return connection;
//        return ConnectionFactory.create();
    }
}
