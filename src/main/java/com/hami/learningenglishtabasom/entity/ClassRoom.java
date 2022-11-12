package com.hami.learningenglishtabasom.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_meeting")
    private int totalMeeting;

    private int price;

    @Column(name = "total_deposit")
    private BigDecimal totalDeposit;

    private int deposit;

    private int dept;

    @Column(name = "date_register")
    @CreationTimestamp
    private Date dateRegister;

    @Column(name = "date_deposit")
    @CreationTimestamp
    private Date dateDeposit;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public ClassRoom(Long id, int totalMeeting, int price, BigDecimal totalDeposit, int deposit, int dept, Date dateRegister, Date dateDeposit, User user) {
        this.id = id;
        this.totalMeeting = totalMeeting;
        this.price = price;
        this.totalDeposit = totalDeposit;
        this.deposit = deposit;
        this.dept = dept;
        this.dateRegister = dateRegister;
        this.dateDeposit = dateDeposit;
        this.user = user;
    }

    public Long getId() {
        return id;
    }


    public int getTotalMeeting() {
        return totalMeeting;
    }

    public void setTotalMeeting(int totalMeeting) {
        this.totalMeeting = totalMeeting;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public BigDecimal getTotalDeposit() {
        return totalDeposit;
    }

    public void setTotalDeposit(BigDecimal totalDeposit) {
        this.totalDeposit = totalDeposit;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getDept() {
        return dept;
    }

    public void setDept(int dept) {
        this.dept = dept;
    }

    public Date getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
    }

    public Date getDateDeposit() {
        return dateDeposit;
    }

    public void setDateDeposit(Date dateDeposit) {
        this.dateDeposit = dateDeposit;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
