package com.psps.petclinic.controllers;

import com.psps.petclinic.model.Owner;
import com.psps.petclinic.services.OwnerService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class OwnerControllerTest {
    @InjectMocks
    OwnerController ownerController;

    @Mock
    OwnerService ownerService;

    @Mock
    Model model;

    Owner owner1;

    Set<Owner> owners = new HashSet<>();

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        owner1 = Owner.builder().id(1L).firstName("Santhosh").lastName("Harish").build();
        owners.add(owner1);

        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    @Test
    void listAllOwners() throws Exception {
        Mockito.when(ownerService.findAll()).thenReturn(owners);


        mockMvc.perform(MockMvcRequestBuilders.get("/owners"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners",hasSize(1)));



    }
}