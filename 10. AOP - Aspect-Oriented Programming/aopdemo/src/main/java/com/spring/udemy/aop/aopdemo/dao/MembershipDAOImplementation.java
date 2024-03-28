package com.spring.udemy.aop.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImplementation implements MembershipDAO {

    @Override
    public boolean addMembership() {

        System.out.println(getClass() + ": Adding a membership account");
        return true;
    }

    @Override
    public void deleteMembership() {
        System.out.println(getClass() + ": Deleting a membership account");
    }
}
