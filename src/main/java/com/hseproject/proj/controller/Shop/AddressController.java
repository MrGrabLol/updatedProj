package com.hseproject.proj.controller.Shop;

import com.hseproject.proj.service.Address.AddressService;
import com.hseproject.proj.view.AddressOutView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address")
    public List<AddressOutView> getAddress() {
        return addressService.getAddress();
    }
}
