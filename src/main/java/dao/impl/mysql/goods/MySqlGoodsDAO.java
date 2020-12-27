package dao.impl.mysql.goods;

import dao.exception.DAOException;
import dao.goods.GoodsDAO;
import dao.impl.mysql.MySqlAbstractDAO;
import dao.sql.SqlQueries;
import entity.field.goods.GoodsEntityFields;
import entity.goods.GoodsEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class MySqlGoodsDAO extends MySqlAbstractDAO<GoodsEntity> implements GoodsDAO {
    @Override
    public GoodsEntity create(GoodsEntity entity) throws DAOException {
        return null;
    }

    @Override
    public Optional<GoodsEntity> getEntity(Long id) throws DAOException {
        return Optional.empty();
    }

    @Override
    public List<GoodsEntity> getAll() throws DAOException {
        final Optional<Connection> connectionOptional = getConnection();
        if (connectionOptional.isPresent()) {
            try (Connection connection = connectionOptional.get();
                 Statement statement = connection.createStatement()) {
                final ResultSet resultSet = statement.executeQuery(SqlQueries.SQL_READ_ALL_GOODS);
                List<GoodsEntity> goodsEntities = new ArrayList<>();
                while (resultSet.next()) {
                    final GoodsEntity goodsEntity = processResultSet(resultSet);
                    goodsEntities.add(goodsEntity);
                }
                return goodsEntities;

            } catch (SQLException e) {
                LOGGER.error("Unable to get connection: {}", e.getMessage(), e);
                throw new DAOException("Unable to retrieve products");
            }

            private GoodsEntity processResultSet(ResultSet resultSet){
                try {
                    final long id = resultSet.getLong(GoodsEntityFields.ID);
                    final String name = resultSet.getString(GoodsEntityFields.NAME);
                    final String description = resultSet.getString(GoodsEntityFields.DESCRIPTION);
                    final String price = resultSet.getString(GoodsEntityFields.PRICE);
                    final long timestamp = resultSet.getLong(GoodsEntityFields.TIMESTAMP);
                } catch (SQLException e) {
                    LOGGER.error("Unable to parse ResultSet: {}", e.getMessage(), e);
                    throw new DAOException("Unable to read goods", e);
                }
            }
            return Collections.emptyList();
        }
    }

    @Override
    public GoodsEntity updateEntity(GoodsEntity entity) throws DAOException {
        return null;
    }

    @Override
    public void deleteEntity(Long id) throws DAOException {

    }
}