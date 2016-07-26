/**
 * This class open connection with helps driver to DB
 * @author Kirill Bugrim on 20.07.2016.
 * @version 1.1
 */

package com.training2.guide.dao.jdbc.mysql;
import com.training2.guide.dao.IPassangerDao;
import com.training2.guide.dao.jdbc.mysql.utils.DAOFactory;
import com.training2.guide.models.Passanger;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PassangerDao extends AbstractMySQLDao implements IPassangerDao<Passanger, Integer> {

    private static final Logger LOG = Logger.getLogger(DAOFactory.class);

    private static final String GET_PASSENGER = "SELECT * FROM guide.passangers where id=?",
            INSERT_PASSANGER="insert ignore into passangers(namePassanger,gender,Age) values(?,?,?)";
    final static String NAME="namePassanger",GENDER="gender",AGE="age";
    final static String[] PASSANGER_NAME={"Ivan  Ivanov","Elena  Ivanova","Petr Petrov","Sidr  Sidorov","Olga  Karaseva","Vladimir  Ershov",
            "Vasilisa  Vaskina","'Vasya  Vasev","Artur  Pirozhkov","Aleksandr Grigorievich Lukashenko"};
    final static String[] PASSANGER_GENDER={"male","","male","male","","male","","male","male","male"};
    final static int[] PASSANGER_AGE={25,21,11,24,53,32,43,22,35,61};

    final static List<Passanger> PASSANGERS=new ArrayList<>();

    @Override
    public void create() {
        PreparedStatement preparedStatement = getPreparedStatement(INSERT_PASSANGER);
        int i=0;
        Passanger passanger;
        while(i!=PASSANGER_NAME.length){
            passanger=new Passanger();
            passanger.setAge(PASSANGER_AGE[i]);
            passanger.setFirstName(PASSANGER_NAME[i]);
            passanger.setGender(PASSANGER_GENDER[i]);
            PASSANGERS.add(passanger);
            i++;
        }

        try {

            for (int j = 0; j <PASSANGERS.size(); j++) {

                preparedStatement.setString(1, PASSANGERS.get(j).getFirstName());
                preparedStatement.setString(2, PASSANGERS.get(j).getGender());
                preparedStatement.setInt(3, PASSANGERS.get(j).getAge());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            LOG.error("SQLException", e);
        }finally {

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    LOG.error("SQLException", e);
                }
            }
            connectionClose();

        }
    }

    @Override
    public Passanger getByStationId(Integer id) {
        Passanger passanger=new Passanger();
        passanger.setId(id);
        PreparedStatement preparedStatement = getPreparedStatement(GET_PASSENGER);
        int age=0;
        String gender="";
        String firstName="";

        try {
            preparedStatement.setInt(1,id);

            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){

                firstName=result.getString(NAME);
                gender=result.getString(GENDER);
                age=result.getInt(AGE);
            }
            passanger.setAge(age);
            passanger.setFirstName(firstName);
            passanger.setGender(gender);

            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connectionClose();
        }
        return passanger;
    }

    @Override
    public List<Passanger> getListByStationId(Integer stationId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Passanger> getAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getCount() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Passanger getById(int id) {
        throw new UnsupportedOperationException();
    }
}
