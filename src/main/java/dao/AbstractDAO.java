package dao;

import entity.IEntity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

abstract public class AbstractDAO<E extends IEntity> implements DAO<E> {
    protected static final Logger LOGGER = LogManager.getLogger(AbstractDAO.class);
}
