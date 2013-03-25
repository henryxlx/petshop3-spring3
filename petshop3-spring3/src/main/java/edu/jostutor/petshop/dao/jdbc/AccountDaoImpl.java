package edu.jostutor.petshop.dao.jdbc;

import edu.jostutor.petshop.dao.AccountDao;
import edu.jostutor.petshop.entity.Account;
import edu.jostutor.petshop.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: xulixin
 * Date: 2013-3-12
 * Time: 下午11:45
 * To change this template use File | Settings | File Templates.
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    private static final String SQL_SELECT_ACCOUNT_BY_USERID_PASSWORD =
            "SELECT Account.Email, Account.FirstName, Account.LastName,  Account.Addr1, Account.Addr2, " +
                    " Account.City, Account.State, Account.Zip, Account.Country, Account.Phone, " +
                    " Profile.LangPref, Profile.FavCategory, Profile.MyListOpt, Profile.BannerOpt, " +
                    " Account.UserId, SignOn.Password " +
                    " FROM Account INNER JOIN Profile ON Account.UserId = Profile.UserId " +
                    " INNER JOIN SignOn ON Account.UserId = SignOn.UserName " +
                    " WHERE SignOn.UserName = ? AND SignOn.Password = ?";

    private static final String SQL_SELECT_ACCOUNT_BY_USERID =
            "SELECT Account.Email, Account.FirstName, Account.LastName,  Account.Addr1, Account.Addr2, " +
                    " Account.City, Account.State, Account.Zip, Account.Country, Account.Phone, " +
                    " Profile.LangPref, Profile.FavCategory, Profile.MyListOpt, Profile.BannerOpt, " +
                    " Account.UserId, SignOn.Password " +
                    " FROM Account INNER JOIN Profile ON Account.UserId = Profile.UserId " +
                    " INNER JOIN SignOn ON Account.UserId = SignOn.UserName " +
                    " WHERE SignOn.UserName = ?";

    private final class AccountRowMapper implements RowMapper<Account> {
        @Override
        public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
            Address myAddress = new Address(rs.getString("firstname"), rs.getString("lastname"),
                    rs.getString("addr1"), rs.getString("addr2"), rs.getString("city"),
                    rs.getString("state"), rs.getString("zip"), rs.getString("country"), rs.getString("phone"));
            return new Account(rs.getString("UserId"), rs.getString("Password"),
                    rs.getString("email"), myAddress, rs.getString("langpref"),
                    rs.getString("favcategory"), rs.getInt("mylistopt"), rs.getInt("banneropt"));
        }
    }

    @Override
    public Account signIn(String userId, String password) {
        return jdbcTemplate.queryForObject(SQL_SELECT_ACCOUNT_BY_USERID_PASSWORD,
                new Object[]{userId, password}, new AccountRowMapper());
    }

    @Override
    public Account getAccountByUsername(String username) {
        return jdbcTemplate.queryForObject(SQL_SELECT_ACCOUNT_BY_USERID,
                new Object[]{username}, new AccountRowMapper());
    }

    private static final String SQL_INSERT_SIGNON = "INSERT INTO SignOn VALUES (:userId, :password)";
    private static final String SQL_INSERT_ACCOUNT = "INSERT INTO Account " +
            " VALUES(:userId, :email, :firstName, :lastName, 'OK', " +
            " :address1, :address2, :city, :state, :zip, :country, :phone)";
    private static final String SQL_INSERT_PROFILE = "INSERT INTO Profile " +
            " VALUES(:userId, :language, :category, :showFavorites, :showBanners)";

    @Override
    public int insertObject(Account account) {
        Map<String, Object> signOnMap = new HashMap<String, Object>();
        signOnMap.put("userId", account.getUserId());
        signOnMap.put("password", account.getPassword());
        Map<String, Object> accountMap = new HashMap<String, Object>();
        accountMap.put("email", account.getEmail());
        accountMap.put("firstName", account.getAddress().getFirstName());
        accountMap.put("lastName", account.getAddress().getLastName());
        accountMap.put("address1", account.getAddress().getAddress1());
        accountMap.put("address2", account.getAddress().getAddress2());
        accountMap.put("city", account.getAddress().getCity());
        accountMap.put("state", account.getAddress().getState());
        accountMap.put("zip", account.getAddress().getZip());
        accountMap.put("country", account.getAddress().getCountry());
        accountMap.put("phone", account.getAddress().getPhone());
        accountMap.put("userId", account.getUserId());
        Map<String, Object> profileMap = new HashMap<String, Object>();
        profileMap.put("language", account.getLanguage());
        profileMap.put("category", account.getCategory());
        profileMap.put("showFavorites", account.getShowFavorites());
        profileMap.put("showBanners", account.getShowBanners());
        profileMap.put("userId", account.getUserId());
        SqlParameterSource signOnParameterSource = new MapSqlParameterSource(signOnMap);
        SqlParameterSource accountParameterSource = new MapSqlParameterSource(accountMap);
        SqlParameterSource profileParameterSource = new MapSqlParameterSource(profileMap);
        int num = namedParameterJdbcTemplate.update(SQL_INSERT_SIGNON, signOnParameterSource);
        num += namedParameterJdbcTemplate.update(SQL_INSERT_ACCOUNT, accountParameterSource);
        num += namedParameterJdbcTemplate.update(SQL_INSERT_PROFILE, profileParameterSource);
        return num;
    }

    private static final String SQL_UPDATE_PROFILE = "UPDATE Profile SET LangPref = :language, " +
            " FavCategory = :category, MyListOpt = :showFavorites, BannerOpt = :showBanners WHERE UserId = :userId";
    private static final String SQL_UPDATE_ACCOUNT = "UPDATE Account SET Email = :email, " +
            " FirstName = :firstName, LastName = :lastName, Addr1 = :address1, Addr2 = :address2, " +
            " City = :city, State = :state, Zip = :zip, Country = :country, Phone = :phone WHERE UserId =:userId";

    @Override
    public int updateObject(Account account) {
        Map<String, Object> accountMap = new HashMap<String, Object>();
        accountMap.put("email", account.getEmail());
        accountMap.put("firstName", account.getAddress().getFirstName());
        accountMap.put("lastName", account.getAddress().getLastName());
        accountMap.put("address1", account.getAddress().getAddress1());
        accountMap.put("address2", account.getAddress().getAddress2());
        accountMap.put("city", account.getAddress().getCity());
        accountMap.put("state", account.getAddress().getState());
        accountMap.put("zip", account.getAddress().getZip());
        accountMap.put("country", account.getAddress().getCountry());
        accountMap.put("phone", account.getAddress().getPhone());
        accountMap.put("userId", account.getUserId());
        Map<String, Object> profileMap = new HashMap<String, Object>();
        profileMap.put("language", account.getLanguage());
        profileMap.put("category", account.getCategory());
        profileMap.put("showFavorites", account.getShowFavorites());
        profileMap.put("showBanners", account.getShowBanners());
        profileMap.put("userId", account.getUserId());
        SqlParameterSource accountParameterSource = new MapSqlParameterSource(accountMap);
        SqlParameterSource profileParameterSource = new MapSqlParameterSource(profileMap);
        int num = namedParameterJdbcTemplate.update(SQL_UPDATE_ACCOUNT, accountParameterSource);
        num += namedParameterJdbcTemplate.update(SQL_UPDATE_PROFILE, profileParameterSource);
        return num;
    }
}
