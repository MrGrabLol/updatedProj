package com.hseproject.proj.service.Address;

import com.hseproject.proj.model.Address;
import com.hseproject.proj.view.AddressOutView;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{

    private final EntityManager em;

    public AddressServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<AddressOutView> getAddress() {
        List<AddressOutView> addressList = new ArrayList<>();
        TypedQuery<Address> typedQuery = em.createQuery("SELECT p FROM Address p", Address.class);
        typedQuery.getResultList().forEach(address -> addressList.add(new AddressOutView(address.getName(),
                address.getAddress(), address.getPhone(), address.getPhotoId(), address.getWorktime())));
        return addressList;
    }
}
