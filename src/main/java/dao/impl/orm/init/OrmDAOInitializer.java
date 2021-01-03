package dao.impl.orm.init;

import dao.init.DAOInitializer;
import dao.impl.orm.session.SessionFactoryProvider;

public class OrmDAOInitializer implements DAOInitializer {
    @Override
    public void init() {
        SessionFactoryProvider.getInstance().init();
    }
    @Override
    public void destroy() {
    }
}
