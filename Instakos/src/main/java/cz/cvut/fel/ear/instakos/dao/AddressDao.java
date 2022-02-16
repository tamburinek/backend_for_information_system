package cz.cvut.fel.ear.instakos.dao;

import cz.cvut.fel.ear.instakos.model.user.Address;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDao extends BaseDao<Address> {

    public AddressDao() {
        super(Address.class);
    }
}
