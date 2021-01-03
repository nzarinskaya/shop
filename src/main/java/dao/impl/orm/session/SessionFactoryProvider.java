package dao.impl.orm.session;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SessionFactoryProvider {

    private static final Lock LOCK = new ReentrantLock();
    private SessionFactory sessionFactory;
    private StandardServiceRegistry registry;

    private SessionFactoryProvider() {}

    private static class SessionFactoryHolder {
        private static final SessionFactoryProvider INSTANCE = new SessionFactoryProvider();
    }

    public static SessionFactoryProvider getInstance() {
        return SessionFactoryHolder.INSTANCE;
    }

    public void init() {
        if (this.sessionFactory == null) {
            try {
                LOCK.lock();
                registry = new StandardServiceRegistryBuilder().configure().build();
                MetadataSources sources = new MetadataSources(registry);
                Metadata metadata = sources.getMetadataBuilder().build();
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            } finally {
                LOCK.unlock();
            }
        }
    }
    public void destroy() {
        if (this.sessionFactory == null) {
            try {
                LOCK.lock();
                StandardServiceRegistryBuilder.destroy(registry);
            } finally {
                LOCK.unlock();
            }
        }
    }
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
