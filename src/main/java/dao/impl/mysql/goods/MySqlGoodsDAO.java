package dao.impl.mysql.goods;

import dao.exception.DAOException;
import dao.goods.GoodsDAO;
import dao.impl.mysql.MySqlAbstractDAO;
import dao.sql.SqlQueries;
import entity.field.goods.GoodsFields;
import entity.goods.Goods;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class MySqlGoodsDAO extends MySqlAbstractDAO<Goods> implements GoodsDAO {
    @Override
    public Goods create(Goods entity) throws DAOException {
        return null;
    }

    @Override
    public Optional<Goods> getEntity(int id) throws DAOException {
        return Optional.empty();
    }

    @Override
    public List<Goods> getAll() throws DAOException {
        final Optional<Connection> connectionOptional = getConnection();
        if (connectionOptional.isPresent()) {
            try (Connection connection = connectionOptional.get();
                 Statement statement = connection.createStatement()) {
                final ResultSet resultSet = statement.executeQuery(SqlQueries.SQL_READ_ALL_GOODS);
                List<Goods> goods = new ArrayList<>();
                while (resultSet.next()) {
                    final Goods goodsEntity = processResultSet(resultSet);
                    goods.add(goodsEntity);
                }
                return goods;
            } catch (SQLException e) {
                LOGGER.error("Unable to get connection: {}", e.getMessage(), e);
                throw new DAOException("Unable to retrieve products");
            }
        }
        return Collections.emptyList();
    }

    private Goods processResultSet(ResultSet resultSet) {
        try {
            final int id = resultSet.getInt(GoodsFields.ID);
            final String name = resultSet.getString(GoodsFields.NAME);
            final String description = resultSet.getString(GoodsFields.DESCRIPTION);
            final String price = resultSet.getString(GoodsFields.PRICE);
            return new Goods(name, description, price, id);

        } catch (SQLException e) {
            LOGGER.error("Unable to parse ResultSet: {}", e.getMessage(), e);
            throw new DAOException("Unable to read goods", e);
        }
    }
    @Override
    public Goods updateEntity(Goods entity) throws DAOException {
        return null;
    }

    @Override
    public void deleteEntity(int id) throws DAOException {
    }
}
