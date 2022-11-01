package com.omc.sales.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="sll_channel_mapping")
public class SllChannel {



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer Id;

        @Column(name = "sll_id")
        private Integer sllId;

        @Column(name = "channel_no")
        private String channelNo;

        @Column(name = "added_by")
        private int addedBy;


        @Column(name = "added_on")
        private Date addedOn;

        @Column(name = "updated_on")
        private Date updatedOn;

        public SllChannel() {
        }

        public Integer getId() {
                return Id;
        }

        public void setId(Integer id) {
                Id = id;
        }

        public Integer getSllId() {
                return sllId;
        }

        public void setSllId(Integer sllId) {
                this.sllId = sllId;
        }

        public String getChannelNo() {
                return channelNo;
        }

        public void setChannelNo(String channelNo) {
                this.channelNo = channelNo;
        }

        public int getAddedBy() {
                return addedBy;
        }

        public void setAddedBy(int addedBy) {
                this.addedBy = addedBy;
        }

        public Date getAddedOn() {
                return addedOn;
        }

        public void setAddedOn(Date addedOn) {
                this.addedOn = addedOn;
        }

        public Date getUpdatedON() {
                return updatedOn;
        }

        public void setUpdatedON(Date updatedON) {
                this.updatedOn = updatedOn;
        }
}
