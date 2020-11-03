package abc.dao;

import abc.beans.Country;

public interface ICountryDao {
    public Country selectCountryById(int id);
}
