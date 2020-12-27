package dao.impl.orm.init;

import dao.impl.orm.session.SessionFactoryProvider;
import dao.init.DAOInitializer;

public class OrmDAOInitializer implements DAOInitializer {
    @Override
    public void init() {
        SessionFactoryProvider.getInstance().init();
    }

    @Override
    public void destroy() {

    }
}
